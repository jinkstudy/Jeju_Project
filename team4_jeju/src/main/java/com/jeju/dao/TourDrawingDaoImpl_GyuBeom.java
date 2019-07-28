package com.jeju.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jeju.tour_method.CalDistanceFinal_GyuBeom;
import com.jeju.vo.FinalPlaceVO_GyuBeom;
import com.jeju.vo.ScheduleFinalOutputVO;
import com.jeju.vo.ScheduleInputVO;
import com.jeju.vo.ScheduleRefinedInOutputVO;

//객체 변수명 첫 글자 소문자 주의
@Repository("tourDrawingDao")
public class TourDrawingDaoImpl_GyuBeom implements TourDrawingDao_GyuBeom{
	
	//객체 변수명 첫 글자 소문자 주의
	@Autowired
	private SqlSessionTemplate mybatis;	
	
	public List<FinalPlaceVO_GyuBeom> mapDrawingList(){
		return mybatis.selectList("tourDrawingMap.selectTourDrawing");
	}
	
	public List<ScheduleFinalOutputVO> insertSchMethod(ScheduleInputVO vo){		
		List<ScheduleFinalOutputVO> olist = new ArrayList<ScheduleFinalOutputVO>();		
		mybatis.insert("schInOutputMap.inputSchRequest", vo);		
		return olist;
	}
	
	public int selectTourDayCount(ScheduleInputVO vo) {
		int tourDaysCount = mybatis.selectOne("schInOutputMap.selectTourDaysCount", vo);
		return tourDaysCount;
	}
	
	
	
