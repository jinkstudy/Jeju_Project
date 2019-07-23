package com.jeju.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeju.dao.TourCateDaoImpl;


import com.jeju.vo.PlaceTestVO;

//객체 변수명 첫 글자 소문자 주의
@Service("tourCateService")
public class TourCateServiceImpl implements TourCateService{
	
	//객체 변수명 첫 글자 소문자 주의
	@Autowired
	private TourCateDaoImpl tourCateDAO;

	public List<PlaceTestVO> getHotPlaceList() {
		return tourCateDAO.getHotPlaceList();
				
	}
	
}
