package com.jeju.vo;

public class MajorClassVO {

	private int Major_Num;
	private String Major_Name;
	
	public MajorClassVO() {
		
	}
	
	public MajorClassVO(int major_Num, String major_Name) {
		super();
		Major_Num = major_Num;
		Major_Name = major_Name;
	}

	public int getMajor_Num() {
		return Major_Num;
	}

	public void setMajor_Num(int major_Num) {
		Major_Num = major_Num;
	}

	public String getMajor_Name() {
		return Major_Name;
	}

	public void setMajor_Name(String major_Name) {
		Major_Name = major_Name;
	}
	
	
	
}
