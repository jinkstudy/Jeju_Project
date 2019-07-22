package com.jeju.service;

import java.util.List;

import com.jeju.vo.QnAVO;

public interface QnAService {
	
	
	// CRUD 기능의 메소드 구현
		// QnA 등록
		void insertQnA(QnAVO vo);

		// QnA 수정
		void updateQnA(QnAVO vo);

		// QnA 삭제
		void deleteQnA(QnAVO vo);
		
		// 조회수 수정
		void updateCnt(QnAVO vo);


		// QnA 상세 조회
		QnAVO getQnA(QnAVO vo);

		// QnA 목록 조회
		List<QnAVO> getQnAList(QnAVO vo);

		
}
