package com.huae.ch3.conditional.config;

import com.huae.ch3.conditional.condition.LinuxConditionMatch;
import com.huae.ch3.conditional.condition.WindowsConditionMatch;
import com.huae.ch3.conditional.service.ConditionalBeanService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionalConfig {
    // 注释掉测试Conditional是否生效
//    @Bean
//    @Conditional(WindowsConditionMatch.class)
//    public ConditionalBeanService windows() {
//        return new ConditionalBeanService("Windows");
//    }

    @Bean
    @Conditional(LinuxConditionMatch.class)
    public ConditionalBeanService linux() {
        return new ConditionalBeanService("Linux");
    }
}