package com.jeju.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jeju.service.TourCateServiceImpl;
import com.jeju.vo.MajorClassVO;
import com.jeju.vo.MiddleClassVO;

@Controller
@RequestMapping("/tourCate")
public class TourCateController {
	
	@Autowired
	private TourCateServiceImpl tourCateService;
	
	@RequestMapping(value="{url}.do")
	public String blablabla(@PathVariable String url) {
		return "/admin/"+url;
	}	
	//hotPlace top50 select
	@RequestMapping(value="/selectHotplace.do")
	public ModelAndView selectHotplace() {
		ModelAndView mv = new ModelAndView();
		for (int i = 1; i <= 3; i++) {
			mv.addObject("midCateName"+i
			         , tourCateService.getMiddName(i));
			
		}
		mv.addObject("placeList"
			         , tourCateService.getHotPlaceList());
		//System.out.println("List"+ tourCateService.getHotPlaceList().size());
		
		//setViewName을 해주지 않으면 저하될 가능성 ↑
		// 따라서 setViewName 지정해 줄 것
		// setViewName 현재 views 직하위로 절대 경로 잡아놓은 상태 (servlet-context.xml)
		// 따라서 setViewName 지정시에 하기와 같이 / 절대 경로로 표기해줄 것.
		mv.setViewName("/tourCate/tourCateList");
		return mv;
	}
	
	//중분류 카테고리 이름과, 대분류번호에 따른 장소 셀렉트 결과값.
	@RequestMapping(value="/selectMiddleCate.do")
	public ModelAndView selectMiddleCate(MiddleClassVO vo) {
		
		ModelAndView mv = new ModelAndView();
		System.out.println("selectMiddleCate Controller 호출:"+vo.getMajor_Num());
		
		for (int i = 1; i <= 3; i++) {
			mv.addObject("midCateName"+i
			         , tourCateService.getMiddName(i));
			
		}
		mv.addObject("placeList",tourCateService.selectPlaceByMajor(vo));
	
		//setViewName을 해주지 않으면 저하될 가능성 ↑
		// 따라서 setViewName 지정해 줄 것
		// setViewName 현재 views 직하위로 절대 경로 잡아놓은 상태 (servlet-context.xml)
		// 따라서 setViewName 지정시에 하기와 같이 / 절대 경로로 표기해줄 것.
		mv.setViewName("/tourCate/tourCateList");
		return mv;
	}
	
	//MiddleClass로 장소리스트 select	
	@RequestMapping(value="/selectPlacebyMidd.do")
	public ModelAndView selectPlacebyMidd(MiddleClassVO vo) {
		
		ModelAndView mv = new ModelAndView();
		for (int i = 1; i <= 3; i++) {
			mv.addObject("midCateName"+i
			         , tourCateService.getMiddName(i));
			
		}
		System.out.println("selectPlacebyMidd Controller 호출:"+vo.getMiddle_Num());
		mv.addObject("placeList"
			         , tourCateService.getPlacebyMidd(vo));
		//setViewName을 해주지 않으면 저하될 가능성 ↑
		// 따라서 setViewName 지정해 줄 것
		// setViewName 현재 views 직하위로 절대 경로 잡아놓은 상태 (servlet-context.xml)
		// 따라서 setViewName 지정시에 하기와 같이 / 절대 경로로 표기해줄 것.
		mv.setViewName("/tourCate/tourCateList");
		return mv;
	}
	
	
	
}
