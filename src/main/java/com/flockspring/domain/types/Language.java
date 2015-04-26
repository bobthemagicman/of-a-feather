/*  Copyright (c) 2013, Lehman Technolog Group
/*
 *  All rights reserved.
 *  
 *  Redistribution and use in source and binary forms, with or without modification, are permitted provided that 
 *  the following conditions are met:
 *  
 *  Redistributions of source code must retain the above copyright notice, this list of conditions and the following 
 *  disclaimer.
 *  
 *  Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following 
 *  disclaimer in the documentation and/or other materials provided with the distribution.
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "aS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, 
 *  INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
 *  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR 
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; 
 *  OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT 
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF 
 *  SUCH DAMAGE.
 *
 */
package com.flockspring.domain.types;

/**
 * Language.java
 *
 * @author Justen L. Britain
 * @date May 18, 2013
 *
 */
public enum Language {
    AMERICAN_SIGN_LANGUAGE(new String[]{"language.american.sign.language"}, new String[]{"American Sign Language"}),
    ARMENIAN(new String[]{"language.armenian"}, new String[]{"հայերեն"}),
    CANTONESE(new String[]{"language.cantonese", "yue", "yueh"}, new String[]{"粵語/粤语"}),
    MANDARIN(new String[]{"language.mandarin"}, new String[]{"官话"}),
    FRENCH(new String[]{"language.french"}, new String[]{"français"}), 
    FRENCH_CREOLE(new String[]{"language.french.creole"}, new String[]{}),
    GERMAN(new String[]{"language.german"}, new String[]{"ˈdɔʏtʃ"}),
    GREEK(new String[]{"language.greek"}, new String[]{"ελληνικά"}),
    GUJARATI(new String[]{"language.gujarati"}, new String[]{"ગુજરાતી "}),
    HINDI(new String[]{"language.hindi"}, new String[]{""}),
    HMONG(new String[]{"language.hmong", "mong", "miao"}, new String[]{"lus hmoob", "lug moob", "lol hmongb"}),
    ITALIAN(new String[]{"language.italian"}, new String[]{"Italiano"}),
    JAPANESE(new String[]{"language.japanese"}, new String[]{"日本語"}),
    KOREAN(new String[]{"language.korean"}, new String[]{"한국어, 조선말"}),
    LAOTIAN(new String[]{"language.loation"}, new String[]{"ພາສາລາວ"}),
    KHMER(new String[]{"language.khmer", "cambodian"}, new String[]{"ភាសាខ្មែរ"}),
    PORTUGESE(new String[]{"language.portuguese"}, new String[]{"português"}),
    RUSSIAN(new String[]{"language.russian"}, new String[]{"ру́сский язы́к"}),
    SERBO_CROATION(new String[]{"language.serbo.croatian", "serbo-croat"}, new String[]{"srpskohrvatski"}),
    SPANISH(new String[]{"language.spanish", "castilian"}, new String[]{"español"}),
    THAI(new String[]{"language.thai", "siamese"}, new String[]{"ภาษาไทย"}),
    URDU(new String[]{"language.urdu"}, new String[]{"اُردُو"}),
    VIETNAMESE(new String[]{"language.vietnamese"}, new String[]{"Tiếng Việt"}),
    YIDDISH(new String[]{"language.yiddish"}, new String[]{"ייִדיש"}),
    ENGLISH(new String[]{"language.english"}, new String[]{"english"});
//    ARABIC(new String[]{"arabic"}, new String[]{"العربية"}),
//    BENGALI(new String[]{"bengali"}, new String[]{"বাংলা"}),
//    PUNJABI(new String[]{"punjabi"}, new String[]{"ਪੰਜਾਬੀ"}),
//    JAVANESE(new String[]{"javanese"}, new String[]{""}),
//    WU(new String[]{"wu"}, new String[]{"吴语"}),
//    MALAY(new String[]{"malay", "indonesian"}, new String[]{"Bahasa Melayu"}),
//    TELUGU(new String[]{"telugu"}, new String[]{"తెలుగు"}),
//    MARATHI(new String[]{"marathi"}, new String[]{"मराठी "}),
//    TAMIL(new String[]{"tamil"}, new String[]{"தமிழ்"}),
//    PERSIAN(new String[]{"persian"}, new String[]{"فارسی"}),
//    TURKISH(new String[]{"turkish", "Istanbul Turkish"}, new String[]{"Türkçe"}),
//    JIN(new String[]{"jin", "jinese"}, new String[]{"晋语"}),
//    MIN_NAN(new String[]{"min Nan"}, new String[]{" 闽南语"}),
//    POLISH(new String[]{"polish", "pakhto"}, new String[]{"język polski"}),
//    PASHTO(new String[]{"pashto"}, new String[]{"پښتو"}),
//    KANNADA(new String[]{"kannada", "kanarese"}, new String[]{"kannaḍa"}),
//    XIANG(new String[]{"xiang", "siang"}, new String[]{"湘语"}),
//    MALAYALAM(new String[]{"malayalam"}, new String[]{"മലയാളം"}),
//    SUNDANESE(new String[]{"sundanese"}, new String[]{""}),
//    HAUSA(new String[]{"hausa"}, new String[]{"هَوُسَ"}),
//    ORIYA(new String[]{"oriya"}, new String[]{"ଓଡ଼ିଆ oṛiā"}),
//    BURMESE(new String[]{"burmese"}, new String[]{"မြန်မာစာ"}),
//    HAKKA(new String[]{"hakka", "kejia"}, new String[]{"客家話/客家话"}),
//    UKRAINIAN(new String[]{"ukrainian"}, new String[]{"українська мова"}),
//    BHOJPURI(new String[]{"bhojpuri"}, new String[]{"भोजपुरी"}),
//    TAGALOG(new String[]{"tagalog"}, new String[]{"Wikang Tagalog"}),
//    YORUBA(new String[]{"yoruba"}, new String[]{"Yorùbá"}),
//    MAITHILI(new String[]{"maithili"}, new String[]{"मैथिली, মৈথিলী"}),
//    UZBEK(new String[]{"uzbek"}, new String[]{"oʻzbek tili"}),
//    SINDHI(new String[]{"sindhi"}, new String[]{"سنڌي"}),
//    AMARIC(new String[]{"amharic"}, new String[]{"አማርኛ?"}),
//    FULA(new String[]{"fula", "fulani"}, new String[]{"Fulfulde"}),
//    ROMANIAN(new String[]{"romanian"}, new String[]{"Daco-Romanian"}),
//    OROMO(new String[]{"oromo"}, new String[]{""}),
//    IGBO(new String[]{"igbo"}, new String[]{"Asụsụ Igbo"}),
//    AZERBAIJANI(new String[]{"azerbaijani", "azeri"}, new String[]{"آذربايجان ديلی"}),
//    AWADHI(new String[]{"awadhi"}, new String[]{"अवधी"}),
//    GAN_CHINESE(new String[]{"gan Chinese", "jiangxinese"}, new String[]{"贛語"}),
//    CEBUANO(new String[]{"cebuano", "binisaya"}, new String[]{"Bisaya"}),
//    DUTCH(new String[]{"dutch"}, new String[]{"Nederlands"}),
//    KURDISH(new String[]{"kurdish"}, new String[]{"کوردی"}),
//    MALAGASY(new String[]{"malagasy"}, new String[]{""}),
//    SARAIKI(new String[]{"saraiki", "siraiki"}, new String[]{"سرائیکی"}),
//    NEPALI(new String[]{"nepali"}, new String[]{"नेपाली"}),
//    SINHALESE(new String[]{"sinhalese", "sinhalese"}, new String[]{"සිංහල"}),
//    CHITTAGONIAN(new String[]{"chittagonian"}, new String[]{"চাটগাঁইয়া বুলি"}),
//    ZHUANG(new String[]{"zhuang"}, new String[]{"Vahcuengh"}),
//    ASSAMESE(new String[]{"assamese", "asamiya"}, new String[]{"অসমীয়া"}),
//    MADURESE(new String[]{"madurese"}, new String[]{"Madhura"}),
//    SOMALI(new String[]{"somali"}, new String[]{"Af-Soomaali"}),
//    MARWARI(new String[]{"marwari", "marvari", "marwadi", "marvadi"}, new String[]{"मारवाड़ी"}),
//    MAGAHI(new String[]{"magahi", "magadhi"}, new String[]{"मगही", "मगधी"}),
//    HARYANVI(new String[]{"haryanvi"}, new String[]{"हरियाणवी"}),
//    HUNGARIAN(new String[]{"hungarian"}, new String[]{"magyar"}),
//    CHHATTISGARHI(new String[]{"chhattisgarhi", "khaltahi", "laria"}, new String[]{"छत्तीसगढ़ी"}),
//    CHEWA(new String[]{"chewa", "nyanja", "chichewa", "chinyanja"}, new String[]{""}),
//    DECCAN(new String[]{"deccan", "dakkhani", "deccani"}, new String[]{"دکنی‎"}),
//    AKAN(new String[]{"akan", "twi", "fante"}, new String[]{"", "tɕɥi", ""}),
//    KAZAKH(new String[]{"kazakh", "qazaq", "qazaqşa"}, new String[]{"қазақ тілі", "qazaq tili", "قازاق تىلى‎"}),
//    MIN_BEI(new String[]{"min bei", "northern min"}, new String[]{"闽北", "閩北", "mǐnběi"}),
//    SYLHETI(new String[]{"sylheti"}, new String[]{"ছিলটী", "Silôṭi"}),
//    ZULU(new String[]{"zulu"}, new String[]{"isiZulu"}),
//    CZECH(new String[]{"czech"}, new String[]{"čeština", "český jazyk"}),
//    KINYARWANDA(new String[]{"kinyarwanda", "rwanda", "rwandan"}, new String[]{"ikinyarwanda"}),
//    DHUNDHARI(new String[]{"dhundhari"}, new String[]{""}),
//    HAITIAN_CREOLE(new String[]{"haitian creole", "creole", "kreyòl"}, new String[]{"kreyòl ayisyen"}),
//    MIN_DONG(new String[]{"min Dong"}, new String[]{"閩東語", "閩東語", "mǐndōngyǔ"}),
//    ILOKANO(new String[]{"ilokano"}, new String[]{"Iloko"}),
//    QUECHUA(new String[]{"quechua"}, new String[]{"qhichwa Simi", "runa simi"}),
//    KIRUNDI(new String[]{"kirundi", "rundi"}, new String[]{"Ikirundi"}),
//    SWEDISH(new String[]{"swedish"}, new String[]{"svenska"}),
//    SHONA(new String[]{"shona", "chiShona"}, new String[]{""}),
//    UYGHUR(new String[]{"uyghur", "eastern turki"}, new String[]{"ئۇيغۇر تىلى"}),
//    HILIGAYNON(new String[]{"hiligaynon", "ilonggo"}, new String[]{""}),
//    MOSSI(new String[]{"mossi"}, new String[]{"mooré", "moré", "moshi", "moore","more"}),
//    XHOSA(new String[]{"xhosa"}, new String[]{"isiXhosa"}),
//    BELARUSIAN(new String[]{"belarusian", "white ruthenian"}, new String[]{"беларуская мова", "byelaruskaya mova"}),
//    BALOCHI(new String[]{"balochi"}, new String[]{"بلوچی", "baločî", "Balóćí"}),
//    KONKANI(new String[]{"konkani"}, new String[]{"कोंकणी", "konknni", "ಕೊಂಕಣಿ", "കൊങ്കണി"});
    
    private String[] names;
    private String[] UTF8Localizations;
    
    Language(String[] names, String[] UTF8Localizations)
    {
        this.names = names;
        this.UTF8Localizations = UTF8Localizations;
    }

    public String getCommonName()
    {
        return names[0];
    }
    public String[] getNames()
    {
        return names;
    }

    public String[] getUTF8Localizations()
    {
        return UTF8Localizations;
    }
    
    public String getName()
    {
        return this.name();
    }
}
