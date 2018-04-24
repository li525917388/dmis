package com.dmis.util;

import java.util.List;

/**
 * 分页service返回工具类
 * @author Administrator
 *
 * @param <T>
 */
public class ResultAndTotal<T> {

	private int total;	//总数据数
	
	private List<T> rows;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	
}
