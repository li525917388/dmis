package com.dmis.sys.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dmis.sys.dao.MenuDao;
import com.dmis.sys.entity.Menu;
import com.dmis.sys.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {

	@Resource
	private MenuDao menuDao;

	public MenuDao getMenuDao() {
		return menuDao;
	}

	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}



	@Override
	public List<Menu> getMenuByUid(long uid) {
		
		List<Menu> menus = menuDao.getMenuByUid(uid);
		
		List<Menu> res = new ArrayList<Menu>();
				
		for(Menu m : menus){
			
			if(m.getType() == 1){
				
				res.add(m);
				
			}else{
				
				for(Menu mm : res){
					
					if(mm.getMenuNo().equals(m.getFno())){
						
						if(mm.getChildren() == null){
							
							mm.setChildren(new ArrayList<Menu>());
						}
						mm.getChildren().add(m);
					}
				}
			}
		}
		
		return res;
	}

	@Override
	public List<Menu> getMenusQuery() {
		
		return menuDao.getMenusQuery();
	}

}
