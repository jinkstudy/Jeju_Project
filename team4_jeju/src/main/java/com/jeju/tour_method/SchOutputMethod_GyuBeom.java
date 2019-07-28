package com.jeju.tour_method;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.jeju.dao.TourDrawingDaoImpl_GyuBeom;
import com.jeju.vo.ScheduleInputVO;
import com.jeju.vo.ScheduleRefinedInOutputVO;

public class SchOutputMethod_GyuBeom {
	
	
	TourDrawingDaoImpl_GyuBeom drawMethod = new TourDrawingDaoImpl_GyuBeom();
	
	
	//arraylist 합칠 때 addall(list끼리 합칠 때.) 써주기. (unionList.addAll(list1))
	//input에 따라 새롭게 값을 받고, 중복값을 제거할 ArrayList 생성.
	List<String> unionList = new ArrayList<String>();
	
	//unionList를 정제한 최종 ArrayList 필요
	List<String> finalRefinedUnionList = new ArrayList<String>();
	
	// _ 문자로 잘라서 구분한 값들을 받을 배열
	//모든 여행의 카테고리를 6개로 divide.
	String[] mcArr = new String[6];
	
	//각 카테고리마다 가지고 있는 여행 분야 총 7가지
	//1. romantic
	List<String> romantic = Arrays.asList(
			"드라이브", "커플"
	);
	
	//2. photospot
	List<String> photospot = Arrays.asList(
			"걷기", "등산", "경관/포토", "도보"
			, "동굴", "오름", "일몰", "일출"
	);
	
	//3. healing
	List<String> healing = Arrays.asList(
			"계곡", "공연", "도보", "드라이브"
			, "오름", "숲길", "템플스테이", "혼자", "휴식"
	);
	
	//4. culture
	List<String> culture = Arrays.asList(
			"역사", "갤러리", "체험관광", "문화유적지", "공연", "낚시"
			, "동물", "전시관", "예술", "테마공원", "템플스테이"
	);
	
	//5. inner
	List<String> inner = Arrays.asList(
			"역사", "갤러리", "공연", "미술/박물관", "비.눈", "실내"
	);
	
	//6. activity
	List<String> activity = Arrays.asList(
			"레이싱", "골프", "낚시", "승마", "액티비티"
	);
	
	//7. children
	List<String> children = Arrays.asList(
			"레이싱", "체험관광", "동물", "미술/박물관", "아이", "어린이"
	);
		
		
	
