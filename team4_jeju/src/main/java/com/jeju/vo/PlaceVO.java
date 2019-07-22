package com.jeju.vo;

public class PlaceVO {

	private int place_Num;
	private String place_Name;
	private String place_Det;
	private int middle_Num;
	private String image_Path;
	private double longi_Coord;
	private double lati_Coord;
	private String open_Time;
	private String close_Time;
	private String break_S_Time;
	private String break_F_Time;
	private String place_Tel;
	private int place_Price;
	private String close_day;
	private int tour_Hour;
	private int place_Opt_Num;
	
	public PlaceVO() {
		
	}

	public PlaceVO(int place_Num, String place_Name, String place_Det, int middle_Num, String image_Path,
			double longi_Coord, double lati_Coord, String open_Time, String close_Time, String break_S_Time,
			String break_F_Time, String place_Tel, int place_Price, String close_day, int tour_Hour,
			int place_Opt_Num) {
		super();
		this.place_Num = place_Num;
		this.place_Name = place_Name;
		this.place_Det = place_Det;
		this.middle_Num = middle_Num;
		this.image_Path = image_Path;
		this.longi_Coord = longi_Coord;
		this.lati_Coord = lati_Coord;
		this.open_Time = open_Time;
		this.close_Time = close_Time;
		this.break_S_Time = break_S_Time;
		this.break_F_Time = break_F_Time;
		this.place_Tel = place_Tel;
		this.place_Price = place_Price;
		this.close_day = close_day;
		this.tour_Hour = tour_Hour;
		this.place_Opt_Num = place_Opt_Num;
	}

	public int getPlace_Num() {
		return place_Num;
	}

	public void setPlace_Num(int place_Num) {
		this.place_Num = place_Num;
	}

	public String getPlace_Name() {
		return place_Name;
	}

	public void setPlace_Name(String place_Name) {
		this.place_Name = place_Name;
	}

	public String getPlace_Det() {
		return place_Det;
	}

	public void setPlace_Det(String place_Det) {
		this.place_Det = place_Det;
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

	public String getBreak_S_Time() {
		return break_S_Time;
	}

	public void setBreak_S_Time(String break_S_Time) {
		this.break_S_Time = break_S_Time;
	}

	public String getBreak_F_Time() {
		return break_F_Time;
	}

	public void setBreak_F_Time(String break_F_Time) {
		this.break_F_Time = break_F_Time;
	}

	public String getPlace_Tel() {
		return place_Tel;
	}

	public void setPlace_Tel(String place_Tel) {
		this.place_Tel = place_Tel;
	}

	public int getPlace_Price() {
		return place_Price;
	}

	public void setPlace_Price(int place_Price) {
		this.place_Price = place_Price;
	}

	public String getClose_day() {
		return close_day;
	}

	public void setClose_day(String close_day) {
		this.close_day = close_day;
	}

	public int getTour_Hour() {
		return tour_Hour;
	}

	public void setTour_Hour(int tour_Hour) {
		this.tour_Hour = tour_Hour;
	}

	public int getPlace_Opt_Num() {
		return place_Opt_Num;
	}

	public void setPlace_Opt_Num(int place_Opt_Num) {
		this.place_Opt_Num = place_Opt_Num;
	}
	
	
	
}
