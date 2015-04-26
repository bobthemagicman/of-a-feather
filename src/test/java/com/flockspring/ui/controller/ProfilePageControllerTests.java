package com.flockspring.ui.controller;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyDouble;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Locale;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.flockspring.config.TestControllerConfig;
import com.flockspring.config.TestSocialConfig;
import com.flockspring.domain.service.OrganizationDiscoveryService;
import com.flockspring.domain.types.Organization;
import com.flockspring.domain.types.impl.ApplicationUserImpl;
import com.flockspring.domain.types.impl.OrganizationImpl;
import com.flockspring.ui.IdentifiedPageTests;
import com.flockspring.ui.config.SecurityConfig;
import com.flockspring.ui.config.WebappConfig;
import com.flockspring.ui.mapper.OrganizationUIModelMapper;
import com.flockspring.ui.model.OrganizationUIModel;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestControllerConfig.class, WebappConfig.class, SecurityConfig.class, TestSocialConfig.class})
@WebAppConfiguration
@ActiveProfiles("controller-tests")
public class ProfilePageControllerTests extends IdentifiedPageTests {
 
    private final static String ORGANIZATION_ID = "S123456789654";
    
    private MockMvc mockMvc;

    @Autowired
    private OrganizationDiscoveryService organizationDiscoveryService;
    
    @Autowired
    private OrganizationUIModelMapper organizationUIModelMapper;
 
    @Autowired
    private WebApplicationContext webApplicationContext;
    
    @Autowired
    private FilterChainProxy springSecurityFilterChain;

	private OrganizationUIModel organizationModel = Mockito.mock(OrganizationUIModel.class);
    private Organization organization;
    
    @Before
    public void setUp() 
    {
    	organization = new OrganizationImpl.OrganizationBuilder()
    			.withId(ORGANIZATION_ID)
				.build();
    	
        Mockito.reset(organizationDiscoveryService, organizationUIModelMapper, organizationModel);
        
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
        		.addFilters(springSecurityFilterChain)
        		.build();
    }
 
    @Test
    public void testRenderOrganizationByProfileIdRedirectsToCanonical() throws Exception {
        when(organizationDiscoveryService.getOrganization(anyString())).thenReturn(organization);
        when(organizationUIModelMapper.map(any(Organization.class), anyDouble(), any(Locale.class), any(ApplicationUserImpl.class))).thenReturn(organizationModel);
        
        mockMvc.perform(get("/churches/" + ORGANIZATION_ID))
        		.andExpect(status().isOk())
                .andExpect(view().name("profilePage"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/profilePage.jsp"))
                .andExpect(model().attribute("organization", organizationModel))
                .andExpect(model().attribute("hasPreviousSearch", false))
                .andExpect(model().attribute("searchQuery", ""));
 
        verify(organizationDiscoveryService, times(1)).getOrganization(ORGANIZATION_ID);
        verifyNoMoreInteractions(organizationDiscoveryService);
    }

    @Test
    public void testRenderOrganizationByRegionAndNameNoDenomination() throws Exception {
    	
    }
    
    @Test
    public void testRenderOrganizationByRegionAndNameAndDenomination() throws Exception {
    	
    }
    
    @Override
    public void testPageIsIdentified() throws Exception
    {
		when(organizationDiscoveryService.getOrganization(anyString())).thenReturn(organization);
		when(organizationUIModelMapper.map(any(Organization.class), anyDouble(), any(Locale.class), any(ApplicationUserImpl.class))).thenReturn(organizationModel);
		
		mockMvc.perform(get("/churches/" + ORGANIZATION_ID))
				.andExpect(status().isOk())
                .andExpect(view().name("profilePage"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/profilePage.jsp"))
		        .andExpect(model().attribute(PAGE_ID_MAP_KEY, ProfilePageController.PAGE_ID));
    }
}
