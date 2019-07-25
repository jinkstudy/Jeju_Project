package com.jeju.dao;

import java.util.ArrayList;
import java.util.List;

import com.jeju.vo.AdminSelVO;
import com.jeju.vo.FinalPlaceVO_GyuBeom;
import com.jeju.vo.PlaceNewVO;

public interface AdminDao {
	
	void insertVisitJeju(List<AdminSelVO> visitJejuArray);
	
	List<AdminSelVO> getVisitJejuArray();
	
	List<PlaceNewVO> getApiArray();
	
	void insertApiList(List<PlaceNewVO> placeListArray);
	
	List<FinalPlaceVO_GyuBeom> getFinalPlaceList();
	
	void updateFinalPlaceSequenceList(List<FinalPlaceVO_GyuBeom> fvolist);
	
}
