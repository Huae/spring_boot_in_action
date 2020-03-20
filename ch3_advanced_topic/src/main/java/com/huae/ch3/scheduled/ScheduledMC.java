package com.huae.ch3.scheduled;

import com.huae.ch3.scheduled.config.ScheduledConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScheduledMC {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ScheduledConfig.class);
//        ctx.close();
    }
}