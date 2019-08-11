package com.jeju.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jeju.service.TourSchService;
import com.jeju.vo.ScheduleInputVO;
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
	public ModelAndView selectSchOutput(ScheduleInputVO vo) {
		ModelAndView mv = new ModelAndView();

		mv.addObject("daylist",tourschService.getDayList(vo));
		mv.addObject("schPlaceList",tourschService.getSchPlace(vo));
		mv.addObject("schInputNum",vo);
		List<ScheduleOutputVO> li = tourschService.getSchPlace(vo);

		System.out.println();
		
		mv.setViewName("/tour/tourDrawingPage");
		return mv;
	}
//	@RequestMapping(value="getTimetable.do")
//	@ResponseBody
//	public ModelAndView getTimetable(ScheduleOutputVO vo) {
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("daylist",tourschService.getDayList(vo));
//		mv.addObject("schPlaceList",tourschService.getSchPlace(vo));
//
//		
//		mv.setViewName("/tour/tourDrawingPage");
//		return mv;
//	}
	
	
		@RequestMapping(value="getTimetable.do")
		@ResponseBody
	public Map<String, List<ScheduleOutputVO>>getTimetable(ScheduleInputVO vo) {
			
			System.out.println("Timetable 그리기 :"+ vo.getKey_Given_by_Front());
			
			Map<String, List<ScheduleOutputVO>> result = new HashMap<String, List<ScheduleOutputVO>>();
			result.put("daylist", tourschService.getDayList(vo));
			result.put("schPlaceList", tourschService.getSchPlace(vo));
		
		//mv.addObject("daylist",tourschService.getDayList(vo));
		//mv.addObject("schPlaceList",tourschService.getSchPlace(vo));

		return result;
	}
	
	
	
		//일정 삭제 클릭 시, SchOutput 결과를 업데이트 . 
	@RequestMapping(value="updateDelSch.do")
	@ResponseBody
	public void updateDelSch(ScheduleOutputVO vo) {
		System.out.println("일정리스트삭제 업데이트 controller:"+ vo.getSch_Output_Mnum());
		tourschService.updateDelSch(vo);	
	}
}
