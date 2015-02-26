/**
 *
 *   Copyright 2015 Justen L. Britain
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 **/
package com.ofafeather.domain.service;

import java.util.List;

import org.springframework.data.mongodb.core.geo.GeoPage;

import com.ofafeather.domain.OrganizationFilter;
import com.ofafeather.domain.types.Address;
import com.ofafeather.domain.types.Organization;
import com.ofafeather.domain.types.impl.OrganizationImpl;

/**
 * IOrganizationService.java
 *
 * @author Justen L. Britain
 * @date May 18, 2013
 *
 */
public interface OrganizationDiscoveryService {

    GeoPage<OrganizationImpl> getFilteredOrganizations(final OrganizationFilter filterRequest, final int page);
    
    GeoPage<OrganizationImpl> getFilteredOrganizations(final OrganizationFilter filterRequest, final int page, final int dist);

    void saveOrganization(final OrganizationImpl organization);
    
	Organization getOrganization(final String OrganizationId);

	List<Organization> getOrganizationsForRegion(final Address address);
	
	List<OrganizationImpl> getOrganizationsByIds(final Iterable<String> organizationIds);

	Organization getOrganization(Address address, String organizationName);
}
