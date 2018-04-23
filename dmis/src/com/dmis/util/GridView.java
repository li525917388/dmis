package com.dmis.util;

import java.io.Serializable;
import java.util.List;

public class GridView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//总记录数
	private int records;
	//每页记录数
	private int maxResults;
	//总页数
	private int total;
	//当前页数
	private int page;
	//列表数据
	private List<?> rows;
	
	public int getRecords() {
		return records;
	}
	public void setRecords(int records) {
		this.records = records;
	}
	public int getMaxResults() {
		return maxResults;
	}
	public void setMaxResults(int maxResults) {
		this.maxResults = maxResults;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}

	
	
}
