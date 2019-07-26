package com.jeju.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jeju.service.MemberService;
import com.jeju.vo.MemberVO;

@Controller
@RequestMapping("/main")
public class MainController {
	
	//로깅을 위한 변수
//	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
    //싱글톤으로 선언된 것을 주입 받는다.
//    @Inject
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
    public String login( MemberVO vo, HttpSession session) {
    	System.out.println("login controller");
        return "/main.do";
    }
  	
  	
  	
  //로그인  처리
    @RequestMapping(value="/loginCheck.do", method=RequestMethod.POST)
    public String loginCheck( MemberVO vo, HttpSession session) {
    	memberService.loginCheck(vo, session);
    	
    	System.out.println("loginCheck controller");
   	  
    	return "redirect:main.do";
        
    }
	
	
	
    //로그아웃  처리
	@RequestMapping("/logout.do")
    public String logout(HttpSession session) {
    	memberService.logout(session);
//    	if (session != null) {
//			session.invalidate();
			System.out.println("invalidated  =  "+ session);	
//			session.removeAttribute("session");
//			System.out.println("member_Email"+ session);	
//		} else {
//			response.addDateHeader("Expires", 1);
//			session.invalidate();
//
//			System.out.println(" removeAttribute  =  "+ session);
//
//		}
//    	System.out.println("logout service  = "+session);
    	return "redirect:main.do";
    }

//
	
}
