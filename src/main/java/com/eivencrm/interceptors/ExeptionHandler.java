package com.eivencrm.interceptors;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExeptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) {
        ModelAndView mv = new ModelAndView();
        System.out.println("====页面异常====");
        mv.addObject("e", e);
        mv.addObject("uri", req.getRequestURI());
        mv.setViewName("/system/error");
        return mv;
    }
}
