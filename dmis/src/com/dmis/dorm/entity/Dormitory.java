package com.dmis.dorm.entity;

/**
 * 宿舍
 * @author Administrator
 *
 */
public class Dormitory {

	private Long id;
	
	//楼宇id
	private Long buildId;
	
	//楼宇name（非字段）
	private String buildName;
	
	//床位数
	private Integer maxNum;
	
	//宿舍编号
	private Integer dormNo;
	
	//宿舍性别
	private Integer dormSex;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBuildId() {
		return buildId;
	}

	public void setBuildId(Long buildId) {
		this.buildId = buildId;
	}

	public Integer getMaxNum() {
		return maxNum;
	}

	public void setMaxNum(Integer maxNum) {
		this.maxNum = maxNum;
	}

	public Integer getDormNo() {
		return dormNo;
	}

	public void setDormNo(Integer dormNo) {
		this.dormNo = dormNo;
	}

	public Integer getDormSex() {
		return dormSex;
	}

	public void setDormSex(Integer dormSex) {
		this.dormSex = dormSex;
	}

	public String getBuildName() {
		return buildName;
	}

	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}
	
	
}
