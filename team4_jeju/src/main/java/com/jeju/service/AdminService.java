package com.jeju.service;

import java.util.List;

import com.jeju.vo.AdminSelVO;
import com.jeju.vo.PlaceNewVO;

public interface AdminService {
	
	//VisitJeju data input
	void insertVisitJeju();
	
	//VisitJeju data get
	List<AdminSelVO> getVisitJejuArray();
	
	//api data get
	List<PlaceNewVO> getApiList();
}
