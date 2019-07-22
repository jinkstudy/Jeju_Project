package com.jeju.dao;

import java.util.List;

import com.jeju.vo.QnAVO;

public interface QnADao {
	
	// QnA 등록
	public void insertQnA(QnAVO vo);
	
	// QnA 수정
	public void updateQnA(QnAVO vo) ;

	// QnA 삭제
	public void deleteQnA(QnAVO vo);

	// QnA 상세조회
	public QnAVO getQnA(QnAVO vo) ;

	// QnA 글 목록 보기
	public List<QnAVO> getQnAList(QnAVO vo) ;

}
