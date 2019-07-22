package com.jeju.vo;

public class FinalPlaceVO_GyuBeom {

	int final_Place_Num; /* NUMBER, /* 1-장소관리번호 !!!DONE!!! */
	String place_Id; /* VARCHAR(100), /* 2-장소ID !!!DONE!!! */
	String place_Name; /* VARCHAR2(1000), /* 3-장소이름 !!!DONE!!! */
	int tour_Sequence_Key_Num; /* NUMBER, /*** 4-투어 시퀀스 키 넘버 ***/
	double next_Distance; /* NUMBER(20,10), /*** 5-다음 코스까지의 거리 ***/
	int middle_Num; /* NUMBER(3), /* 6-중분류관리번호 !!!DONE!!! */
	String restaurant_Place_Id; /* VARCHAR(100), /* 7-해당 장소 식당 아이디 */
	String image_Path; /* VARCHAR2(700), /* 8-이미지경로 !!!DONE!!! */
	double lati_Coord; /* NUMBER(30,20), /* 9-위도 !!!DONE!!! */
	double longi_Coord; /* NUMBER(30,20), /* 10-경도 !!!DONE!!! */
	String place_Tel; /* VARCHAR2(700),  /* 11-연락처 !!!DONE!!! */
	String place_Addr; /* VARCHAR2(700), /* 12-장소주소 !!!DONE!!! */
	String close_Day; /* VARCHAR2(10), /* 13-휴일 !!!DONE!!! */
	String close_Possible_Day; /* VARCHAR2(100), /* 14-휴일가능여부(동일 텍스트) !!!DONE!!! */
	String open_Time; /* VARCHAR2(30), /* 15-오픈시간 !!!DONE!!! */
	String close_Time; /* VARCHAR2(30),  /* 16-종료시간 !!!DONE!!! */
	String use_Time; /* VARCHAR2(100), /* 17-이용시간  (오픈시간~종료시간 텍스트) !!!DONE!!! */
	int tour_Hour; /* NUMBER, /* 18-관광소요시간 - 2시간 (10:00부터 관광 START) !!!DONE!!! */
	String place_Det; /* VARCHAR2(4000), /* 19-장소간략설명 !!!DONE!!! */
	int like_Count; /* NUMBER, /* 20-좋아요횟수 !!!DONE!!! */
	String tags; /* VARCHAR2(100)  /* 21-태그 !!!DONE!!! */
	
	public FinalPlaceVO_GyuBeom() {
		
	}

	public FinalPlaceVO_GyuBeom(int final_Place_Num, String place_Id, String place_Name, int tour_Sequence_Key_Num,
			double next_Distance, int middle_Num, String restaurant_Place_Id, String image_Path, double lati_Coord,
			double longi_Coord, String place_Tel, String place_Addr, String close_Day, String close_Possible_Day,
			String open_Time, String close_Time, String use_Time, int tour_Hour, String place_Det, int like_Count,
			String tags) {
		super();
		this.final_Place_Num = final_Place_Num;
		this.place_Id = place_Id;
		this.place_Name = place_Name;
		this.tour_Sequence_Key_Num = tour_Sequence_Key_Num;
		this.next_Distance = next_Distance;
		this.middle_Num = middle_Num;
		this.restaurant_Place_Id = restaurant_Place_Id;
		this.image_Path = image_Path;
		this.lati_Coord = lati_Coord;
		this.longi_Coord = longi_Coord;
		this.place_Tel = place_Tel;
		this.place_Addr = place_Addr;
		this.close_Day = close_Day;
		this.close_Possible_Day = close_Possible_Day;
		this.open_Time = open_Time;
		this.close_Time = close_Time;
		this.use_Time = use_Time;
		this.tour_Hour = tour_Hour;
		this.place_Det = place_Det;
		this.like_Count = like_Count;
		this.tags = tags;
	}

	public int getFinal_Place_Num() {
		return final_Place_Num;
	}

	public void setFinal_Place_Num(int final_Place_Num) {
		this.final_Place_Num = final_Place_Num;
	}

	public String getPlace_Id() {
		return place_Id;
	}

	public void setPlace_Id(String place_Id) {
		this.place_Id = place_Id;
	}

	public String getPlace_Name() {
		return place_Name;
	}

	public void setPlace_Name(String place_Name) {
		this.place_Name = place_Name;
	}

	public int getTour_Sequence_Key_Num() {
		return tour_Sequence_Key_Num;
	}

	public void setTour_Sequence_Key_Num(int tour_Sequence_Key_Num) {
		this.tour_Sequence_Key_Num = tour_Sequence_Key_Num;
	}

	public double getNext_Distance() {
		return next_Distance;
	}

	public void setNext_Distance(double next_Distance) {
		this.next_Distance = next_Distance;
	}

	public int getMiddle_Num() {
		return middle_Num;
	}

	public void setMiddle_Num(int middle_Num) {
		this.middle_Num = middle_Num;
	}

	public String getRestaurant_Place_Id() {
		return restaurant_Place_Id;
	}

	public void setRestaurant_Place_Id(String restaurant_Place_Id) {
		this.restaurant_Place_Id = restaurant_Place_Id;
	}

	public String getImage_Path() {
		return image_Path;
	}

	public void setImage_Path(String image_Path) {
		this.image_Path = image_Path;
	}

	public double getLati_Coord() {
		return lati_Coord;
	}

	public void setLati_Coord(double lati_Coord) {
		this.lati_Coord = lati_Coord;
	}

	public double getLongi_Coord() {
		return longi_Coord;
	}

	public void setLongi_Coord(double longi_Coord) {
		this.longi_Coord = longi_Coord;
	}

	public String getPlace_Tel() {
		return place_Tel;
	}

	public void setPlace_Tel(String place_Tel) {
		this.place_Tel = place_Tel;
	}

	public String getPlace_Addr() {
		return place_Addr;
	}

	public void setPlace_Addr(String place_Addr) {
		this.place_Addr = place_Addr;
	}

	public String getClose_Day() {
		return close_Day;
	}

	public void setClose_Day(String close_Day) {
		this.close_Day = close_Day;
	}

	public String getClose_Possible_Day() {
		return close_Possible_Day;
	}

	public void setClose_Possible_Day(String close_Possible_Day) {
		this.close_Possible_Day = close_Possible_Day;
	}

	public String getOpen_Time() {
		return open_Time;
	}

	public void setOpen_Time(String open_Time) {
		this.open_Time = open_Time;
	}

	public String getClose_Time() {
		return close_Time;
	}

	public void setClose_Time(String close_Time) {
		this.close_Time = close_Time;
	}

	public String getUse_Time() {
		return use_Time;
	}

	public void setUse_Time(String use_Time) {
		this.use_Time = use_Time;
	}

	public int getTour_Hour() {
		return tour_Hour;
	}

	public void setTour_Hour(int tour_Hour) {
		this.tour_Hour = tour_Hour;
	}

	public String getPlace_Det() {
		return place_Det;
	}

	public void setPlace_Det(String place_Det) {
		this.place_Det = place_Det;
	}

	public int getLike_Count() {
		return like_Count;
	}

	public void setLike_Count(int like_Count) {
		this.like_Count = like_Count;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}
	
}
