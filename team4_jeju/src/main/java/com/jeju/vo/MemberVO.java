package com.jeju.vo;

public class MemberVO {
	
	private String member_Email;
	private String password;
	private String member_Name;
	private String member_Tel;
	private String birthday;
	
	public MemberVO() {
		
	}

	public MemberVO(String member_Email, String password, String member_Name, String member_Tel, String birthday) {
		super();
		this.member_Email = member_Email;
		this.password = password;
		this.member_Name = member_Name;
		this.member_Tel = member_Tel;
		this.birthday = birthday;
	}

	public String getMember_Email() {
		return member_Email;
	}

	public void setMember_Email(String member_Email) {
		this.member_Email = member_Email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMember_Name() {
		return member_Name;
	}

	public void setMember_Name(String member_Name) {
		this.member_Name = member_Name;
	}

	public String getMember_Tel() {
		return member_Tel;
	}

	public void setMember_Tel(String member_Tel) {
		this.member_Tel = member_Tel;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	

	
	
	
}
