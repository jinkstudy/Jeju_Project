package com.jeju.service;

import java.util.List;

import com.jeju.vo.ReplyVO;

public interface ReplyService {

	//댓글 등록
	void addComment(ReplyVO vo);
	//댓글 리스트 조회
	List<ReplyVO> getCommentList(ReplyVO vo);
	//댓글 수정
	//댓글 삭제
}
