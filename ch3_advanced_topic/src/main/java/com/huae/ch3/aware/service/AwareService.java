package com.huae.ch3.aware.service;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

/**
 * 使用Spring Aware使Bean获得Spring容器提供的一系列服务
 * <p>
 * 使用BeanNameAware使Bean获得Bean在容器中的名称
 * 使用ResourceLoaderAware使Bean获得加载外部资源的能力
 */
@Service
public class AwareService implements BeanNameAware, ResourceLoaderAware {

    private String beanName;
    private ResourceLoader resourceLoader;

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public void outputResult() {
        System.out.println("Bean的名称为:" + beanName);
        try {
            System.out.println(IOUtils.toString(resourceLoader.getResource("classpath:test.txt").getInputStream()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}