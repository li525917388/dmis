package com.dmis.dorm.entity;

/**
 * 宿舍楼宇
 * @author Administrator
 *
 */
public class Building {

	//
	private Long id;
	
	//编号
	private int no;
	
	//类型
	private int type;
	
	//名字
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
