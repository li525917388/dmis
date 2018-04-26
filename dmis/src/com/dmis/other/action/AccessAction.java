package com.dmis.other.action;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dmis.other.entity.AccessPerson;
import com.dmis.other.service.AccessService;
import com.dmis.util.GridView;
import com.dmis.util.PageUtil;
import com.dmis.util.ResultAndTotal;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("other/access")
public class AccessAction {

	@Resource
	AccessService accessService;
	
	/**
	 * 获得来访人员列表
	 * @param request
	 * @param response
	 * @param pageSize
	 * @param pageNumber
	 * @throws IOException
	 */
	@RequestMapping("/getAccessPersons")
	public void getAccessPersons(HttpServletRequest request, HttpServletResponse response,int pageSize, int pageNumber) throws IOException{
		response.setContentType("text/html;charset=utf-8");
		
		PageUtil pageUtil = new PageUtil();
		pageUtil.setPageSize(pageSize);
		pageUtil.setPage(pageNumber);
		
		ResultAndTotal<AccessPerson> result = accessService.searchAccessPerson(pageUtil);
		
		GridView grid = new GridView();
		
		grid.setRows(result.getRows());
		grid.setTotal(result.getTotal());
		
		String json = JSONObject.fromObject(grid).toString();
		
		response.getWriter().print(json);
	}
	
	
	/**
	 * 跳转来访人员编辑页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("toAccessPersonForm")
	public String toAccessPersonForm(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");
		String oper = request.getParameter("oper");
		
		request.setAttribute("oper", oper);
		
		if("edit".equals(oper) || "view".equals(oper)){
			
			AccessPerson accessPerson = accessService.getAccessPersonEntity(Long.valueOf(id));
			
			//设置时间转换
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			
			Date at = accessPerson.getAccessTime();
			if(at != null)accessPerson.setAccessTimeCn(sdf.format(at));
			
			Date lt = accessPerson.getLeaveTime();
			if(lt != null)accessPerson.setLeaveTimeCn(sdf.format(lt));
			
			request.setAttribute("accessPerson", accessPerson);
		}
		
		return "other/form/accessPersonForm";
	}
	
	/**
	 * 保存来访人员信息
	 * @param request
	 * @param response
	 * @param accessPerson
	 * @throws IOException 
	 */
	@RequestMapping("saveAccessPerson")
	public void saveAccessPerson(HttpServletRequest request, HttpServletResponse response,AccessPerson accessPerson) throws IOException{
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		try {
			Date at = sdf.parse(accessPerson.getAccessTimeCn());
			Date lt = sdf.parse(accessPerson.getLeaveTimeCn());
			
			accessPerson.setAccessTime(at);
			accessPerson.setLeaveTime(lt);
			
		} catch (ParseException e) {
			
			System.out.println("时间格式错误");
			e.printStackTrace();
			
			response.getWriter().print("时间格式错误");
			
			return ;
		}
		
		int res = accessService.saveAccessPerson(accessPerson);
		
		response.getWriter().print(res);
	}
}
