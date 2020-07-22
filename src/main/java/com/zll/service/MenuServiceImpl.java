package com.zll.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zll.mapper.MenuMapper;
import com.zll.pojo.Menu;
@Service
public class MenuServiceImpl implements MenuService{
    @Resource
    private MenuMapper menuMapper;
	@Override
	public List<Menu> getMenuList(Integer menuId) {
		// TODO Auto-generated method stub
		return menuMapper.getMenuList(menuId);
	}
	@Override
	public List<Menu> getMenulist() {
		// TODO Auto-generated method stub
		return menuMapper.getMenulist();
	}
	@Override
	public List<Menu> getMenulist2() {
		// TODO Auto-generated method stub
		return menuMapper.getMenulist2();
	}
	@Override
	public List<Menu> getMenulist3() {
		// TODO Auto-generated method stub
		return menuMapper.getMenulist3();
	}

}
