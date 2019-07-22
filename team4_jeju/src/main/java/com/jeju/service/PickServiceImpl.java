package com.jeju.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeju.dao.PickDaoImpl;
import com.jeju.vo.PickVO;
import com.jeju.vo.PlaceNewVO;

//객체 변수명 첫 글자 소문자 주의
@Service("pickService")
public class PickServiceImpl implements PickService{
	
	//객체 변수명 첫 글자 소문자 주의
	@Autowired
	private PickDaoImpl pickDao;
	
	//찜 등록
	public void insertPick(PickVO vo) {
		pickDao.insertPick(vo);
	}
	//찜 삭제
	public void deletePick(PickVO vo) {
		pickDao.deletePick(vo);
	}
	//찜 목록 조회
	public List<PlaceNewVO> getPickList(PickVO vo){
		return pickDao.getPickList(vo);
	}
}
