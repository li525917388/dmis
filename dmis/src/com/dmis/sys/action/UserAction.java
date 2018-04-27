package com.dmis.sys.action;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dmis.sys.entity.User;
import com.dmis.sys.service.UserService;
import com.dmis.util.GridView;
import com.dmis.util.PageUtil;
import com.dmis.util.ResultAndTotal;

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
		request.getSession().setAttribute("sessionUser", user);
		String jsonString = "{\"flag\":\""+flag+"\"}";
        String json = JSONObject.fromObject(jsonString).toString();
		response.getWriter().print(json);
	}
	
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("exit")
	public String exit(HttpServletRequest request, HttpServletResponse response){
		
		request.getSession().removeAttribute("sessionUser");
		
		return "redirect:/home/index";
	}
	
	@RequestMapping("toUser")
	public String toUser(HttpServletRequest request, HttpServletResponse response){
		
		return "sys/user";
	}
	
	
	@RequestMapping("getUsers")
	public void getUsers(HttpServletRequest request,HttpServletResponse response,int pageSize, int pageNumber) throws IOException{
		response.setContentType("text/html;charset=utf-8");
		
		PageUtil pageUtil = new PageUtil();
		pageUtil.setPageSize(pageSize);
		pageUtil.setPage(pageNumber);
		
		ResultAndTotal<User> res = userService.searchUser(pageUtil);
		
		GridView view = new GridView();
		view.setRows(res.getRows());
		view.setTotal(res.getTotal());
		
		String json = JSONObject.fromObject(view).toString();
		
		response.getWriter().print(json);
		
	}
	
	
	/**
	 * 跳转编辑页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("toUserForm")
	public String toUserForm(HttpServletRequest request, HttpServletResponse response){
		
		String id = request.getParameter("id");
		String oper = request.getParameter("oper");
		
		if("edit".equals(oper) || "view".equals(oper)){
			
			User user = userService.getUserEntity(Long.valueOf(id));
			
			request.setAttribute("user", user);
		}
		
		request.setAttribute("oper", oper);
		
		return "sys/form/userForm";
	}
	
	
	/**
	 * 保存
	 * @param request
	 * @param response
	 * @param user
	 * @throws IOException 
	 */
	@RequestMapping("saveUser")
	public void saveUser(HttpServletRequest request, HttpServletResponse response,User user) throws IOException{
		
		int res = userService.saveUser(user);
		
		response.getWriter().print(res);
	}
	
	
	/**
	 * 删除
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping("delUser")
	public void delUser(HttpServletRequest request, HttpServletResponse response,String ids) throws IOException{
		
		int res = userService.delUsers(ids);
		
		response.getWriter().print(res);
	}
}
