#!/usr/bin/perl

use utf8;
use strict;
use warnings;

=head1 NAME

csv_to_js.pl - Script to parse CSV file and create JSON file

=head1 SYNOPSIS

    csv_to_js.pl --csv_file=file --output_file=file
    
    csv_file - a csv file containing all of the data to parse, required
    output_file - the document name to output to, required

=head1 DESCRIPTION

This script reads the inputted CSV file, parses the data and performs translations
on it, and prints the data out to a JSON file.

=head1 VERSION

Version 1.3.1

=cut

our $VERSION = '1.3.1';

=head1 AUTHOR

Joel Crosswhite, C<< <joel.crosswhite at ix.netcom.com> >>

=head1 LICENSE AND COPYRIGHT

Copyright 2013 

=cut

use Getopt::Long;
use Text::CSV;
use Geo::StreetAddress::US;
use JSON;
use DateTime;
use REST::Client;

# Get command line options
my $csv_file;
my $output_file;
GetOptions(
    'csv_file=s'    => \$csv_file,
    'output_file=s' => \$output_file,
);
die 'Please define --csv_file on command line'    if ( !defined($csv_file) );
die 'Please define --output_file on command line' if ( !defined($output_file) );

my $KEY = '<Set your key here>';
die 'You need to set your MaqQuest API key on line 58'
  if ( $KEY eq '<Set your key here>' );
my $API    = 'http://www.mapquestapi.com/geocoding/v1/address';
my $client = REST::Client->new;

my $data = parse_csv($csv_file);
print_json($data);

# read in the CSV file
sub parse_csv {

    my ($file) = @_;

    my @retval;
    my $csv = Text::CSV->new( { binary => 1 } )
      or die 'Cannot use CSV: ' . Text::CSV->error_diag;

    print 'Reading CSV file...';
    open( my $fh, '<:encoding(windows-1252)', $file )
      or die 'Cannot open file ' . $file . ': ' . $!;
    $csv->column_names( $csv->getline($fh) );
    while ( my $row = $csv->getline_hr($fh) ) {
        push @retval, transform($row);
    }
    close $fh;
    print "Done.\n";

    print 'Found ' . scalar(@retval) . ' records.' . "\n";
    return \@retval;
}    # parse_csv

