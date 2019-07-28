package com.jeju.vo;

import java.util.Date;

public class QnAVO {

	private String qnA_Mnum;
	private String member_Email;
	private String writer_Pw;
	private String writer_Name;
	private String qnA_Content;
	private String qnA_Date;
	private int qnA_Cnt;
	private String qnA_Title;

	public QnAVO() {

	}

	public QnAVO(String qnA_Mnum, String member_Email, String writer_Pw, String writer_Name, String qnA_Content,
			String qnA_Date, int qnA_Cnt, String qnA_Title) {
		super();
		this.qnA_Mnum = qnA_Mnum;
		this.member_Email = member_Email;
		this.writer_Pw = writer_Pw;
		this.writer_Name = writer_Name;
		this.qnA_Content = qnA_Content;
		this.qnA_Date = qnA_Date;
		this.qnA_Cnt = qnA_Cnt;
		this.qnA_Title = qnA_Title;
	}

	public String getQnA_Mnum() {
		return qnA_Mnum;
	}

	public void setQnA_Mnum(String qnA_Mnum) {
		this.qnA_Mnum = qnA_Mnum;
	}

	public String getMember_Email() {
		return member_Email;
	}

	public void setMember_Email(String member_Email) {
		this.member_Email = member_Email;
	}

	public String getWriter_Pw() {
		return writer_Pw;
	}

	public void setWriter_Pw(String writer_Pw) {
		this.writer_Pw = writer_Pw;
	}

	public String getWriter_Name() {
		return writer_Name;
	}

	public void setWriter_Name(String writer_Name) {
		this.writer_Name = writer_Name;
	}

	public String getQnA_Content() {
		return qnA_Content;
	}

	public void setQnA_Content(String qnA_Content) {
		this.qnA_Content = qnA_Content;
	}

	public String getQnA_Date() {
		return qnA_Date;
	}

	public void setQnA_Date(String qnA_Date) {
		this.qnA_Date = qnA_Date;
	}

	public int getQnA_Cnt() {
		return qnA_Cnt;
	}

	public void setQnA_Cnt(int qnA_Cnt) {
		this.qnA_Cnt = qnA_Cnt;
	}

	public String getQnA_Title() {
		return qnA_Title;
	}

	public void setQnA_Title(String qnA_Title) {
		this.qnA_Title = qnA_Title;
	}
	
	
	
}
