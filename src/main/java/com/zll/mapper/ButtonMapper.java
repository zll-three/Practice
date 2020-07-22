package com.zll.mapper;

import java.util.List;

import com.zll.pojo.Button;

public interface ButtonMapper {
    
	/**
	 * 查询全部按钮信息
	 * @return
	 */
	public List<Button> getButtonList();
}
