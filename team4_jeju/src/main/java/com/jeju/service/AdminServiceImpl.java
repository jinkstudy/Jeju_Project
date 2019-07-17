package com.jeju.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeju.dao.AdminDaoImpl;
import com.jeju.vo.AdminSelVO;
import com.jeju.tour_method.VisitJeju_GyuBeom;

//객체 변수명 첫 글자 소문자 주의
@Service("adminService")
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminDaoImpl adminDao;
	
	//VisitJeju data input
	public void insertVisitJeju() {
		VisitJeju_GyuBeom vj = new VisitJeju_GyuBeom();
		adminDao.insertVisitJeju(vj.crawl());
	};
	
}








