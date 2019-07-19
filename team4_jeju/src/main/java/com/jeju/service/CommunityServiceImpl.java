package com.jeju.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeju.dao.CommunityDaoImpl;
import com.jeju.vo.CommunityBoardVO;

//객체 변수명 첫 글자 소문자 주의
@Service("communityService")
public class CommunityServiceImpl implements CommunityService{

	//객체 변수명 첫 글자 소문자 주의
	@Autowired
	private CommunityDaoImpl communityDao;
	
	//글 목록 조회
	public List<CommunityBoardVO> getCommunityBoardList(CommunityBoardVO vo){
		return communityDao.getCommunityBoardList(vo);
	}
	
	//글 등록
	public void insertCommunityBoard(CommunityBoardVO vo) {
		communityDao.insertCommunityBoard(vo);
	}
	//글 수정
	public void updateCommunityBoard(CommunityBoardVO vo) {
		communityDao.updateCommunityBoard(vo);
	}
	//글 삭제
	public void deleteCommunityBoard(CommunityBoardVO vo) {
		communityDao.deleteCommunityBoard(vo);
	}
	//글 상세조회
	public CommunityBoardVO getCommunityBoard(CommunityBoardVO vo) {
		return communityDao.getCommunityBoard(vo);
	}
}
