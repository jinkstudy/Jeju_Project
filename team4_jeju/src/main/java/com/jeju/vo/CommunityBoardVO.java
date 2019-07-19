package com.jeju.vo;

public class CommunityBoardVO {
	
	private String comm_Mnum;
	private String member_Email;
	private String comm_Title;
	private String comm_Content;
	private String comm_Date;
	private int comm_Cnt;
	private String comm_Pass;
	
	public CommunityBoardVO() {
		
	}
	

	public CommunityBoardVO(String comm_Mnum, String member_Email, String comm_Title, String comm_Content,
			String comm_Date, int comm_Cnt, String comm_Pass) {
		super();
		this.comm_Mnum = comm_Mnum;
		this.member_Email = member_Email;
		this.comm_Title = comm_Title;
		this.comm_Content = comm_Content;
		this.comm_Date = comm_Date;
		this.comm_Cnt = comm_Cnt;
		this.comm_Pass = comm_Pass;
	}


	public String getComm_Mnum() {
		return comm_Mnum;
	}

	public void setComm_Mnum(String comm_Mnum) {
		this.comm_Mnum = comm_Mnum;
	}

	public String getMember_Email() {
		return member_Email;
	}

	public void setMember_Email(String member_Email) {
		this.member_Email = member_Email;
	}

	public String getComm_Title() {
		return comm_Title;
	}

	public void setComm_Title(String comm_Title) {
		this.comm_Title = comm_Title;
	}

	public String getComm_Content() {
		return comm_Content;
	}

	public void setComm_Content(String comm_Content) {
		this.comm_Content = comm_Content;
	}

	public String getComm_Date() {
		return comm_Date;
	}

	public void setComm_Date(String comm_Date) {
		this.comm_Date = comm_Date;
	}

	public int getComm_Cnt() {
		return comm_Cnt;
	}

	public void setComm_Cnt(int comm_Cnt) {
		this.comm_Cnt = comm_Cnt;
	}

	public String getComm_Pass() {
		return comm_Pass;
	}

	public void setComm_Pass(String comm_Pass) {
		this.comm_Pass = comm_Pass;
	}


}
