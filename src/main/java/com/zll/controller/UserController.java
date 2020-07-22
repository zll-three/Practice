package com.zll.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.zll.pojo.Menu;
import com.zll.pojo.Role;
import com.zll.pojo.Um;
import com.zll.pojo.Ur;
import com.zll.pojo.User;
import com.zll.service.MenuService;
import com.zll.service.UserService;

@Controller
public class UserController {
          @Resource
          private UserService userService;
          @Resource
          private MenuService menuService;
          
          //用户信息
          @RequestMapping("/UserList")
          public String UserList(Model model,User user,Menu menu,@RequestParam(value = "link") String link,
        		      @RequestParam(value = "menuId") String menuId ) {
        	  List<Menu> getMenuList=menuService.getMenuList(Integer.parseInt(menuId));
        	  List<User> getUserLst=userService.getUserList(user);
        	  List<Menu> getMenu=userService.getMenu(menu);       	  
        	  model.addAttribute("getMenu",getMenu);
        	  model.addAttribute("getMenuList",getMenuList);
        	  model.addAttribute("getUserLst",getUserLst);
        	  model.addAttribute("link",link);
        	  model.addAttribute("menuId",menuId);       	  
			return "UserList";        	 	  
          }
          //查询用户的当下权限
          @RequestMapping("/fp")
          public String fp(User user,Model model, @RequestParam(value = "userId") String userId) {
        	  user.setUserId(Integer.parseInt(userId));
   
        	  List<User> getList=userService.getUser(user);    
         	  List<User> getUmList=userService.getUmList(Integer.parseInt(userId));
              List<Menu> getMenu=userService.getMenu(null);  
              List<Role> getRoleList =userService.getRoleList();
              model.addAttribute("getRoleList",getRoleList);
         	 model.addAttribute("getMenu",getMenu);
         	 model.addAttribute("getUmList", getUmList);
        	  for(User uer:getList) {
        		  for(Role role :uer.getRoleList()) {
        			  model.addAttribute("roleIdList", role.getRoleId());
        		  }
        		  
        	  }
        	  for(User uer:getList) {
        		  for(Menu menu :uer.getMenulist()) {
        			  model.addAttribute("menuIdList", menu.getMenuId());
        		  }
        		  
        	  }
        	  model.addAttribute("getList", getList);
			  return "FPNt";
        	  
        	  
          }
          @RequestMapping("/add")
          public String add(HttpSession session,Model model,Menu menu) {
        	  User user = (User) session.getAttribute("user");
        	  List<User> getUmList=userService.getUmList(user.getUserId());
              List<Menu> getMenu=userService.getMenu(null);  
              List<Role> getRoleList =userService.getRoleList();
              model.addAttribute("getRoleList",getRoleList);
         	 model.addAttribute("getMenu",getMenu);
         	 model.addAttribute("getUmList", getUmList);
			return "AddUserNt";
        	  
          }
          
        //删除用户方法
  	    @RequestMapping(value="/delUser/{userId}",method=RequestMethod.POST)
  		@ResponseBody
  		public Object delUser(@PathVariable("userId") String userId){
  	    	HashMap<String, String> resultMap = new HashMap<String, String>();
  			String[] d=userId.split(",");
  			System.out.println(d);
		    int count =userService.deleteUser(d); if(count>0) {
		     resultMap.put("delResult", "true");
		  
		    }else { resultMap.put("delResult", "false"); }
		 
  					 			  return JSONArray.toJSONString(resultMap);
  			  }
  	    
  	//判断用户名是否重复方法
  	    @RequestMapping(value="/count",method=RequestMethod.POST)
  		@ResponseBody
  		public Object count(@RequestParam(value = "userName") String userName){
  	    	HashMap<String, String> resultMap = new HashMap<String, String>();
		    int count =userService.userNameCount(userName);
		    if(count>0) {
		     resultMap.put("countResult", "true");
		  
		    }else {
		    	resultMap.put("countResult", "false"); 
		    	}
		 
  		  return JSONArray.toJSONString(resultMap);
  			  }
  	  //增加用户方法
  	    @RequestMapping(value="/addUser/{roleId}/{menuId}/{userName}/{password}",method=RequestMethod.POST)
  		@ResponseBody
  		public Object addUser(User user,
  				    @PathVariable("roleId") String roleId,
  				    @PathVariable("menuId") String menuId,
  				    @PathVariable("userName") String userName,
  				    @PathVariable("password") String password){
  	    	HashMap<String, String> resultMap = new HashMap<String, String>();
  	    	
  	    	
  			String[] r=roleId.split(",");
  			String[] m=menuId.split(",");
  	    	user.setUserName(userName);
  	    	user.setPassword(password);
  	    	int count =userService.addUser(user);
  	    	int num2=0;
  	    	
  	    	//System.out.println(roleId);
  	    	System.out.println(r.length);
            for(int i=0;i<r.length;i++) {          	
            	System.out.println(r[i]);
            	int num=userService.addUr(user.getUserId(), r[i]);
  	    	}
		 for(int i=0;i<m.length;i++) { System.out.println(m);
		 //System.out.println(menuId); 
		  num2 =userService.addUm(user.getUserId(),m[i]);
		  
		  }
		
		  
		    
		
		  if(num2>0) { resultMap.put("addUserResult", "true");
		  
		  }else { resultMap.put("addUserResult", "false"); }
		 
		 
  					 			  return JSONArray.toJSONString(resultMap);
  			  }
  	    //分配用户权利   /fpUser/"+roleId+"/"+menuId+"/"+userId
  	    @RequestMapping(value="/fpUser/{roleId}/{menuId}/{userId}",method=RequestMethod.POST)
		@ResponseBody
		public Object fpUser(User user,
				    @PathVariable("roleId") String roleId,
				    @PathVariable("menuId") String menuId,
				    @PathVariable("userId") String userId){
	    	HashMap<String, String> resultMap = new HashMap<String, String>();

	    	
			String[] r=roleId.split(",");
			String[] m=menuId.split(",");
	    	int count =userService.delUr(Integer.parseInt(userId));
	    	int count2=userService.delUm(Integer.parseInt(userId));
	    	int num2=0;
	    	
	    	System.out.println(userId);
          for(int i=0;i<r.length;i++) {          	
          
          	int num=userService.addUr(Integer.parseInt(userId), r[i]);
	    	}
		 for(int i=0;i<m.length;i++) { System.out.println(m);
		 //System.out.println(menuId); 
		  num2 =userService.addUm(Integer.parseInt(userId),m[i]);
		  
		  }
		
		  
		    
		
		  if(num2>0) { resultMap.put("fpUserResult", "true");
		  
		  }else { resultMap.put("fpUserResult", "false"); }
		 
		 
					 			  return JSONArray.toJSONString(resultMap);
			  }
}
