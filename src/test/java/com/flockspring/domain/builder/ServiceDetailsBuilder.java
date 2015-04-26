/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.builder;

import java.util.Arrays;
import java.util.Set;

import org.joda.time.LocalDateTime;

import com.flockspring.domain.types.DressAttire;
import com.flockspring.domain.types.Language;
import com.flockspring.domain.types.MusicStyle;
import com.flockspring.domain.types.ServiceDay;
import com.flockspring.domain.types.ServiceDetailsImpl;
import com.flockspring.domain.types.ServiceStyle;
import com.flockspring.domain.types.TimeAndDay;
import com.flockspring.domain.types.impl.AgeDemographics;
import com.flockspring.domain.types.impl.MusicalInstruments;
import com.google.common.collect.Sets;

/**
 * ServiceDetailsBuilder.java
 *
 * @author Justen L. Britain
 * @date Jul 6, 2014
 *
 */
public class ServiceDetailsBuilder
{

    private MusicStyle musicStyle;
    private ServiceStyle serviceStyle;
    private DressAttire dressAttire;
    private AgeDemographics ageDemongraphics;
    private Set<MusicalInstruments> instruments;
    private int durationInMinutes;
    private TimeAndDay timeAndDay;
    private String serviceName;
    private Set<Language> languages;
    
    private boolean languagesSetReset = false;
    private boolean instrumentsSetReset = false;

    public ServiceDetailsBuilder()
    {
        musicStyle = MusicStyle.NEUTRAL_5;
        serviceStyle = ServiceStyle.NEUTRAL_5;
        dressAttire = DressAttire.NEUTRAL_5;
        ageDemongraphics = AgeDemographics.NEUTRAL_4;
        instruments = Sets.newTreeSet(Arrays.asList(MusicalInstruments.ACOUSTIC_GUITAR, MusicalInstruments.DRUMS, MusicalInstruments.ELECTRIC_GUITAR));
        durationInMinutes = 90;
        timeAndDay = new TimeAndDay(new LocalDateTime(0000, 12, 30, 11, 15), ServiceDay.SUNDAY);
        serviceName = "Unit Test Service Name";
        languages = Sets.newTreeSet(Arrays.asList(Language.AMERICAN_SIGN_LANGUAGE, Language.SPANISH, Language.ENGLISH));

    }

    public ServiceDetailsBuilder withMusicStyle(MusicStyle musicStyle)
    {
        this.musicStyle = musicStyle;
        return this;
    }
    
    public ServiceDetailsBuilder withServiceStyle(ServiceStyle serviceStyle)
    {
        this.serviceStyle = serviceStyle;
        return this;
    }
    
    public ServiceDetailsBuilder withDressAttire(DressAttire dressAttire)
    {
        this.dressAttire = dressAttire;
        return this;
    }
    
    public ServiceDetailsBuilder withAgeDemongraphics(AgeDemographics ageDemongraphics)
    {
        this.ageDemongraphics = ageDemongraphics;
        return this;
    }
    
    public ServiceDetailsBuilder withInstruments(Set<MusicalInstruments> instruments)
    {
        this.instruments = instruments;
        return this;
    }
    
    public ServiceDetailsBuilder withDurationInMinutes(int durationInMinutes)
    {
        this.durationInMinutes = durationInMinutes;
        return this;
    }
    
    public ServiceDetailsBuilder withTimeAndDay(TimeAndDay timeAndDay)
    {
        this.timeAndDay = timeAndDay;
        return this;
    }
    
    public ServiceDetailsBuilder withServiceName(String serviceName)
    {
        this.serviceName = serviceName;
        return this;
    }
    
    public ServiceDetailsBuilder withLanguages(Set<Language> languages)
    {
        this.languages = languages;
        return this;
    }
    
    public ServiceDetailsBuilder addLanguage(Language language)
    {
        if(!this.languagesSetReset || this.languages == null)
        {
            this.languages = Sets.newTreeSet(Arrays.asList(language));
            this.languagesSetReset = true;
        }
        else
        {
            this.languages.add(language);
        }
        
        return this;
    }
    
    public ServiceDetailsBuilder addInstrument(MusicalInstruments instrument)
    {
        if(!this.instrumentsSetReset || this.instruments == null)
        {
            this.instruments = Sets.newTreeSet(Arrays.asList(instrument));
            this.instrumentsSetReset = true;
        }
        else
        {
            this.instruments.add(instrument);
        }
        
        return this;
    }
    
    public ServiceDetailsImpl build()
    {
        return new ServiceDetailsImpl(musicStyle, serviceStyle, dressAttire, ageDemongraphics, instruments, durationInMinutes, timeAndDay, serviceName, languages);
    }

}
