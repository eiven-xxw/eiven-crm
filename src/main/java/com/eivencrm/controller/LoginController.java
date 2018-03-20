
package com.eivencrm.controller;

import com.eivencrm.common.config.JsonConsts;
import com.eivencrm.common.util.MD5Util;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class LoginController extends BaseController{
	
	  /**
     * 日志（slf4j->logback）
     */
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private MkUserService mkUserService;
    @Autowired
    private SysUserService sysUserService;

    
    @RequestMapping("login")
    public String login(Map<String,Object> map){
    	System.out.println("======这是登录页面=========");
    	map.put("hello","from TemplateController.helloFtl");  
    	map.put("title","Hello Eiven");  
		return "/system/login";
    }
    @RequestMapping(value = "doLogin",method = RequestMethod.POST)
    public ModelAndView doLogin(HttpServletRequest request, HttpServletResponse response){
       /* @RequestParam(value = "username",required = false)  String username ,
        @RequestParam(value = "password", required = false) String password*/

        ModelAndView mv = new ModelAndView();
        mv.setViewName("/system/login");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(StringUtils.isBlank(username)||StringUtils.isBlank(password)){
            mv.addObject(JsonConsts.ErrMsg,JsonConsts.Err_Wrong_Param.getInfo());
            return mv;
        }else{
            SysUserEntity userEn = sysUserService.getUserByLoginName("eiven");
            if(userEn!=null){
                password = MD5Util.MD5Encode(password);
                if(password.equals(userEn.getPassword())){
                    userEn.setPassword("");
                    this.getCurrentsession().setAttribute("UserBo",userEn);
                    mv.setViewName("/system/home/index");
                }else{
                    mv.addObject(JsonConsts.ErrMsg,JsonConsts.Err_User_Passord_NotEqual.getInfo());
                }
            }
        }

        System.out.println("======登录验证=========");
       // mv.setViewName("redirect:/login");
       // SysUserEntity en = (SysUserEntity) sysUserServic1e.findByid(new SysUserEntity(),1);
        return mv;
    }


}