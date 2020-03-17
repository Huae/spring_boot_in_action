package com.huae.spring_boot_in_action.ch1.aop_test;

import com.huae.spring_boot_in_action.ch1.aop_test.config.AopConfig;
import com.huae.spring_boot_in_action.ch1.aop_test.service.DemoAnnotationService;
import com.huae.spring_boot_in_action.ch1.aop_test.service.DemoMethodService;
import com.huae.spring_boot_in_action.ch1.aop_test.service.TestAroundAdviceService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// 主类
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        DemoAnnotationService after = context.getBean(DemoAnnotationService.class);
        DemoMethodService before = context.getBean(DemoMethodService.class);
        TestAroundAdviceService around = context.getBean(TestAroundAdviceService.class);

        after.add();//
        System.out.println("-------------------------------");
        before.add();
        System.out.println("-------------------------------");
        around.around();
        System.out.println("-------------------------------");

        context.close();
    }
}