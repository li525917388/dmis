package com.dmis.dorm.entity;

/**
 * 宿舍规格
 * @author Administrator
 *
 */
public class DormType {

	private Long id;
	
	//最大人数
	private int maxNum;
	
	//名称
	private String dormTypeName;
	
	//排序
	private int dorder;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getMaxNum() {
		return maxNum;
	}

	public void setMaxNum(int maxNum) {
		this.maxNum = maxNum;
	}

	public String getDormTypeName() {
		return dormTypeName;
	}

	public void setDormTypeName(String dormTypeName) {
		this.dormTypeName = dormTypeName;
	}

	public int getDorder() {
		return dorder;
	}

	public void setDorder(int dorder) {
		this.dorder = dorder;
	}
	
	
}
