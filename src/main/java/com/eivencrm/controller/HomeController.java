
package com.eivencrm.controller;

import com.eivencrm.service.MkUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class HomeController {
	
	  /**
     * 日志（slf4j->logback）
     */
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);



    
    @RequestMapping("index")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        System.out.println("======这是首页=========");
        // mv.setViewName("redirect:/login");
        mv.setViewName("/system/home/index");
		return mv;
    }

}