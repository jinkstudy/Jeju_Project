package com.jeju.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeju.dao.PickDaoImpl;
import com.jeju.vo.MemberVO;

//객체 변수명 첫 글자 소문자 주의
@Service("pickService")
public class PickServiceImpl implements PickService{
	
	//객체 변수명 첫 글자 소문자 주의
	@Autowired
	private PickDaoImpl pickDao;
	
}
