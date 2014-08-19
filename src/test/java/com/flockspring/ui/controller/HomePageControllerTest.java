package com.flockspring.ui.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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
import com.flockspring.ui.IdentifiedPageTests;
import com.flockspring.ui.config.SecurityConfig;
import com.flockspring.ui.config.WebappConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestControllerConfig.class, TestSocialConfig.class, SecurityConfig.class, WebappConfig.class})
@WebAppConfiguration
@ActiveProfiles(profiles = "tests")
public class HomePageControllerTest extends IdentifiedPageTests 
{
 
    private MockMvc mockMvc;
 
    @Autowired
    private WebApplicationContext webApplicationContext;
 
    @Autowired
    private FilterChainProxy springSecurityFilterChain;
    
    @Before
    public void setUp()
    {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .addFilters(springSecurityFilterChain).build();
    }
    
    @Test
    public void testRenderDefaultHomePage() throws Exception 
    {
 
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("homePage"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/homePage.jsp"));
    }

    
    @Override
    @Test
    public void testPageIsIdentified() throws Exception
    {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("homePage"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/homePage.jsp"))
                .andExpect(model().attribute(PAGE_ID_MAP_KEY, HomePageController.PAGE_ID));
    }
}
