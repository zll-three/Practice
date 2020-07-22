package com.zll.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zll.mapper.ButtonMapper;
import com.zll.pojo.Button;
@Service
public class ButtonServiceImpl implements ButtonService{
    @Resource
    private ButtonMapper buttonMapper;
    
	@Override
	public List<Button> getButtonList() {
		// TODO Auto-generated method stub
		return buttonMapper.getButtonList();
	}
   
}
