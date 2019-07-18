package com.jeju.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/pick")
public class PickController {

	@RequestMapping(value="/pick_list.do")
	public String blablabla() {
		return "/pick/pick_list";
	}
	
	@RequestMapping(value="/inputPick.do")
	@ResponseBody //ajax로 처리 했을때는 반드시 입력해준다.
	public void inputPick() {
		System.out.println("ajax 연결 성공");
	}
	
}
