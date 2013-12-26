/*
 * Copyright 2013 flockspring Inc. All rights reserved
 */
package com.flockspring.domain.types;

import com.flockspring.ui.model.LocalizedEnum;

public enum Affiliation implements LocalizedEnum
{
    NONDENOMINATIONAL("affiliation.nondenominational"),
    CATHOLIC("affiliation.catholicism"),
    EASTERN_ORTHODOX("affiliation.eastern.orthodox"),
    ORIENTAL_ORTHODOX("affiliation.oriental.orthodox"),
    PROTESTANT("affiliation.protestantism"),
    LUTHERAN("affiliation.lutheranism"),
    ANGLICAN("affiliation.angelicanism"),
    CALVIN("affiliation.calvinism"),
    PRESBYTERIAN("affiliation.presbyterianism"),
    CONGREGATIONALIST("affiliation.congregationalist"),
    ANABAPTISTS("affiliation.anabaptists"),
    BRETHREN("affiliation.brethren"),
    METHODISTS("affiliation.methodists"),
    PRIESTS_AND_HOLINESS("affiliation.priests.and.holiness"),
    BAPTIST("affiliation.baptists"),
    APISTOLIC("affiliation.apistolic"),
    PENTECOSTAL("affiliation.pentecostalism"),
    CHARISMATICS("affiliation.charismatics"),
    AFRICAN_INITIATED("affiliation.african.initiated"),
    MESSIANIC_JUDA("affiliation.messianic.judiasm"),
    UNITED_AND_UNITING("affiliation.united.and.uniting"),
    QUAKER("affiliation.quaker"),
    STONE_CAMPBELL_RESTORATION("affiliation.stone.campbell.restoration"),
    SOUTHCOTTITES("affiliation.southcottites"),
    MILLERITES("affiliation.millerites"),
    LATTER_DAY_SAINTS("affiliation.latter.day.saints"),
    ONENESS_PENTACOSTAL("affiliation.oneness.pentacostalism"),
    UNITARIAN("affiliation.unitarian"),
    BIBLE_STUDENT_GROUPS("affiliation.bible.student.groups"),
    CHRISTIAN_SCIENCE("affiliation.christian.science"),
    NEW_THOUGHT("affiliation.new.thought"),
    ESOTERIC("affiliation.esotericism"),
    ASSEMBLIES_OF_GOD("affiliation.assemblies.of.god"),
    CHURCH_OF_GOD("affiliation.church.of.god"),
    DISCIPLES_OF_CHRIST("affiliation.disciples.of.christ"),
    FOURSQUARE("affiliation.foursquare"),
    JEHOVAS_WITNESS("affiliation.jehovas.witness"),
    MENNONITE("affiliation.mennonite"),
    NAZARENE("affiliation.nazarene"),
    OPEN_BIBLE("affiliation.open.bible"),
    ORTHODOX("affiliation.orthodox"),
    REFORMED_CHURCHES("affiliation.reformed.churches"),
    SEVENTH_DAY_ADVENTIST("affiliation.seventh.day.adventist"),
    UNITED_CHURCH_OF_CHRIST("affiliation.united.church.of.christ"),
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
