package com.jeju.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jeju.vo.FinalPlaceVO_GyuBeom;
import com.jeju.vo.MajorClassVO;
import com.jeju.vo.MiddleClassVO;
import com.jeju.vo.PlaceTestVO;

//객체 변수명 첫 글자 소문자 주의
@Repository("tourCateDao")
public class TourCateDaoImpl implements TourCateDao{
	
	//객체 변수명 첫 글자 소문자 주의
	@Autowired
	private SqlSessionTemplate mybatis;

	//hotPlace top50 select
	public List<PlaceTestVO> getHotPlaceList() {
		return mybatis.selectList("tourCateMap.selectHotPlace");
	
	}
	//MiddleClass로 장소리스트 select
	public List<FinalPlaceVO_GyuBeom> getPlacebyMidd(MiddleClassVO vo) {
		// TODO Auto-generated method stub
		return mybatis.selectList("tourCateMap.selectPlacebyMidd",vo);
	}
	// 대분류 번호에 따른 중분류 LIST 가져오기.
	public List<MiddleClassVO> getMiddName(int i) {
		// TODO Auto-generated method stub
		return mybatis.selectList("tourCateMap.selectMiddName",i);
	}
	// 대분류번호에 따른 Place list 가져오기.
	public List<FinalPlaceVO_GyuBeom> selectPlaceByMajor(MiddleClassVO vo) {
		// TODO Auto-generated method stub
		return mybatis.selectList("tourCateMap.selectPlaceByMajor",vo);
	}	
	
}