# perform any transformations here
sub transform {

    my ($data) = @_;
    my $retval;

    # basic information
    $retval->{yearFounded} =
      ( $data->{'Founding Year'} =~ /\d+/ )
      ? $data->{'Founding Year'} + 0
      : '';
    $retval->{name}             = _html_replace( $data->{'Church Name'} );
    $retval->{missionStatement} = _html_replace(
        $data->{
'Church Mission or Vision Statement (also known as a Statement of Purpose)'
        }
    );
    $retval->{statementOfFaith} =
      _html_replace( $data->{'Church Statement of Faith'} );
    $retval->{welcomeMessage} =
      _html_replace( $data->{'Personal Welcome Message to Newcomers'} );

    # address information
    my $address = Geo::StreetAddress::US->parse_location( $data->{'Address'} );

    my $street =
        ( defined( $address->{number} ) ? $address->{number} . ' ' : '' )
      . ( defined( $address->{prefix} ) ? $address->{prefix} . ' ' : '' )
      . ( defined( $address->{street} ) ? $address->{street} . ' ' : '' )
      . ( defined( $address->{type} )   ? $address->{type} . ' '   : '' );
    my ( $street1, $street2 ) = split( /\n|\r/, $street );
    $retval->{address} = {
        street1    => ( defined($street1)            ? $street1          : '' ),
        street2    => ( defined($street2)            ? $street2          : '' ),
        city       => ( defined( $address->{city} )  ? $address->{city}  : '' ),
        postalCode => ( defined( $address->{zip} )   ? $address->{zip}   : '' ),
        state      => ( defined( $address->{state} ) ? $address->{state} : '' ),
        country    => 'USA',
    };

    # minimum information to get MQ to work
    if ( defined( $address->{zip} )
        || ( defined( $address->{city} ) && defined( $address->{state} ) ) )
    {
        # Get Lat & Lon from MQ
        my $mq_addr = (
            defined($street2) ? _trim($street2) . ', '
            : ( defined($street1) ? _trim($street1) . ', ' : '' )
          )
          . (
            defined( $address->{city} ) ? _trim( $address->{city} ) . ', '
            : ''
          )
          . (
            defined( $address->{state} ) ? _trim( $address->{state} ) . ', '
            : ''
          ) . ( defined( $address->{zip} ) ? _trim( $address->{zip} ) : '' );
        $client->GET( $API . '?key='
              . $KEY
              . '&maxResults=1&thumbMaps=false&outFormat=json&location='
              . $mq_addr );
        if ( $client->responseCode() eq '200' ) {

            my $content = decode_json( $client->responseContent() );

            if ( $content->{info}{statuscode} == 0 ) {

                $retval->{address}{longitude} =
                  $content->{results}[0]{locations}[0]{latLng}{lng};
                $retval->{address}{latitude} =
                  $content->{results}[0]{locations}[0]{latLng}{lat};
            }
            else {

                $retval->{address}{longitude} = '';
                $retval->{address}{latitude}  = '';
            }
        }
        else {

            $retval->{address}{longitude} = '';
            $retval->{address}{latitude}  = '';
        }
    }
    else {

        $retval->{address}{longitude} = '';
        $retval->{address}{latitude}  = '';
    }
    $retval->{address}{location} =
      [ $retval->{address}{longitude}, $retval->{address}{latitude} ];

    # atmosphere information
    $retval->{atmosphere} = {
        congregationSize => _congregation_size( $data->{'Size'} ),
        serviceSchedule  => '',
        serviceDetails   => [],
        gayAffirming     => ( $data->{'Gay Affirming'} =~ /true/i )
        ? JSON::true
        : JSON::false,
        homeChurch => ( $data->{'Home Church?'} =~ /yes/i ) ? JSON::true
        : JSON::false,
    };

    # parse atmosphere1-6 information
    for ( 1 .. 6 ) {

        my (
            $music,       $service,  $dress,       $age,
            $instruments, $duration, $service_day, $start_time,
            $time_range,  $languages
        ) = split( /\|/, $data->{ 'Atmosphere' . $_ } );

        next
          if !defined($service_day)
          || $service_day eq
          '';    # if service day doesn't exist, skip this atmosphere

        # set the time to a date object
        my ( $hour, $minute, $second ) =
          split( /:/, $data->{ $_ . '-StartTime' } );
        $second ||= 0;
        my $dt = DateTime->new(
            year      => 1970,
            month     => 1,
            day       => 1,
            hour      => $hour,
            minute    => $minute,
            second    => $second,
            time_zone => 'UTC'
        );
        my $service_details = {

            musicStyle        => _conv_music_style($music),
            serviceStyle      => _conv_service_style($service),
            dressAttire       => _conv_dress_attire($service),
            ageDemographics   => _conv_age_demo($service),
            instruments       => _get_instruments($instruments),
            durationInMinutes => _conv_dur_time( $data->{'Duration'} ),
            serviceName       => '',
            timeAndDay        => {
                startTime        => { "\$date" => $dt->epoch },
                serviceDay       => $service_day,
                serviceTimeRange => $time_range,
            },
            languages => [],
        };

        push( @{ $retval->{atmosphere}{serviceDetails} }, $service_details );
    }

    # social media information
    $retval->{socialMedia} = {
        websiteUrl    => $data->{'Website URL'},
        facebookUrl   => $data->{'Facebook URL (optional)'},
        blogUrl       => $data->{'Blog URL (optional)'},
        googlePlusUrl => $data->{'Google Plus URL (optional)'},
        youtubeUrl    => $data->{'YouTube URL (optional)'},
        podcastUrl    => $data->{'Podcast URL (optional)'},
        twitterUrl    => $data->{'Twitter URL (optional)'},
        otherUrl      => '',
        instagramUrl  => '',
    };

    # denomination information
    $retval->{denomination}    = _html_replace( $data->{'Denomination'} );
    $retval->{subDenomination} = _html_replace(
        $data->{
'For Non-Denominational Churches:  What denomination is this church similar to in beliefs and style?'
        }
    );
    $retval->{multimedia} = [];

    # contact/leader information
    my $leader = _parse_leader( $data->{'Leader Name'} );

    $retval->{leadershipTeam} = [
        {
            name  => $leader->{name},
            title => ( defined( $leader->{title} ) ? $leader->{title} : '' ),
            bio   => _html_replace( $data->{'Pastor Bio'} ),
            leaderRole     => ['PASTOR'],
            image          => '',
            primaryContact => JSON::true,
            primaryLeader  => JSON::true,
            phoneNumber    => $data->{'Church Phone Number'},
            emailAddress   => $data->{'Church Email contact'},
            yearStarted    => (
                ( $data->{'Year Pastor Joined'} =~ /\d+/ )
                ? $data->{'Year Pastor Joined'} + 0
                : ''
            ),
        }
    ];

    # program information
    $retval->{programsOffered} = [];
    if ( $data->{'Nursery Care'} =~ /\w+/ ) {
        push(
            @{ $retval->{programsOffered} },
            _html_replace( $data->{'Nursery Care'} )
        );
    }
    if ( $data->{'Programs & Ministries - Gender focused'} =~ /\w+/ ) {
        push(
            @{ $retval->{programsOffered} },
            _html_replace( $data->{'Programs & Ministries - Gender focused'} )
        );
    }
    if ( $data->{'Programs & Ministries'} =~ /\w+/ ) {
        push(
            @{ $retval->{programsOffered} },
            _html_replace( $data->{'Programs & Ministries'} )
        );
    }
    if ( $data->{'Programs & Ministries - Community Outreach'} =~ /\w+/ ) {
        push(
            @{ $retval->{programsOffered} },
            _html_replace(
                $data->{'Programs & Ministries - Community Outreach'}
            )
        );
    }

    $data->{'accessibilitySupport'} =
      [ _html_replace( $data->{'Special Needs Accommodations'} ) ];
    if ( $data->{'If "other", please explain below.'} =~ /\w+/ ) {
        push(
            @{ $retval->{programsOffered} },
            _html_replace( $data->{'If "other", please explain below.'} )
        );
    }

    return $retval;

}    # transform

