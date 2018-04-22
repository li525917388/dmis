package com.dmis.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 跳转controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("home")
public class HomeAction {

	/**
	 * 主页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/index")
	public String index(HttpServletRequest request, HttpServletResponse response){
		
		System.out.println("主页");
		
		return "index";
	}
	
	
	@RequestMapping("/main")
	public String main(HttpServletRequest request, HttpServletResponse response){
		
		System.out.println("主页");
		
		return "main";
	}
	
	
	@RequestMapping("/user")
	public String user(HttpServletRequest request, HttpServletResponse response){
		
		System.out.println("user");
		
		return "sys/user";
	}
}
