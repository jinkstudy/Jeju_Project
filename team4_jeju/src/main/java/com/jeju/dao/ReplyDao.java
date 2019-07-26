package com.jeju.dao;

import java.util.List;

import com.jeju.vo.ReplyVO;

public interface ReplyDao {
	
	
	//댓글 등록
	public void addComment(ReplyVO vo);
	//댓글 리스트 조회
	public List<ReplyVO> getCommentList(ReplyVO vo);
	//댓글 수정
	public void modifyComment(ReplyVO vo);
	//댓글 삭제
	public void deleteComment(ReplyVO vo);
}
