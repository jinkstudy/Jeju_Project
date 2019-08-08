package com.jeju.dao;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

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
	public void loginCheck(MemberVO vo, Model model) {
		
		mybatis.selectOne("memberMapper.loginCheck",vo);
		System.out.println("loginCheck DaoImpl");
		
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

	// 회원가입
	public int signUp(MemberVO vo) {
		return mybatis.insert("memberMapper.signUp",vo);
		
	}


	
	
}
