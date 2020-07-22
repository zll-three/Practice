package com.zll.pojo;

import java.util.List;

public class User {
        private int userId;//用户id
        private String userName;//用户名
        private String password;//用户密码;
        
       
        private List<Role> roleList;//角色
        private List<Menu> menulist;//菜单
        public List<Menu> getMenulist() {
			return menulist;
		}
		public void setMenulist(List<Menu> menulist) {
			this.menulist = menulist;
		}
		public List<Role> getRoleList() {
			return roleList;
		}
		public void setRoleList(List<Role> roleList) {
			this.roleList = roleList;
		}
		
		
		
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
        
}
