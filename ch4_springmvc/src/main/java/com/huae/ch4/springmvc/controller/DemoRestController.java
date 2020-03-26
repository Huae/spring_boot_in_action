package com.huae.ch4.springmvc.controller;

import com.huae.ch4.springmvc.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller  // @ResponseBody 声明方法返回的是数据而不是页面
@RequestMapping("/rest")
public class DemoRestController {
    @RequestMapping(value = "/getjson", produces = "application/json;charset=UTF-8")    // 返回JSON数据 需要第三方包(添加依赖)支持
    @ResponseBody
    public DemoObj getJson(DemoObj obj) {
        return new DemoObj(obj.getId() + 1, obj.getName() + " json");
    }

    @RequestMapping(value = "/getxml", produces = "application/xml;charset=UTF-8")     // 返回xml数据 需要第三方包(添加依赖)支持
    @ResponseBody
    public DemoObj getXml(DemoObj obj) {
        return new DemoObj(obj.getId() + 1, obj.getName() + " xml");
    }
}