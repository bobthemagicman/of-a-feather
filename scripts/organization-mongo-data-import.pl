#!/usr/bin/perl

use utf8;
use strict;
use warnings;
$| = 1;

=head1 NAME

csv_to_js.pl - Script to parse CSV file and create JSON file

=head1 SYNOPSIS

    csv_to_js.pl file --output_file=file

    csv_file - a csv file containing all of the data to parse, required
    output_file - the document name to output to, required

=head1 DESCRIPTION

This script reads the inputted CSV file, parses the data and performs translations
on it, and prints the data out to a JSON file.

=head1 VERSION

Version 1.3.0

=cut

our $VERSION = '1.3.0';

=head1 AUTHOR

Joel Crosswhite, C<< <joel.crosswhite at ix.netcom.com> >> and
Blake Stephens, C<< <brak.stephens at gmail.com >>

=head1 LICENSE AND COPYRIGHT

Copyright 2015

=cut

use Getopt::Long;
use Text::CSV;
use Geo::StreetAddress::US;
use JSON;
use REST::Client;
use MongoDB;
use DateTime;
use Data::Dumper;

# Get command line options
my $csv_file = '';
my $output_file;
my $mongo_host = '';
my $mongo_port = '';
my $mongo_user = '';
my $mongo_pass = '';
my $dry_run = 0;
my $skip_latlng = 0;
my $row_limiter = 0;

GetOptions(
    'input_file=s'  => \$csv_file,
    'host=s'        => \$mongo_host,
    'port=s'        => \$mongo_port,
    'username=s'    => \$mongo_user,
    'password=s'    => \$mongo_pass,
    'dry-run|d'     => \$dry_run,           ### Don't send anything to the database
    'skip-latlng'   => \$skip_latlng,       ### Don't do the costly (time) lat/long lookup. Dev option.
    'row=s'         => \$row_limiter,       ### just work on this one row
);
die 'Please define --input_file on command line' if ( !defined($csv_file) );

$mongo_host = 'localhost' unless defined($mongo_host);
$mongo_port = 27017 unless defined($mongo_port);

my $KEY = 'Fmjtd%7Cluub250rnq%2C85%3Do5-9u8wq0';
die 'You need to set your MaqQuest API key on line 57' if ( $KEY eq '<Set your key here>' );
my $API    = 'http://open.mapquestapi.com/geocoding/v1/address';
my $client = REST::Client->new;
my $mongo_connection = MongoDB::Connection->new(host => $mongo_host, port => $mongo_port);
if (defined($mongo_user) && defined($mongo_pass)) {
    $mongo_connection->authenticate('of-a-feather-test', $mongo_user, $mongo_pass);
    # $mongo_connection->authenticate('of-a-feather', $mongo_user, $mongo_pass);
}
my $db = $mongo_connection->get_database('of-a-feather-test');
# my $db = $mongo_connection->get_database('of-a-feather');
my $collection = $db->get_collection( 'organizations');

parse_csv_and_insert_to_mongo($csv_file, $collection);

#print_json($data);

# read in the CSV file
sub parse_csv_and_insert_to_mongo {
    my $file = shift();
    my $collection = shift();

    my @retval;
    my $csv = Text::CSV->new( { binary => 1 } ) or die 'Cannot use CSV: ' . Text::CSV->error_diag;

    print "Reading CSV file... \n";
    open( my $fh, '<:encoding(iso-8859-1)', $file ) or die 'Cannot open file ' . $file . ': ' . $!;

    $csv->column_names( $csv->getline($fh) );

    ### We start at row 2 because row 1 is the colunm names. Tracker refers to the file's record/row number.
    my $tracker = 0;
    my $row_num = 1;
    while ( my $row = $csv->getline_hr($fh) ) {
        $row_num++;

        ### If we specified a specific row, skip any row that's not that row.
        next if ($row_limiter and $row_limiter != $row_num);

        printf("\rReading row %d \b ", $row_num);

        my $org = transform($row);
        my $orgName = $org->{'name'};

        printf("\rReading church with name %s \b ", $orgName);

        next unless ($orgName);

        eval {
            #print Dumper($org);
            $collection->insert($org) unless ($dry_run);
        };
        if ($@) {
            print "\nError while attempting to insert record on line $tracker, for organization called $orgName \n";
            print "Error from MongoDB: $@\n";
        }
        $tracker++;
    }
    close $fh;
    printf("\nDone.\nFound %d records.\n", $tracker);

    return;
}

