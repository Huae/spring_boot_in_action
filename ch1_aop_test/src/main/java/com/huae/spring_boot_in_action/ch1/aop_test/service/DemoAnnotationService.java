package com.huae.spring_boot_in_action.ch1.aop_test.service;

import com.huae.spring_boot_in_action.ch1.aop_test.annotation.Action;
import org.springframework.stereotype.Service;

// 使用注解拦截规则
@Service
public class DemoAnnotationService {

    @Action(name = "注解式规则拦截")
    public void add() {
        System.out.println("注解after");
    }
}