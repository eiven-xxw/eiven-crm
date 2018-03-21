package com.eivencrm.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;

import javax.persistence.Table;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eivencrm.common.util.RequestUtil;
import com.eivencrm.common.util.StringUtils;
import com.eivencrm.entity.SysMenuEntity;
import com.eivencrm.entity.SysUserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContext;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.alibaba.fastjson.JSONObject;

/**
 * @Description: TODO 
 * Author Fred
 * @date 2016年2月19日 下午7:05:06 
 * Updates
 * .....
 * 
 */

public class BaseController  {
	private static final Logger log = LoggerFactory.getLogger(BaseController.class);
			
	protected HttpServletRequest getCurrentRequest() {
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
	}
	
	protected HttpServletResponse getCurrentResponse() {
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
	}
	
	protected HttpSession getCurrentsession() {
		return getCurrentRequest().getSession();
	}

	protected SysUserEntity getUserBo() {
		return (SysUserEntity) getCurrentRequest().getSession().getAttribute("UserBo");
	}
	
	protected void addCookie(Cookie cookie) {
		getCurrentResponse().addCookie(cookie);
	}
	
	protected String getBasePath() {
		return RequestUtil.getBasePath(getCurrentRequest());
	}
	
	protected boolean isMobile() {
		return RequestUtil.isMobile(getCurrentRequest());
	}
	
	protected boolean isWechat() {
		return RequestUtil.isWechat(getCurrentRequest());
	}
	
	public ModelAndView redirectToLogin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/login");
		return mv;
	}
	
	public ModelAndView redirectToError() {
		return redirectToError(null);
	}
	
	public ModelAndView redirectToError(String msg) {
		ModelAndView mv = new ModelAndView();
		if(StringUtils.isNotEmpty(msg)) {
			/*try {
				mv.setViewName("redirect:/error?" + WebConsts.ErrMsg + "=" + URLEncoder.encode(msg, "utf-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		} else {
			mv.setViewName("redirect:/error");
		}
		
		return mv;
	}
	
	protected void addNoticeMsg(String msg) {
		log.error("Show Notice:" + msg);
		//this.getCurrentRequest().setAttribute(WebConsts.NoticeMsg, msg);
	}
	
	protected void addErrorMsg(String msg) {
		log.error("Show Error:" + msg);
		//this.getCurrentRequest().setAttribute(WebConsts.ErrMsg, msg);
	}
	
	protected ApplicationContext getApplicationContext() {
		 //String lang = RequestContextUtils.getLocale(this.getCurrentRequest()).getDisplayLanguage();
	     ApplicationContext ctx = RequestContextUtils.getWebApplicationContext(getCurrentRequest()); 
	     return ctx;
	}
	
	protected String getMessage(String code) {
		 RequestContext requestContext = new RequestContext(getCurrentRequest());
		 return requestContext.getMessage(code);
	}
	
	protected String getMessage(String code, Object[] params) {
		 RequestContext requestContext = new RequestContext(getCurrentRequest());
		 return requestContext.getMessage(code, params);
	}

	/**
	 * 获取Hql表名
	 * */
	protected  String getHqlTableName(Class clazz){
		return clazz.getSimpleName();
	}
	/**
	 * 获取Sql表名
	 * */
	protected  String getSqlTableName(Class clazz){
		Table annotation = (Table)clazz.getAnnotation(Table.class);
		return annotation.name();
	}

	
	protected boolean isSkipUrl(String url) {
		if(StringUtils.isNotEmpty(url)) {
			if(url.contains("regist") || url.contains("login") || url.contains("toReset") || url.contains(this.getCurrentRequest().getRequestURI()))
				return true;
		}
		return false;
	}

	
}
