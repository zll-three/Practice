package com.zll.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.zll.pojo.User;
import com.zll.service.UserService;

@Controller
public class LoginController {
	@Resource
	private UserService userService;
       //用户退出
	@RequestMapping("/login")
	public String remove(HttpServletRequest request, HttpServletResponse response) {
		if (request.getSession() != null) {
			// 让会话失效！
			request.getSession().invalidate();
		}
		return "Login";
	}
	
	    //登录方法
	    @RequestMapping(value="/login",method=RequestMethod.POST)
		@ResponseBody
		public Object LoginUser(@ModelAttribute() User user,HttpSession session,HttpServletRequest request){
			HashMap<String, String> resultMap = new HashMap<String, String>();
			
			user=userService.getLogin(user);
					  if(user!=null) {
						  resultMap.put("loginResult", "true"); 
						  session.setAttribute("user", user);			
					  }else {
						  resultMap.put("loginResult", "false");
					  }
					 			  return JSONArray.toJSONString(resultMap);
			  }
}
