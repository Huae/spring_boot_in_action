package com.huae.spring_boot_in_action.ch1.aop_test.annotation;

import java.lang.annotation.*;

// 注解拦截规则
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {
    String name();
}