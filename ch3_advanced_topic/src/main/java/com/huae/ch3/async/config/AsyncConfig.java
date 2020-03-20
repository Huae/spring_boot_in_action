package com.huae.ch3.async.config;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * 使用Spring @EnableAsync执行异步任务
 * 实现AsyncConfigurer接口返回Executor 异步任务执行时从Executor中获取线程
 */
@Configuration
@ComponentScan("com.huae.ch3.async.*")
@EnableAsync    // 开启异步任务支持
public class AsyncConfig implements AsyncConfigurer {
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor threadPoolExecutor = new ThreadPoolTaskExecutor();
        threadPoolExecutor.setCorePoolSize(Runtime.getRuntime().availableProcessors() * 2);
        threadPoolExecutor.setMaxPoolSize(10);
        threadPoolExecutor.setQueueCapacity(25);
        threadPoolExecutor.setKeepAliveSeconds(2);  // 任务执行完空闲2秒后回收线程
        threadPoolExecutor.setAllowCoreThreadTimeOut(true); // 释放核心线程,保证所有任务执行完回收线程
        threadPoolExecutor.initialize();
        return threadPoolExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }
}