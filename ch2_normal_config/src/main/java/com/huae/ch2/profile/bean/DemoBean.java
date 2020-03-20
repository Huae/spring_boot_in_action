package com.huae.ch2.profile.bean;

// 使用Profile实现不同环境实例化不同的Bean
public class DemoBean {
    private String content;

    public DemoBean(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}