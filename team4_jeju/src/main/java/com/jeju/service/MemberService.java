package com.jeju.service;

import com.jeju.vo.MemberVO;

public interface MemberService {
	public MemberVO idCheck_Login( MemberVO vo);
	public int userInsert(MemberVO vo);
}
