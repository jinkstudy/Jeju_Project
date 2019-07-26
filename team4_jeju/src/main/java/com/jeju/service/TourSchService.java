package com.jeju.service;

import java.util.List;


import com.jeju.vo.ScheduleOutputVO;

public interface TourSchService {

	//일정에 해당하는 날짜 별 List
//	public List<List<ScheduleOutputVO>> getListByDay(ScheduleOutputVO vo);
	//일정 Output에 해당
	public List<ScheduleOutputVO> getSchPlace(ScheduleOutputVO vo) ;
	public void updateDelSch(ScheduleOutputVO vo);
	public List<ScheduleOutputVO> getDayList(ScheduleOutputVO vo);

}
