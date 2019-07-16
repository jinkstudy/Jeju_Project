package com.jeju.vo;

public class PlaceOptVO {
	
	private int Place_Opt_Num;
	private String Place_Opt_name;
	
	public PlaceOptVO() {
		
	}
	
	public PlaceOptVO(int place_Opt_Num, String place_Opt_name) {
		super();
		Place_Opt_Num = place_Opt_Num;
		Place_Opt_name = place_Opt_name;
	}

	public int getPlace_Opt_Num() {
		return Place_Opt_Num;
	}

	public void setPlace_Opt_Num(int place_Opt_Num) {
		Place_Opt_Num = place_Opt_Num;
	}

	public String getPlace_Opt_name() {
		return Place_Opt_name;
	}

	public void setPlace_Opt_name(String place_Opt_name) {
		Place_Opt_name = place_Opt_name;
	}
	
	
	
}
