package com.huae.ch4.springmvc.controller;

import com.huae.ch4.springmvc.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdviceController {
    @RequestMapping("/advice")      // @ModelAttribute("msg")将ModelAttribute中的属性注入到msg中
    public String getSomething(@ModelAttribute("msg") String msg, DemoObj obj) {
        throw new IllegalArgumentException("非常抱歉,参数有误/" + "来自@ModelAttribute:" + msg);
    }
}