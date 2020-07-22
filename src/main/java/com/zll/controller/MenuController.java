package com.zll.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.zll.pojo.Menu;
import com.zll.pojo.User;
import com.zll.service.MenuService;
import com.zll.service.UserService;

@Controller
public class MenuController {
          @Resource
          private MenuService menuService;
          @Resource
          private UserService userService;
          @RequestMapping("/MenuList")
          public  String MenuList(Model model,@RequestParam(value = "link") String link,
    		      @RequestParam(value = "menuId") String menuId,HttpSession session ) {
        	  List<Menu> getMenuList=menuService.getMenuList(Integer.parseInt(menuId));
        	  User u = (User) session.getAttribute("user");
        	  List<User> getUmList=userService.getUmList(u.getUserId());
        	  List<Menu> getMenu =userService.getMenu(null);
        	  model.addAttribute("getMenu",getMenu);
        	  model.addAttribute("getUmList",getUmList);
        	  model.addAttribute("getMenuList",getMenuList);
			return "Menu";
        	  
        	  
          }
          @RequestMapping("/menulist")
  		  @ResponseBody
          public Object menulist(HttpSession session ) {
        	  HashMap<String, Object> resultMap = new HashMap<String, Object>();
        	 
        	  List<Menu> getMenulist=menuService.getMenulist();
        	  List<Menu> getMenulist2=menuService.getMenulist2();
        	  List<Menu> getMenulist3=menuService.getMenulist3();
        	  User u = (User) session.getAttribute("user");
        	  List<User> getUmList=userService.getUmList(u.getUserId());
        	  for(User user:getUmList) {
        		  
        		  resultMap.put("getUmList",user.getMenulist());
        	  }
        	 
        	 
        	  resultMap.put("getMenulist3", getMenulist3);
        	  resultMap.put("getMenulist2", getMenulist2);
        	  resultMap.put("getMenulist", getMenulist);
        	  
        	  return JSONArray.toJSONString(resultMap);
          }
         @RequestMapping("/addMenu")
         public String addMenu() {
			return "addMenu";
        	 
        	 
         }
}
