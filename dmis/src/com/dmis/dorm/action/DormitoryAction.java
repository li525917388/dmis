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
	
	
	/**
	 * 编辑页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("toDormitoryForm")
	public String toDormitoryForm(HttpServletRequest request, HttpServletResponse response){
		
		String id = request.getParameter("id");
		String oper = request.getParameter("oper");
		
		if("edit".equals(oper) || "view".equals(oper)){
			
			Dormitory dorm = dormitoryService.getEntity(Long.valueOf(id));
			
			request.setAttribute("dormitory", dorm);
			request.setAttribute("oper", oper);
			
		}
		
		return "dorm/form/dormitoryForm";
	}
	
	
	/**
	 * 保存
	 * @param request
	 * @param response
	 * @param dorm
	 * @throws IOException 
	 */
	@RequestMapping("saveDorm")
	public void saveDorm(HttpServletRequest request, HttpServletResponse response,Dormitory dorm) throws IOException{
		
		System.out.println(dorm.getMaxNum());
		
		long res = dormitoryService.save(dorm);
		
		response.getWriter().print(res);
	}
	
	@RequestMapping("delDorm")
	public void delDorm(HttpServletRequest request, HttpServletResponse response,String ids) throws IOException{
		
		int res = 0;
		
		if(ids.length() > 1){
			
			res = dormitoryService.dels(ids.substring(0, ids.length() - 1));
		}
		
		response.getWriter().print(res);
	}
}
