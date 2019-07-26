package com.jeju.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jeju.vo.QnAVO;

//객체 변수명 첫 글자 소문자 주의
@Repository("qnADao")
public class QnADaoImpl implements QnADao{


	@Autowired
	private SqlSessionTemplate mybatis;

	// 글 등록
	public void insertQnA(QnAVO vo) {
		System.out.println("===> Mybatis insertQnA() 호출");
		mybatis.insert("QnADao.insertQnA", vo);//
	} 
	
	// 글 수정
	public void updateQnA(QnAVO vo) {
		System.out.println("===> Mybatis updateQnA() 호출");
		mybatis.update("QnADao.updateQnA", vo);	
	}

	// 글삭제
	public void deleteQnA(QnAVO vo) {
		System.out.println("===> Mybatis deleteQnA() 호출");
		mybatis.delete("QnADao.deleteReply",vo);
		mybatis.delete("QnADao.deleteQnA", vo);
	}
	
	// 글 상세조회
	public QnAVO getQnA(QnAVO vo) {
		System.out.println("===> Mybatis getQnA() 호출");
		mybatis.update("QnADao.updateCnt", vo);
		System.out.println("===> Mybatis updateCnt() 호출");
		return (QnAVO) mybatis.selectOne("QnADao.getQnA", vo);
	}
	
	// 글 목록 조회
	public List<QnAVO> getQnAList(QnAVO vo) {
		System.out.println("===> Mybatis getQnAList() 호출");
		return mybatis.selectList("QnADao.getQnAList", vo);
	}

	@Override // 조회수 수정
	public void updateCnt (QnAVO qnA_Cnt) {
		System.out.println("===> Mybatis updateCnt() 호출");
		mybatis.update("QnADao.updateCnt", qnA_Cnt);
		
	}
	
}
