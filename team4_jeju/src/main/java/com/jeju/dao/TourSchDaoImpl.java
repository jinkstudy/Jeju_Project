package com.jeju.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jeju.vo.FinalPlaceVO_GyuBeom;
import com.jeju.vo.ScheduleInputVO;
import com.jeju.vo.ScheduleOutputVO;

//객체 변수명 첫 글자 소문자 주의
@Repository("tourSchDao")
public class TourSchDaoImpl implements TourSchDao{
	
	//객체 변수명 첫 글자 소문자 주의
	@Autowired
	private SqlSessionTemplate mybatis;

	//일정에 속한 날짜를 구해옴.
	public List<ScheduleOutputVO> getDayList(ScheduleInputVO vo) {
		// TODO Auto-generated method stub
	System.out.println("getDayList Dao"+vo.getKey_Given_by_Front());
		return mybatis.selectList("tourSchMap.getSchDay", vo);
	}
		
//	//일정별 리스트 묶음을 뽑아옴.
//	public List<ScheduleOutputVO> getListByDay(ScheduleOutputVO vo,ScheduleOutputVO scheduleOutputVO){
//		
//		HashMap<String,String> params = new HashMap<String,String>();
//		params.put("sch_Input_Mnum", vo.getSch_Input_Mnum());
//		params.put("sch_Date", scheduleOutputVO);
//		
//		return mybatis.selectList("tourSchMap.getListByDay", params);
//	}

	//schOutput 테이블과 place 테이블 조인해서, 정보 가져옴.
	public List<ScheduleOutputVO> getSchPlace(ScheduleInputVO vo) {
		// TODO Auto-generated method stub
		return  mybatis.selectList("tourSchMap.getSchPlace", vo);
	}
	//일정 삭제 클릭 시 비우기.
	public void updateDelSch(ScheduleOutputVO vo) {
		mybatis.update("tourSchMap.updateDelSch", vo);
		
	}


}
