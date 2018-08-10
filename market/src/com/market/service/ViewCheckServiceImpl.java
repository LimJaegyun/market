package com.market.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.market.domain.ViewCheck;
import com.market.persistence.ViewCheckMapper;

@Service
public class ViewCheckServiceImpl implements ViewCheckService {
	@Resource
	private ViewCheckMapper viewCheckMapper;
	
	@Override
	public void insert(ViewCheck viewCheck) {
		viewCheckMapper.insert(viewCheck);
	}

}
