/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.types;

import java.util.List;

public interface Affiliation
{

    String getAffiliationName();

    List<Affiliation> getSubAffiliations();

    Affiliation getParentAffiliation();

    String getName();

    long getId();
}
