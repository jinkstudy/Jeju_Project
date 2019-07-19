package com.jeju.vo;

public class PickVO {
	
	private String pick_Mnum;
	private String member_Email;
	private int place_Num;
	
	public PickVO() {
		
	}

	public PickVO(String pick_Mnum, String member_Email, int place_Num) {
		super();
		this.pick_Mnum = pick_Mnum;
		this.member_Email = member_Email;
		this.place_Num = place_Num;
	}

	public String getPick_Mnum() {
		return pick_Mnum;
	}

	public void setPick_Mnum(String pick_Mnum) {
		this.pick_Mnum = pick_Mnum;
	}

	public String getMember_Email() {
		return member_Email;
	}

	public void setMember_Email(String member_Email) {
		this.member_Email = member_Email;
	}

	public int getPlace_Num() {
		return place_Num;
	}

	public void setPlace_Num(int place_Num) {
		this.place_Num = place_Num;
	}
	
	
	
	
}
