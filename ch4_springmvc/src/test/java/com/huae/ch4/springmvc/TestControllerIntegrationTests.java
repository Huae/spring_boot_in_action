package com.huae.ch4.springmvc;

import com.huae.ch4.springmvc.config.SpringMVCconfig;
import com.huae.ch4.springmvc.service.DemoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringMVCconfig.class})
@WebAppConfiguration("src/main/resources")  // 声明加载的ApplicationContext是WebApplicationContext 属性指定Web资源的位置
public class TestControllerIntegrationTests {
    /**
     * 模拟MVC对象 在setUp中初始化
     */
    private MockMvc mockMvc;

    @Autowired
    private DemoService demoService;

    /**
     * 注入WEB对象
     */
    @Autowired
    WebApplicationContext wac;

    /**
     * 注入模拟的request session对象
     */
    @Autowired
    MockHttpServletRequest request;
    @Autowired
    MockHttpSession session;

    /**
     * 测试开始前进行初始化工作
     */
    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testNormalController() throws Exception {
        mockMvc.perform(get("/normal")) // 模拟"get请求 /normal"
          .andExpect(status().isOk())   // 预期返回状态为 200
          .andExpect(view().name("page")) // 预期view的名称为'page'
          .andExpect(forwardedUrl("/WEB-INF/classes/views/page.jsp")) // 预期页面转向的真正路径为 /WEB-INFO/classes/views/page.jsp
          .andExpect(model().attribute("msg", demoService.saySomething())); // 预期model中msg属性的值为demoService.saySomething()的值hello
    }

    @Test
    public void testRestController() throws Exception {
        mockMvc.perform(get("/testRest")) // 模拟"get请求 /testRest"
          .andExpect(status().isOk())  // 预期返回状态为 200
          .andExpect(content().contentType("text/plain;charset=UTF-8")) // 预期返回媒体类型为 text/plain;charset=UTF-8
          .andExpect(content().string(demoService.saySomething())); // 预期返回的值为demoService.saySomething()的值hello
    }
}