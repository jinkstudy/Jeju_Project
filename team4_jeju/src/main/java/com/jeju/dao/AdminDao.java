package com.jeju.dao;

import java.util.ArrayList;
import java.util.List;

import com.jeju.vo.AdminSelVO;

public interface AdminDao {
	
	void insertVisitJeju(ArrayList<AdminSelVO> visitJejuArray);
	
	List<AdminSelVO> getVisitJejuArray();
	
}
