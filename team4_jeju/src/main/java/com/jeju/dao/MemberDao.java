package com.jeju.dao;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.jeju.vo.MemberVO;

@Repository
public interface MemberDao {
	
	// 회원가입
	public int signUp(MemberVO vo);
	
	// 회원 로그인체크
	public void loginCheck(MemberVO vo, Model model);

	// 회원 로그인 정보
	public MemberVO viewMember(MemberVO vo);

	// 회원 로그아웃
	public void logout(HttpSession session, HttpServletResponse response);

	
	
	
}
