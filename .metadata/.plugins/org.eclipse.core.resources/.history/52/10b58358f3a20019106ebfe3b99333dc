package com.jeju.dao;

import org.mybatis.spring.SqlSessionTemplate;
import com.jeju.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//객체 변수명 첫 글자 소문자 주의
@Repository("memberDao")
public class MemberDaoImpl implements MemberDao{
	
	//객체 변수명 첫 글자 소문자 주의
	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public MemberVO idCheck(MemberVO vo) {
		System.out.println("===> MemberMapper idCheck 호출");
		return (MemberVO) mybatis.selectOne("user.idCheck", vo);
	}

	@Override
	public int memberInsert(MemberVO vo) {
		System.out.println("===>  MemberMapper userInsert() 호출");
		return mybatis.insert("user.userInsert", vo);
	}

	@Override
	public MemberVO memberLogin(MemberVO vo) {
		System.out.println("===> MemberMapper idCheck 호출");
		return (MemberVO) mybatis.selectOne("user.idCheck", vo);
	}

}
