package com.huae.ch2.scope;

import com.huae.ch2.scope.config.ScopeConfig;
import com.huae.ch2.scope.service.DemoPrototypeService;
import com.huae.ch2.scope.service.DemoSingletonService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试spring Scope属性
 */
public class ScopeMC {
    public static void main(String[] args) {
        // 加载spring容器,使用配置类作为配置文件
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ScopeConfig.class);
        // 获取bean
        DemoSingletonService singleton1 = ctx.getBean(DemoSingletonService.class);
        DemoSingletonService singleton2 = ctx.getBean(DemoSingletonService.class);
        DemoPrototypeService protoType1 = ctx.getBean(DemoPrototypeService.class);
        DemoPrototypeService protoType2 = ctx.getBean(DemoPrototypeService.class);
        // 测试bean的Scope属性是否生效
        System.out.println("single:" + (singleton1.equals(singleton2)));
        System.out.println("prototype:" + (protoType1.equals(protoType2)));

        ctx.close();
    }
}