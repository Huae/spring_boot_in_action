package com.huae.ch2.scope.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // 声明这是一个配置类,意味着本类有0个或多个bean (@Bean声明或使用包扫描)
@ComponentScan("com.huae.ch2.scope.*")  // 配置包扫描
public class ScopeConfig {
}