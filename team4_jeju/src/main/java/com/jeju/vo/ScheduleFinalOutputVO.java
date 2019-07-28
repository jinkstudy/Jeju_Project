package com.jeju.vo;

public class ScheduleFinalOutputVO {
	
	String sch_Output_Mnum; /* 일정출력관리번호 */
	String sch_Input_Mnum; /* 일정입력관리번호 */
	String place_NAME; /* map drawing 요소 : 장소이름 */
	double lati_COORD; /* map drawing 요소 : 위도 좌표 */
	double longi_COORD; /* map drawing 요소 : 경도 좌표 */
	String divided_by_Center; // /*** 5-센터 좌표로 구분한 구역 명명 : map drawing 요소 ***/
	double s_out_SEQUENCE; // /* 0.00001 단위 - 정하기 나름 : map drawing 요소 */
	double fore_DISTANCE; // 이전 여행지와의 거리 m
	String sch_Date; /* 연월일 */
	String sch_Start_Time; /* 시작시간 */
	String sch_Finish_Time; /* 종료시간 */
	int place_Num; /* 장소관리번호 */
	
	public ScheduleFinalOutputVO() {
		
	}

	public ScheduleFinalOutputVO(String sch_Output_Mnum, String sch_Input_Mnum, String place_NAME, double lati_COORD,
			double longi_COORD, String divided_by_Center, double s_out_SEQUENCE, double fore_DISTANCE, String sch_Date,
			String sch_Start_Time, String sch_Finish_Time, int place_Num) {
		super();
		this.sch_Output_Mnum = sch_Output_Mnum;
		this.sch_Input_Mnum = sch_Input_Mnum;
		this.place_NAME = place_NAME;
		this.lati_COORD = lati_COORD;
		this.longi_COORD = longi_COORD;
		this.divided_by_Center = divided_by_Center;
		this.s_out_SEQUENCE = s_out_SEQUENCE;
		this.fore_DISTANCE = fore_DISTANCE;
		this.sch_Date = sch_Date;
		this.sch_Start_Time = sch_Start_Time;
		this.sch_Finish_Time = sch_Finish_Time;
		this.place_Num = place_Num;
	}

	public String getSch_Output_Mnum() {
		return sch_Output_Mnum;
	}

	public void setSch_Output_Mnum(String sch_Output_Mnum) {
		this.sch_Output_Mnum = sch_Output_Mnum;
	}

	public String getSch_Input_Mnum() {
		return sch_Input_Mnum;
	}

	public void setSch_Input_Mnum(String sch_Input_Mnum) {
		this.sch_Input_Mnum = sch_Input_Mnum;
	}

	public String getPlace_NAME() {
		return place_NAME;
	}

	public void setPlace_NAME(String place_NAME) {
		this.place_NAME = place_NAME;
	}

	public double getLati_COORD() {
		return lati_COORD;
	}

	public void setLati_COORD(double lati_COORD) {
		this.lati_COORD = lati_COORD;
	}

	public double getLongi_COORD() {
		return longi_COORD;
	}

	public void setLongi_COORD(double longi_COORD) {
		this.longi_COORD = longi_COORD;
	}

	public String getDivided_by_Center() {
		return divided_by_Center;
	}

	public void setDivided_by_Center(String divided_by_Center) {
		this.divided_by_Center = divided_by_Center;
	}

	public double getS_out_SEQUENCE() {
		return s_out_SEQUENCE;
	}

	public void setS_out_SEQUENCE(double s_out_SEQUENCE) {
		this.s_out_SEQUENCE = s_out_SEQUENCE;
	}

	public double getFore_DISTANCE() {
		return fore_DISTANCE;
	}

	public void setFore_DISTANCE(double fore_DISTANCE) {
		this.fore_DISTANCE = fore_DISTANCE;
	}

	public String getSch_Date() {
		return sch_Date;
	}

	public void setSch_Date(String sch_Date) {
		this.sch_Date = sch_Date;
	}

	public String getSch_Start_Time() {
		return sch_Start_Time;
	}

	public void setSch_Start_Time(String sch_Start_Time) {
		this.sch_Start_Time = sch_Start_Time;
	}

	public String getSch_Finish_Time() {
		return sch_Finish_Time;
	}

	public void setSch_Finish_Time(String sch_Finish_Time) {
		this.sch_Finish_Time = sch_Finish_Time;
	}

	public int getPlace_Num() {
		return place_Num;
	}

	public void setPlace_Num(int place_Num) {
		this.place_Num = place_Num;
	}
	
	
	
}
