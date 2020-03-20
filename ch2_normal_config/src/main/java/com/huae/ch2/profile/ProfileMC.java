package com.huae.ch2.profile;

import com.huae.ch2.profile.bean.DemoBean;
import com.huae.ch2.profile.config.ProfileConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProfileMC {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//        ctx.getEnvironment().setActiveProfiles("dev");  // 设置环境为开发环境
//        ctx.register(ProfileConfig.class);  // 先设置环境再注册配置类 才能找到Bean

        ctx.getEnvironment().setActiveProfiles("prod");  // 设置环境为生产环境
        ctx.register(ProfileConfig.class);  // 先设置环境再注册配置类 才能找到Bean
        ctx.refresh();  // 刷新容器

        DemoBean bean = ctx.getBean(DemoBean.class);
        System.out.println(bean.getContent());
        ctx.close();
    }
}