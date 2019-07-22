package com.jeju.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.jeju.service.TourCateServiceImpl;

@Controller
@RequestMapping("/tourCate")
public class TourCateController {
	
	@Autowired
	private TourCateServiceImpl tourCateService;
	
	@RequestMapping(value="{url}.do")
	public String blablabla(@PathVariable String url) {
		return "/admin/"+url;
	}	
	
	@RequestMapping(value="/selectHotplace.do")
	public ModelAndView selectHotplace() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("hotplace"
			         , tourCateService.getHotPlaceList());
		//setViewName을 해주지 않으면 저하될 가능성 ↑
		// 따라서 setViewName 지정해 줄 것
		// setViewName 현재 views 직하위로 절대 경로 잡아놓은 상태 (servlet-context.xml)
		// 따라서 setViewName 지정시에 하기와 같이 / 절대 경로로 표기해줄 것.
		mv.setViewName("/tourCate/tourCateMiddle");
		return mv;
	}
	
	@RequestMapping(value="/selectMiddleCate.do")
	public ModelAndView selectMiddleCate() {
		ModelAndView mv = new ModelAndView();
		//mv.addObject("visitJeju"
			         //, tourCateService.getHotPlaceList());
		//setViewName을 해주지 않으면 저하될 가능성 ↑
		// 따라서 setViewName 지정해 줄 것
		// setViewName 현재 views 직하위로 절대 경로 잡아놓은 상태 (servlet-context.xml)
		// 따라서 setViewName 지정시에 하기와 같이 / 절대 경로로 표기해줄 것.
		mv.setViewName("/tourCate/tourCateMiddle");
		return mv;
	}
	
}
