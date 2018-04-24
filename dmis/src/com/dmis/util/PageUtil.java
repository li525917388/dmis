package com.dmis.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.type.Alias;

/**
 * 分页查询工具类
 * @author Administrator
 *
 */
@Alias("pageUtil")
public class PageUtil {

	//一页数据数
	private int pageSize;
	
	//当前页
	private int page;
	
	//
	private int start;
	
	//
	private int end;
	
	private List<Where> where = new ArrayList<Where>();
	
	private String whereStr ;
	
	public void addEquals(String parm, Object value){
		
		Where w = new Where();
		w.setParm(parm);
		w.setOp("=");
		w.setValue(value.toString());
		
		where.add(w);
		
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		
		if(this.page > 0) this.start = (this.page - 1) * pageSize;
		
		this.pageSize = pageSize;
	}

	public int getPage() {
		
		return page;
	}

	public void setPage(int page) {
		
		if(this.pageSize > 0) this.start = (page - 1) * this.pageSize;
		
		this.page = page;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public List<Where> getWhere() {
		return where;
	}

	public void setWhere(List<Where> where) {
		this.where = where;
	}

	public String getWhereStr() {
		return whereStr;
	}

	public void setWhereStr(String whereStr) {
		this.whereStr = whereStr;
	}
	
	
}
