package com.huae.ch2.profile.config;

import com.huae.ch2.profile.bean.DemoBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ProfileConfig {

    @Bean
    @Profile("prod")
    public DemoBean prodDemoBean(){
        return new DemoBean("Prod ENV");
    }

    @Bean
    @Profile("dev")
    public DemoBean devDemoBean(){
        return new DemoBean("dev ENV");
    }
}