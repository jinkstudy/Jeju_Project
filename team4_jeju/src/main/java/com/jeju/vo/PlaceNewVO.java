package com.jeju.vo;

public class PlaceNewVO {

	private int place_Num; //장소번호 SEQ
	private String place_Id;  //장소 ID
	private String place_Name; //장소이름
	private int middle_Num; //중분류관리번호
	private String image_Path; //이미지경로
	private double longi_Coord; //경도
	private double lati_Coord; //위도
	private String place_Tel; //연락처
	private String place_Addr; //장소주소
	private String close_Day = null; //휴일
	private String open_Time; //오픈시간
	private String close_Time; //종료시간
	private String use_Time = null; //이용시간 //13
	private int tour_Hour = 2; //관광소요시간 //14
	private String place_Det; //장소간략 설명 //15
	private String place_Price = null; //입장료 //16
	private String info_Center = null; //문의처
	private String open_Date = null; //개장일
	private String use_Season = null; //이용시기
	private String event_S_Date = null; //행사시작일
	private String event_E_Date = null; //행사종료일
	private String event_Homepage = null; //행사홈페이지
	private String event_Place = null; //행사장소
	private String play_Time = null; //공연시간
	
	public PlaceNewVO() {
		
	}

	public PlaceNewVO(int place_Num, String place_Id, String place_Name, int middle_Num, String image_Path,
			double longi_Coord, double lati_Coord, String place_Tel, String place_Addr, String close_Day,
			String open_Time, String close_Time, String use_Time, int tour_Hour, String place_Det,
			String place_Price, String info_Center, String open_Date, String use_Season, String event_S_Date,
			String event_E_Date, String event_Homepage, String event_Place, String play_Time) {
		super();
		this.place_Num = place_Num;
		this.place_Id = place_Id;
		this.place_Name = place_Name;
		this.middle_Num = middle_Num;
		this.image_Path = image_Path;
		this.longi_Coord = longi_Coord;
		this.lati_Coord = lati_Coord;
		this.place_Tel = place_Tel;
		this.place_Addr = place_Addr;
		this.close_Day = close_Day;
		this.open_Time = open_Time;
		this.close_Time = close_Time;
		this.use_Time = use_Time;
		this.tour_Hour = tour_Hour;
		this.place_Det = place_Det;
		this.place_Price = place_Price;
		this.info_Center = info_Center;
		this.open_Date = open_Date;
		this.use_Season = use_Season;
		this.event_S_Date = event_S_Date;
		this.event_E_Date = event_E_Date;
		this.event_Homepage = event_Homepage;
		this.event_Place = event_Place;
		this.play_Time = play_Time;
	}

	public int getPlace_Num() {
		return place_Num;
	}

	public void setPlace_Num(int place_Num) {
		this.place_Num = place_Num;
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

	public int getMiddle_Num() {
		return middle_Num;
	}

	public void setMiddle_Num(int middle_Num) {
		this.middle_Num = middle_Num;
	}

	public String getImage_Path() {
		return image_Path;
	}

	public void setImage_Path(String image_Path) {
		this.image_Path = image_Path;
	}

	public double getLongi_Coord() {
		return longi_Coord;
	}

	public void setLongi_Coord(double longi_Coord) {
		this.longi_Coord = longi_Coord;
	}

	public double getLati_Coord() {
		return lati_Coord;
	}

	public void setLati_Coord(double lati_Coord) {
		this.lati_Coord = lati_Coord;
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

	public String getPlace_Price() {
		return place_Price;
	}

	public void setPlace_Price(String place_Price) {
		this.place_Price = place_Price;
	}

	public String getInfo_Center() {
		return info_Center;
	}

	public void setInfo_Center(String info_Center) {
		this.info_Center = info_Center;
	}

	public String getOpen_Date() {
		return open_Date;
	}

	public void setOpen_Date(String open_Date) {
		this.open_Date = open_Date;
	}

	public String getUse_Season() {
		return use_Season;
	}

	public void setUse_Season(String use_Season) {
		this.use_Season = use_Season;
	}

	public String getEvent_S_Date() {
		return event_S_Date;
	}

	public void setEvent_S_Date(String event_S_Date) {
		this.event_S_Date = event_S_Date;
	}

	public String getEvent_E_Date() {
		return event_E_Date;
	}

	public void setEvent_E_Date(String event_E_Date) {
		this.event_E_Date = event_E_Date;
	}

	public String getEvent_Homepage() {
		return event_Homepage;
	}

	public void setEvent_Homepage(String event_Homepage) {
		this.event_Homepage = event_Homepage;
	}

	public String getEvent_Place() {
		return event_Place;
	}

	public void setEvent_Place(String event_Place) {
		this.event_Place = event_Place;
	}

	public String getPlay_Time() {
		return play_Time;
	}

	public void setPlay_Time(String play_Time) {
		this.play_Time = play_Time;
	}
	
	
//	@Override
//	public String toString() {
//		
//		System.out.println("장소이름: "+getPlace_Name());
//		System.out.println("장소번호: "+getPlace_Id());
//		System.out.println("중분류번호: "+getMiddle_Num());
//		System.out.println("이미지경로: "+getImage_Path());
//		System.out.println("경도/위도: " +getLongi_Coord()+"/"+getLati_Coord());
//		System.out.println("주소: "+getPlace_Addr());
//		System.out.println("전화번호: "+getPlace_Tel());
//		System.out.println("개요 :"+getPlace_Det());
//		System.out.println("이용시간 :"+getUse_Time());
//		System.out.println("휴무일:" +getClose_Day());
//		System.out.println("관광시간:" +getTour_Hour());
//		
//		
//		return super.toString();
//	}
	
	
}
