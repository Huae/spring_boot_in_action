package com.huae.ch3.conditional;

import com.huae.ch3.conditional.config.ConditionalConfig;
import com.huae.ch3.conditional.service.ConditionalBeanService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConditionalMC {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ConditionalConfig.class);
        ConditionalBeanService bean = ctx.getBean(ConditionalBeanService.class);
        bean.outputResult();
        ctx.close();
    }
}