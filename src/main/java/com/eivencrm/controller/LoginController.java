
package com.eivencrm.controller;

import com.alibaba.fastjson.JSONObject;
import com.eivencrm.entity.MkUser;
import com.eivencrm.service.MkUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class LoginController {
	
	  /**
     * 日志（slf4j->logback）
     */
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private MkUserService mkUserService;

    
    @RequestMapping("login")
    public String login(Map<String,Object> map){
    	System.out.println("======这是登录页面=========");
    	map.put("hello","from TemplateController.helloFtl");  
    	map.put("title","Hello Eiven");  
		return "/system/login";
    }
    @RequestMapping("doLogin")
    public ModelAndView doLogin(@RequestParam(value = "username",required = false)  String username ,
                          @RequestParam(value = "password", required = false) String password){
        ModelAndView mv = new ModelAndView();
        System.out.println("======登录验证=========");
       // mv.setViewName("redirect:/login");
        mv.setViewName("/system/home/index");
        return mv;
    }
}