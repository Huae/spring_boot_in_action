package com.huae.ch2.event;

import org.springframework.context.ApplicationEvent;

/**
 * 测试使用Spring ApplicationContext发布事件实现Bean之间的消息通信
 */
public class DemoEvent extends ApplicationEvent {

    private String msg;
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the component that published the event (never {@code null})
     */
    public DemoEvent(Object source,String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}