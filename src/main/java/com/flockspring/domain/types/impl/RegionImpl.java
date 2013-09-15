/*
 * Copyright 2013 flockspring Inc. All rights reserved
 */
package com.flockspring.domain.types.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.flockspring.domain.types.Organization;
import com.flockspring.domain.types.Region;


/**
 * RegionImpl.java
 *
 * @author Justen L. Britain
 * @date Jun 16, 2013
 *
 */
@Entity
@Table(name="GLOBAL_REGION")
public class RegionImpl extends JpaGlobalRegionImpl<Region> implements Region
{
    private static final long serialVersionUID = -1601591650248928148L;
    
    @ManyToOne
    @JoinColumn(name = "PARENT_REGION_ID")
    private RegionImpl parentRegion;
    
    @OneToMany(mappedBy = "region")
    private List<OrganizationImpl> organizations;
    
    @Override
    public List<Organization> getOrganizations()
    {
        List<Organization> organizationList = new ArrayList<Organization>();
        organizationList.addAll(organizations);
        
        return organizationList;
    }

    public void setOrganizations(List<OrganizationImpl> organizations)
    {
        this.organizations = organizations;
    }

    @Override
    public Region getParentRegion()
    {
        return parentRegion;
    }
}