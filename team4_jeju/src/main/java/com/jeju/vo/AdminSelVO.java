package com.jeju.vo;

public class AdminSelVO {
	
	private int admin_SEL_ID;
	private String admin_SEL_TITLE;
	private int admin_SEL_LIKE;
	private String admin_SEL_TAGS;
	
	public AdminSelVO() {
		
	}

	public AdminSelVO(int admin_SEL_ID, String admin_SEL_TITLE, int admin_SEL_LIKE, String admin_SEL_TAGS) {
		super();
		this.admin_SEL_ID = admin_SEL_ID;
		this.admin_SEL_TITLE = admin_SEL_TITLE;
		this.admin_SEL_LIKE = admin_SEL_LIKE;
		this.admin_SEL_TAGS = admin_SEL_TAGS;
	}

	public int getAdmin_SEL_ID() {
		return admin_SEL_ID;
	}

	public void setAdmin_SEL_ID(int admin_SEL_ID) {
		this.admin_SEL_ID = admin_SEL_ID;
	}

	public String getAdmin_SEL_TITLE() {
		return admin_SEL_TITLE;
	}

	public void setAdmin_SEL_TITLE(String admin_SEL_TITLE) {
		this.admin_SEL_TITLE = admin_SEL_TITLE;
	}

	public int getAdmin_SEL_LIKE() {
		return admin_SEL_LIKE;
	}

	public void setAdmin_SEL_LIKE(int admin_SEL_LIKE) {
		this.admin_SEL_LIKE = admin_SEL_LIKE;
	}

	public String getAdmin_SEL_TAGS() {
		return admin_SEL_TAGS;
	}

	public void setAdmin_SEL_TAGS(String admin_SEL_TAGS) {
		this.admin_SEL_TAGS = admin_SEL_TAGS;
	}
	
	
	
	
}
