package com.ofafeather.config;

import org.mockito.Mockito;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.social.connect.ConnectionRepository;

import com.ofafeather.dataaccess.mongodb.UserSocialConnectionRepository;
import com.ofafeather.domain.service.GeoLocationService;
import com.ofafeather.domain.service.OrganizationDiscoveryService;
import com.ofafeather.domain.service.user.impl.UserDetailsServiceImpl;

public class TestWebConfig {

	public TestWebConfig() {
		super();
	}

	@Bean
	public MessageSource messageSource() {
	    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	
	    messageSource.setBasename("i18n/messages");
	    messageSource.setUseCodeAsDefaultMessage(true);
	
	    return messageSource;
	}

	@Bean
	public ConnectionRepository getConnectionRepository() {
	    return Mockito.mock(ConnectionRepository.class);
	}

	@Bean
	public OrganizationDiscoveryService getOrganizationDiscoveryService() {
	    return Mockito.mock(OrganizationDiscoveryService.class);
	}
	
	@Bean
	public GeoLocationService getGeoLocationService() {
	    return Mockito.mock(GeoLocationService.class);
	}

	@Bean
	public UserDetailsServiceImpl getUserDetailsServiceImpl() {
	    return Mockito.mock(UserDetailsServiceImpl.class);
	}

	@Bean
	public UserSocialConnectionRepository getUserSocialConnectionRepository() {
	    return Mockito.mock(UserSocialConnectionRepository.class);
	}

}