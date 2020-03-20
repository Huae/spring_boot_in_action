package com.huae.ch2.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EventMC {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(EventConfig.class);
        DemoPublisher bean = ctx.getBean(DemoPublisher.class);
        bean.publish("hello world");
        ctx.close();
    }
}