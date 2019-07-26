package com.jeju.vo;

public class ScheduleInputVO {

	private String sch_Input_Mnum;
	private String start_Date;
	private String finish_Date;
	private String member_Id;
	private int place_Opt_Num;
	private int speed_Opt_Num;
	private String middle_Class_List;
	private String confirm_Check;
	private String access_Date;
	
	public ScheduleInputVO() {
		
	}

	public ScheduleInputVO(String sch_Input_Mnum, String start_Date, String finish_Date, String member_Id,
			int place_Opt_Num, int speed_Opt_Num, String middle_Class_List, String confirm_Check, String access_Date) {
		super();
		this.sch_Input_Mnum = sch_Input_Mnum;
		this.start_Date = start_Date;
		this.finish_Date = finish_Date;
		this.member_Id = member_Id;
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

	public String getMember_Id() {
		return member_Id;
	}

	public void setMember_Id(String member_Id) {
		this.member_Id = member_Id;
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
