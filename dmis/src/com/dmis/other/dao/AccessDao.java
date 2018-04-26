package com.dmis.other.dao;

import java.util.List;

import com.dmis.other.entity.AccessMaterial;
import com.dmis.other.entity.AccessPerson;
import com.dmis.util.PageUtil;

/**
 * 来访人员dao
 * @author Administrator
 *
 */
public interface AccessDao {

	/**
	 * 获得来访人员列表
	 * @param pageUtil
	 * @return
	 */
	public List<AccessPerson> getAccessPersons(PageUtil pageUtil);
	
	/**
	 * 获得来访人员记录数
	 * @param pageUtil
	 * @return
	 */
	public int getAccessPersonTotal(PageUtil pageUtil);
	
	
	/**
	 * 添加来访人员
	 * @param accessPerson
	 * @return
	 */
	public int addAccessPerson(AccessPerson accessPerson);
	
	
	/**
	 * 更新来访人员信息
	 * @param accessPerson
	 * @return
	 */
	public int updateAccessPerson(AccessPerson accessPerson);
	
	
	/**
	 * 获得来访人员信息
	 * @param id
	 * @return
	 */
	public AccessPerson getAccessPersonEntity(long id);
	
	
	/**
	 * 获得物资出入列表
	 * @param pageUtil
	 * @return
	 */
	public List<AccessMaterial> getAccessMaterials(PageUtil pageUtil);
	
	/**
	 * 获得物资出入记录数
	 * @param pageUtil
	 * @return
	 */
	public int getAccessMaterialTotal(PageUtil pageUtil);
	
	
	/**
	 * 添加物资出入
	 * @param accessPerson
	 * @return
	 */
	public int addAccessMaterial(AccessMaterial accessPerson);
	
	
	/**
	 * 更新物资出入信息
	 * @param accessPerson
	 * @return
	 */
	public int updateAccessMaterial(AccessMaterial accessPerson);
	
	
	/**
	 * 获得物资出入信息
	 * @param id
	 * @return
	 */
	public AccessMaterial getAccessMaterialEntity(long id);
}
