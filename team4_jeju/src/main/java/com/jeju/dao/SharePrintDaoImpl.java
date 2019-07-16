package com.jeju.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//객체 변수명 첫 글자 소문자 주의
@Repository("sharePrintDao")
public class SharePrintDaoImpl implements SharePrintDao{
	
	//객체 변수명 첫 글자 소문자 주의
	@Autowired
	private SqlSessionTemplate mybatis;

}
