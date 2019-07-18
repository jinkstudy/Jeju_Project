package com.jeju.service;

import java.util.List;

import com.jeju.vo.CommunityBoardVO;

public interface CommunityService {
	
	//글 목록 조회
	List<CommunityBoardVO> getCommunityBoardList(CommunityBoardVO vo);
	
	//글 등록
	void insertCommunityBoard(CommunityBoardVO vo);
	//글 수정
	//글 삭제
	//글 상세 조회
}
