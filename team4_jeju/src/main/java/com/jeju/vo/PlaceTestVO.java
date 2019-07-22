package com.jeju.vo;

public class PlaceTestVO {
	private int place_num;
	private String place_title;
	private int place_like_num;
	private String place_tags;
	private String place_img_path;
	private int midd_num;
	
	public PlaceTestVO() {
		
	}

	public PlaceTestVO(int place_num, String place_title, int place_like_num, String place_tags, String place_img_path,
			int midd_num) {
		super();
		this.place_num = place_num;
		this.place_title = place_title;
		this.place_like_num = place_like_num;
		this.place_tags = place_tags;
		this.place_img_path = place_img_path;
		this.midd_num = midd_num;
	}

	public void setPlace_num(int place_num) {
		this.place_num = place_num;
	}

	public void setPlace_title(String place_title) {
		this.place_title = place_title;
	}

	public void setPlace_like_num(int place_like_num) {
		this.place_like_num = place_like_num;
	}

	public void setPlace_tags(String place_tags) {
		this.place_tags = place_tags;
	}

	public void setPlace_img_path(String place_img_path) {
		this.place_img_path = place_img_path;
	}

	public void setMidd_num(int midd_num) {
		this.midd_num = midd_num;
	}

	public int getPlace_num() {
		return place_num;
	}

	public String getPlace_title() {
		return place_title;
	}

	public int getPlace_like_num() {
		return place_like_num;
	}

	public String getPlace_tags() {
		return place_tags;
	}

	public String getPlace_img_path() {
		return place_img_path;
	}

	public int getMidd_num() {
		return midd_num;
	}
	
	
	


	
}
