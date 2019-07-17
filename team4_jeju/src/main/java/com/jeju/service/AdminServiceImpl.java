package com.jeju.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeju.dao.AdminDaoImpl;
import com.jeju.vo.AdminSelVO;

//객체 변수명 첫 글자 소문자 주의
@Service("adminService")
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminDaoImpl adminDao;
	
	//VisitJeju data input
	public void insertVisitJeju(AdminSelVO vo) {
		adminDao.insertVisitJeju(vo);
	};
	
}








