package com.jeju.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {
	
	@RequestMapping(value="/mainRedirect.do")
	public String mainRedirectMethod() {
		return "redirect:/main/main.do";
	}
	
	@RequestMapping(value="/main.do")
	public void receiveRedirectMain() {
		//return "redirect:/main_header_footer/main.do";
	}
	
}
