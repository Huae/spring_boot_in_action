package com.huae.spring_boot_in_action.ch1.aop_test.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

// 配置类
@Configuration
@ComponentScan("com.huae.spring_boot_in_action.ch1.aop_test.*")
@EnableAspectJAutoProxy // 开启spring对aspectJ的支持
public class AopConfig {

}