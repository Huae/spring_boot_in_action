package com.huae.ch4.springmvc;

import com.huae.ch4.springmvc.config.SpringMVCconfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Spring使用WebApplicationInitializer来配置Servlet3.0+的接口,从而替代web.xml
 * 实现WebApplicationInitializer接口的类会被Spring容器获取到
 */
public class WebInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // 初始化WebApplicationContext 注册配置类并将其和当前ServletContext关联
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(SpringMVCconfig.class);

        // 配置springmvc核心Servlet(请求拦截分发)
        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
        servlet.setAsyncSupported(true);    // 开启异步方法支持
        ctx.setServletContext(servletContext);
    }


}