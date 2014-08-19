package com.flockspring.ui.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
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
import com.flockspring.domain.service.user.UserService;
import com.flockspring.ui.IdentifiedPageTests;
import com.flockspring.ui.config.SecurityConfig;
import com.flockspring.ui.config.WebappConfig;
import com.flockspring.ui.mapper.SearchResultsUIModelMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestControllerConfig.class, WebappConfig.class, SecurityConfig.class, TestSocialConfig.class})
@WebAppConfiguration
@ActiveProfiles(profiles = "controller-tests")
public class UserControllerTests extends IdentifiedPageTests {
 
    private MockMvc mockMvc;
 
    @Autowired
    private FilterChainProxy springSecurityFilterChain;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private OrganizationDiscoveryService organizationDiscoveryService;
    
    @Autowired
    private SearchResultsUIModelMapper searchResultsModelMapper;
 
    @Autowired
    private WebApplicationContext webApplicationContext;
 
    @Before
    public void setUp() {
        Mockito.reset(userService, organizationDiscoveryService, searchResultsModelMapper);
       
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .addFilters(springSecurityFilterChain).build();
    }
 
    @Test
    public void testRenderUserFavoritesNonAuthenticated() throws Exception 
    {
        mockMvc.perform(get("/user/favorites"))
                .andExpect(redirectedUrl("http://localhost/signin"));
                
    }
    
    @Test
    public void testRenderUserFavoritesAuthenticated() throws Exception 
    {
//        mockMvc.perform(get("/user/favorites").with(null))
//                .andExpect(status().isOk());
    }
    
    @Test
    public void testRenderUserPreferences() throws Exception {
        
    }
    
    @Test
    public void testAddFavoriteForUser() throws Exception {
        
    }

    @Override
    public void testPageIsIdentified() throws Exception
    {
        mockMvc.perform(get("/"))
        .andExpect(status().isOk())
        .andExpect(view().name("homePage"));
    }
}
