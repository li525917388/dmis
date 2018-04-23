package com.dmis.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Result {

	/**
	 * 写数据
	 * @param date
	 * @param response
	 * @throws IOException
	 */
	public static void write(Object data, HttpServletResponse response) throws IOException{
		
		String join = "";
		
		join = JSONObject.fromObject(data).toString();
		
		response.getWriter().print(join);
	}
}
