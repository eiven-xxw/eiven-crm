
package com.eivencrm.controller;

import com.eivencrm.entity.MkUser;
import com.eivencrm.entity.SysUserEntity;
import com.eivencrm.service.MkUserService;
import com.eivencrm.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class LoginController {
	
	  /**
     * 日志（slf4j->logback）
     */
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private MkUserService mkUserService;
    @Autowired
    private SysUserService sysUserServic1e;

    
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
        SysUserEntity en = sysUserServic1e.getUserByLoginName("eiven");
       // SysUserEntity en = (SysUserEntity) sysUserServic1e.findByid(new SysUserEntity(),1);
        MkUser user = mkUserService.getById("1");
        mv.setViewName("/system/home/index");
        return mv;
    }
}