package com.jeju.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import com.jeju.vo.AdminSelVO;

//객체 변수명 첫 글자 소문자 주의
@Repository("adminDao")
public class AdminDaoImpl implements TourSchDao{
	
	//객체 변수명 첫 글자 소문자 주의
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertVisitJeju(ArrayList<AdminSelVO> visitJejuArray) {
		mybatis.delete("adminSelMap.deleteVisitJeju");
		System.out.println("insertVisitJeju 메소드 호출");
		mybatis.insert("adminSelMap.insertVisitJeju", visitJejuArray);
	}
	
}









