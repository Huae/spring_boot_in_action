package com.huae.ch2.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

// 消息接听器 可监听DemoEvent事件
@Component
public class DemoListener implements ApplicationListener<DemoEvent> {
    @Override
    public void onApplicationEvent(DemoEvent event) {
        System.out.println("DemoListener监听到了demoPublisher发布的消息-->" + event.getMsg());
    }
}