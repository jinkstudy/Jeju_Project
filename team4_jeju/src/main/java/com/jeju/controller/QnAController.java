package com.jeju.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeju.service.QnAService;
import com.jeju.service.ReplyService;
import com.jeju.vo.QnAVO;
import com.jeju.vo.ReplyVO;


@Controller
@RequestMapping("/qnA")
public class QnAController{

	@Autowired
	private QnAService qnAService;

	@Autowired
	private ReplyService replyService;

	//	 DB연동이 필요없는 모든 메소드를 대체해줌
	@RequestMapping("/{step}.do")
	public String viewPage(@PathVariable String step) {
		step ="qnA/"+step;
		return step;
	}

	// 글 목록 검색
	@RequestMapping("/getQnAList.do" )
	public void getQnAList(QnAVO vo,Model model) {
		List<QnAVO> list= qnAService.getQnAList(vo);
		model.addAttribute("qnAList",list);
	}

	//		// 글 등록
	@RequestMapping(value= {"/insertQnA.do", "/saveQnA.do"}, method= RequestMethod.POST)
	public String insertQnA(QnAVO vo) throws IOException{

		qnAService.insertQnA(vo);
		return "redirect:getQnAList.do"; //완료 후 페이지 redirect 하겠다.
	}

	//		// 글 등록
	//		@RequestMapping(value="/saveQnA.do", method= RequestMethod.POST)
	//		public String saveQnA(QnAVO vo) throws IOException{
	//			
	//			qnAService.insertQnA(vo);//
	//			return "redirect:getQnAList.do"; //완료 후 페이지 redirect 하겠다.
	//		}

	// 글 수정
	@RequestMapping("/updateQnA.do")
	public String updateQnA(@ModelAttribute("qnA")QnAVO vo) {
		qnAService.updateQnA(vo);
		System.out.println("updateQnA실행");
		return "redirect:getQnAList.do";
	}

	// 글 삭제
	@RequestMapping("/deleteQnA.do")
	public String deleteQnA(QnAVO vo) {
		qnAService.deleteQnA(vo);
		return "redirect:getQnAList.do";
	}

	// 글 상세 조회
	@RequestMapping("/getQnA.do")
	public void getQnA(QnAVO vo,Model model, ReplyVO revo) {
		//			qnAService.updateCnt(vo);
		System.out.println("getQnA실행");
		model.addAttribute("qnA", qnAService.getQnA(vo));// Model 정보 저장		
		model.addAttribute("reply", replyService.qnACommentList(revo));
	}

	// 글 조회수 수정
	public void updateCnt(QnAVO vo) {
		System.out.println("updateCnt실행");
		qnAService.updateCnt(vo);

	}

	/**
	 * 댓글 등록(Ajax)
	 */
	@RequestMapping(value="/qnAComment.do")
	@ResponseBody
	public String qnAComment(@ModelAttribute("ReplyVO")ReplyVO vo) throws IOException{
		replyService.qnAComment(vo);
		return "success";
	}

	/*댓글 리스트 불러오기 (Ajax)*/
	@RequestMapping(value="/qnACommentList",produces="application/json; charset=utf8")
	@ResponseBody
	public String qnACommentList(@ModelAttribute("ReplyVO") ReplyVO vo) throws Exception {
		System.out.println("컨트롤러 : " + vo.getQnA_Mnum());
		ArrayList<HashMap> hmlist = new ArrayList<HashMap>();

		List<ReplyVO> replyVO = replyService.qnACommentList(vo);

		if(replyVO.size()>0) {
			for(int i =0; i< replyVO.size();i++) {
				HashMap hm = new HashMap();
				hm.put("reply_Content", replyVO.get(i).getReply_Content());
				hm.put("member_Email", replyVO.get(i).getMember_Email());
				hm.put("reply_Date", replyVO.get(i).getReply_Date());
				hmlist.add(hm);
			}
		}
		JSONArray json = new JSONArray(hmlist);
		return json.toString();
	}


}
