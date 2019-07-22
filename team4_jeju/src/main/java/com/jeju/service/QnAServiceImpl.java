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

	
	public void insertQnA(QnAVO vo) {
		qnADao.insertQnA(vo); //
	}

	
	public void updateQnA(QnAVO vo) {
		qnADao.updateQnA(vo);
	}

	
	public void deleteQnA(QnAVO vo) {
		qnADao.deleteQnA(vo);
		
	}

	
	public QnAVO getQnA(QnAVO vo) {
		return qnADao.getQnA(vo);
	}

	
	public List<QnAVO> getQnAList(QnAVO vo) {
		return qnADao.getQnAList(vo);
	}
	
	@Override
	public void updateCnt(QnAVO vo) {
		qnADao.updateCnt(vo);
	}
}
