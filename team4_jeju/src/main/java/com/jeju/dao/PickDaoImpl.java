package com.jeju.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jeju.vo.PickVO;

//객체 변수명 첫 글자 소문자 주의
@Repository("pickDao")
public class PickDaoImpl implements PickDao{
	
	//객체 변수명 첫 글자 소문자 주의
	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public int inputPick(PickVO vo) {
		System.out.println("===>PickMapper inputPick 호출");
		return mybatis.insert("user.inputPick",vo);		
	}
	
}
