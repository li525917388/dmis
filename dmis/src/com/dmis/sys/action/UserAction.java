package com.dmis.sys.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dmis.sys.entity.User;
import com.dmis.sys.service.UserService;

@Controller
@RequestMapping("sys/user")
public class UserAction {
	
	@Resource
	UserService userService;

	@RequestMapping("login")
	public void login(HttpServletRequest request, HttpServletResponse response){
		
		System.out.println("登录");
		
		String username = request.getParameter("username");
		
		User user = userService.login(username, "");
		
		System.out.println(user.getName());
	}
	
	@RequestMapping("toUser")
	public String toUser(HttpServletRequest request, HttpServletResponse response){
		
		return "sys/user";
	}
}
