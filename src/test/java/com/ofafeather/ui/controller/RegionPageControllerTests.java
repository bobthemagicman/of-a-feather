package com.ofafeather.ui.controller;

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

import com.ofafeather.config.TestControllerConfig;
import com.ofafeather.config.TestSocialConfig;
import com.ofafeather.ui.IdentifiedPageTests;
import com.ofafeather.ui.config.SecurityConfig;
import com.ofafeather.ui.config.WebappConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestControllerConfig.class, WebappConfig.class, SecurityConfig.class, TestSocialConfig.class})
@WebAppConfiguration
@ActiveProfiles(profiles = "controller-tests")
public class RegionPageControllerTests extends IdentifiedPageTests {
 
    private MockMvc mockMvc;
 
 
    @Autowired
    private WebApplicationContext webApplicationContext;
 
    @Before
    public void setUp() {
    }
 
    @Test
    public void testRenderDefaultHomePage() throws Exception {
//        when(todoServiceMock.findAll()).thenReturn(Arrays.asList(first, second));
// 
//        mockMvc.perform(get("/"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("todo/list"))
//                .andExpect(forwardedUrl("/WEB-INF/jsp/todo/list.jsp"))
//                .andExpect(model().attribute("todos", hasSize(2)))
//                .andExpect(model().attribute("todos", hasItem(
//                        allOf(
//                                hasProperty("id", is(1L)),
//                                hasProperty("description", is("Lorem ipsum")),
//                                hasProperty("title", is("Foo"))
//                        )
//                )))
//                .andExpect(model().attribute("todos", hasItem(
//                        allOf(
//                                hasProperty("id", is(2L)),
//                                hasProperty("description", is("Lorem ipsum")),
//                                hasProperty("title", is("Bar"))
//                        )
//                )));
// 
//        verify(todoServiceMock, times(1)).findAll();
//        verifyNoMoreInteractions(todoServiceMock);
    }

    @Override
    public void testPageIsIdentified()
    {
        // TODO Auto-generated method stub
        
    }
}
