package com.jeju.dao;

import java.util.List;
import com.jeju.vo.FinalPlaceVO_GyuBeom;
import com.jeju.vo.ScheduleInputVO;
import com.jeju.vo.ScheduleFinalOutputVO;
import com.jeju.vo.ScheduleRefinedInOutputVO;

public interface TourDrawingDao_GyuBeom {

	List<FinalPlaceVO_GyuBeom> mapDrawingList();
	
	List<ScheduleFinalOutputVO> insertSchMethod(ScheduleInputVO vo);
	
	int selectTourDayCount(ScheduleInputVO vo);
	
	List<ScheduleFinalOutputVO> makeFinalOutPut(ScheduleRefinedInOutputVO rvo);
	
}
