package com.jeju.dao;

import com.jeju.vo.PickVO;

public interface PickDao {

	/**
	 * 
	 * ajax 버튼 클릭시 찜목록 DB에 저장시키는 기능 구현
	 */
	int inputPick(PickVO vo);
}
