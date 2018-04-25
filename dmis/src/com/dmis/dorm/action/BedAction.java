package com.dmis.dorm.action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dmis.dorm.entity.Bed;
import com.dmis.dorm.entity.DormType;
import com.dmis.dorm.service.BedService;
import com.dmis.util.GridView;
import com.dmis.util.PageUtil;
import com.dmis.util.ResultAndTotal;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("dorm/bed")
public class BedAction {

	@Resource
	BedService bedService;
	
	@RequestMapping("getBedList")
	public void getBedList(HttpServletRequest request, HttpServletResponse response,int pageSize , int pageNumber) throws IOException{
	
		response.setContentType("text/html;charset=utf-8");

		
		PageUtil pageUtil = new PageUtil();
		
		pageUtil.setPageSize(pageSize);
		pageUtil.setPage(pageNumber);
		ResultAndTotal<Bed> res = bedService.searchBedAndTotal(pageUtil);

		GridView grid = new GridView();
		grid.setRows(res.getRows());
		grid.setTotal(res.getTotal());
		
		String json = JSONObject.fromObject(grid).toString();
		
		response.getWriter().print(json);
	}
	
	
	/**
	 * 获得宿舍类型列表
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping("getDormTypeList")
	public void getDormTypeList(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=utf-8");
		
		List<DormType> list = bedService.getDormTypeList();
		
		String json = JSONArray.fromObject(list).toString();
		
		response.getWriter().print(json);
	}
}
