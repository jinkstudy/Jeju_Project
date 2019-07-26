package com.jeju.vo;

public class ReplyVO {
	
	private String reply_Num;
	private String member_Email;
	private String reply_Content;
	private String reply_Date;
	private String comm_Mnum;
	private String qnA_Mnum;
	private String p_Reply_Num;
	
	public ReplyVO() {
		
	}

	public ReplyVO(String reply_Num, String member_Email, String reply_Content, String reply_Date, String comm_Mnum,
			String p_Reply_Num, String qnA_Mnum) {
		super();
		this.reply_Num = reply_Num;
		this.member_Email = member_Email;
		this.reply_Content = reply_Content;
		this.reply_Date = reply_Date;
		this.comm_Mnum = comm_Mnum;
		this.p_Reply_Num = p_Reply_Num;
		this.qnA_Mnum = qnA_Mnum;
	}

	public String getQnA_Mnum() {
		return qnA_Mnum;
	}

	public void setQnA_Mnum(String qnA_Mnum) {
		this.qnA_Mnum = qnA_Mnum;
	}

	public String getReply_Num() {
		return reply_Num;
	}

	public void setReply_Num(String reply_Num) {
		this.reply_Num = reply_Num;
	}

	public String getMember_Email() {
		return member_Email;
	}

	public void setMember_Email(String member_Email) {
		this.member_Email = member_Email;
	}

	public String getReply_Content() {
		return reply_Content;
	}

	public void setReply_Content(String reply_Content) {
		this.reply_Content = reply_Content;
	}

	public String getReply_Date() {
		return reply_Date;
	}

	public void setReply_Date(String reply_Date) {
		this.reply_Date = reply_Date;
	}

	public String getComm_Mnum() {
		return comm_Mnum;
	}

	public void setComm_Mnum(String comm_Mnum) {
		this.comm_Mnum = comm_Mnum;
	}

	public String getP_Reply_Num() {
		return p_Reply_Num;
	}

	public void setP_Reply_Num(String p_Reply_Num) {
		this.p_Reply_Num = p_Reply_Num;
	}
	
	
	
}
