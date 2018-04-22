package com.dmis.sys.util;

import java.util.List;

import com.dmis.sys.entity.Menu;

public class MenuView extends Menu {

	private List<Menu> children;

	public List<Menu> getChildren() {
		return children;
	}

	public void setChildren(List<Menu> children) {
		this.children = children;
	}
	
	
}
