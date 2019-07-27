package com.jeju.service;

import java.util.List;

import com.jeju.vo.ReplyVO;

public interface ReplyService {

	//댓글 등록
	void addComment(ReplyVO vo);
	//댓글 리스트 조회
	List<ReplyVO> getCommentList(ReplyVO vo);
	//댓글 수정
	void modifyComment(ReplyVO vo);
	//댓글 삭제
	void deleteComment(ReplyVO vo);

	/*QnA 부분 댓글*/
	//댓글 등록
	void qnAComment(ReplyVO vo);
	//댓글 리스트 조회
	List<ReplyVO> qnACommentList(ReplyVO vo);
	//댓글 수정
	void qnAModifyComment(ReplyVO vo);
	//댓글 삭제
	void qnADeleteComment(ReplyVO vo);

}
