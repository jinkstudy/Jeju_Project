package com.jeju.dao;

import java.util.List;

import com.jeju.vo.PickVO;
import com.jeju.vo.PlaceVO;

public interface PickDao {

	//찜 등록
	public void insertPick(PickVO vo);
	//찜 삭제
	public void deletePick(PickVO vo);
	//찜 목록 조회
	public List<PlaceVO> getPickList(PickVO vo);
}
