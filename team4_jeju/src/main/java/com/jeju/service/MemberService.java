package com.jeju.service;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.jeju.vo.MemberVO;

public interface MemberService {
	
	//회원가입
	void signUp(MemberVO vo);
	
	// 회원 로그인 체크
	public void loginCheck(MemberVO vo, Model model);
	
	//회원 로그인 정보
	public MemberVO viewMember( MemberVO vo);
	
	// 회원 로그아웃
	 public void logout(MemberVO vo, Model model);

	




	
	 
	 
}
