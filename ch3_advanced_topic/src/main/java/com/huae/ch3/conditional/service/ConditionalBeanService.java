package com.huae.ch3.conditional.service;

public class ConditionalBeanService {
    private String msg;

    public ConditionalBeanService(String msg) {
        this.msg = msg;
    }

    public void outputResult() {
        System.out.println(msg);
    }
}