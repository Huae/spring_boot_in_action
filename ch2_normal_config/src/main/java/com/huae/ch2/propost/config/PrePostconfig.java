package com.huae.ch2.propost.config;

import com.huae.ch2.propost.service.JSR250BeanInitAndDestory;
import com.huae.ch2.propost.service.SpringAnnotationBeanInitAndDestory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.huae.ch2.propost.service")
public class PrePostconfig {
    @Bean
    public JSR250BeanInitAndDestory jsrWay(){
        return new JSR250BeanInitAndDestory();
    }

    @Bean(initMethod = "init",destroyMethod = "destory")
    public SpringAnnotationBeanInitAndDestory springWay(){
        return new SpringAnnotationBeanInitAndDestory();
    }
}