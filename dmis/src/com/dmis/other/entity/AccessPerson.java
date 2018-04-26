package com.dmis.other.entity;

import java.util.Date;

/**
 * 来访人员记录表
 * @author Administrator
 *
 */
public class AccessPerson {

	//主键
	private Long id;
	
	//来访人姓名
	private String personName;
	
	//联系方式
	private String phone;
	
	//目的
	private String objective;
	
	//人数
	private Integer personSum;
	
	//访问时间
	private Date accessTime;
	private String accessTimeCn;
	
	//离开时间
	private Date leaveTime;
	private String leaveTimeCn;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getObjective() {
		return objective;
	}

	public void setObjective(String objective) {
		this.objective = objective;
	}

	public Integer getPersonSum() {
		return personSum;
	}

	public void setPersonSum(Integer personSum) {
		this.personSum = personSum;
	}

	public Date getAccessTime() {
		return accessTime;
	}

	public void setAccessTime(Date accessTime) {
		this.accessTime = accessTime;
	}

	public Date getLeaveTime() {
		return leaveTime;
	}

	public void setLeaveTime(Date leaveTime) {
		this.leaveTime = leaveTime;
	}

	public String getAccessTimeCn() {
		return accessTimeCn;
	}

	public void setAccessTimeCn(String accessTimeCn) {
		this.accessTimeCn = accessTimeCn;
	}

	public String getLeaveTimeCn() {
		return leaveTimeCn;
	}

	public void setLeaveTimeCn(String leaveTimeCn) {
		this.leaveTimeCn = leaveTimeCn;
	}
	
	
}
