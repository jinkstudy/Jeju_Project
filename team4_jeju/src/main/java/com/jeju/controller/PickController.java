package com.jeju.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jeju.service.PickService;
import com.jeju.vo.PickVO;
import com.jeju.vo.PlaceVO;

@Controller
@RequestMapping("/pick")
public class PickController {

//	@RequestMapping(value="/pick_list.do")
//	public String blablabla() {
//		return "/pick/pick_list";
//	}
	
	@Autowired
	PickService pickService;
	
	@RequestMapping("/{step}.do")//정해지지 않은 명령어들은 이쪽으로 들어오게 되는게 {step}
	public String viewPage(@PathVariable String step) {
		
		step="pick/"+step;
		return step; // 들어오는 애를 글자 그대로 리턴시켜서 밑과 같은 아무것도 안하는 함수를 생성할 필요가 없게 한다.(DB를 갔다오지 않는 애들을 위한 함수)
	}
	
	/* ajax에서 버튼이 한번 눌러졌을때  DB에 insert해주기*/
	@RequestMapping(value="/insertPick.do")
	@ResponseBody //ajax로 처리 했을때는 반드시 입력해준다.
	public void insertPick(PickVO vo) throws IOException{
		System.out.println("ajax 연결 성공2");
		pickService.insertPick(vo);		
	}
	/* ajax에서 버튼이 두번째 눌러졌을때 DB에서 delete해주기*/
	@RequestMapping(value="/deletePick.do")
	@ResponseBody //ajax로 처리 했을때는 반드시 입력해준다.
	public void deletePick(PickVO vo) {
		System.out.println("ajax 연결 성공2-1");
		pickService.deletePick(vo);
	}
	/*찜 목록 검색*/
	@RequestMapping("/pick_list.do")
	public ModelAndView getPickList(PickVO vo) {
		ModelAndView model = new ModelAndView();
		model.addObject("pickList", pickService.getPickList(vo));
		model.setViewName("pick/pick_list");
		return model;
	}
	
}

