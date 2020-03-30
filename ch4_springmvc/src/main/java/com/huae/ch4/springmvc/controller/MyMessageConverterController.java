package com.huae.ch4.springmvc.controller;

import com.huae.ch4.springmvc.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyMessageConverterController {

    // 本方法返回自定义的媒体类型
    @RequestMapping(value = "/convert", produces = {"application/x-huae"})
    public @ResponseBody
    DemoObj convert(@RequestBody DemoObj demoObj) {
        return demoObj;
    }
}