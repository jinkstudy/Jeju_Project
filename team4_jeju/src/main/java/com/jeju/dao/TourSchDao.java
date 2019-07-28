package com.jeju.dao;

import java.util.List;

import com.jeju.vo.ScheduleInputVO;
import com.jeju.vo.ScheduleOutputVO;

public interface TourSchDao {

	public List<ScheduleOutputVO> getDayList(ScheduleInputVO vo);
	//public List<ScheduleOutputVO> getListByDay(ScheduleOutputVO vo,String date);
	public List<ScheduleOutputVO> getSchPlace(ScheduleInputVO vo);
	public void updateDelSch(ScheduleOutputVO vo); 
	
}
