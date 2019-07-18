package com.jeju.service;

import java.util.List;
import java.util.ArrayList;
import com.jeju.vo.AdminSelVO;

public interface AdminService {
	
	//VisitJeju data input
	void insertVisitJeju();
	
	//VisitJeju data get
	List<AdminSelVO> getVisitJejuArray();
	
}
