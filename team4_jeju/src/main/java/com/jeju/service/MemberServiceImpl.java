package com.jeju.service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.jeju.dao.MemberDaoImpl;
import com.jeju.vo.MemberVO;

//객체 변수명 첫 글자 소문자 주의
@Service("memberService")
public class MemberServiceImpl implements MemberService{

	@Inject
	@Autowired
	private MemberDaoImpl memberDao;

	// 회원가입
	@Override
	public void signUp(MemberVO vo) {
		memberDao.signUp(vo);

	}


	// 회원 로그인 체크
	@Override
	public void loginCheck(MemberVO vo, Model model) {
		memberDao.loginCheck(vo, model);	

		model.addAttribute("member_Email", vo.getMember_Email());
		model.addAttribute("password", vo.getPassword());

		System.out.println(" login service ");
//		System.out.println("member_Email   = " + vo.getMember_Email());
//		System.out.println("password   = " + vo.getPassword());
//		System.out.println("vo    =   " + vo);

	}


	// 회원 로그인정보
	@Override
	public MemberVO viewMember(MemberVO vo) {
		return memberDao.viewMember(vo);
	}


	// 회원 로그아웃
	@Override
	public void logout(MemberVO vo, Model model) {
		System.out.println(" logout service ");
//		System.out.println("vo  =  "+ vo);	
//		System.out.println("model  =  "+ model);
	}
}
