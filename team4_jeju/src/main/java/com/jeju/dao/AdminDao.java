package com.jeju.dao;

import java.util.ArrayList;
import com.jeju.vo.AdminSelVO;

public interface AdminDao {
	
	void insertVisitJeju(ArrayList<AdminSelVO> visitJejuArray);
	
	ArrayList<AdminSelVO> getVisitJejuArray();
	
}
