package com.jeju.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeju.dao.MemberDaoImpl;
import com.jeju.vo.MemberVO;

//객체 변수명 첫 글자 소문자 주의
@Service("memberService")
public class MemberServiceImpl implements MemberService{
	
	//객체 변수명 첫 글자 소문자 주의
	@Autowired
	private MemberDaoImpl memberDAO;
	
	
	/**
	  * 아이디 중복 체크하는 sql + 로그인 기능 sql
	  */
	  public MemberVO idCheck_Login( MemberVO vo)
	  {
		  return memberDAO.idCheck(vo);
	  }
	  
	  
	  /**
	   * 회원가입 sql
	   */
	   public int userInsert(MemberVO vo )
	   {
		  return memberDAO.memberInsert(vo);
	   }
}
