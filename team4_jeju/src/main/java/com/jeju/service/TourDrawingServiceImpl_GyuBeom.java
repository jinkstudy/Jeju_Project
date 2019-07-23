package com.jeju.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeju.dao.TourSchDaoImpl;
import com.jeju.vo.FinalPlaceVO_GyuBeom;

//객체 변수명 첫 글자 소문자 주의
@Service("tourDrawingService")
public class TourDrawingServiceImpl_GyuBeom implements TourDrawingService_GyuBeom{
	
	//객체 변수명 첫 글자 소문자 주의
	@Autowired
	private TourSchDaoImpl tourDAO;
	
	public List<FinalPlaceVO_GyuBeom> tourListDrawing(){
		
		FinalPlaceVO_GyuBeom fvo = new FinalPlaceVO_GyuBeom();
		
		List<FinalPlaceVO_GyuBeom> fdlist = new ArrayList<FinalPlaceVO_GyuBeom>();  
		
		return fdlist;
	};
	
}
