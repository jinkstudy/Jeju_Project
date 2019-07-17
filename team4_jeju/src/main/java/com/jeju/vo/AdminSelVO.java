package com.jeju.vo;

public class AdminSelVO {
	
	private int ADMIN_SEL_ID;
	private String ADMIN_SEL_TITLE;
	private int ADMIN_SEL_LIKE;
	private String ADMIN_SEL_TAGS;
	
	public AdminSelVO() {
		
	}
	
	public AdminSelVO(int aDMIN_SEL_ID, String aDMIN_SEL_TITLE, int aDMIN_SEL_LIKE, String aDMIN_SEL_TAGS) {
		super();
		ADMIN_SEL_ID = aDMIN_SEL_ID;
		ADMIN_SEL_TITLE = aDMIN_SEL_TITLE;
		ADMIN_SEL_LIKE = aDMIN_SEL_LIKE;
		ADMIN_SEL_TAGS = aDMIN_SEL_TAGS;
	}

	public int getADMIN_SEL_ID() {
		return ADMIN_SEL_ID;
	}

	public void setADMIN_SEL_ID(int aDMIN_SEL_ID) {
		ADMIN_SEL_ID = aDMIN_SEL_ID;
	}

	public String getADMIN_SEL_TITLE() {
		return ADMIN_SEL_TITLE;
	}

	public void setADMIN_SEL_TITLE(String aDMIN_SEL_TITLE) {
		ADMIN_SEL_TITLE = aDMIN_SEL_TITLE;
	}

	public int getADMIN_SEL_LIKE() {
		return ADMIN_SEL_LIKE;
	}

	public void setADMIN_SEL_LIKE(int aDMIN_SEL_LIKE) {
		ADMIN_SEL_LIKE = aDMIN_SEL_LIKE;
	}

	public String getADMIN_SEL_TAGS() {
		return ADMIN_SEL_TAGS;
	}

	public void setADMIN_SEL_TAGS(String aDMIN_SEL_TAGS) {
		ADMIN_SEL_TAGS = aDMIN_SEL_TAGS;
	}
	
	
}
