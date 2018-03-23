
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class SysUserController {
	
	  /**
     * 日志（slf4j->logback）
     */
    private static final Logger logger = LoggerFactory.getLogger(SysUserController.class);


    @RequestMapping("userList")
    public ModelAndView userList(){
        ModelAndView mv = new ModelAndView();

        mv.setViewName("/system/user/list");
        return mv;
    }
}