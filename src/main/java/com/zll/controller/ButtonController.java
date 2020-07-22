package com.zll.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zll.pojo.Button;
import com.zll.pojo.Menu;
import com.zll.pojo.User;
import com.zll.service.ButtonService;
import com.zll.service.MenuService;
import com.zll.service.UserService;

@Controller
public class ButtonController {
	 @Resource
     private UserService userService;
	 @Resource
     private MenuService menuService;
	 @Resource
	 private ButtonService buttonService;
	//跳转到按钮
	@RequestMapping("/ButtonList")
	public String ButtonList(Model model,User user,Menu menu,@RequestParam(value = "link") String link,
		      @RequestParam(value = "menuId") String menuId ) {
		
		  List<Menu> getMenuList=menuService.getMenuList(Integer.parseInt(menuId));
		  List<Button> getButtonList=buttonService.getButtonList();
		  model.addAttribute("getMenuList", getMenuList);
		  model.addAttribute("getButtonList", getButtonList);
		
		return "Button";
		
	}
	//增加按钮
	@RequestMapping("/addButton")
	public String addButton() {
		
		
		return "addButton";
		
		
	}
	
}
