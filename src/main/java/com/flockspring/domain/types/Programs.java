/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.types;

import com.flockspring.ui.model.LocalizedEnum;

/**
 * Programs.java
 *
 * @author Justen L. Britain
 * @date Oct 27, 2013
 *
 */
public enum Programs implements LocalizedEnum, Category<Programs>
{
    NURSERY_CARE(null, "programs.nursery.care"),
    EDUCATION(null, "programs.education"),
    SUPPORT_AND_COUNSELING(null, "programs.support.and.counseling"),
    OUTREACH(null, "programs.outreach"),
    AGE_GROUPS(null, "programs.age.groups"),
    GENDER_GROUPS(null, "programs.gender.groups"),
    SOCIAL(null, "programs.social"),
    SPIRITUAL(null, "programs.spiritual"),
    MUSIC_AND_ARTS(null, "programs.music.and.arts"),
    
    INFANT_CARE(NURSERY_CARE, "programs.infant.care"),
    TODDLER_CARE(Programs.NURSERY_CARE, "programs.todeler.care"),
    SUNDAY_SCHOOL(Programs.EDUCATION, "programs.sunday.school"),
    BIBLE_STUDY(Programs.EDUCATION, "programs.bible.study"),
    ADULT_EDUCATION(Programs.EDUCATION, "programs.adult.education"),
    SPIRITUAL_CLASSES(Programs.EDUCATION, "programs.spiritual.classes"),
//    PRE_SCHOOL(Programs.NUSRSERY_CARE_AND_EDUCATIONAL, "programs.pre.school"),
//    PRIMARY_SCHOOL(Programs.NUSRSERY_CARE_AND_EDUCATIONAL, "programs.primary.school"),
//    SECONDARY_SCHOOL(Programs.NUSRSERY_CARE_AND_EDUCATIONAL, "programs.secondary.school"),
//    GRADUATE_STUDIES(Programs.NUSRSERY_CARE_AND_EDUCATIONAL, "programs.graduate.sutides"),
    CHILDRENS_GROUP(Programs.AGE_GROUPS, "programs.childrens.group"),
    MIDDLE_SCHOOL_GROUP(Programs.AGE_GROUPS, "programs.middle.school.group"),
    HIGH_SCHOOL_GROUP(Programs.AGE_GROUPS, "programs.high.school.group"),
    COLLEGE_GROUP(Programs.AGE_GROUPS, "programs.college.group"),
    YOUNG_ADULT_GROUP(Programs.AGE_GROUPS, "programs.young.adult.group"),
    ADULT_GROUP(Programs.AGE_GROUPS, "programs.adult,group"),
    SENIOR_GROUP(Programs.AGE_GROUPS, "programs.senior.group"),
    MENS_GROUP(Programs.GENDER_GROUPS, "programs.mens.group"),
    WOMENS_GROUP(Programs.GENDER_GROUPS, "programs.womens.group"),
    CHOIR(Programs.MUSIC_AND_ARTS, "programs.chior"),
    DANCE(Programs.MUSIC_AND_ARTS, "programs.dance"),
    MUSIC_MINISTRY(Programs.MUSIC_AND_ARTS, "programs.music.ministry"),
    DRAMA(Programs.MUSIC_AND_ARTS, "programs.drama"),
    CREATIVE_ARTS(Programs.MUSIC_AND_ARTS, "programs.creative.arts"),
    SPORTS(Programs.SOCIAL, "programs.sports"),
    SOCIAL_EVENTS(Programs.SOCIAL, "programs.social.events"),
    SMALL_GROUPS(Programs.SOCIAL, "programs.small.groups"),
    SINGLES_GROUPS(Programs.SOCIAL, "programs.singles.groups"),
    PRAYER_GROUPS(Programs.SPIRITUAL, "programs.prayer.groups"),
    HEALING_MINISTRY(Programs.SPIRITUAL, "programs.healing.ministry"),
    PROPHETIC_MINISTRY(Programs.SPIRITUAL, "programs.prophetic.ministry"),
    WORSHIP_MINISTRY(Programs.SPIRITUAL, "programs.worship.ministry"),
    MEDITATION(Programs.SPIRITUAL, "programs.meditation"),
    PRE_MARITIAL_COUNSELING(Programs.SUPPORT_AND_COUNSELING, "programs.premarital.counseling"),
    COUPLES_COUNSELING(Programs.SUPPORT_AND_COUNSELING, "programs.couples.counseling"),
    GENERAL_COUNSELING(Programs.SUPPORT_AND_COUNSELING, "programs.general.counseling"),
    DIVORCE_GRIEF_COUNSELING(Programs.SUPPORT_AND_COUNSELING, "programs.divorce.grief.counseling"),
    ADDICTION_RECOVERY_COUNSELING(Programs.SUPPORT_AND_COUNSELING, "programs.addiction.recovery.counseling"),
    COMMUNITY_OUTREACH(Programs.OUTREACH, "programs.community.outreach"),
    FOOD_PANTRY_OUTREACH(Programs.OUTREACH, "programs.food.pantry.outreach"),
    FAMILY_OUTREACH(Programs.OUTREACH, "programs.family.outreach"),
    HOMELESS_OUTREACH(Programs.OUTREACH, "programs.homeless.outreach"),
    SOCIAL_JUSTICE_OUTREACH(Programs.OUTREACH, "programs.social.justice.outreach"),
    EVANGELISM_OUTREACH(Programs.OUTREACH, "programs.evangelism.outreach"),
    MISSION_OUTREACH(Programs.OUTREACH, "programs.mission.outreach");
    
    private Programs category;
    private String localizedStringCode;
    
    private Programs(Programs category, String localizedStringCode)
    {
        this.category = category;
        this.localizedStringCode = localizedStringCode;
    }
    
    @Override
    public Programs getCategory()
    {
        return category;
    }

    @Override
    public String getLocalizedStringCode()
    {
        return localizedStringCode;
    }

    @Override
    public String getName()
    {
        return this.name();
    }

    @Override
    public int getOrdinal()
    {
        return this.ordinal();
    }
}
