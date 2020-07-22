package com.zll.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zll.pojo.Menu;
import com.zll.pojo.Role;
import com.zll.pojo.User;
import com.zll.service.UserService;

@Controller
public class IndexController {
	    @Resource
	    private UserService userService;
	
         @RequestMapping("/index")
         public String index(HttpSession session,Model model,Menu menu){
 
        	 User user = (User) session.getAttribute("user");
        	 if(user==null) {
        		 return "Login"; 
        	 }
        	 
        	  List<User> getUmList=userService.getUmList(user.getUserId());
        	  model.addAttribute("getUmList", getUmList);
			return "Homepage";
        	 
         }      
} 
