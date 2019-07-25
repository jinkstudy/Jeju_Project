package com.jeju.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeju.dao.AdminDaoImpl;
import com.jeju.tour_method.CalCulateDistance_GyuBeom;
import com.jeju.tour_method.GetAPI;
import com.jeju.tour_method.VisitJeju_GyuBeom;
import com.jeju.vo.AdminSelVO;
import com.jeju.vo.FinalPlaceVO_GyuBeom;
import com.jeju.vo.PlaceNewVO;;

//객체 변수명 첫 글자 소문자 주의
@Service("adminService")
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminDaoImpl adminDao;
	
	//VisitJeju data input
	public void insertVisitJeju() {
		VisitJeju_GyuBeom vj = new VisitJeju_GyuBeom();
		adminDao.insertVisitJeju(vj.crawl());
	};
	
	public List<AdminSelVO> getVisitJejuArray() {
		return adminDao.getVisitJejuArray();
	};
	
	public void insertApiList() {
		GetAPI api = new GetAPI();
		adminDao.insertApiList(api.parce());
	};
	
	public List<PlaceNewVO> getApiList(){
		return adminDao.getApiArray();
	}
	
	
	//순서 중요 - 1.
	public void updateWhatAreaAreYou() {
		List<FinalPlaceVO_GyuBeom> fvolist = new ArrayList<FinalPlaceVO_GyuBeom>();
		CalCulateDistance_GyuBeom calDist = new CalCulateDistance_GyuBeom();
		
	}
	
	//순서 중요 - 2.
	public void updateTourSequenceKeyNum() {
		List<FinalPlaceVO_GyuBeom> fvolist = new ArrayList<FinalPlaceVO_GyuBeom>();
		CalCulateDistance_GyuBeom calDist = new CalCulateDistance_GyuBeom();
		fvolist = calDist.updateTourSeqKeyNum(adminDao.getDefaultTourPartData());
		adminDao.updateFinalPlaceSequenceList(fvolist);
	}
	
	public List<FinalPlaceVO_GyuBeom> getFinalPlaceList(){
		return adminDao.getFinalPlaceList();
	}
	
}








