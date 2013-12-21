/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.model;

/**
 * Programs.java
 *
 * @author Justen L. Britain
 * @date Oct 27, 2013
 *
 */
public enum Programs implements LocalizedEnum
{
    NUSRSERY_CARE_AND_EDUCATIONAL(null, "programs.nursery.care.and.educational"),    
    SUPPORT_AND_OUTREACH(null, "programs.support.and.outreach"),
    SOCIAL_AND_SPIRITUAL(null, "programs.social.and.spiritual"),
    AGE_GROUPS_AND_CREATIVE_ARTS(null, "programs.age.groups.and.creative.arts"),
    
    INFANT_CARE(NUSRSERY_CARE_AND_EDUCATIONAL, "programs.infant.care"),
    TODDLER_CARE(Programs.NUSRSERY_CARE_AND_EDUCATIONAL, "programs.todeler.care"),
    SUNDAY_SCHOOL(Programs.NUSRSERY_CARE_AND_EDUCATIONAL, "programs.sunday.school"),
    BIBLE_STUDY(Programs.NUSRSERY_CARE_AND_EDUCATIONAL, "programs.bible.study"),
    ADULT_EDUCATION(Programs.NUSRSERY_CARE_AND_EDUCATIONAL, "programs.adult.education"),
    SPIRITUAL_CLASSES(Programs.NUSRSERY_CARE_AND_EDUCATIONAL, "programs.spiritual.classes"),
    PRE_SCHOOL(Programs.NUSRSERY_CARE_AND_EDUCATIONAL, "programs.pre.school"),
    PRIMARY_SCHOOL(Programs.NUSRSERY_CARE_AND_EDUCATIONAL, "programs.primary.school"),
    SECONDARY_SCHOOL(Programs.NUSRSERY_CARE_AND_EDUCATIONAL, "programs.secondary.school"),
    GRADUATE_STUDIES(Programs.NUSRSERY_CARE_AND_EDUCATIONAL, "programs.graduate.sutides"),
    CHILDRENS_GROUP(Programs.AGE_GROUPS_AND_CREATIVE_ARTS, "programs.childrens.group"),
    MIDDLE_SCHOOL_GROUP(Programs.AGE_GROUPS_AND_CREATIVE_ARTS, "programs.middle.school.group"),
    HIGH_SCHOOL_GROUP(Programs.AGE_GROUPS_AND_CREATIVE_ARTS, "programs.high.school.group"),
    YOUNG_ADULT_GROUP(Programs.AGE_GROUPS_AND_CREATIVE_ARTS, "programs.young.adult.group"),
    ADULT_GROUP(Programs.AGE_GROUPS_AND_CREATIVE_ARTS, "programs.adult,group"),
    SENIOR_GROUP(Programs.AGE_GROUPS_AND_CREATIVE_ARTS, "programs.senior.group"),
    MENS_GROUP(Programs.AGE_GROUPS_AND_CREATIVE_ARTS, "programs.mens.group"),
    WOMENS_GROUP(Programs.AGE_GROUPS_AND_CREATIVE_ARTS, "programs.womens.group"),
    CHIOR(Programs.AGE_GROUPS_AND_CREATIVE_ARTS, "programs.chior"),
    DANCE(Programs.AGE_GROUPS_AND_CREATIVE_ARTS, "programs.dance"),
    MUSIC_MINISTRY(Programs.AGE_GROUPS_AND_CREATIVE_ARTS, "programs.music.ministry"),
    DRAMA(Programs.AGE_GROUPS_AND_CREATIVE_ARTS, "programs.drama"),
    CREATIVE_ARTS(Programs.AGE_GROUPS_AND_CREATIVE_ARTS, "programs.creative.arts"),
    SPROTS(Programs.SOCIAL_AND_SPIRITUAL, "programs.sports"),
    SOCAIL_EVENTS(Programs.SOCIAL_AND_SPIRITUAL, "programs.social.events"),
    SMALL_GROUPS(Programs.SOCIAL_AND_SPIRITUAL, "programs.small.groups"),
    SINGLES_GROUPS(Programs.SOCIAL_AND_SPIRITUAL, "programs.singles.groups"),
    PRAYER_GROUPS(Programs.SOCIAL_AND_SPIRITUAL, "programs.prayer.groups"),
    HEALING_MINISTRY(Programs.SOCIAL_AND_SPIRITUAL, "programs.healing.ministry"),
    PROPHETIC_MINISTRY(Programs.SOCIAL_AND_SPIRITUAL, "programs.prophetic.ministry"),
    WORSHIP_MINISTRY(Programs.SOCIAL_AND_SPIRITUAL, "programs.worship.ministry"),
    PRE_MARITIAL_COUNSELING(Programs.SUPPORT_AND_OUTREACH, "programs.premarital.counseling"),
    COUPLES_COUNSELING(Programs.SUPPORT_AND_OUTREACH, "programs.couples.counseling"),
    GENERAL_COUNSELING(Programs.SUPPORT_AND_OUTREACH, "programs.general.counseling"),
    DIVORCE_GRIEF_COUNSELING(Programs.SUPPORT_AND_OUTREACH, "programs.divorce.grief.counseling"),
    ADDICTION_RECOVERY_COUNSELING(Programs.SUPPORT_AND_OUTREACH, "programs.addiction.recovery.counseling"),
    COMMUNITY_OUTREACH(Programs.SUPPORT_AND_OUTREACH, "programs.community.outreach"),
    FOOD_PANTRY_OUTREACH(Programs.SUPPORT_AND_OUTREACH, "programs.food.pantry.outreach"),
    FAMILY_OUTREACH(Programs.SUPPORT_AND_OUTREACH, "programs.family.outreach"),
    HOMELESS_OUTREACH(Programs.SUPPORT_AND_OUTREACH, "programs.homeless.outreach"),
    SOCIAL_JUSTICE_OUTREACH(Programs.SUPPORT_AND_OUTREACH, "programs.social.justice.outreach"),
    EVANGELISM_OUTREACH(Programs.SUPPORT_AND_OUTREACH, "programs.evangelism.outreach"),
    MISSION_OUTREACH(Programs.SUPPORT_AND_OUTREACH, "programs.mission.outreach");
    
    private Programs category;
    private String localizedStringCode;
    
    private Programs(Programs category, String localizedStringCode)
    {
        this.category = category;
        this.localizedStringCode = localizedStringCode;
    }
    
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
