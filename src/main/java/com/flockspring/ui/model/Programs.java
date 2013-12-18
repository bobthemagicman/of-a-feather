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
    NUSRSERY_CARE_AND_EDUCATIONAL(null, "enum.nursery.care.and.educational"),    
    SUPPORT_AND_OUTREACH(null, "enum.support.and.outreach"),
    SOCIAL_AND_SPIRITUAL(null, "enum.social.and.spiritual"),
    AGE_GROUPS_AND_CREATIVE_ARTS(null, "enum.age.groups.and.creative.arts"),    
    INFANT_CARE(NUSRSERY_CARE_AND_EDUCATIONAL, "enum.infant.care"),
    TODDLER_CARE(Programs.NUSRSERY_CARE_AND_EDUCATIONAL, "enum.todeler.care"),
    SUNDAY_SCHOOL(Programs.NUSRSERY_CARE_AND_EDUCATIONAL, "enum.sunday.school"),
    BIBLE_STUDY(Programs.NUSRSERY_CARE_AND_EDUCATIONAL, "enum.bible.study"),
    ADULT_EDUCATION(Programs.NUSRSERY_CARE_AND_EDUCATIONAL, "enum.adult.education"),
    SPIRITUAL_CLASSES(Programs.NUSRSERY_CARE_AND_EDUCATIONAL, "enum.spiritual.classes"),
    PRE_SCHOOL(Programs.NUSRSERY_CARE_AND_EDUCATIONAL, "enum.pre.school"),
    PRIMARY_SCHOOL(Programs.NUSRSERY_CARE_AND_EDUCATIONAL, "enum.primary.school"),
    SECONDARY_SCHOOL(Programs.NUSRSERY_CARE_AND_EDUCATIONAL, "enum.secondary.school"),
    GRADUATE_STUDIES(Programs.NUSRSERY_CARE_AND_EDUCATIONAL, "enum.graduate.sutide"),
    CHILDRENS_GROUP(Programs.AGE_GROUPS_AND_CREATIVE_ARTS, "enum.childrens.group"),
    MIDDLE_SCHOOL_GROUP(Programs.AGE_GROUPS_AND_CREATIVE_ARTS, "enum.middle.school.group"),
    HIGH_SCHOOL_GROUP(Programs.AGE_GROUPS_AND_CREATIVE_ARTS, "enum.high.school.group"),
    YOUNG_ADULT_GROUP(Programs.AGE_GROUPS_AND_CREATIVE_ARTS, "enum.young.adult.group"),
    ADULT_GROUP(Programs.AGE_GROUPS_AND_CREATIVE_ARTS, "enum.adult,group"),
    SENIOR_GROUP(Programs.AGE_GROUPS_AND_CREATIVE_ARTS, "enum.senior.group"),
    MENS_GROUP(Programs.AGE_GROUPS_AND_CREATIVE_ARTS, "enum.mens.group"),
    WOMENS_GROUP(Programs.AGE_GROUPS_AND_CREATIVE_ARTS, "enum.womens.group"),
    CHIOR(Programs.AGE_GROUPS_AND_CREATIVE_ARTS, "enum.chior"),
    DANCE(Programs.AGE_GROUPS_AND_CREATIVE_ARTS, "enum.dance"),
    MUSIC_MINISTRY(Programs.AGE_GROUPS_AND_CREATIVE_ARTS, "enum.music.ministry"),
    DRAMA(Programs.AGE_GROUPS_AND_CREATIVE_ARTS, "enum.drama"),
    CREATIVE_ARTS(Programs.AGE_GROUPS_AND_CREATIVE_ARTS, "enum.creative.arts"),
    MENTORSHIPT(Programs.SOCIAL_AND_SPIRITUAL, "enum.mentorship"),
    SPROTS(Programs.SOCIAL_AND_SPIRITUAL, "enum.sports"),
    SOCAIL_EVENTS(Programs.SOCIAL_AND_SPIRITUAL, "enum.social.events"),
    SMALL_GROUPS(Programs.SOCIAL_AND_SPIRITUAL, "enum.small.groups"),
    SINGLES_GROUPS(Programs.SOCIAL_AND_SPIRITUAL, "enum.singles.groups"),
    PRAYER_GROUPS(Programs.SOCIAL_AND_SPIRITUAL, "enum.prayer.groups"),
    HEALING_MINISTRY(Programs.SOCIAL_AND_SPIRITUAL, "enum.healing.ministry"),
    PROPHETIC_MINISTRY(Programs.SOCIAL_AND_SPIRITUAL, "enum.prophetic.ministry"),
    WORSHIP_MINISTRY(Programs.SOCIAL_AND_SPIRITUAL, "enum.worship.ministry"),
    MEDITATION(Programs.SOCIAL_AND_SPIRITUAL, "enum.meditation"),
    PRE_MARITIAL_COUNSELING(Programs.SUPPORT_AND_OUTREACH, "enum.premarital.counseling"),
    COUPLES_COUNSELING(Programs.SUPPORT_AND_OUTREACH, "enum.couples.counseling"),
    GENERAL_COUNSELING(Programs.SUPPORT_AND_OUTREACH, "enum.general.counseling"),
    DIVORCE_GRIEF_COUNSELING(Programs.SUPPORT_AND_OUTREACH, "enum.divorce.grief.counseling"),
    ADDICTION_RECOVERY_COUNSELING(Programs.SUPPORT_AND_OUTREACH, "enum.addiction.recovery.counseling"),
    COMMUNITY_OUTREACH(Programs.SUPPORT_AND_OUTREACH, "enum.community.outreach"),
    FOOD_PANTRY_OUTREACH(Programs.SUPPORT_AND_OUTREACH, "enum.food.pantry.outreach"),
    FAMILY_OUTREACH(Programs.SUPPORT_AND_OUTREACH, "enum.family.outreach"),
    HOMELESS_OUTREACH(Programs.SUPPORT_AND_OUTREACH, "enum.homeless.outreach"),
    SOCIAL_JUSTICE_OUTREACH(Programs.SUPPORT_AND_OUTREACH, "enum.social.justice.outreach"),
    EVANGELISM_OUTREACH(Programs.SUPPORT_AND_OUTREACH, "enum.evangelism.outreach"),
    MISSION_OUTREACH(Programs.SUPPORT_AND_OUTREACH, "enum.mission.outreach");
    
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
