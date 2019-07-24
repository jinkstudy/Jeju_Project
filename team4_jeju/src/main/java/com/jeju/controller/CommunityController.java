package com.jeju.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jeju.service.CommunityService;
import com.jeju.service.ReplyService;
import com.jeju.vo.CommunityBoardVO;
import com.jeju.vo.ReplyVO;

@Controller
@RequestMapping("/community")
public class CommunityController {
	
	@Autowired
	private CommunityService communityService;
	
	@Autowired
	private ReplyService replyService;
	
//	@RequestMapping(value=""
//	                , produces="application/text; charset=UTF-8")
//	public void blablabla() {
//		
//	}
	
	@RequestMapping("/{step}.do") //정해지지 않은 명령어들은 이쪽으로 들어오게 되는게 {step}
	public String viewPage(@PathVariable String step) {
		
		step="community/"+step;
		return step; // 들어오는 애를 글자 그대로 리턴시켜서 밑과 같은 아무것도 안하는 함수를 생성할 필요가 없게 한다.(DB를 갔다오지 않는 애들을 위한 함수)
	}
	
	// 글 목록 검색
	@RequestMapping("/getCommunityBoardList.do")
	public ModelAndView getCommunityBoardList(CommunityBoardVO vo) {
		//model.addAttribute("cList", communityService.getCommunityBoardList(vo));
		// ViewResolver를 지정하지 않으면 아래처럼 페이지명 지정
		// return "views/getCommunityBoardList.jsp"; // View 이름 리턴
		ModelAndView model = new ModelAndView();
		model.addObject("community",communityService.getCommunityBoardList(vo));
		model.setViewName("community/getCommunityBoardList");
		return model;
	}
	
	//글 등록
	@RequestMapping(value="/saveCommunityBoard.do")
	public String insertCommunityBoard(CommunityBoardVO vo) throws IOException{
		communityService.insertCommunityBoard(vo);
		return "redirect:getCommunityBoardList.do";
	}
	//글 수정
	@RequestMapping("/updateCommunityBoard.do")
	public String updateCommunityBoard(@ModelAttribute("community") CommunityBoardVO vo ) {
		communityService.updateCommunityBoard(vo);
		return "redirect:getCommunityBoardList.do";
	}
	
	//글 삭제
	@RequestMapping("/deleteCommunityBoard.do")
	public String deleteCommunityBoard(CommunityBoardVO vo) {
		communityService.deleteCommunityBoard(vo);
		return "redirect:getCommunityBoardList.do";
	}
	//글 상세 조회
	@RequestMapping(value="/getCommunityBoard.do")
	public void getCommunityBoard(CommunityBoardVO vo,ReplyVO revo,Model model) {
		model.addAttribute("community", communityService.getCommunityBoard(vo));// Model 정보 저장	
    	model.addAttribute("reply", replyService.getCommentList(revo));// model에 정보저장
	}
	
	
	  /**
     * 댓글 등록(Ajax)
     */
    @RequestMapping(value="/addComment.do")
    @ResponseBody
    public void addComment(ReplyVO vo) throws IOException{
    	System.out.println("controller"+vo.getReply_Content());
    	replyService.addComment(vo);  
    }
   /*
    public String ajax_addComment(@ModelAttribute("ReplyVO") ReplyVO vo, HttpServletRequest request) throws Exception{
        
        HttpSession session = request.getSession();
        LoginVO loginVO = (LoginVO)session.getAttribute("loginVO");
        
        try{
        
        	ReplyVO.setWriter(loginVO.getUser_id());        
            boardServiceImpl.addComment(ReplyVO);
            
        } catch (Exception e){
            e.printStackTrace();
        }
        
        return "success";
    }
    */
    
    /**
     * 게시물 댓글 불러오기(Ajax)
     */
//    @RequestMapping(value="/getCommentList.do", produces="application/json; charset=utf8")
//    @ResponseBody
//    public void getCommentList(ReplyVO vo,Model model) {
//    	model.addAttribute("reply", replyService.getCommentList(vo));// model에 정보저장
//    }
//    public ResponseEntity ajax_commentList(@ModelAttribute("boardVO") BoardVO boardVO, HttpServletRequest request) throws Exception{
//        
//        HttpHeaders responseHeaders = new HttpHeaders();
//        ArrayList<HashMap> hmlist = new ArrayList<HashMap>();
//        
//        // 해당 게시물 댓글
//        List<BoardVO> commentVO = boardServiceImpl.selectBoardCommentByCode(boardVO);
//        
//        if(commentVO.size() > 0){
//            for(int i=0; i<commentVO.size(); i++){
//                HashMap hm = new HashMap();
//                hm.put("c_code", commentVO.get(i).getC_code());
//                hm.put("comment", commentVO.get(i).getComment());
//                hm.put("writer", commentVO.get(i).getWriter());
//                
//                hmlist.add(hm);
//            }
//            
//        }
//        
//        JSONArray json = new JSONArray(hmlist);        
//        return new ResponseEntity(json.toString(), responseHeaders, HttpStatus.CREATED);
//        
//    }
//}
}
