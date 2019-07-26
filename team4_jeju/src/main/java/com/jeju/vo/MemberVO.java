package com.jeju.vo;

public class MemberVO {
	
	private String member_Email;
	private String password;

	
	public MemberVO() {
		
	}

	@Override
	public String toString() {
		return "MemberVO [ member_Email=" + member_Email 
				+ ", password=" + password	+ "]";
	}
	
	public MemberVO(String member_Email, String password) {
		super();
		this.member_Email = member_Email;
		this.password = password;
	
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


	
	
	
}