# a subroutine to try and parse out the leader's title from their name
sub _parse_leader {

    my ($leader) = @_;

    my %retval;
    if ( $leader =~ /pastor/i ) {

        my ( $prefix, $name ) = split( /pastor/i, $leader );
        $retval{name} = $name;
        $retval{name} =~ s/^\s+//;
        $retval{title} = ( defined($prefix) ? $prefix . ' ' : '' ) . 'Pastor';
    }
    elsif ( $leader =~ /rev/i ) {

        my ( $prefix, $name ) = split( /rev[erend]?[\.]?/i, $leader );
        $retval{name} = $name;
        $retval{name} =~ s/^\s+//;
        $retval{title} = ( defined($prefix) ? $prefix . ' ' : '' ) . 'Rev.';
    }
    else {

        $retval{name} = $leader;
    }

    return \%retval;
}    # _parse_leader

# parse strings and replace certain characters with HTML
sub _html_replace {

    my ($str) = @_;

    return if !defined($str);
    $str =~ s/\t/<span class="tab"> ...<\/span>/g;
    $str =~ s/\n|\r/<br \/>/g;
    $str =~ s/"/&quot;/g;
    $str =~ s/'/&#39;/g;

    return $str;
}    # _html_replace

sub _trim {

    my ($str) = @_;

    $str =~ s/^\s+//;
    $str =~ s/\s+$//;

    return $str;
}    # _trim

