package com.huae.spring_boot_in_action.ch1.aop_test.service;

import com.huae.spring_boot_in_action.ch1.aop_test.annotation.Action;
import org.springframework.stereotype.Service;

@Service
public class TestAroundAdviceService {
    @Action(name = "测试环绕通知")
    public void around() {
        System.out.println("around");
    }
}