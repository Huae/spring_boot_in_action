package com.huae.ch3.fortest.config;

import com.huae.ch3.fortest.bean.ForTestBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ForTestConfig {

    @Bean
    @Profile("dev")
    public ForTestBean dev() {
        return new ForTestBean("dev");
    }

    @Bean
    @Profile("prod")
    public ForTestBean prod() {
        return new ForTestBean("prod");
    }
}