	//ScheduleRefinedInputVO - 정제된 VO Return형으로 만들기.
	//input 데이터들을 정제해주는 메소드.
	public ScheduleRefinedInOutputVO schOutPutMaker(ScheduleInputVO vo, int tourDaysCnt) {
		
		//테스트
//		for(int i = 0, max = romantic.size(); i < max; i++) {
//			System.out.println(romantic.get(i));
//		}
		
		
		//최종 정제된 준비물 list 모음
		// 1. finalRefinedUnionList <<< 처리 완료. 정제된 태그 분류를 리스트 형태로 가지고 있음.
		// 2. 여행일수 <<< 처리 완료.
		// 3. 총 out 레코드 건수 (row 건수)
		// 3-1. 장소 옵션
		
		// 3-1-1. 장소 옵션이 1 인 경우. 숨어 있는 명소. order by tags asc;
		// 3-1-2. 장소 옵션이 2 인 경우. 적당히. 우선은 select * (추후 시간이 남으면 핫 70 : 숨 30 비율로 셋팅)
		// 3-1-3. 장소 옵션이 3 인 경우. 핫플레이스. order by tags desc;
		
		// 3-2-1. 스피드 옵션이 1인 경우. 휙빠르게. 총 레코드 수 = 하루 4개 x 여행 일수
		// 3-2-2. 스피드 옵션이 2인 경우. 휙빠르게. 총 레코드 수 = 하루 3개 x 여행 일수
		// 3-2-3. 스피드 옵션이 3인 경우. 휙빠르게. 총 레코드 수 = 하루 2개 x 여행 일수
		
		// 4. 아이의 수가 0 이상인 경우 <<< 처리 완료.
		// 5. middle class 에 따른 태그 where 조건 리스트 <<< 처리 완료. 위 1번과 동일한 내용.
		
		
		
		// ref. 사용자 편의를 위해, 화면 단에 찍어줄, 사용자가 선택한 middle class
		// 만약 아무 것도 선택하지 않은 경우 "-" 보이도록 처리.
		String selectedMidClass = "-";
		
		
		
		//몇 박 몇 일인지 보여주는 스트링
		String m_bak_m_il = (tourDaysCnt - 1) + "박 " + tourDaysCnt + "일"; 
		
		
		
		//장소 옵션
		
		
		
		//스피드 옵션에 따라 하루에 반영할 레코드 수
		//디폴트 값 = 하루 3개
		int howManyToursInOneDay = 3;
		Integer usersHowManyInOneDay = vo.getSpeed_Opt_Num();
		
		if(usersHowManyInOneDay != null) {
			//프론트에서 화면 오류로 인해 값 중복으로 들어올 경우를 대비하여
			//if문을 나누어 놓음.
			if(usersHowManyInOneDay == 1) {
				howManyToursInOneDay = 4;
			}
			
			if(usersHowManyInOneDay == 3) {
				howManyToursInOneDay = 2;
			}
		}
		
		//이제 전체 몇 레코드를 반영해주어야 하는지 확인 가능.
		int totalRecordCount = tourDaysCnt * howManyToursInOneDay;		
		
		
		
		//아동 체크 여부 확인.
		int childrenCount = vo.getChildrenNum();
		
		//만약 사용자가 아이 명수를 입력한 경우, 아이 여행 태그들도 추가해주세요.
		if(childrenCount > 0) {
			unionList.addAll(children);
		}
		
		
		
		//사용자가 선택한 카테고리 받기.
		String mclist = vo.getMiddle_Class_List();
		
		//받아서 "_" 문자열로 자르기.
		if(mclist != null) {
			mcArr = mclist.split("_");
		}
		
		//input js 단에서 값을 전송하는 순서는 고정이므로 하기와 같이 기술.
		for(int i = 0, max = mcArr.length; i < max; i++) {
			
			//만약 로맨틱 체크했으면, 로맨틱 분야에 있는 모든 장소 태그 추가해줘 <<< 하기도 모두 이런 패턴.
			if(mcArr[0].equals("romantic")) {
				unionList.addAll(romantic);
				if(i == max - 1) {
					selectedMidClass = "로맨틱";
				}				
			}
			
			if(mcArr[1].equals("photospot")) {
				unionList.addAll(photospot);
				if(i == max - 1) {
					if(selectedMidClass.equals("-")) {
						selectedMidClass = "포토스팟";
					}else{
						selectedMidClass += ", 포토스팟";
					}
				}				
			}
			
			if(mcArr[2].equals("healing")) {
				unionList.addAll(healing);
				if(i == max - 1) {
					if(selectedMidClass.equals("-")) {
						selectedMidClass = "힐링";
					}else{
						selectedMidClass += ", 힐링";
					}
				}				
			}
			
			if(mcArr[3].equals("culture")) {
				unionList.addAll(culture);
				if(i == max - 1) {
					if(selectedMidClass.equals("-")) {
						selectedMidClass = "문화/체험";
					}else{
						selectedMidClass += ", 문화/체험";
					}
				}				
			}
			
			if(mcArr[4].equals("inner")) {
				unionList.addAll(inner);
				if(i == max - 1) {
					if(selectedMidClass.equals("-")) {
						selectedMidClass = "실내";
					}else{
						selectedMidClass += ", 실내";
					}
				}				
			}
			
			if(mcArr[5].equals("activity")) {
				unionList.addAll(activity);
				if(i == max - 1) {
					if(selectedMidClass.equals("-")) {
						selectedMidClass = "액티비티";
					}else{
						selectedMidClass += ", 액티비티";
					}
				}				
			}
			
		}
		//The end of for
		
		
		
		//for문까지 끝난 후에 해야할 작업은 바로 
		//unionList 리스트 내부에 있는 중복 요소 제거 작업이다.
		//class마다 중복 tag를 가지고 있을 수 있기 때문.
		// 최종 ArrayList : finalRefinedUnionList
		//unionList 정제 작업 시작.
		int list_max = unionList.size();
		
		if(list_max > 0) {
			
			for (int i = 0; i < list_max; i++) {
	        	
	        	// ! 요소를 갖고 있지 않은 경우에만, 최종 List에 반영.
	            if (!finalRefinedUnionList.contains(unionList.get(i))) {
	            	finalRefinedUnionList.add(unionList.get(i));
	            }
	            
	        }
			
		}
        
		
//		1	숨어있는 명소
//		2	적당히
//		3	핫플레이스
		//장소 옵션 to 텍스트.
		String placeOptText = "-";
		if(vo.getPlace_Opt_Num() == 1) {
			placeOptText = "숨어있는 명소";
		}else if(vo.getPlace_Opt_Num() == 2) {
			placeOptText = "적당히 (기본값)";
		}else if(vo.getPlace_Opt_Num() == 3) {
			placeOptText = "핫플레이스";
		}
		
		
//		1	휙빠르게
//		2	보통
//		3	여유롭게
		//스피드 옵션 to 텍스트.
		String speedOptText = "-";
		if(vo.getSpeed_Opt_Num() == 1) {
			speedOptText = "휙빠르게";
		}else if(vo.getSpeed_Opt_Num() == 2) {
			speedOptText = "보통 (기본값)";
		}else if(vo.getSpeed_Opt_Num() == 3) {
			speedOptText = "여유롭게";
		}

		
		//여행 시작일 요일 추가하기
		String startWeekDay = getDateDay(vo.getStart_Date(), "yyyy-MM-dd");
		String s_TourDay = vo.getStart_Date() + " (" + startWeekDay + ")";
		
		//여행 종료일 요일 추가하기
		String endWeekDay = getDateDay(vo.getFinish_Date(), "yyyy-MM-dd");
		String e_TourDay = vo.getFinish_Date() + " (" + endWeekDay + ")";
		
		
		//테스트
		System.out.println("--------------------------------");
		System.out.println("여행 시작일 : " + s_TourDay);
		System.out.println("여행 종료일 : " + e_TourDay);
		System.out.println("여행 일수 : " + tourDaysCnt);
		System.out.println("--------------------------------\n");		
		
		//테스트
		System.out.println("--------------------------------");
		System.out.println("장소(핫 플레이스 등) 옵션 : " + vo.getPlace_Opt_Num());
		System.out.println("텍스트 : " + placeOptText);
		System.out.println("--------------------------------\n");
		
		//테스트
		System.out.println("--------------------------------");
		System.out.println("스피드 옵션 : " + vo.getSpeed_Opt_Num());
		System.out.println("텍스트 : " + speedOptText);
		System.out.println("--------------------------------\n");
		
		//테스트
		System.out.println("--------------------------------");
		System.out.println(" Output 전체 레코드 수 : " + totalRecordCount);
		System.out.println("--------------------------------\n");
		
		
		System.out.println("----------------------------------------");
		//테스트
		System.out.println("where 반복문에 들어갈 tags 리스트");
		System.out.println("----------------------------------------");
		int final_max = finalRefinedUnionList.size();
		if(final_max > 0) {			
			for (int i = 0; i < final_max; i++) {	        	
	        	// ! 요소를 갖고 있지 않은 경우에만, 최종 List에 반영.
	            System.out.println(finalRefinedUnionList.get(i));            
	        }			
		}
		System.out.println("----------------------------------------\n");
		
		//테스트
		System.out.println("--------------------------------");
		System.out.println(" 사용자가 선택한 Mid Class : " + selectedMidClass);
		System.out.println("--------------------------------\n");
		
		//테스트
		System.out.println("--------------------------------");
		System.out.println(" 몇 박 몇 일 : " + m_bak_m_il);
		System.out.println("--------------------------------\n");
				
		
		
		
		//---------------------------------------------------------------------------
		
		//정제 Final VO에 담기 - ScheduleRefinedInputVO
		ScheduleRefinedInOutputVO refinedVO = new ScheduleRefinedInOutputVO();
		
		//DB table을 그리기 위한 아이들.
		refinedVO.setKey_Given_by_Front(vo.getKey_Given_by_Front());
		refinedVO.setTotal_Row_count_Refined(totalRecordCount);	
		refinedVO.setTourDaysCnt_Refined(tourDaysCnt);
		refinedVO.setHowManyInOneDay_Refined(howManyToursInOneDay);
		refinedVO.setStart_Date_Refined(vo.getStart_Date());
		refinedVO.setPlace_Opt_Num_Refined(vo.getPlace_Opt_Num());
		refinedVO.setTagList_Refined(finalRefinedUnionList); //배열을 통째로 set.
		
		//사용자 편의를 위해, 화면에 뿌려주기 위한 아이들
		refinedVO.setStartTourDay(s_TourDay);
		refinedVO.setEndTourDay(e_TourDay);
		refinedVO.setMbakMIl(m_bak_m_il);
		refinedVO.setChoosedAdultNum(vo.getAdultNum());
		refinedVO.setChoosedChildrenNum(vo.getChildrenNum());
		refinedVO.setPlaceOptText(placeOptText);
		refinedVO.setSpeedOptText(speedOptText);
		refinedVO.setSelectedMidClass(selectedMidClass);
		
		
		//final Return
		return refinedVO;
		
		
	}
	
	
	
	public String getDateDay(String date, String dateType){

		String day = "" ;		     
		SimpleDateFormat dateFormat = new SimpleDateFormat(dateType);
		Date nDate;

		try {			
			nDate = dateFormat.parse(date);
			Calendar cal = Calendar.getInstance() ;
			cal.setTime(nDate);
			int dayNum = cal.get(Calendar.DAY_OF_WEEK) ;		     

			switch(dayNum){
			case 1:
				day = "일";
				break ;
			case 2:
				day = "월";
				break ;
			case 3:
				day = "화";
				break ;
			case 4:
				day = "수";
				break ;
			case 5:
				day = "목";
				break ;
			case 6:
				day = "금";
				break ;
			case 7:
				day = "토";
				break ; 	            
			} 
		}catch (ParseException e) {
			e.printStackTrace();              
		}      
		return day ;
	}
	
	
	
}
