package com.flockspring.domain.service;

import com.flockspring.domain.types.Address;

public interface GeoLocationService
{

	Address getAddressFromQuery(String query);
}
