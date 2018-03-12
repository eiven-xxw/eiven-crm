
package com.eivencrm.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.eivencrm.entity.MkUser;
import com.eivencrm.service.MkUserService;

@Controller
@RequestMapping("/user")
public class MkUserController {
	
	  /**
     * 日志（slf4j->logback）
     */
    private static final Logger logger = LoggerFactory.getLogger(MkUserController.class);

    @Autowired
    private MkUserService mkUserService;
	
    /**
     * 返回text格式数据
     * @param id 主键id
     * @return 用户json字符串
     */
    @RequestMapping("/getUser/{id}")
    @ResponseBody
    public String getUserById(@PathVariable("id")String id){
        logger.info("request /user/getUser/{id}, parameter is "+id);
        MkUser user = mkUserService.getById(id);
        return JSONObject.toJSONString(user);
    }
    
    //@RequestMapping("/list")
    public ModelAndView queryUserList(HttpServletRequest request) {
    	System.out.println("===============");
    	ModelAndView mv = new ModelAndView("/index");
    	//mv.setViewName("index");
		return mv;
    }
    
    @RequestMapping("index")
    public String index(Map<String,Object> map){
    	System.out.println("===============66666666");
    	map.put("hello","from TemplateController.helloFtl");  
    	map.put("title","Hello Eiven");  
		return "/user/index";
    }
    
}