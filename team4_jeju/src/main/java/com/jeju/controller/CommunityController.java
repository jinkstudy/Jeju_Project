package com.jeju.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jeju.service.CommunityService;
import com.jeju.vo.CommunityBoardVO;

@Controller
@RequestMapping("/community")
public class CommunityController {
	
	@Autowired
	private CommunityService communityService;
	
	/*
	 * @RequestMapping(value="" , produces="application/text; charset=UTF-8")
	 */
	
	@RequestMapping(value="getCommunityBoardList.do")
	public void blablabla() {
		
	}
	
	
	
//	@RequestMapping(value=""
//	                , produces="application/text; charset=UTF-8")
//	public void blablabla() {
//		
//	}
	
	@RequestMapping("/{step}.do") //정해지지 않은 명령어들은 이쪽으로 들어오게 되는게 {step}
	public String viewPage(@PathVariable String step) {
		return step; // 들어오는 애를 글자 그대로 리턴시켜서 밑과 같은 아무것도 안하는 함수를 생성할 필요가 없게 한다.(DB를 갔다오지 않는 애들을 위한 함수)
	}
	
	// 글 목록 검색
	@RequestMapping("/getCommunityBoardList.do")
	public void getCommunityBoardList(CommunityBoardVO vo, Model model) {
		model.addAttribute("communityBoardList", communityService.getCommunityBoardList(vo));
		// ViewResolver를 지정하지 않으면 아래처럼 페이지명 지정
		// return "views/getCommunityBoardList.jsp"; // View 이름 리턴
	}
	
	//글 등록
	@RequestMapping(value="/saveCommunityBoard.do")
	public String insertCommunityBoard(CommunityBoardVO vo) throws IOException{
		communityService.insertCommunityBoard(vo);
		return "redirect:/getCommunityBoardList.do";
	}
	//글 수정
	
	
	//글 삭제
	
	//글 상세 조회
	
}
