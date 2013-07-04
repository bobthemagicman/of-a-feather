/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.types.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import com.flockspring.domain.types.Organization;
import com.flockspring.domain.types.Region;
import com.lehman.technology.group.common.domain.types.impl.JpaGlobalRegionImpl;


/**
 * RegionImpl.java
 *
 * @author Justen L. Britain
 * @date Jun 16, 2013
 *
 */
@Entity
public class RegionImpl extends JpaGlobalRegionImpl implements Region
{
    private static final long serialVersionUID = -1601591650248928148L;
    
    @OneToMany
    @JoinTable(name="REGION_ORGANIZATIONS", joinColumns=@JoinColumn(name = "REGION_ID"), inverseJoinColumns=@JoinColumn(name = "ORGANIZATION_ID"))
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
}