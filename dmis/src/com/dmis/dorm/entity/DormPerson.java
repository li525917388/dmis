package com.dmis.dorm.entity;

/**
 * 宿舍人员表
 * @author Administrator
 *
 */
public class DormPerson {

	private Long id;
	
	//学生id
	private Long stuId;
	
	//学生姓名
	private String stuName;
	//学生学号
	private String stuNo;
	
	//宿舍id
	private Long dormId;
	
	//床位id
	private Long bedId;
	//床位编号
	private String bedNo;
	//床位类型
	private String bedType;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStuId() {
		return stuId;
	}

	public void setStuId(Long stuId) {
		this.stuId = stuId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuNo() {
		return stuNo;
	}

	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}

	public Long getDormId() {
		return dormId;
	}

	public void setDormId(Long dormId) {
		this.dormId = dormId;
	}

	public Long getBedId() {
		return bedId;
	}

	public void setBedId(Long bedId) {
		this.bedId = bedId;
	}

	public String getBedNo() {
		return bedNo;
	}

	public void setBedNo(String bedNo) {
		this.bedNo = bedNo;
	}

	public String getBedType() {
		return bedType;
	}

	public void setBedType(String bedType) {
		this.bedType = bedType;
	}
	
}
