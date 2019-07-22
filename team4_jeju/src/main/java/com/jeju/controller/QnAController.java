package com.jeju.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jeju.service.QnAService;
import com.jeju.vo.QnAVO;


@Controller
@RequestMapping("/qnA")
public class QnAController{

	@Autowired
	private QnAService qnAService;

//	 DB연동이 필요없는 모든 메소드를 대체해줌
	@RequestMapping("/{step}.do")
	public String viewPage(@PathVariable String step) {
		step ="qnA/"+step;
		return step;
	}


	// 글 목록 검색
		@RequestMapping("/getQnAList.do")
		public void getQnAList(QnAVO vo,Model model) {
			List<QnAVO> list= qnAService.getQnAList(vo);
			model.addAttribute("qnAList",list);
		}
		
//		// 글 등록
		@RequestMapping(value="/insertQnA.do", method= RequestMethod.POST)
		public String insertQnA(QnAVO vo) throws IOException{
			
			
			qnAService.insertQnA(vo);//
		
			return "redirect:getQnAList.do"; //완료 후 페이지 redirect 하겠다.
		}
		
		// 글 등록
		@RequestMapping(value="/saveQnA.do", method= RequestMethod.POST)
		public String saveQnA(QnAVO vo) throws IOException{
			
			
			qnAService.insertQnA(vo);//
		
			return "redirect:getQnAList.do"; //완료 후 페이지 redirect 하겠다.
		}
	
		// 글 수정
		@RequestMapping("/updateQnA.do")
		public String updateQnA(@ModelAttribute("qnA")QnAVO vo) {
			qnAService.updateQnA(vo);
		     System.out.println("updateQnA실행");
			return "redirect: /getQnAList.do";
		}
	
		// 글 삭제
		@RequestMapping("/deleteQnA.do")
		public String deleteQnA(QnAVO vo) {
			qnAService.deleteQnA(vo);
			return "redirect:/getQnAList.do";
		}
	
		// 글 상세 조회
		@RequestMapping("/getQnA.do")
		public void getQnA(QnAVO vo,Model model) {
			model.addAttribute("qnA", qnAService.getQnA(vo));// Model 정보 저장		
		}
		
		public void updateCnt(QnAVO vo) {
			qnAService.updateCnt(vo);
		}


}
