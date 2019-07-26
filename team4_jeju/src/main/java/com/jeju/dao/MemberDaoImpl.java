package com.jeju.dao;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jeju.vo.MemberVO;

//객체 변수명 첫 글자 소문자 주의
@Repository("memberDao")
public class MemberDaoImpl implements MemberDao{
	

	//싱글톤으로 선언된걸 주입 받음
    @Inject
    SqlSession sqlSession;
    
  //객체 변수명 첫 글자 소문자 주의
  	@Autowired
  	private SqlSessionTemplate mybatis;

    // 회원 로그인 체크
	@Override
	public void loginCheck(MemberVO vo, HttpSession session) {
		String member_Email = 
		mybatis.selectOne("memberMapper.loginCheck",vo);
//		sqlSession.selectOne("memberMapper.loginCheck",vo);
		System.out.println("login dao mybatis   "+vo+ "    "+ member_Email );
//		System.out.println("login dao member_Email   " +vo + "    "+member_Email );
		
		
	}


	// 회원 로그인 정보
	@Override
	public MemberVO viewMember(MemberVO vo) {
		
		return sqlSession.selectOne("main.viewMember", vo);
	}


	// 회원 로그아웃
	@Override
	public void logout(HttpSession session, HttpServletResponse response) {
		System.out.println("logout dao session"+session);
	}


	public int signUp(MemberVO vo) {
		return mybatis.insert("memberMapper.signUp",vo);
		
	}


	
	
}
