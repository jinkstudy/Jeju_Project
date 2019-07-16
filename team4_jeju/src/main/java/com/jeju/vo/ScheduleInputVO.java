package com.jeju.vo;

public class ScheduleInputVO {

	private String Sch_Input_Mnum;
	private String Start_Date;
	private String Finish_Date;
	private String Member_Id;
	private int Place_Opt_Num;
	private int Speed_Opt_Num;
	private String Middle_Class_List;
	private String Confirm_Check;
	private String Access_Date;
	
	public ScheduleInputVO() {
		
	}
	
	public ScheduleInputVO(String sch_Input_Mnum, String start_Date, String finish_Date, String member_Id,
			int place_Opt_Num, int speed_Opt_Num, String middle_Class_List, String confirm_Check, String access_Date) {
		super();
		Sch_Input_Mnum = sch_Input_Mnum;
		Start_Date = start_Date;
		Finish_Date = finish_Date;
		Member_Id = member_Id;
		Place_Opt_Num = place_Opt_Num;
		Speed_Opt_Num = speed_Opt_Num;
		Middle_Class_List = middle_Class_List;
		Confirm_Check = confirm_Check;
		Access_Date = access_Date;
	}

	public String getSch_Input_Mnum() {
		return Sch_Input_Mnum;
	}

	public void setSch_Input_Mnum(String sch_Input_Mnum) {
		Sch_Input_Mnum = sch_Input_Mnum;
	}

	public String getStart_Date() {
		return Start_Date;
	}

	public void setStart_Date(String start_Date) {
		Start_Date = start_Date;
	}

	public String getFinish_Date() {
		return Finish_Date;
	}

	public void setFinish_Date(String finish_Date) {
		Finish_Date = finish_Date;
	}

	public String getMember_Id() {
		return Member_Id;
	}

	public void setMember_Id(String member_Id) {
		Member_Id = member_Id;
	}

	public int getPlace_Opt_Num() {
		return Place_Opt_Num;
	}

	public void setPlace_Opt_Num(int place_Opt_Num) {
		Place_Opt_Num = place_Opt_Num;
	}

	public int getSpeed_Opt_Num() {
		return Speed_Opt_Num;
	}

	public void setSpeed_Opt_Num(int speed_Opt_Num) {
		Speed_Opt_Num = speed_Opt_Num;
	}

	public String getMiddle_Class_List() {
		return Middle_Class_List;
	}

	public void setMiddle_Class_List(String middle_Class_List) {
		Middle_Class_List = middle_Class_List;
	}

	public String getConfirm_Check() {
		return Confirm_Check;
	}

	public void setConfirm_Check(String confirm_Check) {
		Confirm_Check = confirm_Check;
	}

	public String getAccess_Date() {
		return Access_Date;
	}

	public void setAccess_Date(String access_Date) {
		Access_Date = access_Date;
	}
	
	
	
}
