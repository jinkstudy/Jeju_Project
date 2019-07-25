package com.jeju.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeju.dao.TourDrawingDaoImpl_GyuBeom;
import com.jeju.vo.FinalPlaceVO_GyuBeom;

//객체 변수명 첫 글자 소문자 주의
@Service("tourDrawingService")
public class TourDrawingServiceImpl_GyuBeom implements TourDrawingService_GyuBeom{
	
	//객체 변수명 첫 글자 소문자 주의
	@Autowired
	private TourDrawingDaoImpl_GyuBeom mapDrawingDao;
	
	public List<FinalPlaceVO_GyuBeom> tourMapDrawing(){
		return mapDrawingDao.mapDrawingList();
	};
	
}
