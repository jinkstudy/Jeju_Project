package com.jeju.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/pick")
public class PickController {

//	@RequestMapping(value="/pick_list.do")
//	public String blablabla() {
//		return "/pick/pick_list";
//	}
	
	
	@RequestMapping("/{step}.do")//정해지지 않은 명령어들은 이쪽으로 들어오게 되는게 {step}
	public String viewPage(@PathVariable String step) {
		
		step="pick/"+step;
		return step; // 들어오는 애를 글자 그대로 리턴시켜서 밑과 같은 아무것도 안하는 함수를 생성할 필요가 없게 한다.(DB를 갔다오지 않는 애들을 위한 함수)
	}
	
	@RequestMapping(value="/inputPick.do")
	@ResponseBody //ajax로 처리 했을때는 반드시 입력해준다.
	public void inputPick() {
		System.out.println("ajax 연결 성공");
	}
	
}

