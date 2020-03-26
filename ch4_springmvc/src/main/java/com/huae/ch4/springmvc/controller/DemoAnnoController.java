package com.huae.ch4.springmvc.controller;

import com.huae.ch4.springmvc.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/anno")
public class DemoAnnoController {

    @RequestMapping(produces = "text/plain;charset=UTF-8")
    public @ResponseBody
    String index(HttpServletRequest request) {
        return "url:" + request.getRequestURL() + "can access" + "----test" + request.getRequestURI();
    }

    @RequestMapping(value = "/pathvar/{str}", produces = "text/plain;charset=UTF-8")
    public @ResponseBody
    String demoPathVar(@PathVariable("str") String str, HttpServletRequest request) {
        return "url:" + request.getRequestURL() + " can access,str:" + str;
    }

    @RequestMapping(value = "requestParam", produces = "text/plain;charset=UTF-8")
    public @ResponseBody
    String passRequestParam(Long id, HttpServletRequest request) {
        return "url:" + request.getRequestURL() + " can access,id: " + id;
    }

    @RequestMapping(value = "/obj", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String passObj(DemoObj obj, HttpServletRequest request) {
        return "url:" + request.getRequestURL() + " can access,obj id:" + obj.getId() + " obj name:" + obj.getName();
    }

    @RequestMapping(value = {"/name1", "name2"}, produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String remove(HttpServletRequest request) {
        return "url: " + request.getRequestURL() + " can access";
    }
}