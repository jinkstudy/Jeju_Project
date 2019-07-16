package com.jeju.vo;

public class MemberVO {
	
	private String Member_Id;
	private String Password;
	private String Member_Name;
	private String Member_Tel;
	private String Member_Email;
	private String Birthday;
	
	public MemberVO() {
		
	}
	
	public MemberVO(String member_Id, String password, String member_Name, String member_Tel, String member_Email,
			String birthday) {
		super();
		Member_Id = member_Id;
		Password = password;
		Member_Name = member_Name;
		Member_Tel = member_Tel;
		Member_Email = member_Email;
		Birthday = birthday;
	}

	public String getMember_Id() {
		return Member_Id;
	}

	public void setMember_Id(String member_Id) {
		Member_Id = member_Id;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getMember_Name() {
		return Member_Name;
	}

	public void setMember_Name(String member_Name) {
		Member_Name = member_Name;
	}

	public String getMember_Tel() {
		return Member_Tel;
	}

	public void setMember_Tel(String member_Tel) {
		Member_Tel = member_Tel;
	}

	public String getMember_Email() {
		return Member_Email;
	}

	public void setMember_Email(String member_Email) {
		Member_Email = member_Email;
	}

	public String getBirthday() {
		return Birthday;
	}

	public void setBirthday(String birthday) {
		Birthday = birthday;
	}
	
	
	
}
