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
import com.dmis.util.GridView;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

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
	
	
	/**
	 * 获得菜单列表
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("getMenuList")
	public void getMenuList(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=utf-8");
		
		List<Menu> list = menuService.getMenusQuery();
		
		GridView grid = new GridView();

		grid.setRows(list);
		grid.setTotal(list.size());

		
		String json = JSONObject.fromObject(grid).toString();
		
		response.getWriter().print(json);
	}
	
	
	/**
	 * 跳转菜单编辑页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("toMenuForm")
	public String toMenuForm(HttpServletRequest request, HttpServletResponse response){
		
		String id = request.getParameter("id");
		String oper = request.getParameter("oper");
		
		if("edit".equals(oper) || "view".equals(oper)){
			
			Menu menu = menuService.getMenuEntity(Long.valueOf(id));
			
			request.setAttribute("menu", menu);
		}
		
		request.setAttribute("oper", oper);
		
		return "sys/form/menuForm";
	}
	
	
	/**
	 * 新增菜单
	 * @param request
	 * @param response
	 * @param menu
	 * @throws IOException 
	 */
	@RequestMapping("saveMenu")
	public void saveMenu(HttpServletRequest request, HttpServletResponse response,Menu menu) throws IOException{
		
		int res = menuService.saveMenu(menu);
		
		response.getWriter().print(res);
	}
	
	
	/**
	 * 删除菜单
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping("delMenu")
	public void delMenu(HttpServletRequest request, HttpServletResponse response,String ids) throws IOException{
		
		int res = menuService.delMenus(ids);
		
		response.getWriter().print(res);
	}
}
