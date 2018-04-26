package com.dmis.other.entity;

import java.util.Date;

/**
 * 物品出入登记表
 * @author Administrator
 *
 */
public class AccessMaterial {

	//主键
	private Long id;
	
	//物资名称
	private String matName;
	
	//
	private String matType;
	
	//数量
	private int matNum;
	
	//单位
	private String unit;
	
	//时间
	private Date nowTime;
	private String nowTimeCn;
	
	//进出
	private int accessType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMatName() {
		return matName;
	}

	public void setMatName(String matName) {
		this.matName = matName;
	}

	public String getMatType() {
		return matType;
	}

	public void setMatType(String matType) {
		this.matType = matType;
	}

	public int getMatNum() {
		return matNum;
	}

	public void setMatNum(int matNum) {
		this.matNum = matNum;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Date getNowTime() {
		return nowTime;
	}

	public void setNowTime(Date nowTime) {
		this.nowTime = nowTime;
	}

	public String getNowTimeCn() {
		return nowTimeCn;
	}

	public void setNowTimeCn(String nowTimeCn) {
		this.nowTimeCn = nowTimeCn;
	}

	public int getAccessType() {
		return accessType;
	}

	public void setAccessType(int accessType) {
		this.accessType = accessType;
	}
	
	
}
