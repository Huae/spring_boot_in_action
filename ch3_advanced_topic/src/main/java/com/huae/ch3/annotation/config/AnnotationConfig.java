package com.huae.ch3.annotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 使用自定义组合注解实现 @Configuration 和 @ComponentScan的共嫩
 */
//@HuaeConfiguration("com.huae.ch3.annotation")         // value值不能覆盖原值 失败!!! Spring4.2提供@AliasFor注解用于覆盖原值
@Configuration
@ComponentScan("com.huae.ch3.annotation")
public class AnnotationConfig {
}