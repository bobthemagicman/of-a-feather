/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.types;

import com.lehman.technology.group.common.web.ui.model.LocalizedEnum;

public enum Affiliation implements LocalizedEnum
{
    //Christian Denominations
    CATHOLICISM("affiliation.catholicism"),
    EASTERN_ORTHODOX("affiliation.eastern.orthodox"),
    ORIENTAL_ORTHODOXY("affiliation.oriental.orthodoxy"),
    
    //Primary Religions
    BABISM("affiliation.babism"),
    BAHA_I_FAITH("affiliation.baha-i-faith", Affiliation.CATHOLICISM),
    CHRISTIANITY("affiliation.christianity"),
    DRUZE("affiliation.druze"),
    GNOSTICISM("affiliation.gnosticism"),
    ISLAM("affiliation.islam"),
    JUDAISM("affiliation.judiasm"),
    RASTAFARI_MOVEMENT("affiliation.rastafari.movement"),
    BLACK_HEBREW_ISRAELITES("affiliation.black.hebrew.israelites"),
    MANDAEANS("affiliation.mandaeans"),
    SABIANS("affiliation.sabians"),
    SAMARITANISM("affiliation.samaritanism"),
    SHABAKISM("affiliation.shabakism"),
    AYYAVAZHI("affiliation.ayyavazhi"),
    BHAKTI_MOVEMENT("affiliation.bhakti.movement"),
    BUDDHISM("affiliation.buddhism"),
    DIN_I_LLAHI("affiliation.din-i-llahi"),
    HINDUISM("affiliation.hinduism"),
    JAINISM("affiliation.jainism"),
    MEIVAZHI("affiliation.meivazhi"),
    SIKHISM("affiliation.sikhism"),
    MANICHAEISM("affiliation.manichaeism"),
    MAZDAKISM("affiliation.mazdakism"),
    MITHRAISM("affiliation.mithraism"),
    YAZDANISM("affiliation.yazdanism"),
    ZOROASTRIANISM("affiliation.zoroastrianism"),
    CONFUCIANISM("affiliation.confucianism"),
    SHINTO("affiliation.shinto"),
    TAOISM("affiliation.taoism"),
    CAODAISM("affiliation.caodaism"),
    CHINESE_FOLK("affiliation.chinese.folk"),
    CHONDOGYO("affiliation.chondogyo"),
    FALUN_GONG("affiliation.falun.gong"),
    HAO_HAO("affiliation.hao.hao"),
    I_KUAN_TAO("affiliation.i-kuan-tao"),
    JEUNG_SAN_DO("affiliation.jeung.san.do"),
    MOHISM("affiliation.mohism"),
    OOMOTO("affiliation.oomoto"),
    SEICHO_NO_LE("affiliation.seicho.no.le"),
    TENRIKYO("affiliation.tenrikyo"),
    BATUQUE("affiliation.batuque"),
    CANDOMBLE("affiliation.candomble"),
    DAHOMEY_MYTHOLOGY("affiliation.dahomey.mythology"),
    HAITAIN_MYTHOLOG("affiliation.haitain.mythology"),
    KUMINA("affiliation.kumina"),
    MACUMBA("affiliation.macumba"),
    MAMI_WATA("affiliation.mami.wata"),
    OBEAH("affiliation.obeah"),
    OYOTUNJI("affiliation.oyotunji"),
    QUIMBANDA("affiliation.quimbanda"),
    SANTERIA("affiliation.santeria"),
    UMBANDA("affiliation.umbanda"),
    VODOU("affiliation.vodou"),
    PALO("affiliation.palo");
    
    private String localizationCode;
    private Affiliation [] affiliations;
    
    Affiliation(String localizationCode, Affiliation ... affiliations)
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
}
