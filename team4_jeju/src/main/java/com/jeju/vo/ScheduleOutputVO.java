package com.jeju.vo;

public class ScheduleOutputVO {

	private String Sch_Output_Mnum;
	private String Sch_Input_Mnum;
	private String Sch_Date;
	private String Sch_Start_Time;
	private String Sch_Finish_Time;
	private int Place_Num;
	
	public ScheduleOutputVO() {
		
	}
	
	public ScheduleOutputVO(String sch_Output_Mnum, String sch_Input_Mnum, String sch_Date, String sch_Start_Time,
			String sch_Finish_Time, int place_Num) {
		super();
		Sch_Output_Mnum = sch_Output_Mnum;
		Sch_Input_Mnum = sch_Input_Mnum;
		Sch_Date = sch_Date;
		Sch_Start_Time = sch_Start_Time;
		Sch_Finish_Time = sch_Finish_Time;
		Place_Num = place_Num;
	}

	public String getSch_Output_Mnum() {
		return Sch_Output_Mnum;
	}

	public void setSch_Output_Mnum(String sch_Output_Mnum) {
		Sch_Output_Mnum = sch_Output_Mnum;
	}

	public String getSch_Input_Mnum() {
		return Sch_Input_Mnum;
	}

	public void setSch_Input_Mnum(String sch_Input_Mnum) {
		Sch_Input_Mnum = sch_Input_Mnum;
	}

	public String getSch_Date() {
		return Sch_Date;
	}

	public void setSch_Date(String sch_Date) {
		Sch_Date = sch_Date;
	}

	public String getSch_Start_Time() {
		return Sch_Start_Time;
	}

	public void setSch_Start_Time(String sch_Start_Time) {
		Sch_Start_Time = sch_Start_Time;
	}

	public String getSch_Finish_Time() {
		return Sch_Finish_Time;
	}

	public void setSch_Finish_Time(String sch_Finish_Time) {
		Sch_Finish_Time = sch_Finish_Time;
	}

	public int getPlace_Num() {
		return Place_Num;
	}

	public void setPlace_Num(int place_Num) {
		Place_Num = place_Num;
	}
	
	
	
}
