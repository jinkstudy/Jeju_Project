package com.jeju.service;

import java.util.List;

import com.jeju.vo.AdminSelVO;
import com.jeju.vo.PlaceNewVO;
import com.jeju.vo.FinalPlaceVO_GyuBeom;

public interface AdminService {
	
	//VisitJeju data insert
	void insertVisitJeju();
	
	//VisitJeju data get
	List<AdminSelVO> getVisitJejuArray();
	
	//api data insert
	void insertApiList();
	
	//api data get
	List<PlaceNewVO> getApiList();
	
	// !important - updateTourSequenceKeyNum in DB Table, named Final_Place
	void updateTourSequenceKeyNum();
	
	//Final_Place data get
	List<FinalPlaceVO_GyuBeom> getFinalPlaceList();
	
	
}
