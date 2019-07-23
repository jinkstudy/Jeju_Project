package com.jeju.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {
	
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
	
	
	
}
