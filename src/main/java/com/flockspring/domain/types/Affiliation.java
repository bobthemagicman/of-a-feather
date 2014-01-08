/*
 * Copyright 2013 flockspring Inc. All rights reserved
 */
package com.flockspring.domain.types;

import com.flockspring.ui.model.LocalizedEnum;

public enum Affiliation implements LocalizedEnum
{
    APISTOLIC("affiliation.apistolic"),
    ASSEMBLIES_OF_GOD("affiliation.assemblies.of.god"),
//    AFRICAN_INITIATED("affiliation.african.initiated"),    
    ANGLICAN("affiliation.angelicanism"),    
//    ANABAPTISTS("affiliation.anabaptists"),
    BAPTIST("affiliation.baptists"),
//    BRETHREN("affiliation.brethren"),
//    BIBLE_STUDENT_GROUPS("affiliation.bible.student.groups"),
    CHRISTIAN_SCIENCE("affiliation.christian.science"),
//    CONGREGATIONALIST("affiliation.congregationalist"),
    CATHOLIC("affiliation.catholicism"),
//    CALVIN("affiliation.calvinism"),
    CHURCH_OF_GOD("affiliation.church.of.god"),
//    CHARISMATICS("affiliation.charismatics"),
    DISCIPLES_OF_CHRIST("affiliation.disciples.of.christ"),
//    ESOTERIC("affiliation.esotericism"),
//    EASTERN_ORTHODOX("affiliation.eastern.orthodox"),
    FOURSQUARE("affiliation.foursquare"),
    JEHOVAS_WITNESS("affiliation.jehovas.witness"),
    LUTHERAN("affiliation.lutheranism"),
    LATTER_DAY_SAINTS("affiliation.latter.day.saints"),
    METHODISTS("affiliation.methodists"),
//    MILLERITES("affiliation.millerites"),
    MESSIANIC_JUDAISM("affiliation.messianic.judiasm"),
    NONDENOMINATIONAL("affiliation.nondenominational"),
    MENNONITE("affiliation.mennonite"),
    NAZARENE("affiliation.nazarene"),
//    NEW_THOUGHT("affiliation.new.thought"),
    NONE("affiliation.none"),
//    ONENESS_PENTACOSTAL("affiliation.oneness.pentacostalism"),
//    ORIENTAL_ORTHODOX("affiliation.oriental.orthodox"),
    OPEN_BIBLE("affiliation.open.bible"),
    ORTHODOX("affiliation.orthodox"),
    PRESBYTERIAN("affiliation.presbyterianism"),
    PROTESTANT("affiliation.protestantism"),
    PENTECOSTAL("affiliation.pentecostalism"),    
//    PRIESTS_AND_HOLINESS("affiliation.priests.and.holiness"),
    QUAKER("affiliation.quaker"),
    REFORMED_CHURCHES("affiliation.reformed.churches"),
//    STONE_CAMPBELL_RESTORATION("affiliation.stone.campbell.restoration"),
//    SOUTHCOTTITES("affiliation.southcottites"),
    SEVENTH_DAY_ADVENTIST("affiliation.seventh.day.adventist"),
//    UNITED_AND_UNITING("affiliation.united.and.uniting"),
    UNITARIAN("affiliation.unitarian"),
    UNITED_CHURCH_OF_CHRIST("affiliation.united.church.of.christ");


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
