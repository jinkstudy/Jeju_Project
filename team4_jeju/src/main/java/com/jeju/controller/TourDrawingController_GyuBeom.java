package com.jeju.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jeju.service.TourDrawingServiceImpl_GyuBeom;

@Controller
@RequestMapping("/tour")
public class TourDrawingController_GyuBeom {
	
	@Autowired
	private TourDrawingServiceImpl_GyuBeom mapDrawingService;
	
	@RequestMapping(value="{url}.do")
	public String blablabla(@PathVariable String url) {
		return "/tour/"+url;
	}
	
	@RequestMapping(value="tourDrawingPage.do")
	public void tourMapListDrawing() {
		
	}
	
	//맵 그려주는 key 컨트롤러 - 인자 값으로 넘길 VO 생성할 지 고려 후 진행할 것.
	@RequestMapping(value="MapDrawing.do")
	public ModelAndView MapDrawing() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("mapList"
		             , mapDrawingService.tourMapDrawing());
		mv.setViewName("/tour/mapTest");
		return mv;
	}
	
}
