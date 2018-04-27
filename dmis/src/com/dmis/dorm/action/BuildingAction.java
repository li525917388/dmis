package com.dmis.dorm.action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dmis.dorm.entity.Building;
import com.dmis.dorm.service.BuildingService;
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
}
