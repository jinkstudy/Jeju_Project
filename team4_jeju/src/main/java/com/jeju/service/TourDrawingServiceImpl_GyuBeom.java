package com.jeju.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeju.dao.TourDrawingDaoImpl_GyuBeom;
import com.jeju.tour_method.SchOutputMethod_GyuBeom;
import com.jeju.vo.FinalPlaceVO_GyuBeom;
import com.jeju.vo.ScheduleInputVO;
import com.jeju.vo.ScheduleFinalOutputVO;
import com.jeju.vo.ScheduleRefinedInOutputVO;

//객체 변수명 첫 글자 소문자 주의
@Service("tourDrawingService")
public class TourDrawingServiceImpl_GyuBeom implements TourDrawingService_GyuBeom{
	
	
	//객체 변수명 첫 글자 소문자 주의
	@Autowired
	private TourDrawingDaoImpl_GyuBeom mapDrawingDao;
	
	
	public List<FinalPlaceVO_GyuBeom> tourMapDrawing(){
		return mapDrawingDao.mapDrawingList();
	};
	
	
	public List<ScheduleFinalOutputVO> insertSchMethod(ScheduleInputVO ivo){		
		List<ScheduleFinalOutputVO> olist = new ArrayList<ScheduleFinalOutputVO>();		
		mapDrawingDao.insertSchMethod(ivo);		
		return olist;		
	}
	
	public int selectTourDayCount(ScheduleInputVO ivo) {		
		int tourDaysCnt = mapDrawingDao.selectTourDayCount(ivo);		
		return tourDaysCnt;		
	}
	
	public ScheduleRefinedInOutputVO schOutPutMaker(ScheduleInputVO vo, int tourDaysCnt) {
		SchOutputMethod_GyuBeom s_out_method = new SchOutputMethod_GyuBeom();		
		return s_out_method.schOutPutMaker(vo, tourDaysCnt);
	}
	
	
	public List<ScheduleFinalOutputVO> makeFinalOutPut(ScheduleRefinedInOutputVO rvo){
		
		List<ScheduleFinalOutputVO> foutvo = new ArrayList<ScheduleFinalOutputVO>();
		
		foutvo = mapDrawingDao.makeFinalOutPut(rvo);
		
		return foutvo;
		
	};
	
}
