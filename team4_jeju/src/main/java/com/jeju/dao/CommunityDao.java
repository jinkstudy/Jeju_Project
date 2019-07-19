package com.jeju.dao;

import java.util.List;

import com.jeju.vo.CommunityBoardVO;

public interface CommunityDao {
	
	//글 목록 조회
	public List<CommunityBoardVO> getCommunityBoardList(CommunityBoardVO vo);
	//글 등록
	public void insertCommunityBoard(CommunityBoardVO vo);
	//글 수정
	public void updateCommunityBoard(CommunityBoardVO vo);
	//글 삭제
	public void deleteCommunityBoard(CommunityBoardVO vo);
	//글 상세 조회
	public CommunityBoardVO getCommunityBoard(CommunityBoardVO vo);
}
