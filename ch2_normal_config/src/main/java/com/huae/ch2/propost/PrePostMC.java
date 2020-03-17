package com.huae.ch2.propost;

import com.huae.ch2.propost.config.PrePostconfig;
import com.huae.ch2.propost.service.JSR250BeanInitAndDestory;
import com.huae.ch2.propost.service.SpringAnnotationBeanInitAndDestory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PrePostMC {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(PrePostconfig.class);
        JSR250BeanInitAndDestory jsrWayBean = ctx.getBean(JSR250BeanInitAndDestory.class);
        SpringAnnotationBeanInitAndDestory springBeanWay = ctx.getBean(SpringAnnotationBeanInitAndDestory.class);
        ctx.close();
    }
}