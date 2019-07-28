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

import com.jeju.service.TourDrawingServiceImpl_GyuBeom;
import com.jeju.service.TourSchService;
import com.jeju.tour_method.SchOutputMethod_GyuBeom;
import com.jeju.vo.ScheduleInputVO;
import com.jeju.vo.ScheduleOutputVO;
import com.jeju.vo.ScheduleRefinedInOutputVO;

@Controller
@RequestMapping("/tour")
public class TourDrawingController_GyuBeom {
	
	//서비스 Autowired
	@Autowired
	private TourDrawingServiceImpl_GyuBeom mapDrawingService;
	

	@Autowired
	private TourSchService tourschService;
	
	@RequestMapping(value="{url}.do")
	public String blablabla(@PathVariable String url) {
		return "/tour/"+url;
	}
	
	//-----------------------------------------------------
	//insert Tour Schedule Test start
	// 메인에서 사용자가 정보를 입력 후 여행 만들기를 눌렀을 때 들어오는 컨트롤.
	//-----------------------------------------------------
	@RequestMapping(value="insertTourSchTestPage.do")
	@ResponseBody
	public ModelAndView insertTourSchTestPage(ScheduleInputVO vo) {		
		
		
		//ModelAndView 여러 개의 addObject가 가능하니
		//걱정하지 않으셔도 돼요.
		
		
		System.out.println("컨트롤러 내부 insertTourSchTestPage 메소드 실행.");
		
		ModelAndView mv = new ModelAndView();
		
		//순서 매우 중요합니다. db에서 날짜 계산을 해주기 때문에 반드시 insert 메소드부터 실행해야 합니다.
		//1. insertSchMethod
		mapDrawingService.insertSchMethod(vo);
		
		//2. selectTourDayCount
		int tourDaysCnt = mapDrawingService.selectTourDayCount(vo);
		
				
		// map 화면단 - output DB data
		//mapDrawingService.makeFinalOutPut(mapDrawingService.schOutPutMaker(vo, tourDaysCnt));
		
		// map 화면단 - input data 관련 (including output) 모델 앤 뷰
		mv.addObject("rioData"
		         	 , mapDrawingService.schOutPutMaker(vo, tourDaysCnt));
		mv.addObject("onlyFinalResult"
				     , mapDrawingService.makeFinalOutPut(mapDrawingService.schOutPutMaker(vo, tourDaysCnt)));
		
		//진경 추가
		mv.addObject("daylist",tourschService.getDayList(vo));
		mv.addObject("schPlaceList",tourschService.getSchPlace(vo));
		mv.addObject("schInputNum",vo);
		
		System.out.println("--------------------------------------------------------");
		System.out.println(	vo.getSch_Input_Mnum() +"/" +vo.getKey_Given_by_Front());
		System.out.println("--------------------------------------------------------");
		
		mv.setViewName("/tour/tourDrawingPage");
		
		return mv;
		
		//테스트
//		System.out.println("컨트롤러 내부 : input 데이타 확인");
//		String start_Date = vo.getStart_Date();
//		String finish_Date = vo.getFinish_Date();
//		int adultNum = vo.getAdultNum();
//		int childrenNum = vo.getChildrenNum();
//		int place_Opt_Num = vo.getPlace_Opt_Num();
//		int speed_Opt_Num = vo.getSpeed_Opt_Num();
//		String middle_Class_List = vo.getMiddle_Class_List();
//		
//		System.out.println(start_Date);
//		System.out.println(finish_Date);
//		System.out.println(adultNum);
//		System.out.println(childrenNum);
//		System.out.println(place_Opt_Num);
//		System.out.println(speed_Opt_Num);
//		System.out.println(middle_Class_List);
		
		//mv.setViewName("/tour/insertTourSchTestPage");
		
	}	
	//-----------------------------------------------------
	//The end of Tour Schedule Test start
	//-----------------------------------------------------
	
	@RequestMapping(value="kakao.do")
	@ResponseBody
	public ModelAndView kakaoPage(ScheduleInputVO vo) {		
		
		
		//ModelAndView 여러 개의 addObject가 가능하니
		//걱정하지 않으셔도 돼요.
		
		
		System.out.println("컨트롤러 내부 kakao 메소드 실행.");
		
		ModelAndView mv = new ModelAndView();
		
		//순서 매우 중요합니다. db에서 날짜 계산을 해주기 때문에 반드시 insert 메소드부터 실행해야 합니다.
		//1. insertSchMethod
		
		
		//2. selectTourDayCount
		//int tourDaysCnt = mapDrawingService.selectTourDayCount(vo);
		
				
		// map 화면단 - output DB data
		//mapDrawingService.makeFinalOutPut(mapDrawingService.schOutPutMaker(vo, tourDaysCnt));
		
		// map 화면단 - input data 관련 (including output) 모델 앤 뷰
		//mv.addObject("rioData"
		         	// , mapDrawingService.schOutPutMaker(vo, tourDaysCnt));
//		mv.addObject("onlyFinalResult"
//				     , mapDrawingService.makeFinalOutPut(mapDrawingService.schOutPutMaker(vo, tourDaysCnt)));
		
		//진경 추가
		mv.addObject("daylist",tourschService.getDayList(vo));
		mv.addObject("schPlaceList",tourschService.getSchPlace(vo));
		mv.addObject("schInputNum",vo);
		
	
		
		mv.setViewName("/tour/tourDrawingPage_1");
		
		return mv;
	
	
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
	//-----------------------------------------------------
	//The end of map draw
	//-----------------------------------------------------
		
//	시간표 그리기.
	@RequestMapping(value="getTimetable.do")
	@ResponseBody
public Map<String, List<ScheduleOutputVO>>getTimetable(ScheduleInputVO vo) {
		System.out.println("타임테이블 :" + vo.getKey_Given_by_Front() + "/"+vo.getSch_Input_Mnum());
		Map<String, List<ScheduleOutputVO>> result = new HashMap<String, List<ScheduleOutputVO>>();
		result.put("daylist", tourschService.getDayList(vo));
		result.put("schPlaceList", tourschService.getSchPlace(vo));
	
	//mv.addObject("daylist",tourschService.getDayList(vo));
	//mv.addObject("schPlaceList",tourschService.getSchPlace(vo));

	return result;
}
	
	@RequestMapping(value="updateDelSch.do")
	@ResponseBody
	public void updateDelSch(ScheduleOutputVO vo) {
		System.out.println("일정리스트삭제 업데이트 controller:"+ vo.getSch_Output_Mnum());
		tourschService.updateDelSch(vo);	
	}
	
}
