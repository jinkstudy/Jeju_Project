package com.jeju.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jeju.service.TourSchService;
import com.jeju.vo.PickVO;
import com.jeju.vo.ScheduleOutputVO;

@Controller
@RequestMapping("/tourSch")
public class TourSchController {
	
	@Autowired
	private TourSchService tourschService;
	
	
	@RequestMapping(value="{url}.do")
	public String blablabla(@PathVariable String url) {
		return "/tour/"+url;
	}
	
	//맵 그려주기 위한 mapList 및 일정 output 결과 값 화면 그려줄 schList 반환.
	@RequestMapping(value="tourDrawingPage.do")
	public ModelAndView selectSchOutput(ScheduleOutputVO vo) {
		ModelAndView mv = new ModelAndView();
//		mv.addObject("mapList"
//		             , mapDrawingService.tourMapDrawing());
		System.out.println("selectSchOutput Controller 호출"+vo.getSch_Input_Mnum());
		//mv.addObject("listByDay",tourschService.getListByDay(vo));
		mv.addObject("daylist",tourschService.getDayList(vo));
		mv.addObject("schPlaceList",tourschService.getSchPlace(vo));
		
		
		
		mv.setViewName("/tour/tourDrawingPage");
		return mv;
	}
	
	
	
	
	
	@RequestMapping(value="updateDelSch.do")
	@ResponseBody
	public void updateDelSch(ScheduleOutputVO vo) {
		System.out.println("일정리스트삭제 업데이트 controller:"+ vo.getSch_Output_Mnum());
		tourschService.updateDelSch(vo);	
	}
}
