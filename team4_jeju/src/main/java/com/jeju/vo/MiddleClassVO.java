package com.jeju.vo;

public class MiddleClassVO {

	private int middle_Num;
	private String middle_Name;
	private int major_Num;
	
	public MiddleClassVO() {
		
	}

	
	
	public MiddleClassVO(int middle_Num, String middle_Name, int major_Num) {
		super();
		this.middle_Num = middle_Num;
		this.middle_Name = middle_Name;
		this.major_Num = major_Num;
	}



	public int getMiddle_Num() {
		return middle_Num;
	}

	public void setMiddle_Num(int middle_Num) {
		this.middle_Num = middle_Num;
	}

	public String getMiddle_Name() {
		return middle_Name;
	}

	public void setMiddle_Name(String middle_Name) {
		this.middle_Name = middle_Name;
	}

	public int getMajor_Num() {
		return major_Num;
	}

	public void setMajor_Num(int major_Num) {
		this.major_Num = major_Num;
	}
	
	
	
}
