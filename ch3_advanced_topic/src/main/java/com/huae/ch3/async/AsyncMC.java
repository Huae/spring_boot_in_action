package com.huae.ch3.async;

import com.huae.ch3.async.config.AsyncConfig;
import com.huae.ch3.async.service.AsyncTaskSerivce;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AsyncMC {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AsyncConfig.class);
        AsyncTaskSerivce bean = ctx.getBean(AsyncTaskSerivce.class);
        for (int i = 0; i < 12; i++) {
            // 两个方法是异步并发执行的
            bean.async1(1);
            bean.async2(2);
        }
        ctx.close();
    }
}