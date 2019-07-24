package com.jeju.dao;

import java.util.List;

import com.jeju.vo.FinalPlaceVO_GyuBeom;
import com.jeju.vo.MajorClassVO;
import com.jeju.vo.MiddleClassVO;
import com.jeju.vo.PlaceTestVO;

public interface TourCateDao {
	public List<PlaceTestVO> getHotPlaceList();
	public List<FinalPlaceVO_GyuBeom> getPlacebyMidd(MiddleClassVO vo);
	public List<MiddleClassVO> getMiddName(int i);
	public List<FinalPlaceVO_GyuBeom> selectPlaceByMajor(MiddleClassVO vo);

}
