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
//		List<CommunityBoardVO> list= mybatis.selectList("communityMap.getCommunityBoardList",vo);
//		for(CommunityBoardVO m : list) {
//				System.out.println(m.getComm_Mnum());
//		}
//		return list;
		
		return mybatis.selectList("communityMap.getCommunityBoardList",vo);
	}
	
	//글 등록
	public void insertCommunityBoard(CommunityBoardVO vo) {
		System.out.println("===> Mybatis insertBoard() 호출");
		mybatis.insert("communityMap.insertCommunityBoard",vo);
	}
	//글 수정
	public void updateCommunityBoard(CommunityBoardVO vo) {
		System.out.println("===> Mybatis updateBoard() 호출");
		mybatis.update("communityMap.updateCommunityBoard",vo);
	}
	//글 삭제
	public void deleteCommunityBoard(CommunityBoardVO vo) {
		System.out.println("===> Mybatis deleteBoard() 호출");
		mybatis.delete("communityMap.deleteReply",vo);
		mybatis.delete("communityMap.deleteCommunityBoard", vo);
	}
	//글 상세조회
	public CommunityBoardVO getCommunityBoard(CommunityBoardVO vo) {
		System.out.println("===> Mybatis getBoard() 호출");
		return (CommunityBoardVO) mybatis.selectOne("communityMap.getCommunityBoard", vo);
	}
	
}
