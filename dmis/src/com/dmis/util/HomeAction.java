package com.dmis.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	
	/**
	 * 菜单管理
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/menu")
	public String menu(HttpServletRequest request, HttpServletResponse response){
		
		return "sys/menu";
	}
	
	
	/**
	 * 角色管理
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/role")
	public String role(HttpServletRequest request, HttpServletResponse response){
		
		return "sys/role";
	}
	
	/**
	 * 楼宇管理
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/building")
	public String building(HttpServletRequest request, HttpServletResponse response){
		
		return "dorm/building";
	}
	
	/**
	 * 宿舍管理
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/dormitory")
	public String dormitory(HttpServletRequest request, HttpServletResponse response){
		
		return "dorm/dormitory";
	}
	
	/**
	 * 床位管理
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/bed")
	public String bed(HttpServletRequest request, HttpServletResponse response){
		
		return "dorm/bed";
	}
	
	
	/**
	 * 床位管理
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/dormAllot")
	public String dormAllot(HttpServletRequest request, HttpServletResponse response){
		
		return "dorm/dormAllot";
	}
}
