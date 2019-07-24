package com.jeju.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeju.dao.TourCateDaoImpl;
import com.jeju.vo.FinalPlaceVO_GyuBeom;
import com.jeju.vo.MajorClassVO;
import com.jeju.vo.MiddleClassVO;
import com.jeju.vo.PlaceTestVO;

//객체 변수명 첫 글자 소문자 주의
@Service("tourCateService")
public class TourCateServiceImpl implements TourCateService{
	
	//객체 변수명 첫 글자 소문자 주의
	@Autowired
	private TourCateDaoImpl tourCateDAO;

	//hotPlace top50 select
	public List<PlaceTestVO> getHotPlaceList() {
		return tourCateDAO.getHotPlaceList();
				
	}

	//MiddleClass로 장소리스트 select
	public List<FinalPlaceVO_GyuBeom>  getPlacebyMidd(MiddleClassVO vo) {
		// TODO Auto-generated method stub
		return tourCateDAO.getPlacebyMidd(vo);
	}

	// 대분류 번호에 따른 중분류 LIST 가져오기.
	public List<MiddleClassVO> getMiddName(int i) {
		// TODO Auto-generated method stub
		return tourCateDAO.getMiddName(i);
	}
	
	// 대분류번호에 따른 Place list 가져오기.
	public List<FinalPlaceVO_GyuBeom> selectPlaceByMajor(MiddleClassVO vo) {
		// TODO Auto-generated method stub
		return tourCateDAO.selectPlaceByMajor(vo);
	}

	
	
}
