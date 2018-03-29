
package com.eivencrm.controller;

import com.alibaba.fastjson.JSONObject;
import com.eivencrm.common.config.JsonConsts;
import com.eivencrm.common.util.JsonContext;
import com.eivencrm.common.util.JsonResult;
import com.eivencrm.common.util.MD5Util;
import com.eivencrm.common.util.StringUtils;
import com.eivencrm.entity.SysUserEntity;
import com.eivencrm.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
@RequestMapping("user")
public class SysUserController extends BaseController{
	
	  /**
     * 日志（slf4j->logback）
     */
    private static final Logger logger = LoggerFactory.getLogger(SysUserController.class);

    @Autowired
    private SysUserService sysUserService;


    @RequestMapping("userList")
    public ModelAndView userList(){
        ModelAndView mv = new ModelAndView();
        /*List<SysUserEntity> userList = null;
        userList = sysUserService.findByMoreFiledpages(this.getHqlTableName(SysUserEntity.class),
                null,1,15);*/

        mv.setViewName("/system/user/list");
        return mv;

    }


    @ResponseBody
    @RequestMapping("userData")
    public JsonResult userData(@RequestParam(value = "name", defaultValue = "") String name,
                                @RequestParam(value = "pageIndex", defaultValue = "1") Integer pageIndex,
                                @RequestParam(value = "pageSize", defaultValue = "15") Integer pageSize){
        LinkedHashMap<String,List<Map<String,Object>>> map = new LinkedHashMap<>();
        List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
        if(StringUtils.isNotBlank(name)){
            Map<String,Object> dengyu = new HashMap<String,Object>();
            dengyu.put("name",name);
            mapList.add(dengyu);
            map.put("like",mapList);
        }
        List<SysUserEntity> userList  = sysUserService.findByMoreFiledPages(
                this.getHqlTableName(SysUserEntity.class),map,pageIndex,pageSize);
        Object count = sysUserService.findCount(this.getHqlTableName(SysUserEntity.class),map);
        return JsonResult.putSuccess(userList,Integer.parseInt(count.toString()));
    }


    //@ResponseBody
    @RequestMapping("toEdit")
    public ModelAndView toEdit(@RequestParam(value = "id", defaultValue = "") String id){
        ModelAndView mv = new ModelAndView();
        if(StringUtils.isNotBlank(id)) {
            SysUserEntity userEntity = sysUserService.findByid(new SysUserEntity(), Integer.parseInt(id));
            mv.addObject("user", userEntity);
        }else{
            mv.addObject("user", new SysUserEntity());
        }
        mv.setViewName("/system/user/add");
        return mv;
    }

    @RequestMapping("doSave")
    public ModelAndView doSave(@ModelAttribute SysUserEntity userEntity){
        ModelAndView mv = new ModelAndView();
        if(userEntity!=null){
            boolean isOk = false;
            if(userEntity.getId()!=null){
                userEntity.setPassword(MD5Util.MD5Encode("1"));
                isOk = sysUserService.update(userEntity);
            }else{
                isOk = sysUserService.save(userEntity);
            }
            mv.addObject("user",userEntity);
            mv.addObject(JsonConsts.Message,isOk);
        }
        mv.setViewName("/system/user/add");
        return mv;
    }
    @ResponseBody
    @RequestMapping("delete")
    public String delete(){
        return "";
    }
}