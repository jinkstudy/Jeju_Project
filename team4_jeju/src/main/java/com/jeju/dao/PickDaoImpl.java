package com.jeju.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jeju.vo.PickVO;
import com.jeju.vo.PlaceVO;

//객체 변수명 첫 글자 소문자 주의
@Repository("pickDao")
public class PickDaoImpl implements PickDao{
	
	//객체 변수명 첫 글자 소문자 주의
	@Autowired
	private SqlSessionTemplate mybatis;
	
	//찜 등록
	@Override
	public void insertPick(PickVO vo) {
		System.out.println("===>PickMapper inputPick 호출");
		mybatis.insert("pickMap.insertPick",vo);		
	}
	//찜 삭제
	public void deletePick(PickVO vo) {
		System.out.println("===>PickMapper deletePick 호출");
		mybatis.delete("pickMap.deletePick",vo);
	}
	//찜 목록 조회
	public List<PlaceVO> getPickList(PickVO vo){
		System.out.println("===>PickMapper getPickList 호출");
		return mybatis.selectList("pickMap.getPickList",vo);
	}
}

