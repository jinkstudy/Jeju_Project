package com.jeju.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeju.dao.SharePrintDaoImpl;

//객체 변수명 첫 글자 소문자 주의
@Service("sharePrintService")
public class SharePrintServiceImpl implements SharePrintService{
	
	//객체 변수명 첫 글자 소문자 주의
	@Autowired
	private SharePrintDaoImpl sharePrintDAO;
	
}
