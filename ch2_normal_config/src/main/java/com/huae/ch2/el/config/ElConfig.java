package com.huae.ch2.el.config;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

import java.io.IOException;

@Configuration // 声明配置类
@ComponentScan("com.huae.ch2.el.*") // 包扫描
@PropertySource("classpath:test.properties")
public class ElConfig {
    @Value("测试@Value注入普通字符串")
    private String normalStr;

    @Value("#{systemProperties['os.name']}")     // @Value注入操作系统属性
    private String osName;

    @Value("#{T(java.lang.Math).random() * 100.0}") // 注入表达式结果
    private double randomNum;

    @Value("#{demoService.another}")    // 注入其他Bean的属性
    private String fromAnother;

    @Value("classpath:test.txt")    // 注入文件资源
    private Resource testFile;

    @Value("http://www.baidu.com")  // 注入网址资源
    private Resource testUrl;

    @Value("${project.name}")   // 注入配置文件需要使用@PropertySource指定文件地址 取值需要配置
    private String projectName;

    @Autowired
    private Environment environment;    //  注入的properties可从environment中获取

    @Bean       // 配合@Value("${project.name}")
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    public void outputResource() {
        try {
            System.out.println(normalStr);
            System.out.println(osName);
            System.out.println(randomNum);
            System.out.println(fromAnother);
            System.out.println(IOUtils.toString(testFile.getInputStream()));
            System.out.println(IOUtils.toString(testUrl.getInputStream()));
            System.out.println(projectName);
            System.out.println(environment.getProperty("project.version"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
