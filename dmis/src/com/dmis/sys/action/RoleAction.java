package com.dmis.sys.action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dmis.sys.entity.Menu;
import com.dmis.sys.entity.Role;
import com.dmis.sys.service.RoleService;
import com.dmis.util.GridView;
import com.dmis.util.PageUtil;
import com.dmis.util.ResultAndTotal;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("sys/role")
public class RoleAction {

	@Resource
	RoleService roleService;
	
	@RequestMapping("getRoles")
	public void getRoles(HttpServletRequest request,HttpServletResponse response,int pageSize, int pageNumber) throws IOException{
		response.setContentType("text/html;charset=utf-8");
		
		PageUtil pageUtil = new PageUtil();
		pageUtil.setPageSize(pageSize);
		pageUtil.setPage(pageNumber);
		
		ResultAndTotal<Role> res = roleService.searchRole(pageUtil);
		
		GridView view = new GridView();
		view.setRows(res.getRows());
		view.setTotal(res.getTotal());
		
		String json = JSONObject.fromObject(view).toString();
		
		response.getWriter().print(json);
		
	}
	
	
	@RequestMapping("toRoleMenu")
	public String toRoleMenu(HttpServletRequest request,HttpServletResponse response){
		
		String rid = request.getParameter("rid");
		
		request.setAttribute("roleId", rid);
		
		return "sys/form/roleMenu";
	}
	
	
	/**
	 * 获得树菜单
	 * @param request
	 * @param response
	 * @param rid
	 * @throws IOException
	 */
	@RequestMapping("getMenuTree")
	public void getMenuTree(HttpServletRequest request,HttpServletResponse response,long rid) throws IOException{
		response.setContentType("text/html;charset=utf-8");
		
		List<Menu> list = roleService.getMenuByRole(rid);
		
		String json = JSONArray.fromObject(list).toString();
		
		response.getWriter().print(json);
	}
	
	
	/**
	 * 重新授权菜单
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping("saveRoleMenu")
	public void saveRoleMenu(HttpServletRequest request,HttpServletResponse response,String mids,long rid) throws IOException{
		
		roleService.newRoleMenu(mids, rid);
		
		response.getWriter().print("ok");
	}
	
	
	@RequestMapping("toUserRole")
	public String toUserRole(HttpServletRequest request,HttpServletResponse response){
		
		String uid = request.getParameter("uid");
		
		request.setAttribute("userId", uid);
		
		return "sys/form/userRole";
	}
	
	
	/**
	 * 获得树角色
	 * @param request
	 * @param response
	 * @param rid
	 * @throws IOException
	 */
	@RequestMapping("getRoleTree")
	public void getRoleTree(HttpServletRequest request,HttpServletResponse response,long uid) throws IOException{
		response.setContentType("text/html;charset=utf-8");
		
		List<Role> list = roleService.getRoleByUser(uid);
		
		String json = JSONArray.fromObject(list).toString();
		
		response.getWriter().print(json);
	}
	
	
	/**
	 * 重新授权角色
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping("saveUserRole")
	public void saveUserRole(HttpServletRequest request,HttpServletResponse response,String rids,long uid) throws IOException{
		
		roleService.newUserRole(rids, uid);
		
		response.getWriter().print("ok");
	}
	
	
	
	/**
	 * 跳转编辑页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("toRoleForm")
	public String toRoleForm(HttpServletRequest request, HttpServletResponse response){
		
		String id = request.getParameter("id");
		String oper = request.getParameter("oper");
		
		if("edit".equals(oper) || "view".equals(oper)){
			
			Role role = roleService.getRoleEntity(Long.valueOf(id));
			
			request.setAttribute("role", role);
		}
		
		request.setAttribute("oper", oper);
		
		return "sys/form/roleForm";
	}
	
	
	/**
	 * 保存
	 * @param request
	 * @param response
	 * @param role
	 * @throws IOException 
	 */
	@RequestMapping("saveRole")
	public void saveRole(HttpServletRequest request, HttpServletResponse response,Role role) throws IOException{
		
		int res = roleService.saveRole(role);
		
		response.getWriter().print(res);
	}
	
	
	/**
	 * 删除
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping("delRole")
	public void delRole(HttpServletRequest request, HttpServletResponse response,String ids) throws IOException{
		
		int res = roleService.delRoles(ids);
		
		response.getWriter().print(res);
	}
}
