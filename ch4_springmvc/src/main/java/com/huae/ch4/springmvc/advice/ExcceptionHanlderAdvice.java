package com.huae.ch4.springmvc.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice // 为所有controller设置建言
public class ExcceptionHanlderAdvice {

    @ExceptionHandler(Exception.class)      // 全局异常处理
    public ModelAndView exception(Exception exception, WebRequest request) {
        ModelAndView error = new ModelAndView("error"); // 设置错误页面
        error.addObject("errorMessage", exception.getMessage());
        return error;
    }

    @ModelAttribute
    public void addAttribute(Model model) {
        model.addAttribute("msg", "额外信息");
    }

    @InitBinder     // WebDataBinder用来自动绑定前台的请求参数
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setDisallowedFields("ids");    // 过滤request请求中的ids参数
    }
}