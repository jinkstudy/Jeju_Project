package com.jeju.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jeju.vo.ReplyVO;

//객체 변수명 첫 글자 소문자 주의
@Repository("replyDao")
public class ReplyDaoImpl implements ReplyDao {

	//객체 변수명 첫 글자 소문자 주의
	@Autowired
	private SqlSessionTemplate mybatis;
	
	//댓글 등록
	@Override
	public void addComment(ReplyVO vo) {
		System.out.println("===>ReplyMapper addComment 호출");
		mybatis.insert("replyMap.addComment",vo);
	}
	//댓글 리스트 조회
	public List<ReplyVO> getCommentList(ReplyVO vo){
		System.out.println("===>ReplyMapper getCommentList 호출"+vo.getComm_Mnum());
		
		return mybatis.selectList("replyMap.getCommentList",vo);
	}
 	//댓글 수정
	//댓글 삭제
}
