package com.jeju.vo;

import java.util.List;

public class ScheduleRefinedInOutputVO {
	
	private String key_Given_by_Front; // 아웃풋에 들어갈 인풋 키 값 (인풋의 PK는 아님)
	//아웃풋 PK는 YYYYMMDDHHMMSS + 아웃풋 시퀀스 + Key_Given_by_Front
	private int total_Row_count_Refined; // 아웃풋의 전체 레코드(행수)를 결정
	private int tourDaysCnt_Refined; // 날짜(일 단위)가 들어가는 갯수를 결정
	private int howManyInOneDay_Refined; // 각 날짜마다 들어갈 여행지 갯수를 결정 (각 일별) 
	private String start_Date_Refined; // 시작일을 결정	
	private int place_Opt_Num_Refined; // 3. 장소 옵션 - 아웃풋의 order by 를 결정. (아래 설명)
	// 3-1-1. 장소 옵션이 1 인 경우. 숨어 있는 명소. order by tags asc;
	// 3-1-2. 장소 옵션이 2 인 경우. 적당히. 우선은 select * (추후 시간이 남으면 핫 70 : 숨 30 비율로 셋팅)
	// 3-1-3. 장소 옵션이 3 인 경우. 핫플레이스. order by tags desc;
	private List<String> tagList_Refined; // tag들을 정제하여 배열로 담아놓음. where 문을 결정할 아이들.
	
	//-----------------------------------------------------
	//이하 사용자 편의를 위해 - 이전 vo 값들을 받는 변수들
	//Refined가 붙지 않은 것은 사용자 편의를 위해 화면단에 찍어줄 아이들.
	private String startTourDay; //사용자가 지정한 여행 시작일
	private String endTourDay; //사용자가 지정한 여행 종료일
	private String mbakMIl; //몇 박 몇 일인지 보여주는 아이.
	private int choosedAdultNum; //사용자가 선택한 성인수 int
	private int choosedChildrenNum; //사용자가 선택한 아이수 int
	private String placeOptText; //사용자가 선택한 장소 옵션 text
	private String speedOptText; //사용자가 선택한 속도 옵션 text
	private String selectedMidClass; //사용자가 선택한 mid 클래스를 보여주는 아이.
	
	public ScheduleRefinedInOutputVO() {
		
	}

	public ScheduleRefinedInOutputVO(String key_Given_by_Front, int total_Row_count_Refined, int tourDaysCnt_Refined,
			int howManyInOneDay_Refined, String start_Date_Refined, int place_Opt_Num_Refined,
			List<String> tagList_Refined, String startTourDay, String endTourDay, String mbakMIl, int choosedAdultNum,
			int choosedChildrenNum, String placeOptText, String speedOptText, String selectedMidClass) {
		super();
		this.key_Given_by_Front = key_Given_by_Front;
		this.total_Row_count_Refined = total_Row_count_Refined;
		this.tourDaysCnt_Refined = tourDaysCnt_Refined;
		this.howManyInOneDay_Refined = howManyInOneDay_Refined;
		this.start_Date_Refined = start_Date_Refined;
		this.place_Opt_Num_Refined = place_Opt_Num_Refined;
		this.tagList_Refined = tagList_Refined;
		this.startTourDay = startTourDay;
		this.endTourDay = endTourDay;
		this.mbakMIl = mbakMIl;
		this.choosedAdultNum = choosedAdultNum;
		this.choosedChildrenNum = choosedChildrenNum;
		this.placeOptText = placeOptText;
		this.speedOptText = speedOptText;
		this.selectedMidClass = selectedMidClass;
	}

	public String getKey_Given_by_Front() {
		return key_Given_by_Front;
	}

	public void setKey_Given_by_Front(String key_Given_by_Front) {
		this.key_Given_by_Front = key_Given_by_Front;
	}

	public int getTotal_Row_count_Refined() {
		return total_Row_count_Refined;
	}

	public void setTotal_Row_count_Refined(int total_Row_count_Refined) {
		this.total_Row_count_Refined = total_Row_count_Refined;
	}

	public int getTourDaysCnt_Refined() {
		return tourDaysCnt_Refined;
	}

	public void setTourDaysCnt_Refined(int tourDaysCnt_Refined) {
		this.tourDaysCnt_Refined = tourDaysCnt_Refined;
	}

	public int getHowManyInOneDay_Refined() {
		return howManyInOneDay_Refined;
	}

	public void setHowManyInOneDay_Refined(int howManyInOneDay_Refined) {
		this.howManyInOneDay_Refined = howManyInOneDay_Refined;
	}

	public String getStart_Date_Refined() {
		return start_Date_Refined;
	}

	public void setStart_Date_Refined(String start_Date_Refined) {
		this.start_Date_Refined = start_Date_Refined;
	}

	public int getPlace_Opt_Num_Refined() {
		return place_Opt_Num_Refined;
	}

	public void setPlace_Opt_Num_Refined(int place_Opt_Num_Refined) {
		this.place_Opt_Num_Refined = place_Opt_Num_Refined;
	}

	public List<String> getTagList_Refined() {
		return tagList_Refined;
	}

	public void setTagList_Refined(List<String> tagList_Refined) {
		this.tagList_Refined = tagList_Refined;
	}

	public String getStartTourDay() {
		return startTourDay;
	}

	public void setStartTourDay(String startTourDay) {
		this.startTourDay = startTourDay;
	}

	public String getEndTourDay() {
		return endTourDay;
	}

	public void setEndTourDay(String endTourDay) {
		this.endTourDay = endTourDay;
	}

	public String getMbakMIl() {
		return mbakMIl;
	}

	public void setMbakMIl(String mbakMIl) {
		this.mbakMIl = mbakMIl;
	}

	public int getChoosedAdultNum() {
		return choosedAdultNum;
	}

	public void setChoosedAdultNum(int choosedAdultNum) {
		this.choosedAdultNum = choosedAdultNum;
	}

	public int getChoosedChildrenNum() {
		return choosedChildrenNum;
	}

	public void setChoosedChildrenNum(int choosedChildrenNum) {
		this.choosedChildrenNum = choosedChildrenNum;
	}

	public String getPlaceOptText() {
		return placeOptText;
	}

	public void setPlaceOptText(String placeOptText) {
		this.placeOptText = placeOptText;
	}

	public String getSpeedOptText() {
		return speedOptText;
	}

	public void setSpeedOptText(String speedOptText) {
		this.speedOptText = speedOptText;
	}

	public String getSelectedMidClass() {
		return selectedMidClass;
	}

	public void setSelectedMidClass(String selectedMidClass) {
		this.selectedMidClass = selectedMidClass;
	}

	
	
}
