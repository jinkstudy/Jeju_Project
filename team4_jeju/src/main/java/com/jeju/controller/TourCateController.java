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
			//대분류번호에 해당하는 중분류 name 리스트 가져오기.
			mv.addObject("midCateName"+i
			         , tourCateService.getMiddName(i));
			
		}
		//핫플레이스 리스트 가져오기
		mv.addObject("placeList"
			         , tourCateService.getHotPlaceList());
		//System.out.println("List"+ tourCateService.getHotPlaceList().size());
		
		
		mv.setViewName("/tourCate/tourCateList");
		return mv;
	}
	
	//중분류 카테고리 이름과, 대분류번호에 따른 장소 셀렉트 결과값.
	@RequestMapping(value="/selectMiddleCate.do")
	public ModelAndView selectMiddleCate(MiddleClassVO vo) {
		
		ModelAndView mv = new ModelAndView();
		System.out.println("selectMiddleCate Controller 호출:"+vo.getMajor_Num());
		//대분류번호에 해당하는 중분류 name 리스트 가져오기.
		for (int i = 1; i <= 3; i++) {
			mv.addObject("midCateName"+i
			         , tourCateService.getMiddName(i));
			
		}
		//대분류 번호에 해당하는 place List 가져오기
		mv.addObject("placeList",tourCateService.selectPlaceByMajor(vo));
	
		mv.setViewName("/tourCate/tourCateList");
		return mv;
	}
	
	//MiddleClass로 장소리스트 select	
	@RequestMapping(value="/selectPlacebyMidd.do")
	public ModelAndView selectPlacebyMidd(MiddleClassVO vo) {
		
		ModelAndView mv = new ModelAndView();
		//대분류번호에 해당하는 중분류 name 리스트 가져오기.
		for (int i = 1; i <= 3; i++) {
			mv.addObject("midCateName"+i
			         , tourCateService.getMiddName(i));
			
		}
		System.out.println("selectPlacebyMidd Controller 호출:"+vo.getMiddle_Num());
		//중분류 번호에 해당하는 place List 가져오기
		mv.addObject("placeList"
			         , tourCateService.getPlacebyMidd(vo));
	
		mv.setViewName("/tourCate/tourCateList");
		return mv;
	}
	
	
	
}
