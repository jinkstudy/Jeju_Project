package com.jeju.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeju.dao.QnADaoImpl;
import com.jeju.vo.QnAVO;

//객체 변수명 첫 글자 소문자 주의
@Service("qnAService")
public class QnAServiceImpl implements QnAService{
	
	//객체 변수명 첫 글자 소문자 주의
	@Autowired
	private QnADaoImpl qnADao;

	// 글 등록
	public void insertQnA(QnAVO vo) {
		qnADao.insertQnA(vo); //
	}

	// 글 수정
	public void updateQnA(QnAVO vo) {
		qnADao.updateQnA(vo);
	}

	// 글 삭제
	public void deleteQnA(QnAVO vo) {
		qnADao.deleteQnA(vo);
		
	}

	// 글 상세조회
	public QnAVO getQnA(QnAVO vo) {
		return qnADao.getQnA(vo);
	}

	// 글 목록 조회
	public List<QnAVO> getQnAList(QnAVO vo) {
		return qnADao.getQnAList(vo);
	}
	
	@Override // 조회수 수정
	public void updateCnt(QnAVO vo) {
		qnADao.updateCnt(vo);
	}
}