	//--------------------------------------------------------------------------------
	//최종 Output List를 반환하는 메소드
	//--------------------------------------------------------------------------------
	public List<ScheduleFinalOutputVO> makeFinalOutPut(ScheduleRefinedInOutputVO rvo) {
		
		//최종 반환 해줄 아이
		List<ScheduleFinalOutputVO> foutvo = new ArrayList<ScheduleFinalOutputVO>();
		
		//2번의 경우 final_place db 값으로 넣어주어야 한다.
		List<FinalPlaceVO_GyuBeom> flist = new ArrayList<FinalPlaceVO_GyuBeom>();
		
		//update 된 시퀀스를 받을 아이.
		List<FinalPlaceVO_GyuBeom> fseqlist = new ArrayList<FinalPlaceVO_GyuBeom>();
		
		int totalRowCount = rvo.getTotal_Row_count_Refined();
		
		//1. two keys input / input 시에 seq도 함께 넣어 줌. (rank가 2부터 시작되니까, 나중에 매칭시 -1 하면 됨.)
		//2. 패턴에 따라 날짜, 시간 정보
		//2. place 정보들 update (조건에 따라 select 된 아이들)
		//3. sequence 정보 update
		//4. 각 일자, start time, finish time 텍스트 정보 update
		//5. 모든 정보가 셋팅 되었으면 이제 select로 셋팅해서 넘겨주자.
		
		//1. two keys input / input 시에 seq도 함께 넣어 줌. (rank가 2부터 시작되니까, 나중에 매칭시 -1 하면 됨.)
		String frontInputKey = rvo.getKey_Given_by_Front();
		try {
			for(int i = 1; i <= totalRowCount; i++) {
				HashMap<String, Object> h1 = new HashMap<String, Object>();
				h1.put("seq", i);
				h1.put("input_key", frontInputKey);
				mybatis.insert("schFinalMap.inputOutputTwoKeys", h1);
				Thread.sleep(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
			
		
		//태크 정보를 입력을 했는지 확인 후 없으면, 마이바티스에서 사용할 스트링 하나 만들어 주자.
		String nullCheck = "ihavetag";		
		if(rvo.getTagList_Refined().isEmpty()) {
			nullCheck = "idonothavetag";
		}
		
		
		//---------------------------------------------
		//테스트
		//---------------------------------------------
		System.out.println("-------------------------------------");
		System.out.println("TourDrawingDaoImpl_GyuBeom 내부");
		System.out.println("rvo.getTagList_Refined() : " + rvo.getTagList_Refined());
		System.out.println("tag_null_check : " + nullCheck);
		System.out.println("-------------------------------------");
		
		//2. place 정보들 update (조건에 따라 select 된 아이들)
		// 2-1. 조건 첫 번째 : 태그 리스트 - 반복 where 절 (마이바티스)
		// 2-2. 조건 두 번째 : 장소 옵션 ( 1 : 숨어있는 명소 / 2 :	적당히 / 3 : 핫플레이스 ) - 조건절 (마이바티스)
		
		
		//여기서 고려해주어야 할 것이, 만약 반환 된 레코드의 수가 totalRowCount를 충족하지 못했다면
		// 그만큼 태그 안에 없는 것들을 반환(where not like)하여 채워줘야 한다.
		// 리스트 moutvo을 활용해서 list.add(list) 기능을 활용한 후에 레코드 수를 채워서 반환해 줄 것.
		
		//다이나믹 쿼리를 위해 Integer를 String으로 변환 후 == 비교시 equals
		HashMap<String, Object> firstOutHashMap = new HashMap<String, Object>();
		firstOutHashMap.put("total_Row_count_Refined", totalRowCount);
		firstOutHashMap.put("place_Opt_Num_Refined", Integer.toString(rvo.getPlace_Opt_Num_Refined()));
		firstOutHashMap.put("null_check", nullCheck);
		firstOutHashMap.put("tagList_Refined", rvo.getTagList_Refined());
		
		flist.addAll(mybatis.selectList("finalPlaceMap.selectFirstFinalOutputPlace", firstOutHashMap));
		
		int flist_max = flist.size();
		
		//만약 제출된 rows 수가 사용자가 원하는 일수 여행량만큼 나오지 않은 경우.
		//기존 제출된 레코드를 제외한 나머지 레코드 중, like count가 높은 순으로(좋은 것들 추천)
		//필요한 갯수만큼 flist를 채워주어라.
		if(flist_max < totalRowCount) {
			
			//우선 기존 나왔던 final_place_num 배열 생성.
			ArrayList<String> f_pNum_list = new ArrayList<String>();
			for(int i = 0; i < flist_max; i++) {
				f_pNum_list.add(Integer.toString(flist.get(i).getFinal_Place_Num()));
			}
			int more_need_count = totalRowCount - flist_max;
			
			HashMap<String, Object> secondOutHashMap = new HashMap<String, Object>();
			secondOutHashMap.put("more_need_rowCount", more_need_count);
			secondOutHashMap.put("already_existing_place_num", f_pNum_list);
			
			flist.addAll(mybatis.selectList("finalPlaceMap.selectSecondFinalOutputPlace", secondOutHashMap));
		}
		
		
		//테스트 2-2
		System.out.println("-----------------------------------------------");
		System.out.println("TourDrawingDaoImpl_GyuBeom 내부 : 1차 output 리스트");
		System.out.println("flist.size() : " + flist.size());
		System.out.println("-----------------------------------------------");
		
		for(int i = 0; i < flist_max; i++) {
			System.out.println(
			flist.get(i).getFinal_Place_Num() 
			+ " | " + flist.get(i).getPlace_Name()
			+ " | " + flist.get(i).getTour_Sequence_Key_Num()
			+ " | " + flist.get(i).getLati_Coord()
			+ " | " + flist.get(i).getLongi_Coord()
			+ " | " + flist.get(i).getDivided_by_Center()
			);
		}
		
		
		CalDistanceFinal_GyuBeom calSeq = new CalDistanceFinal_GyuBeom();
		
		//시퀀스 셋팅된 값 addAll
		fseqlist.addAll(calSeq.updateTourSeqKeyNumFinal(flist));
		
		//시퀀스 셋팅 테스트
		System.out.println("----------------------------------------------");
		System.out.println("TourDrawingDaoImpl_GyuBeom 내부 - 시퀀스 셋팅 테스트");
		System.out.println("----------------------------------------------");
		for(FinalPlaceVO_GyuBeom vo : fseqlist) {
			System.out.println(vo.getFinal_Place_Num()
					           + " | " + vo.getPlace_Name()
					           + " | " + vo.getTour_Sequence_Key_Num()
					           + " | " + vo.getLati_Coord()
					           + " | " + vo.getLongi_Coord()
					           + " | " + vo.getDivided_by_Center());
		}
		
				
		//준비된 flist 환경 세팅.
		//1-1. 날짜 업데이트 및 시간 업데이트
		int howManyInADay = rvo.getHowManyInOneDay_Refined();
		
		//howManyInADay
		String[] s_many4 = {"AM 09:00", "AM 10:30", "PM 01:00", "PM 03:30"};
		String[] e_many4 = {"AM 10:30", "PM 01:00", "PM 03:30", "PM 06:00"};
		String[] s_many3 = {"AM 10:00", "PM 01:00", "PM 03:30"};
		String[] e_many3 = {"PM 01:00", "PM 03:30", "PM 06:00"};
		String[] s_many2 = {"AM 10:00", "PM 02:00"};
		String[] e_many2 = {"PM 00:00(noon)", "PM 06:00"};
		
		//최대 4
		String[] startTimeArray = new String[4];
		String[] endTimeArray = new String[4];
		
		if(howManyInADay == 2) {
			System.arraycopy(s_many2, 0, startTimeArray, 0, s_many2.length);
			System.arraycopy(e_many2, 0, endTimeArray, 0, e_many2.length);
		}else if(howManyInADay == 3) {
			System.arraycopy(s_many3, 0, startTimeArray, 0, s_many3.length);
			System.arraycopy(e_many3, 0, endTimeArray, 0, e_many3.length);
		}else if(howManyInADay == 4) {
			System.arraycopy(s_many4, 0, startTimeArray, 0, s_many4.length);
			System.arraycopy(e_many4, 0, endTimeArray, 0, e_many4.length);
		}
		
		int key = 0;
		for(FinalPlaceVO_GyuBeom vo : fseqlist) {
			key++;
			int r_d_pick = (key-1) % howManyInADay;
			if(vo.getTour_Sequence_Key_Num()-1 == key) {
				int p_Num = vo.getFinal_Place_Num();
				String p_Name = vo.getPlace_Name();
				double lati = vo.getLati_Coord();
				double longi = vo.getLongi_Coord();
				String Area = vo.getDivided_by_Center();
				double dist = vo.getFore_Distance();
				HashMap<String, Object> hm = new HashMap<String, Object>();
				hm.put("day", rvo.getStart_Date_Refined()); // 일자 db sequence로 + 예정.
				hm.put("day_LK", key); // where 절에서 matching 시킬 key 값
				hm.put("startTime", startTimeArray[r_d_pick]); //start time - 반복
				hm.put("endTime", endTimeArray[r_d_pick]); //end time - 반복
				hm.put("placeNum", p_Num);
				hm.put("placeName", p_Name);
				hm.put("latitude", lati);
				hm.put("longitude", longi);
				hm.put("section", Area);
				hm.put("fore_dist", dist);	
				hm.put("f_InputKey", frontInputKey);
				try {
					mybatis.update("schFinalMap.updateFinalOutput", hm);
					Thread.sleep(1);
				}catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		}
		
		

//		
//		
//		//테스트 2-1
//		System.out.println("-----------------------------------------------");
//		System.out.println("TourDrawingDaoImpl_GyuBeom 내부 : 태그 리스트");
//		System.out.println("-----------------------------------------------");
//		int tag_max = rvo.getTagList_Refined().size();
//		for(int i = 0; i < tag_max; i++) {
//			System.out.println(rvo.getTagList_Refined().get(i));
//		}
//		System.out.println("-----------------------------------------------\n");
//		
//		//테스트 2-2
//		System.out.println("-----------------------------------------------");
//		System.out.println("사용자가 선택한 옵션: " + rvo.getPlace_Opt_Num_Refined());
//		System.out.println("-----------------------------------------------\n");
		
		
		foutvo = mybatis.selectList("schFinalMap.selectDrawOutputElements", frontInputKey);
		
		
		//테스트 3
		System.out.println("----------------------------------------------");
		System.out.println("TourDrawingDaoImpl_GyuBeom 내부 - 최종 테스트");
		System.out.println("----------------------------------------------");
		int f_max = foutvo.size();
		for(int i = 0; i < f_max; i++) {			
			System.out.println(foutvo.get(i).getS_out_SEQUENCE()
					           + " | " + foutvo.get(i).getPlace_NAME()
					           + " | " + foutvo.get(i).getLati_COORD()
					           + " | " + foutvo.get(i).getLongi_COORD());
		}
		
		
		//마지막 셀렉트 값을 반환.		
		return foutvo;
		
		
		
	}
	
	
	
}
