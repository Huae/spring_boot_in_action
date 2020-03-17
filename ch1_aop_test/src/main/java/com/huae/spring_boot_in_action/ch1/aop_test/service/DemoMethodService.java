package com.huae.spring_boot_in_action.ch1.aop_test.service;

import org.springframework.stereotype.Service;

// 使用方法拦截规则
@Service
public class DemoMethodService {
    public void add() {
        System.out.println("方法before");
    }
}