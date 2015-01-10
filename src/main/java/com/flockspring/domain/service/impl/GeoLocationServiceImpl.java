package com.flockspring.domain.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flockspring.domain.NoGeoLocationResultsException;
import com.flockspring.domain.service.GeoLocationException;
import com.flockspring.domain.service.GeoLocationService;
import com.flockspring.domain.types.Address;
import com.flockspring.domain.types.impl.AddressImpl;
import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderAddressComponent;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.code.geocoder.model.GeocoderResult;
import com.google.code.geocoder.model.GeocoderStatus;
import com.google.code.geocoder.model.LatLng;

@Service
public class GeoLocationServiceImpl implements GeoLocationService
{
	private static final String LOCALITY = "locality";
    private static final String POSTAL_CODE = "postal_code";
    private static final String STATE = "administrative_area_level_1";
    
	@Override
	public Address getAddressFromQuery(String query)
	{
		final Geocoder geocoder = new Geocoder();
        GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress(query).setLanguage("en").getGeocoderRequest();
        GeocodeResponse geocoderResponse = geocoder.geocode(geocoderRequest);
        GeocoderStatus status = geocoderResponse.getStatus();
        
        if(status == GeocoderStatus.OK)
        {
        	List<GeocoderResult> results = geocoderResponse.getResults();
        	
        	//TODO: this can cause bugs if more than one result is returned. Find a better solution.
        	return mapGoogleResultToAddress(results.get(0));
        }
        
        if(status == GeocoderStatus.ERROR || status == GeocoderStatus.INVALID_REQUEST || status == GeocoderStatus.ZERO_RESULTS)
        {
        	throw new NoGeoLocationResultsException(String.format("Error geolocating query, service returned with the followin non-OK status: ", status.name()));
        }
        
        throw new GeoLocationException(String.format("An Error occured while trying to geolocate query. QUERY: %1, GEOCODER_STATUS: %2.", query, status.name()));
	}
	
	private Address mapGoogleResultToAddress(GeocoderResult geocoderResult)
    {
        String streetNumber = "", route = "", postalCode = "", state = "", city = "", country = "", fullState = "";

        for (GeocoderAddressComponent component : geocoderResult.getAddressComponents())
        {
            switch (component.getTypes().get(0))
            {
                case POSTAL_CODE:
                    postalCode = component.getShortName();
                    break;

                case "country":
                    country = component.getShortName();
                    break;

                case STATE:
                    state = component.getShortName();
                    fullState = component.getLongName();
                    break;

                case LOCALITY:
                    city = component.getShortName();
                    break;

                case "street_number":
                    streetNumber = component.getShortName();
                    break;

                case "route":
                    route = component.getShortName();
                    break;
            }
        }

        LatLng latLng = geocoderResult.getGeometry().getLocation();
        double[] location = new double[]
        {latLng.getLng().doubleValue(), latLng.getLat().doubleValue()};

        return new AddressImpl.AddressBuilder()
                .withStreet1(new StringBuilder(streetNumber).append(route).toString())
                .withPostalCode(postalCode)
                .withState(state)
                .withCity(city)
                .withCountry(country)
                .withLocation(location)
                .withFullState(fullState)
                .build();
    }
}
