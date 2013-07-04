/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.types.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.flockspring.domain.types.Affiliation;

/**
 * Affiliation.java
 *
 * @author Justen L. Britain
 * @date Jun 12, 2013
 *
 */
@Entity
@Table(name="AFFILIATION")
public class AffiliationImpl implements Affiliation, Serializable
{

    private static final long serialVersionUID = -6291629734496256600L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name="NAME")
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "PARENT_AFFILIATION_ID")
    private AffiliationImpl parentAffiliation;
    
    @OneToMany(mappedBy="parentAffiliation")
    private List<AffiliationImpl> subAffiliations;
    
    @Override
    public String getAffiliationName()
    {
        
        return name;
    }

    @Override
    public Affiliation getParentAffiliation()
    {
        
        return parentAffiliation;
    }
    @Override
    public List<Affiliation> getSubAffiliations()
    {
        List<Affiliation> subAffiliationList = new ArrayList<Affiliation>();
        subAffiliationList.addAll(subAffiliationList);
        
        return subAffiliationList;
    }

    @Override
    public long getId()
    {
        return id;
    }

    @Override
    public String getName()
    {
        return name;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setParentAffiliation(AffiliationImpl parentAffiliation)
    {
        this.parentAffiliation = parentAffiliation;
    }

    public void setSubAffiliations(List<AffiliationImpl> subAffiliations)
    {
        this.subAffiliations = subAffiliations;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((parentAffiliation == null) ? 0 : parentAffiliation.hashCode());
        result = prime * result + ((subAffiliations == null) ? 0 : subAffiliations.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AffiliationImpl other = (AffiliationImpl) obj;
        if (id != other.id)
            return false;
        if (name == null)
        {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (parentAffiliation == null)
        {
            if (other.parentAffiliation != null)
                return false;
        } else if (!parentAffiliation.equals(other.parentAffiliation))
            return false;
        if (subAffiliations == null)
        {
            if (other.subAffiliations != null)
                return false;
        } else if (!subAffiliations.equals(other.subAffiliations))
            return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "AffiliationImpl [id=" + id + ", " + (name != null ? "name=" + name + ", " : "")
                + (parentAffiliation != null ? "parentAffiliation=" + parentAffiliation + ", " : "")
                + (subAffiliations != null ? "subAffiliations=" + subAffiliations : "") + "]";
    }
}