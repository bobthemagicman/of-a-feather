package com.flockspring.ui.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.flockspring.config.TestControllerConfig;
import com.flockspring.config.TestSocialConfig;
import com.flockspring.ui.IdentifiedPageTests;
import com.flockspring.ui.config.SecurityConfig;
import com.flockspring.ui.config.WebappConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestControllerConfig.class, WebappConfig.class, SecurityConfig.class, TestSocialConfig.class})
@WebAppConfiguration
@ActiveProfiles(profiles = "controller-tests")
public class SearchPageControllerTests extends IdentifiedPageTests {
 
    private MockMvc mockMvc;
 
    @Autowired
    private WebApplicationContext webApplicationContext;
 
    @Before
    public void setUp() {
    }
 
    @Test
    public void testRenderSearchPage() throws Exception {
 
    }

	@Override
	public void testPageIsIdentified() throws Exception {
		
	}
}
