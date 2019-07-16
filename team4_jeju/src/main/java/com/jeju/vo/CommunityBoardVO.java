package com.jeju.vo;

public class CommunityBoardVO {
	
	private String Comm_Mnum;
	private String Member_Id;
	private String Comm_Title;
	private String Comm_Content;
	private String Comm_Date;
	private int Comm_Cnt;
	
	public CommunityBoardVO() {
		
	}
	
	public CommunityBoardVO(String comm_Mnum, String member_Id, String comm_Title, String comm_Content,
			String comm_Date, int comm_Cnt) {
		super();
		Comm_Mnum = comm_Mnum;
		Member_Id = member_Id;
		Comm_Title = comm_Title;
		Comm_Content = comm_Content;
		Comm_Date = comm_Date;
		Comm_Cnt = comm_Cnt;
	}

	public String getComm_Mnum() {
		return Comm_Mnum;
	}

	public void setComm_Mnum(String comm_Mnum) {
		Comm_Mnum = comm_Mnum;
	}

	public String getMember_Id() {
		return Member_Id;
	}

	public void setMember_Id(String member_Id) {
		Member_Id = member_Id;
	}

	public String getComm_Title() {
		return Comm_Title;
	}

	public void setComm_Title(String comm_Title) {
		Comm_Title = comm_Title;
	}

	public String getComm_Content() {
		return Comm_Content;
	}

	public void setComm_Content(String comm_Content) {
		Comm_Content = comm_Content;
	}

	public String getComm_Date() {
		return Comm_Date;
	}

	public void setComm_Date(String comm_Date) {
		Comm_Date = comm_Date;
	}

	public int getComm_Cnt() {
		return Comm_Cnt;
	}

	public void setComm_Cnt(int comm_Cnt) {
		Comm_Cnt = comm_Cnt;
	}	
	
}
