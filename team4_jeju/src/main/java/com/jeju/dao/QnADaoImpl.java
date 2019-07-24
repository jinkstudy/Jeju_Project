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

	
	public void insertQnA(QnAVO vo) {
		System.out.println("===> Mybatis insertQnA() 호출");
		mybatis.insert("QnADao.insertQnA", vo);//
	} 
	
	public void updateQnA(QnAVO vo) {
		System.out.println("===> Mybatis updateQnA() 호출");
		mybatis.update("QnADao.updateQnA", vo);	
	}

	public void deleteQnA(QnAVO vo) {
		System.out.println("===> Mybatis deleteQnA() 호출");
		mybatis.delete("QnADao.deleteQnA", vo);
	}
	
	public QnAVO getQnA(QnAVO vo) {
		System.out.println("===> Mybatis getQnA() 호출");
		mybatis.update("QnADao.updateCnt", vo);
		System.out.println("===> Mybatis updateCnt() 호출");
		return (QnAVO) mybatis.selectOne("QnADao.getQnA", vo);
		
	}
	
	public List<QnAVO> getQnAList(QnAVO vo) {
		System.out.println("===> Mybatis getQnAList() 호출");
		return mybatis.selectList("QnADao.getQnAList", vo);
	}
	
//	public void updateCnt(QnAVO vo) {
//		System.out.println("===> Mybatis updateCnt() 호출");
//		mybatis.update("QnADao.updateCnt", vo);
//	}

	@Override
	public void updateCnt (QnAVO qnA_Cnt) {
		System.out.println("===> Mybatis updateCnt() 호출");
		mybatis.update("QnADao.updateCnt", qnA_Cnt);
		
	}
	
}
