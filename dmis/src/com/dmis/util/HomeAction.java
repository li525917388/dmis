package com.dmis.util;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dmis.sys.entity.Menu;
import com.dmis.sys.entity.User;
import com.dmis.sys.service.MenuService;

/**
 * 跳转controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("home")
public class HomeAction {

	@Resource
	MenuService menuService;
	
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
		
		User user = (User) request.getSession().getAttribute("sessionUser");
		
		if(user == null) return "redirect:index";
		
		List<Menu> menus = menuService.getMenuByUid(user.getId());
		
		request.setAttribute("roleMenus", menus);
		
		return "main";
	}
	
	/**
	 * 主页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/home")
	public String home(HttpServletRequest request, HttpServletResponse response){
		
		System.out.println("主页");
		
		return "sys/home";
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
	
	
	/**
	 * 来访人员记录
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/accessPerson")
	public String accessPerson(HttpServletRequest request, HttpServletResponse response){
		
		return "other/accessPerson";
	}
	
	
	/**
	 * 物品出入记录
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/accessMaterial")
	public String accessMaterial(HttpServletRequest request, HttpServletResponse response){
		
		return "other/accessMaterial";
	}
}
