package com.jeju.dao;

import java.util.List;

import com.jeju.vo.CommunityBoardVO;

public interface CommunityDao {
	
	//글 목록 조회
	public List<CommunityBoardVO> getCommunityBoardList(CommunityBoardVO vo);
	//글 등록
	public void insertCommunityBoard(CommunityBoardVO vo);
}
