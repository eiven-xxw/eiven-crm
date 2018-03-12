package com.eivencrm.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


@Component
public class UserLoginHandlerInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		String[] notFilter = new String[]{"/login", "/logout","/error"};
		String url = arg0.getRequestURI();
		System.out.println(arg0.getContextPath());
		System.out.println(url);
		System.out.println(">>>UserLoginHandlerInterceptor>>>>>>>在请求处理之前进行调用（Controller方法调用之前）");
		return true;
	}



}
