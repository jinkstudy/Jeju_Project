package com.jeju.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jeju.vo.FinalPlaceVO_GyuBeom;

//객체 변수명 첫 글자 소문자 주의
@Repository("tourDrawingDao")
public class TourDrawingDaoImpl_GyuBeom implements TourDrawingDao_GyuBeom{
	
	//객체 변수명 첫 글자 소문자 주의
	@Autowired
	private SqlSessionTemplate mybatis;	
	
	public List<FinalPlaceVO_GyuBeom> mapDrawingList(){
		return mybatis.selectList("tourDrawingMap.selectTourDrawing");
	}
	
}
