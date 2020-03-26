package com.huae.ch4.springmvc.config;

import com.huae.ch4.springmvc.interceprot.DemoInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan("com.huae.ch4.springmvc")
public class SpringMVCconfig extends WebMvcConfigurerAdapter {  // 继承WebMvcConfigurerAdapter重写方法自定义MVC配置

    // 配置视图解析器
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/classes/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

    // 静态资源访问
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
    }

    @Override   // 添加拦截器
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(demoInterceptor());
    }

    @Bean
    public DemoInterceptor demoInterceptor() {
        return new DemoInterceptor();
    }

    @Override       // 添加全局路径视图匹配
    public void addViewControllers(ViewControllerRegistry registry) {
        // /index映射到index页面
        registry.addViewController("/index").setViewName("index");
        // 文件上传页面映射
        registry.addViewController("/toUpload").setViewName("upload");
    }

    @Override       // 设置路径匹配 不忽略'.'后缀后面的值
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false);
    }

    @Bean   // 配置 MultipartResolver解析文件上传
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setMaxUploadSize(100000);       // 限制文件上传大小
        return resolver;
    }
}