package com.dmis.dorm.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dmis.dorm.entity.Building;
import com.dmis.dorm.service.BuildingService;
import com.dmis.sys.entity.User;
import com.dmis.util.GridView;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("dorm/building")
public class BuildingAction {

	@Resource
	BuildingService buildingService;
	
	@RequestMapping("getBuildingList")
	public void getBuildingList(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=utf-8");
		
		List<Building> list = buildingService.getListQuery();
		
		GridView grid = new GridView();
		
		grid.setRows(list);
		grid.setTotal(list.size());
		
		String json = JSONObject.fromObject(grid).toString();
		
		response.getWriter().print(json);
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping("getAllList")
	public void getAllList(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		response.setContentType("text/html;charset=utf-8");
		
		List<Building> list = buildingService.getListQuery();
		
		String json = JSONArray.fromObject(list).toString();
		
		response.getWriter().print(json);
	}
	
	
	
	/**
	 * 跳转楼管员
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping("toBuildPipe")
	public String toBuildPipe(HttpServletRequest request, HttpServletResponse response,long bid) throws IOException{
		
		Building building = buildingService.getBuildEntity(bid);
		
		request.setAttribute("building", building);
		
		return "dorm/buildPipe";
	}
	
	/**
	 * 获得楼管列表
	 * @param request
	 * @param response
	 * @param buildId
	 * @throws IOException
	 */
	@RequestMapping("getBuildPipes")
	public void getBuildPipes(HttpServletRequest request, HttpServletResponse response,long buildId) throws IOException{
		response.setContentType("text/html;charset=utf-8");
		
		List<User> list = buildingService.getBuildPipes(buildId);
		
		GridView grid = new GridView();
		
		grid.setRows(list);
		grid.setTotal(list.size());
		
		String json = JSONObject.fromObject(grid).toString();
		
		response.getWriter().print(json);
	}
	
	
	/**
	 * 添加楼管
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping("addBuildPipe")
	public void addBuildPipe(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		String uid = request.getParameter("uid");
		String buildId = request.getParameter("buildId");
		
		Map<String, Long> map = new HashMap<String, Long>();
		map.put("uid", Long.valueOf(uid));
		map.put("buildId", Long.valueOf(buildId));
		
		int res = buildingService.addBuildPipe(map);
		
		response.getWriter().print(res);
	}
	
	
	/**
	 * 删除楼管
	 * @param request
	 * @param response
	 * @param id
	 * @throws IOException 
	 */
	@RequestMapping("delBuildPipe")
	public void delBuildPipe(HttpServletRequest request, HttpServletResponse response,String ids) throws IOException{
		
		String[] idss = ids.split(",");
		
		int res = 0;
		
		for(String id : idss){
			
			res = buildingService.delBuildPipe(Long.valueOf(id));
		}
		
		
		response.getWriter().print(res);
	}
}
