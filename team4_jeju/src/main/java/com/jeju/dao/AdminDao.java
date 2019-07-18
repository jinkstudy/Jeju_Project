package com.jeju.dao;

import java.util.ArrayList;
import java.util.List;

import com.jeju.vo.AdminSelVO;
import com.jeju.vo.PlaceNewVO;

public interface AdminDao {
	
	void insertVisitJeju(ArrayList<AdminSelVO> visitJejuArray);
	
	List<AdminSelVO> getVisitJejuArray();
	
	List<PlaceNewVO> getApiArray();
}
