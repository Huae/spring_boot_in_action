package com.huae.spring_boot_in_action.ch1.aop_test.aspect;

import com.huae.spring_boot_in_action.ch1.aop_test.annotation.Action;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

// 模拟日志切面(切面=通知+切点)
@Aspect
@Component
public class LogAspect {

    // 声明切点(空方法,共本类其他方式使用),使用注解拦截规则
    @Pointcut("@annotation(com.huae.spring_boot_in_action.ch1.aop_test.annotation.Action)")
    public void pointCut() {
    }

    // 前置通知:被before中规则拦截到的方法(连接点)执行之前会先执行本before方法
    @Before("execution(* com.huae.spring_boot_in_action.ch1.aop_test.service.DemoMethodService.*(..))")
    public void before(JoinPoint joinPoint) { // 参数中包含该方法的信息
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("方法规则拦截-->" + method.getName());
    }

    // 后置通知:被pointCut中规则拦截的方法在执行之后会执行本after方法
    @After("pointCut()")
    public void after(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Action annotation = method.getAnnotation(Action.class);
        System.out.println("注解规则拦截-->" + annotation.name());
    }

    // 环绕通知:被around中规则拦截的方法在执行前后都会执行本around方法   ❌❌❌❌❌❌❌
    // 环绕通知:所谓环绕是指可以在拦截的方法之前和之后做额外的操作(甚至改变方法入参、返回值)
    @Around("execution(* com.huae.spring_boot_in_action.ch1.aop_test.service.TestAroundAdviceService.around(..))")
    public void around(ProceedingJoinPoint pjp) {
        System.out.println("----------");
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        String name = method.getName();
        System.out.println("环绕通知:" + name);
    }
}