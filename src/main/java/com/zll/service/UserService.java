package com.zll.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zll.pojo.Menu;
import com.zll.pojo.Role;
import com.zll.pojo.Um;
import com.zll.pojo.Ur;
import com.zll.pojo.User;

public interface UserService {
	 /**
     * 用户登录   
     * @param user
     * @return
     */
	public User getLogin(User user);
	/**
	 * 查询用户
	 * @param user
	 * @return
	 */
	public List<User> getUserList(User user);
	/**
	 * 查询用户
	 * @param user
	 * @return
	 */
	public List<User> getUser(User user);
	/**
	 * 查询用户下面的菜单
	 */
	public List<User> getUmList(Integer userId);
	/**
	 * 查询菜单
	 */
	 public List<Menu> getMenu(Menu menu);
	 /**
		 * 查询用户名是否重复
		 */
		public int userNameCount(@Param("userName")String userName);
	 /**
	  * 查询全部角色
	  */
	 public List<Role> getRoleList();
	 /**
	  * 批量删除用户解除关联
	  */
	 public int deleteUser(String[] userId);
	 /**
	  * 增加用户
	  * @param user
	  * @return
	  */
	 public int addUser(User user);
	 /**
	  * 权限关联
	  * @param userId
	  * @param roleId
	  * @return
	  */
	 public int addUr(@Param("userId")Integer userId,@Param("roleId")String roleId);
	 /**
	  * 菜单关联
	  * @return
	  */
	 public int addUm(@Param("userId")Integer userId,@Param("menuId")String menuId);
	 /**
	     * 解除用户所有的角色
	     */
	    public int delUr(@Param("userId")Integer userId);
	    /**
	     * 解除用户所以的菜单
	     */
	    public int delUm(@Param("userId")Integer userId);
}
