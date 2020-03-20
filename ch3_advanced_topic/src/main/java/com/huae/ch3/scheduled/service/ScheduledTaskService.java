package com.huae.ch3.scheduled.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 使用@Scheduled 执行计划任务
 */
@Service
public class ScheduledTaskService {

    private static final SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)    // 每5秒执行一次,程序运行后开始打印
    public void time() {
        System.out.println(format.format(new Date()));
    }

    @Scheduled(cron = "0 12 23 ? * *")  // 使用cron表达式灵活配置任务计划时间
    public void time2() {
        System.out.println("指定时间执行:" + format.format(new Date()));
    }

    @Scheduled(fixedDelay = 3000)  // 程序运行后每3秒打印
    public void time3() {
        System.out.println("指定时间执行:" + format.format(new Date()));
    }
}