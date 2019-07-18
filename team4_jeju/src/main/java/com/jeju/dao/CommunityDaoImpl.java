package com.jeju.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jeju.vo.CommunityBoardVO;

//객체 변수명 첫 글자 소문자 주의
@Repository("communityDao")
public class CommunityDaoImpl implements CommunityDao{
	
	//객체 변수명 첫 글자 소문자 주의
	@Autowired
	private SqlSessionTemplate mybatis;
	
	
	
	//글 목록 조회
	public List<CommunityBoardVO> getCommunityBoardList(CommunityBoardVO vo){
		System.out.println("===> Mybatis getBoardList() 호출");
		return mybatis.selectList("communityMap.getCommunityBoardList",vo);
	}
	
	//글 등록
	public void insertCommunityBoard(CommunityBoardVO vo) {
		System.out.println("===> Mybatis insertBoard() 호출");
		mybatis.insert("communityMap.insertCommunityBoard",vo);
	}
	
}
