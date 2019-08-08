package com.jeju.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeju.dao.TourSchDaoImpl;
import com.jeju.vo.ScheduleInputVO;
import com.jeju.vo.ScheduleOutputVO;

//객체 변수명 첫 글자 소문자 주의
@Service("tourSchService")
public class TourSchServiceImpl implements TourSchService{
	
	//객체 변수명 첫 글자 소문자 주의
	@Autowired
	private TourSchDaoImpl tourSchDao;

	

	@Override
	//InputNum에 해당하는 PlaceList를 가져온다.
	public List<ScheduleOutputVO> getSchPlace(ScheduleInputVO vo) {
		// TODO Auto-generated method stub
		return tourSchDao.getSchPlace(vo);
	}

	@Override
	// 삭제 클릭 시 해당 outPutNum 에 해당하는 장소에 대해서 정보를 삭제 한다.
	public void updateDelSch(ScheduleOutputVO vo) {
		tourSchDao.updateDelSch(vo);
			
	}



	@Override
	//일정에 포함된 날짜들을 얻어온다.
	public List<ScheduleOutputVO> getDayList(ScheduleInputVO vo) {
		
		return tourSchDao.getDayList(vo);
	}
	
}
