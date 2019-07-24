package com.jeju.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tour")
public class TourDrawingController_GyuBeom {
	
	
	
	@RequestMapping(value="{url}.do")
	public String blablabla(@PathVariable String url) {
		return "/tour/"+url;
	}
	
	@RequestMapping(value="tourTest.do")
	public void tourMapListDrawing() {
		
	}
	
}
