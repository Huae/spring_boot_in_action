package com.huae.ch2.propost.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

// 使用JSR注解方式在bean初始化和销毁前执行操作
public class JSR250BeanInitAndDestory {
    @PostConstruct
    public void init(){
        System.out.println("JSR方式构造函数执行之后进行操作...");
    }

    public JSR250BeanInitAndDestory(){
        System.out.println("JSR250BeanInitAndDestory构造函数...");
    }

    @PreDestroy
    public void destory(){
        System.out.println("JSR方式Bean销毁之前进行操作...");
    }
}