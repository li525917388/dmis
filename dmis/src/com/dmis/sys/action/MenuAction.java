package com.dmis.sys.action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dmis.sys.entity.Menu;
import com.dmis.sys.service.MenuService;

import net.sf.json.JSONArray;

/**
 * 菜单controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("sys/menu")
public class MenuAction {

	@Resource
	MenuService menuService;
	
	/**
	 * 获得左侧菜单
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping("getLeftMenus")
	public void getLeftMenus(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=utf-8");
		List<Menu> menus = menuService.getMenuByUid(1);
		
		for(Menu m : menus){
			
			System.out.println(m.getMenuName());
		}
		
		String json = JSONArray.fromObject(menus).toString();
		
		response.getWriter().print(json);
	}
}
