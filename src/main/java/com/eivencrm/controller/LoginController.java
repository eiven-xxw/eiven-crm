
package com.eivencrm.controller;

import com.eivencrm.common.util.StringUtils;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public ModelAndView doLogin(HttpServletRequest request, HttpServletResponse response){
       /* @RequestParam(value = "username",required = false)  String username ,
        @RequestParam(value = "password", required = false) String password*/

        ModelAndView mv = new ModelAndView();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(StringUtils.isBlank(username)||StringUtils.isBlank(password)){
            mv.setViewName("/system/home/index");
        }
        SysUserEntity userEn = sysUserServic1e.getUserByLoginName("eiven");
        if(userEn!=null){

        }



        System.out.println("======登录验证=========");
       // mv.setViewName("redirect:/login");

       // SysUserEntity en = (SysUserEntity) sysUserServic1e.findByid(new SysUserEntity(),1);
        MkUser user = mkUserService.getById("1");
        mv.setViewName("/system/home/index");
        return mv;
    }
}