# determine the congregation size
sub _congregation_size {

    my ($size) = @_;

    return 'UNKNOWN' if ( !defined($size) || $size eq '' || $size !~ /\d+/ );
    my ($p_size) = $size =~ /^(\d+)/;
    return 'SMALL'  if ( $p_size < 50 );
    return 'MEDIUM' if ( $p_size < 200 );
    return 'LARGE'  if ( $p_size < 500 );
    return 'MEGA';
}    # _congregation_size

sub print_json {

    my ($data) = @_;

    # my $json_text = encode($data);
    my $json_text = to_json($data);

    open( my $fh, '>', $output_file )
      or die 'Cannot open file ' . $output_file . ': ' . $!;
    print {$fh} $json_text;
    close $fh;

    return;
}    # print_json

# transform music style
sub _conv_music_style {

    my ($music) = @_;

    die 'Music value needs to be between 1 & 10' if $music < 1 || $music > 10;
    if ( $music < 5 ) {

        return 'TRADITIONAL_' . $music;
    }
    elsif ( $music < 7 ) {

        return 'NEUTRAL_' . $music;
    }
    else {

        return 'CONTEMPORARY_' . $music;
    }
}    # _conv_music_style

# transform service style
sub _conv_service_style {

    my ($service) = @_;

    die 'Service style value needs to be between 1 & 10'
      if $service < 1 || $service > 10;
    if ( $service < 5 ) {

        return 'CONSERVATIVE_' . $service;
    }
    elsif ( $service < 7 ) {

        return 'NEUTRAL_' . $service;
    }
    else {

        return 'HIGH_ENERGY_' . $service;
    }
}    # _conv_service_style

# transform dress attire
sub _conv_dress_attire {

    my ($dress) = @_;

    die 'Dress attire value needs to be between 1 & 10'
      if $dress < 1 || $dress > 10;
    if ( $dress < 5 ) {

        return 'FORMAL_' . $dress;
    }
    elsif ( $dress < 7 ) {

        return 'NEUTRAL_' . $dress;
    }
    else {

        return 'CASUAL_' . $dress;
    }
}    # _conv_dress_attire

# transform age demographic
sub _conv_age_demo {

    my ($age) = @_;

    die 'Age demographic value needs to be between 1 & 10'
      if $age < 1 || $age > 10;
    if ( $age < 5 ) {

        return 'YOUTH_' . $age;
    }
    elsif ( $age < 7 ) {

        return 'NEUTRAL_' . $age;
    }
    else {

        return 'MATURE_' . $age;
    }
}    # _conv_age_demo

# pull out the instruments from the list
sub _get_instruments {

    my ($insts) = @_;

    my $retval = [];
    return $retval if !defined($insts) || $insts eq '' || $insts =~ /^\s+$/;

    my $in_cont_band = 0;
    my $tmp_str      = '';
    foreach my $inst ( split( /,/, $insts ) ) {

        if ( $inst =~ /\(/ ) {

            $in_cont_band = 1;
            $tmp_str .= $inst . ',';
            next;
        }

        if ($in_cont_band) {

            if ( $inst =~ /\)/ ) {

                $in_cont_band = 0;
                $tmp_str .= $inst;
                push( @{$retval}, _trim($tmp_str) );
                $tmp_str = '';
                next;
            }

            $tmp_str .= $inst . ',';
            next;
        }
        push( @{$retval}, _trim($inst) );
    }
    return $retval;
}    # _get_instruments

# convert the duration time to minutes
sub _conv_dur_time {

    my ($duration) = @_;

    return 0 if !defined($duration) or $duration eq '';
    my ( $hour, $min, $sec ) = split( /:/, $duration );
    my $time = $sec + ( $min * 60 ) + ( $hour * 3600 );
    return $time / 60;
}    # _conv_dur_time
