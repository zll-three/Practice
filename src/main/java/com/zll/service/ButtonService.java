package com.zll.service;

import java.util.List;

import com.zll.pojo.Button;

public interface ButtonService {
	/**
	 * 查询全部按钮信息
	 * @return
	 */
	public List<Button> getButtonList();
}
