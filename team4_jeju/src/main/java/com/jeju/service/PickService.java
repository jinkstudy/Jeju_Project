package com.jeju.service;

import java.util.List;

import com.jeju.vo.PickVO;
import com.jeju.vo.PlaceNewVO;

public interface PickService {
	
	//찜 등록
	void insertPick(PickVO vo);
	//찜 삭제
	void deletePick(PickVO vo);
	//찜 목록 조회
	List<PlaceNewVO> getPickList(PickVO vo);
}
