package com.jeju.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.jeju.service.MemberService;
import com.jeju.vo.MemberVO;

@Controller
@RequestMapping("/main")
@SessionAttributes("user")
public class MainController {

	@Autowired
	MemberService memberService;

	@RequestMapping(value="mainRedirect.do")
	public String mainRedirectMethod() {
		//System.out.println("mainRedirect.do 호출 완료.");
		return "redirect:main.do";
	}

	//수정 금지.
	//리다이렉트를 받는 아이 필요.
	@RequestMapping(value="main.do")
	public void main() {

	}


	//회원가입
	@RequestMapping(value="signUp.do", method=RequestMethod.POST)
	public String signUp(MemberVO vo) throws IOException{
		
		memberService.signUp(vo);
		System.out.println("signUp controller");
		return "redirect:main.do";
	}


	//로그인 화면	
	@RequestMapping("/login.do")
	public String login( MemberVO vo) {
		System.out.println("login controller");
		return "/main.do";
	}


	//로그인  처리	
	@RequestMapping(value="/loginCheck.do", method=RequestMethod.POST)
	public String loginCheck(MemberVO vo, Model model) {
		
		memberService.loginCheck(vo, model);
		model.addAttribute("user", vo.getMember_Email());
		System.out.println("loginCheck controller");
//		System.out.println("vo  =   " + vo);
//		System.out.println("model  =   " + model);
		return "redirect:main.do";

	}

	//로그아웃  처리
	@RequestMapping("/logout.do")
	public String logout(@ModelAttribute("vo") MemberVO vo, Model model, SessionStatus session) {
		
	    session.setComplete();
		memberService.logout(vo,model);
		System.out.println("logout controller  ");	
//		System.out.println("invalidated  =  "+ session);	
//		System.out.println("vo  =  "+ vo);	
//		System.out.println("model  =  "+ model);	
		return "redirect:main.do";
	}

}
