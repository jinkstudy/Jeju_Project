package com.jeju.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jeju.service.AdminServiceImpl;

@Controller
@RequestMapping("/admin/placeJoin")
public class Admin_FinalPlaceController {
	
	@Autowired
	private AdminServiceImpl adminService;
	
//	@RequestMapping(value="{url}.do")
//	public String blablabla(@PathVariable String url) {
//		return "/admin/"+url;
//	}	
	
	
	@RequestMapping(value="selectFinalPlace.do")
	public ModelAndView selectFinalPlace() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("finalPlace"
			         , adminService.getFinalPlaceList());
		//setViewName을 해주지 않으면 저하될 가능성 ↑
		// 따라서 setViewName 지정해 줄 것
		// setViewName 현재 views 직하위로 절대 경로 잡아놓은 상태 (servlet-context.xml)
		// 따라서 setViewName 지정시에 하기와 같이 / 절대 경로로 표기해줄 것.
		mv.setViewName("/admin/placeJoin/placeJoin");
		return mv;
	}
	
	
	//UPDATE SEQUENCE AND AREA
	@RequestMapping(value="updateFinalPlace.do")
	public ModelAndView updatePlaceJoin() {
		
		//db update go.
		//1번) first update
		//adminService.updateTourSequenceKeyNum();
		
		//second update
		//2번) 순서 중요 - first 를 돌리지 않았다면 돌리지 말 것
		//(사유는 AREA DATA 가 없기 때문에 반드시 이 순서를 지켜야 한다.)
		adminService.updateTourSeqNumFinal();
		
		// 1번과 2번을 동시에 돌리는 것은 불가능.
				
		ModelAndView mv = new ModelAndView();
		mv.addObject("finalPlace"
			         , adminService.getFinalPlaceList());
		//setViewName을 해주지 않으면 저하될 가능성 ↑
		// 따라서 setViewName 지정해 줄 것
		// setViewName 현재 views 직하위로 절대 경로 잡아놓은 상태 (servlet-context.xml)
		// 따라서 setViewName 지정시에 하기와 같이 / 절대 경로로 표기해줄 것.
		mv.setViewName("/admin/placeJoin/placeJoin");
		return mv;
	}
	
}
