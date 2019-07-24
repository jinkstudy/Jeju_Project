package com.jeju.vo;

public class MajorClassVO {

	private int major_Num;
	private String major_Name;
	
	public MajorClassVO() {
		
	}
	
	
	public MajorClassVO(int major_Num, String major_Name) {
		super();
		this.major_Num = major_Num;
		this.major_Name = major_Name;
	}


	public int getMajor_Num() {
		return major_Num;
	}

	public void setMajor_Num(int major_Num) {
		this.major_Num = major_Num;
	}

	public String getMajor_Name() {
		return major_Name;
	}

	public void setMajor_Name(String major_Name) {
		this.major_Name = major_Name;
	}
	
	
	
	
	
}
