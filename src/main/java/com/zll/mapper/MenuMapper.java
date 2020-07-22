package com.zll.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zll.pojo.Menu;

public interface MenuMapper {
	/**
	 * 根据菜单id查询对应的按钮
	 * @return
	 */      
	public List<Menu> getMenuList(Integer menuId);
	/**
	 * 查询一级菜单
	 */
	public List<Menu> getMenulist();
	/**
	 * 查询二级菜单
	 */
	public List<Menu> getMenulist2();
	/**
	 * 查询三级菜单
	 */
	public List<Menu> getMenulist3();
	
}
