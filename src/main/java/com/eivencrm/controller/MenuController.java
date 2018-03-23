
package com.eivencrm.controller;

import com.eivencrm.common.util.JsonContext;
import com.eivencrm.entity.SysMenuEntity;
import com.eivencrm.service.SysMenuService;
import javafx.scene.control.Tab;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.Table;
import java.lang.annotation.Annotation;
import java.util.List;

@Controller
public class MenuController extends BaseController{
	  /**
     * 日志（slf4j->logback）
     */
    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);

    @Autowired
    private SysMenuService sysMenuService;

    @ResponseBody
    @RequestMapping("initMenu")
    public String initMenu(){

        System.out.println(6666);

        List<SysMenuEntity> menuEn = sysMenuService.findAll(this.getHqlTableName(SysMenuEntity.class));

        String jsonMenu =   JsonContext.toJson(menuEn);

        System.out.println(777);


        String menu = "[{\n" +
                "\t\"title\": \"系统设置\",\n" +
                "\t\"icon\": \"fa-cubes\",\n" +
                "\t\"spread\": true,\n" +
                "\t\"children\": [{\n" +
                "\t\t\"title\": \"菜单\",\n" +
                "\t\t\"icon\": \"&#xe641;\",\n" +
                "\t\t\"href\": \"index\"\n" +
                "\t}, {\n" +
                "\t\t\"title\": \"权限\",\n" +
                "\t\t\"icon\": \"&#xe63c;\",\n" +
                "\t\t\"href\": \"form.html\"\n" +
                "\t}, {\n" +
                "\t\t\"title\": \"用户\",\n" +
                "\t\t\"icon\": \"&#xe63c;\",\n" +
                "\t\t\"href\": \"userList\"\n" +
                "\t}, {\n" +
                "\t\t\"title\": \"角色\",\n" +
                "\t\t\"icon\": \"&#xe609;\",\n" +
                "\t\t\"href\": \"nav.html\"\n" +
                "\t}, {\n" +
                "\t\t\"title\": \"辅助性元素\",\n" +
                "\t\t\"icon\": \"&#xe60c;\",\n" +
                "\t\t\"href\": \"auxiliar.html\"\n" +
                "\t}]\n" +
                "}]";

		return menu;
    }




}