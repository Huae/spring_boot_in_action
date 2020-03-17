package com.huae.ch2.propost.service;

// 使用spring方式在bean初始化和销毁前执行操作
public class SpringAnnotationBeanInitAndDestory {
    public void init(){
        System.out.println("Spring方式构造函数执行完后执行操作...");
    }

    public SpringAnnotationBeanInitAndDestory(){
        System.out.println("SpringAnnotationBeanInitAndDestory构造函数");
    }

    public void destory(){
        System.out.println("Spring方式Bean销毁前执行操作...");
    }
}