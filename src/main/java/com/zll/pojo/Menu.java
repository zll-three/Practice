package com.zll.pojo;

import java.util.List;

/**
 * 菜单实体类
 * @author 19324
 *
 */
public class Menu {
       private int menuId;//菜单id
       private String menuName;//菜单名称
       private int correlationId;//菜单关联
       private String menuIdentification;//菜单标识
       private int type;//菜单状态
       private String link;//菜单链接
       
       private List<Button> buttonList; //按钮
	
	public List<Button> getButtonList() {
		return buttonList;
	}
	public void setButtonList(List<Button> buttonList) {
		this.buttonList = buttonList;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public int getCorrelationId() {
		return correlationId;
	}
	public void setCorrelationId(int correlationId) {
		this.correlationId = correlationId;
	}
	public String getMenuIdentification() {
		return menuIdentification;
	}
	public void setMenuIdentification(String menuIdentification) {
		this.menuIdentification = menuIdentification;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
}
