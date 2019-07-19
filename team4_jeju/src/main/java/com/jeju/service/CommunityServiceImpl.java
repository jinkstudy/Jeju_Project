package com.jeju.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeju.dao.CommunityDaoImpl;

//객체 변수명 첫 글자 소문자 주의
@Service("communityService")
public class CommunityServiceImpl implements CommunityService{

	//객체 변수명 첫 글자 소문자 주의
	@Autowired
	private CommunityDaoImpl communityDao;
	
}
