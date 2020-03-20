package com.huae.ch3.aware;

import com.huae.ch3.aware.config.AwareConfig;
import com.huae.ch3.aware.service.AwareService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AwareMC {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AwareConfig.class);
        AwareService bean = ctx.getBean(AwareService.class);
        bean.outputResult();
        ctx.close();
    }
}