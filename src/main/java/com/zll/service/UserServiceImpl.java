package com.zll.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zll.mapper.UserMapper;
import com.zll.pojo.Menu;
import com.zll.pojo.Role;
import com.zll.pojo.Um;
import com.zll.pojo.Ur;
import com.zll.pojo.User;
@Service
public class UserServiceImpl implements UserService{
    
	@Resource
	private UserMapper userMapper;
	
	/**
	 * 登录方法
	 */
	@Override
	public User getLogin(User user) {
		// TODO Auto-generated method stub
		return userMapper.getLogin(user);
	}

	@Override
	public List<User> getUserList(User user) {
		// TODO Auto-generated method stub
		return userMapper.getUserList(user);
	}

	@Override
	public List<User> getUmList(Integer userId) {
		// TODO Auto-generated method stub
		return userMapper.getUmList(userId);
	}

	@Override
	public List<Menu> getMenu(Menu menu) {
		// TODO Auto-generated method stub
		return userMapper.getMenu(menu);
	}

	@Override
	public int deleteUser(String[] userId) {
		// TODO Auto-generated method stub
		return userMapper.deleteUser(userId);
	}

	@Override
	public List<Role> getRoleList() {
		// TODO Auto-generated method stub
		return userMapper.getRoleList();
	}

	@Override
	public int userNameCount(String userName) {
		// TODO Auto-generated method stub
		return userMapper.userNameCount(userName);
	}

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.addUser(user);
	}


	@Override
	public int addUr(Integer userId, String roleId) {
		// TODO Auto-generated method stub
		return userMapper.addUr(userId, roleId);
	}

	@Override
	public int addUm(Integer userId, String menuId) {
		// TODO Auto-generated method stub
		return userMapper.addUm(userId, menuId);
	}

	@Override
	public List<User> getUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.getUser(user);
	}

	@Override
	public int delUr(Integer userId) {
		// TODO Auto-generated method stub
		return userMapper.delUr(userId);
	}

	@Override
	public int delUm(Integer userId) {
		// TODO Auto-generated method stub
		return userMapper.delUm(userId);
	}

	

	

}
