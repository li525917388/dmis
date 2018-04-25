package com.dmis.sys.action;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dmis.sys.entity.User;
import com.dmis.sys.service.UserService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("sys/user")
public class UserAction {
	
	@Resource
	UserService userService;

	@RequestMapping("login")
	public void  login(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		System.out.println("登录");
		String flag = "failure";
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		User user = userService.login(username);
		if (user == null) {
			flag =  "failure";
		}else if (pwd != null && user != null) {
			if (pwd.equals(user.getPwd())) {
				flag =  "success";
			}
		} 
		request.getSession().setAttribute("user", user);
		String jsonString = "{\"flag\":\""+flag+"\"}";
        String json = JSONObject.fromObject(jsonString).toString();
		response.getWriter().print(json);
	}
	
	@RequestMapping("toUser")
	public String toUser(HttpServletRequest request, HttpServletResponse response){
		
		return "sys/user";
	}
}
