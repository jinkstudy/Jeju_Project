package com.jeju.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeju.dao.ReplyDaoImpl;
import com.jeju.vo.ReplyVO;

//객체 변수명 첫 글자 소문자 주의
@Service("replyService")
public class ReplyServiceImpl implements ReplyService {
	
	//객체 변술명 첫글자 소문자 주의
	@Autowired
	private ReplyDaoImpl replyDao;
	
	//댓글 등록
	public void addComment(ReplyVO vo) {
		replyDao.addComment(vo);
	}
	//댓글 리스트 조회
	public List<ReplyVO> getCommentList(ReplyVO vo){
		System.out.println("서비스 : " + vo.getComm_Mnum());
		return replyDao.getCommentList(vo);
	}
	//댓글 수정
	public void modifyComment(ReplyVO vo) {
		replyDao.modifyComment(vo);
	}
	//댓글 삭제
	public void deleteComment(ReplyVO vo) {
		replyDao.deleteComment(vo);
	}
}
