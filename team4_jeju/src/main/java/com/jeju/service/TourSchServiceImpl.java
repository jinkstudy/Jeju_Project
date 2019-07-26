package com.jeju.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeju.dao.TourSchDaoImpl;

import com.jeju.vo.ScheduleOutputVO;

//객체 변수명 첫 글자 소문자 주의
@Service("tourSchService")
public class TourSchServiceImpl implements TourSchService{
	
	//객체 변수명 첫 글자 소문자 주의
	@Autowired
	private TourSchDaoImpl tourSchDao;

//	@Override
//	public List<List<ScheduleOutputVO>> getListByDay(ScheduleOutputVO vo) {
//		System.out.println("getListByDay service 호출 : " +vo.getSch_Input_Mnum());
//		
//		List<ScheduleOutputVO> datelist = tourSchDao.getDayList(vo);
//		
//		for (int i = 0; i < datelist.size(); i++) {
//			System.out.println("getListByday dao:"+datelist.get(i) );
//		}
//		
//		List<List<ScheduleOutputVO>> listByday = new ArrayList<List<ScheduleOutputVO>>();
//		
//		for (int j = 0; j < datelist.size(); j++) {
//			listByday.add(tourSchDao.getListByDay(vo,datelist.get(j)));
//			System.out.println("입력되는 날짜:"+datelist.get(j));
//		}
//
//		return listByday;
//	}
	
	

	@Override
	public List<ScheduleOutputVO> getSchPlace(ScheduleOutputVO vo) {
		// TODO Auto-generated method stub
		return tourSchDao.getSchPlace(vo);
	}

	@Override
	public void updateDelSch(ScheduleOutputVO vo) {
		tourSchDao.updateDelSch(vo);
			
	}



	@Override
	public List<ScheduleOutputVO> getDayList(ScheduleOutputVO vo) {
		// TODO Auto-generated method stub
		return tourSchDao.getDayList(vo);
	}
	
}
