package com.jeju.vo;

public class ScheduleInputVO {

	private String sch_Input_Mnum; //쿼리에서 넣어줄 값.
	private String key_Given_by_Front; // /* 프론트 엔드에서 준 키 값 */
	private String start_Date; //DONE; 
	private String finish_Date; //DONE;
	private int tourDaysCount; // 쿼리에서 계산하여 넣어줄 값./* 여행 일수 */
	private int adultNum; //DONE;
	private int childrenNum; //DONE;
	private String member_Email = ""; //비회원이 가입한 경우 - 수정 금지 ""
	private int place_Opt_Num; // view 단에서 직접 값을 받을 수 없는 경우
	private int speed_Opt_Num; // view 단에서 직접 값을 받을 수 없는 경우
	private String middle_Class_List; // view 단에서 값을 받을 수 없는 경우
	private String confirm_Check;
	private String access_Date;
	
	public ScheduleInputVO() {
		
	}

	public ScheduleInputVO(String sch_Input_Mnum, String key_Given_by_Front, String start_Date, String finish_Date,
			int tourDaysCount, int adultNum, int childrenNum, String member_Email, int place_Opt_Num, int speed_Opt_Num,
			String middle_Class_List, String confirm_Check, String access_Date) {
		super();
		this.sch_Input_Mnum = sch_Input_Mnum;
		this.key_Given_by_Front = key_Given_by_Front;
		this.start_Date = start_Date;
		this.finish_Date = finish_Date;
		this.tourDaysCount = tourDaysCount;
		this.adultNum = adultNum;
		this.childrenNum = childrenNum;
		this.member_Email = member_Email;
		this.place_Opt_Num = place_Opt_Num;
		this.speed_Opt_Num = speed_Opt_Num;
		this.middle_Class_List = middle_Class_List;
		this.confirm_Check = confirm_Check;
		this.access_Date = access_Date;
	}

	public String getSch_Input_Mnum() {
		return sch_Input_Mnum;
	}

	public void setSch_Input_Mnum(String sch_Input_Mnum) {
		this.sch_Input_Mnum = sch_Input_Mnum;
	}

	public String getKey_Given_by_Front() {
		return key_Given_by_Front;
	}

	public void setKey_Given_by_Front(String key_Given_by_Front) {
		this.key_Given_by_Front = key_Given_by_Front;
	}

	public String getStart_Date() {
		return start_Date;
	}

	public void setStart_Date(String start_Date) {
		this.start_Date = start_Date;
	}

	public String getFinish_Date() {
		return finish_Date;
	}

	public void setFinish_Date(String finish_Date) {
		this.finish_Date = finish_Date;
	}

	public int getTourDaysCount() {
		return tourDaysCount;
	}

	public void setTourDaysCount(int tourDaysCount) {
		this.tourDaysCount = tourDaysCount;
	}

	public int getAdultNum() {
		return adultNum;
	}

	public void setAdultNum(int adultNum) {
		this.adultNum = adultNum;
	}

	public int getChildrenNum() {
		return childrenNum;
	}

	public void setChildrenNum(int childrenNum) {
		this.childrenNum = childrenNum;
	}

	public String getMember_Email() {
		return member_Email;
	}

	public void setMember_Email(String member_Email) {
		this.member_Email = member_Email;
	}

	public int getPlace_Opt_Num() {
		return place_Opt_Num;
	}

	public void setPlace_Opt_Num(int place_Opt_Num) {
		this.place_Opt_Num = place_Opt_Num;
	}

	public int getSpeed_Opt_Num() {
		return speed_Opt_Num;
	}

	public void setSpeed_Opt_Num(int speed_Opt_Num) {
		this.speed_Opt_Num = speed_Opt_Num;
	}

	public String getMiddle_Class_List() {
		return middle_Class_List;
	}

	public void setMiddle_Class_List(String middle_Class_List) {
		this.middle_Class_List = middle_Class_List;
	}

	public String getConfirm_Check() {
		return confirm_Check;
	}

	public void setConfirm_Check(String confirm_Check) {
		this.confirm_Check = confirm_Check;
	}

	public String getAccess_Date() {
		return access_Date;
	}

	public void setAccess_Date(String access_Date) {
		this.access_Date = access_Date;
	}
	
	
	
}
