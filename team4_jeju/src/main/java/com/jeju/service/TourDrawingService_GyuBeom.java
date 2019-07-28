package com.jeju.service;

import java.util.List;
import com.jeju.vo.FinalPlaceVO_GyuBeom;
import com.jeju.vo.ScheduleInputVO;
import com.jeju.vo.ScheduleFinalOutputVO;
import com.jeju.vo.ScheduleRefinedInOutputVO;

public interface TourDrawingService_GyuBeom {
	
	List<FinalPlaceVO_GyuBeom> tourMapDrawing();
	
	List<ScheduleFinalOutputVO> insertSchMethod(ScheduleInputVO ivo);
	
	int selectTourDayCount(ScheduleInputVO ivo);
	
	ScheduleRefinedInOutputVO schOutPutMaker(ScheduleInputVO vo, int tourDaysCnt);
	
	List<ScheduleFinalOutputVO> makeFinalOutPut(ScheduleRefinedInOutputVO rvo);
	
}











