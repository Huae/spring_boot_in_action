package com.huae.ch2.scope.service;

import org.springframework.stereotype.Service;

// 使用Spring容器Bean的Scope属性 Spring bean默认Scope为Singleton,即Spring容器中只有一个本Bean的实例,
// 全容器共享一个实例,多线程时需考虑安全性
@Service
public class DemoSingletonService {
}