package com.huae.ch2.scope.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

// Scope为Prototype的bean每次调用时都会新建一个该Bean的实例
@Service
@Scope("prototype")
public class DemoPrototypeService {
}