/*
 * Copyright 2013 flockspring Inc. All rights reserved
 */
package com.flockspring.domain.types;

import com.flockspring.ui.model.LocalizedEnum;

public enum Affiliation implements LocalizedEnum
{
    NONDENOMINATIONAL("affiliation.nondenominational"),
    CATHOLICISM("affiliation.catholicism"),
    EASTERN_ORTHODOX("affiliation.eastern.orthodox"),
    ORIENTAL_ORTHODOX("affiliation.oriental.orthodox"),
    PROTESTANTISM("affiliation.protestantism"),
    LUTHERANISM("affiliation.lutheranism"),
    ANGLICANISM("affiliation.angelicanism"),
    CALVINISM("affiliation.calvinism"),
    PRESBYTERIANISM("affiliation.presbyterianism"),
    CONGREGATIONALIST("affiliation.congregationalist"),
    ANABAPTISTS("affiliation.anabaptists"),
    BRETHREN("affiliation.brethren"),
    METHODISTS("affiliation.methodists"),
    PRIESTS_AND_HOLINESS("affiliation.priests.and.holiness"),
    BAPTISTS("affiliation.baptists"),
    APISTOLIC("affiliation.apistolic"),
    PENTECOSTALISM("affiliation.pentecostalism"),
    CHARISMATICS("affiliation.charismatics"),
    AFRICAN_INITIATED("affiliation.african.initiated"),
    MESSIANIC_JUDAISM("affiliation.messianic.judiasm"),
    UNITED_AND_UNITING("affiliation.united.and.uniting"),
    QUAKER("affiliation.quaker"),
    STONE_CAMPBELL_RESTORATION("affiliation.stone.campbell.restoration"),
    SOUTHCOTTITES("affiliation.southcottites"),
    MILLERITES("affiliation.millerites"),
    LATTER_DAY_SAINTS("affiliation.latter.day.saints"),
    ONENESS_PENTACOSTALISM("affiliation.oneness.pentacostalism"),
    UNITARIAN("affiliation.unitarian"),
    BIBLE_STUDENT_GROUPS("affiliation.bible.student.groups"),
    CHRISTIAN_SCIENCE("affiliation.christian.science"),
    NEW_THOUGHT("affiliation.new.thought"),
    ESOTERICISM("affiliation.esotericism"),
    NONE("affiliation.none");

    private String localizationCode;
    private Affiliation[] affiliations;

    Affiliation(String localizationCode, Affiliation... affiliations)
    {
        this.localizationCode = localizationCode;
        this.affiliations = affiliations;
    }

    @Override
    public String getLocalizedStringCode()
    {

        return localizationCode;
    }

    public Affiliation[] getChildAffiliations()
    {
        return affiliations;
    }
    
    @Override
    public String getName()
    {
        return this.name();
    }
    
    @Override
    public int getOrdinal()
    {
        return ordinal();
    }
}
