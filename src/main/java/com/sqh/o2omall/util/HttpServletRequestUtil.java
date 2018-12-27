package com.sqh.o2omall.util;

import javax.servlet.http.HttpServletRequest;

/**
 * http请求工具类,根据key值获取请求中的信息转换成相应的类型
 *
 * @author sqh
 * @date 2018/12/25
 */
public class HttpServletRequestUtil {

	public static int getInt(HttpServletRequest request, String key) {
		return Integer.decode(request.getParameter(key));
	}

	public static long getLong(HttpServletRequest request, String key) {
		return Long.valueOf(request.getParameter(key));
	}

	public static double getDouble(HttpServletRequest request, String key) {
		return Double.valueOf(request.getParameter(key));
	}

	public static boolean getBoolean(HttpServletRequest request, String key) {
		return Boolean.valueOf(request.getParameter(key));
	}

	public static String getString(HttpServletRequest request, String key) {
		String res = request.getParameter(key);
		if (res != null) {
			return res.trim();
		} else {
			return res;
		}
	}
}