# perform any transformations here
sub transform {
    my $data = shift();
    my $retval;

    # contact/leader information
    for my $a ( 1 .. 3 ) {
        $retval->{'leadershipTeam'} = [] unless (defined($retval->{'leadershipTeam'}));

        my $leader_name = $data->{$a . ' Leader Name'};
        my $leader = _parse_leader( $leader_name );
        my $first_leader = scalar(@{$retval->{'leadershipTeam'}}) ? 0 : 1;
        push(@{$retval->{'leadershipTeam'}},
            {
                name  => $leader->{'name'},
                title => $leader->{'title'} || '',
                bio   => _html_replace( $data->{'Pastor Bio'} ),
                leaderRole     => ['PASTOR'],
                primaryContact => $first_leader ? boolean::true : boolean::false,
                primaryLeader  => $first_leader ? boolean::true : boolean::false,
                phoneNumber    => $data->{'Church Phone Number'},
                emailAddress   => $data->{'Church Email contact'},
                yearStarted    => (($data->{'Year Pastor Joined'} =~ /\d+/) ? $data->{'Year Pastor Joined'} : ''),
            }
        ) if ($leader_name);
        # print Dumper($leader_name, $retval->{'leadershipTeam'}) if ($leader_name);
    }

    # basic information
    $retval->{'yearFounded'}          = ($data->{'Founding Year'} =~ /\d+/) ? $data->{'Founding Year'} : '';
    $retval->{'name'}                 = _html_replace( $data->{'Church Name'} );
    $retval->{'missionStatement'}     = _html_replace( $data->{'Mission Statement'} );
    $retval->{'statementOfFaith'}     = _html_replace( $data->{'Statement of Faith'} );
    $retval->{'welcomeMessage'}       = _html_replace( $data->{'Welcome Message'} );
    $retval->{'extraServiceDetails'}  = _html_replace( $data->{'Service Details'});

    # address information
    $data->{'Zip'} =~ s/[^\d\-]//g;
    my $address_string = sprintf('%s, %s, %s, %s %s',
        $data->{'Street 1'} || '',
        $data->{'Street 2'} || '',
        $data->{'City'} || '',
        $data->{'State'} || '',
        $data->{'Zip'} || ''
    );
    my $address = Geo::StreetAddress::US->parse_location( $address_string );

    my $street =
        ( $address->{number} ? $address->{number} . ' ' : '' ).
        ( $address->{prefix} ? $address->{prefix} . ' ' : '' ).
        ( $address->{street} ? $address->{street} . ' ' : '' ).
        ( $address->{type}   ? $address->{type} . ' '   : '' );
    my ( $street1, $street2 ) = split( /\s*(\r\n?|\n)\s*/s, $street );
    $street1 = _trim( $street1 );
    $street2 = _trim( $street2 );

    $retval->{'address'} = {
        street1    => ( $street1            ? $street1          : '' ),
        street2    => ( $street2            ? $street2          : '' ),
        city       => ( $address->{city}    ? $address->{city}  : '' ),
        postalCode => ( $address->{zip}     ? $address->{zip}   : '' ),
        state      => ( $address->{state}   ? $address->{state} : '' ),
        country    => 'USA',
    };

    # minimum information to get MQ to work
    if ( defined( $address->{zip} ) || ( defined( $address->{city} ) && defined( $address->{state} ) ) ) {
        # Get Lat & Lon from MQ
        my $mq_addr =   ($street1           ? $street1 . ', ' : '').
                        ($street2           ? $street2 . ', ' : '').
                        ($address->{city}   ? $address->{city} . ', ' : '').
                        ($address->{state}  ? $address->{state} . ', ' : '').
                        ($address->{zip}    ? $address->{zip} : '');

        $client->GET( $API . '?key='
              . $KEY
              . '&maxResults=1&thumbMaps=false&outFormat=json&location='
              . $mq_addr ) unless ($skip_latlng);

        if ( !$skip_latlng and $client->responseCode() eq '200' ) {
            my $content = decode_json( $client->responseContent() );

            if ( $content->{info}{statuscode} == 0 ) {
                $retval->{address}{longitude} = $content->{results}[0]{locations}[0]{latLng}{lng};
                $retval->{address}{latitude} = $content->{results}[0]{locations}[0]{latLng}{lat};
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
    $retval->{address}{location} = [ $retval->{address}{longitude}, $retval->{address}{latitude} ];

    # atmosphere information
    $retval->{'atmosphere'} = {
        congregationSize => _congregation_size( $data->{'Size'} ),
        serviceSchedule  => '',
        serviceDetails   => [],
        gayAffirming     => ( $data->{'Gay Affirming'} =~ /true/i ) ? boolean::true : boolean::false,
        homeChurch       => ( $data->{'Home Church'} =~ /yes/i ) ? boolean::true : boolean::false,
    };

    # parse "1-5 Atmosphere" information
    for ( 1 .. 5 ) {
        next unless (defined($data->{ $_ . ' Atmosphere' }));
        ### Rearrange these if the columns change order:
        my (
            $service_day,
            $start_time,
            $time_range,
            $languages,
            $music,
            $service,
            $dress,
            $age,
            $instruments,
            $duration
        ) = split( /\|/, $data->{ $_ . ' Atmosphere' } );

        next if (!defined($service_day) or $service_day eq '');    # if service day doesn't exist, skip this atmosphere

        my @splitTime = split(/:/, $data->{ $_ . ' StartTime' });

        my $dt = DateTime->new(
            year       => 0000,
            month      => 12,
            day        => 30,
            hour       => $splitTime[0] || 0,
            minute     => $splitTime[1] || 0,
            second     => 0,
            nanosecond => 0,
            time_zone  => 'America/Los_Angeles'
        );
        # print Dumper(\@splitTime, $dt->datetime()) if ($data->{ $_ . ' StartTime' });

        my $service_details = {
            musicStyle        => _conv_music_style($music),
            serviceStyle      => _conv_service_style($service),
            dressAttire       => _conv_dress_attire($service),
            ageDemographics   => _conv_age_demo($service),
            instruments       => _get_instruments($instruments),
            durationInMinutes => _conv_dur_time( $data->{ $_ . ' Duration'} ),
            serviceName       => '',
            timeAndDay        => {
                startTime        => $dt->datetime(), #"ISODate('0000-12-30T" . $data->{ $_ . '-StartTime' } . "Z')",
                serviceDay       => $service_day,
                serviceTimeRange => $time_range,
            },
            languages => [],
        };

        push( @{ $retval->{atmosphere}{serviceDetails} }, $service_details );
    }

    # social media information
    $retval->{socialMedia} = {
        websiteUrl    => $data->{'Website'},
        facebookUrl   => $data->{'Facebook'},
        blogUrl       => $data->{'Blog'},
        googlePlusUrl => $data->{'Google Plus'},
        youtubeUrl    => $data->{'YouTube'},
        podcastUrl    => $data->{'Podcast'},
        twitterUrl    => $data->{'Twitter'},
        otherUrl      => $data->{'Other Social Media'},
        instagramUrl  => $data->{'Instagram'},
    };

    # denomination information
    if ($data->{'Denomination'} and $data->{'Denomination'} =~ /((American|Southern)\s+Baptist)/i) {
        ### Take the capture from the match above and convert the spaces to _
        (my $subden = $1) =~ s/\s+/_/g;
        $subden = uc($subden);
        $retval->{subDenomination} = _html_replace( $subden );
        $retval->{denomination}    = 'BAPTIST';
    }
    else {
        $retval->{denomination} = $data->{'Denomination'}
    }
    $retval->{multimedia} = [];

    # program information
    $retval->{programsOffered} = [];
    push( @{ $retval->{programsOffered} },
        _split_and_trim($data->{'Programs & Ministries - Nursery Care'}),
        _split_and_trim($data->{'Programs & Ministries - Education'}),
        _split_and_trim($data->{'Programs & Ministries - Gender Groups'}),
        _split_and_trim($data->{'Programs & Ministries - Age Groups'}),
        _split_and_trim($data->{'Programs & Ministries - Music and Arts'}),
        _split_and_trim($data->{'Programs & Ministries - Social'}),
        _split_and_trim($data->{'Programs & Ministries - Spiritual'}),
        _split_and_trim($data->{'Programs & Ministries - Community Outreach'}),
        _split_and_trim($data->{'Programs & Ministries - Support and Counseling'})
    );

    ### Convert human readable values to ENUM database values
    my @parking_enum = _split_and_trim($data->{'Parking'});
    foreach (@parking_enum) {
        s/Parking Lot/PARKING_LOT/i,
        s/Street Parking Only/STREET_PARKING/i,
    }

    $retval->{accessibilitySupport} = [];
    push( @{ $retval->{accessibilitySupport} },
        _split_and_trim($data->{'Special Needs Accommodations'}),
        @parking_enum
    );

    return $retval;

}

sub _trim {
    my $str = shift();
    return '' unless (defined($str));
    $str =~ s/^\s+|\s+$//g;
    return $str;
}

sub _split_and_trim {
    my $col = shift();
    my $delim = shift() || ',';

    if ( $col and $col =~ /\w+/ ) {
        return split(/\s*$delim\s*/, _trim($col) );
    }
    return ();
}

# a subroutine to try and parse out the leader's title from their name
sub _parse_leader {
    my $leader = shift() || '';
    my $retval = {};
    my $title = '';
    my $prefix = '';
    my $name = $leader;

    if ( $leader =~ /pastor/i ) {
        ( $prefix, $name ) = split( /\s*pastor\s*/i, $leader );
        $title = 'Pastor';
    }
    elsif ( $leader =~ /rev/i ) {
        ( $prefix, $name ) = split( /\s*rev(?:erend)?\.?\s*/i, $leader );
        $title = 'Rev.';
    }

    $retval->{'name'} = $name;
    $retval->{'title'} = ( $prefix ? $prefix . ' ' : '' ) . $title;

    return $retval;
}

# parse strings and replace certain characters with HTML
sub _html_replace {
    my $str = shift() || '';

    return if !defined($str);
    $str =~ s/\t/<span class="tab"> ...<\/span>/g;
    $str =~ s/(\r?\n|\r)/<br \/>/gs;
    $str =~ s/"/&quot;/g;
    $str =~ s/'/&#39;/g;

    return $str;
}

# determine the congregation size
sub _congregation_size {
    my $size = shift() || '';

    return 'UNKNOWN' if ( !defined($size) || $size eq '' || $size !~ /\d+/ );
    (my $p_size = $size) =~ /^(\d+)/;
    return 'SMALL'  if ( $p_size < 50 );
    return 'MEDIUM' if ( $p_size < 200 );
    return 'LARGE'  if ( $p_size < 500 );
    return 'MEGA';
}

sub print_json {
    my $data = shift();

    my $json_text = encode_json($data);

    open( my $fh, '>', $output_file ) or die 'Cannot open file ' . $output_file . ': ' . $!;
    print {$fh} $json_text;
    close $fh;

    return;
}

# transform music style
sub _conv_music_style {
    my $music = shift() || 5;
    return $music if (length($music) > 2);  ### This is probably a word, not a number
    die 'Music value needs to be between 1 & 10' if ($music < 1 or $music > 10);
    if    ( $music < 5 )    { return 'TRADITIONAL_' . $music; }
    elsif ( $music >= 7 )   { return 'CONTEMPORARY_' . $music; }
    else                    { return 'NEUTRAL_' . $music; }
}

# transform service style
sub _conv_service_style {
    my $service = shift() || 5;
    return $service if (length($service) > 2);  ### This is probably a word, not a number
    die 'Service style value needs to be between 1 & 10' if ($service < 1 or $service > 10);
    if    ( $service < 5 )  { return 'CONSERVATIVE_' . $service; }
    elsif ( $service >= 7 ) { return 'HIGH_ENERGY_' . $service; }
    else                    { return 'NEUTRAL_' . $service; }
}

# transform dress attire
sub _conv_dress_attire {
    my $dress = shift() || 5;
    return $dress if (length($dress) > 2);  ### This is probably a word, not a number
    die 'Dress attire value needs to be between 1 & 10' if ($dress < 1 or $dress > 10);
    if    ( $dress < 5 )    { return 'FORMAL_' . $dress; }
    elsif ( $dress >= 7 )   { return 'CASUAL_' . $dress; }
    else                    { return 'NEUTRAL_' . $dress; }
}

# transform age demographic
sub _conv_age_demo {
    my $age = shift() || 5;
    return $age if (length($age) > 2);  ### This is probably a word, not a number
    die 'Age demographic value needs to be between 1 & 10' if ($age < 1 or $age > 10);
    if    ( $age < 5 )  { return 'YOUTH_' . $age; }
    elsif ( $age >= 7 ) { return 'MATURE_' . $age; }
    else                { return 'NEUTRAL_' . $age; }
}

# pull out the instruments from the list
sub _get_instruments {
    my $insts = shift() || '';
    my $retval = [];

    return $retval if (!defined($insts) or $insts eq '' or $insts =~ /^\s+$/);

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
}

# convert the duration time to minutes
sub _conv_dur_time {
    my $duration = shift();

    return 0 if (!$duration);

    my ( $hour, $min, $sec ) = split( /:/, $duration );
    my $time = $sec + ( $min * 60 ) + ( $hour * 3600 );
    return $time / 60;
}
