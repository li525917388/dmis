package com.dmis.dorm.entity;

/**
 * 床位
 * @author Administrator
 *
 */
public class Bed {

	private Long id;
	
	//编号
	private String bedNo;
	
	//宿舍规格
	private Long dormType;
	
	//
	private Long summary;
	
	//床位类型
	private String bedType;
	/**
	 * 床位类型枚举
	 * @author Administrator
	 *
	 */
	public enum BedTypeEnum{
		/**
		 * 上铺
		 */
		Up("Up","上铺"),
		/**
		 * 下铺
		 */
		Down("Down","下铺"),
		/**
		 * 单层
		 */
		Single("Single","单层");
		private String code;
		private String name;
		private BedTypeEnum(String code,String name){
			this.code = code;
			this.name = name;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Long getDormType() {
		return dormType;
	}
	public void setDormType(Long dormType) {
		this.dormType = dormType;
	}
	public Long getSummary() {
		return summary;
	}
	public void setSummary(Long summary) {
		this.summary = summary;
	}
	
}
