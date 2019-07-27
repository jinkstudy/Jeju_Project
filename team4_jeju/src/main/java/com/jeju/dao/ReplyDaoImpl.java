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
		System.out.println("===>ReplyMapper getCommentList 호출");
		return mybatis.selectList("replyMap.getCommentList",vo);
	}
	//댓글 수정
	public void modifyComment(ReplyVO vo) {
		System.out.println("===>ReplyMapper modifyComment 호출");
		mybatis.update("replyMap.modifyComment",vo);
		System.out.println("vo.getReply_Content()"+vo.getReply_Content());
	}
	//댓글 삭제
	public void deleteComment(ReplyVO vo) {
		System.out.println("===>ReplyMapper deleteComment 호출");
		mybatis.delete("replyMap.deleteComment",vo);
	}

	/*QnA 부분 댓글*/
	//댓글 등록
	public void qnAComment(ReplyVO vo) {
		System.out.println("===>ReplyMapper qnAComment 호출");
		mybatis.insert("replyMap.qnAComment",vo);
	}
	//댓글 리스트 조회
	public List<ReplyVO> qnACommentList(ReplyVO vo){
		System.out.println("===>ReplyMapper qnACommentList 호출"+vo.getQnA_Mnum());

		return mybatis.selectList("replyMap.qnACommentList",vo);
	}
	
	//댓글 수정
	public void qnAModifyComment(ReplyVO vo) {
		System.out.println("===>ReplyMapper qnAModifyComment 호출");
		mybatis.update("replyMap.qnAModifyComment",vo);
		
	}
	
	//댓글 삭제
	public void qnADeleteComment(ReplyVO vo) {
		System.out.println("===>ReplyMapper qnADeleteComment 호출");
		mybatis.delete("replyMap.qnADeleteComment",vo);
		
	}
}
