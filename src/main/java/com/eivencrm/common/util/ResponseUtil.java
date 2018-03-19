package com.eivencrm.common.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;


/**
 * Author eiven
 * @date 2018年3月19日
 */

public class ResponseUtil {

	/*public static void writeJson(HttpServletResponse response, JsonResult jr) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.append(JsonContext.toJson(jr));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}*/
}
