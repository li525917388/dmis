package com.dmis.dorm.action;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dmis.dorm.entity.Dormitory;
import com.dmis.dorm.service.DormitoryService;
import com.dmis.util.GridView;
import com.dmis.util.PageUtil;
import com.dmis.util.ResultAndTotal;

import net.sf.json.JSONObject;

/**
 * 宿舍controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("dorm/dormitory")
public class DormitoryAction {

	@Resource
	DormitoryService dormitoryService;
	
	@RequestMapping("getDormitoryList")
	public void getDormitoryingList(HttpServletRequest request, HttpServletResponse response,int pageSize , int pageNumber) throws IOException{
		response.setContentType("text/html;charset=utf-8");

		String buildId = request.getParameter("buildId");
		
		PageUtil pageUtil = new PageUtil();
		
		pageUtil.setPageSize(pageSize);
		pageUtil.setPage(pageNumber);
		
		if(buildId != null && !"".equals(buildId)){
			pageUtil.addEquals("buildId", buildId);
		}
		
		
		ResultAndTotal<Dormitory> result = dormitoryService.searchAndTotal(pageUtil);
		
		GridView grid = new GridView();
		
		grid.setRows(result.getRows());
		grid.setTotal(result.getTotal());
		
		String json = JSONObject.fromObject(grid).toString();
		
		response.getWriter().print(json);
	}
}
