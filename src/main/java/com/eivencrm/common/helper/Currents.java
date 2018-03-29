package com.eivencrm.common.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @Description: 全局对象，来存储当前接入的机构的一些信息 Author eiven

 * 
 */

public class Currents {
	
	/**
	 * getUserId
	 * @return
	 */
	public static Integer getUserId() {
		try {
			HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
			Object UserID =  request.getSession().getAttribute("UserID");
			if(UserID != null) {
				return Integer.parseInt(UserID.toString());
			}
		} catch(Exception ex) {
			;
		}
		return 0;
	}

	
}
