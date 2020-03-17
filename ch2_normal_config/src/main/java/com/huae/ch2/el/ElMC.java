package com.huae.ch2.el;

import com.huae.ch2.el.config.ElConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ElMC {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ElConfig.class);
        ElConfig bean = ctx.getBean(ElConfig.class);
        bean.outputResource();
        ctx.close();
    }
}