package com.jeju.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jeju.vo.AdminSelVO;
import com.jeju.vo.PlaceNewVO;

//객체 변수명 첫 글자 소문자 주의
@Repository("adminDao")
public class AdminDaoImpl implements TourSchDao{

	//객체 변수명 첫 글자 소문자 주의
	@Autowired
	private SqlSessionTemplate mybatis;

	public void insertVisitJeju(List<AdminSelVO> visitJejuArray) {
		mybatis.delete("adminSelMap.deleteVisitJeju");
		try {
			for(AdminSelVO vo : visitJejuArray) {
				mybatis.insert("adminSelMap.insertVisitJeju", vo);
				Thread.sleep(100);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}



	}

	public List<AdminSelVO> getVisitJejuArray(){
		return mybatis.selectList("adminSelMap.selectVisitJeju");
	}
	
	public List<PlaceNewVO> getApiArray(){
		return mybatis.selectList("getAPI.selectApiListAll");
	}
	
}









