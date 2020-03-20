package com.huae.ch3.async.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncTaskSerivce {

    @Async  // 声明方法为异步方法
    public void async1(Integer i){
        System.out.println("异步打印任务:"+i);
    }

    @Async
    public void async2(Integer i){
        System.out.println("异步相加任务:"+(i+1));
    }
}