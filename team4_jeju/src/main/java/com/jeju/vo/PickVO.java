package com.jeju.vo;

public class PickVO {
	
	private String Pick_Mnum;
	private String Member_Id;
	private int Place_Num;
	
	public PickVO() {
		
	}
	
	public PickVO(String pick_Mnum, String member_Id, int place_Num) {
		super();
		Pick_Mnum = pick_Mnum;
		Member_Id = member_Id;
		Place_Num = place_Num;
	}

	public String getPick_Mnum() {
		return Pick_Mnum;
	}

	public void setPick_Mnum(String pick_Mnum) {
		Pick_Mnum = pick_Mnum;
	}

	public String getMember_Id() {
		return Member_Id;
	}

	public void setMember_Id(String member_Id) {
		Member_Id = member_Id;
	}

	public int getPlace_Num() {
		return Place_Num;
	}

	public void setPlace_Num(int place_Num) {
		Place_Num = place_Num;
	}
	
	
	
}
