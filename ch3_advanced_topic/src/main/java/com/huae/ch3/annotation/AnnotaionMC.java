package com.huae.ch3.annotation;

import com.huae.ch3.annotation.config.AnnotationConfig;
import com.huae.ch3.annotation.service.DemoService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotaionMC {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AnnotationConfig.class);
        DemoService bean = ctx.getBean(DemoService.class);
        bean.output();
        ctx.close();
    }
}