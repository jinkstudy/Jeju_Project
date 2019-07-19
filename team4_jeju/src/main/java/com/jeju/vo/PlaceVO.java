package com.jeju.vo;

public class PlaceVO {

	private int Place_Num;
	private String Place_Name;
	private String Place_Det;
	private int Middle_Num;
	private String Image_Path;
	private double Longi_Coord;
	private double Lati_Coord;
	private String Open_Time;
	private String Close_Time;
	private String Break_S_Time;
	private String Break_F_Time;
	private String Place_Tel;
	private int Place_Price;
	private String Close_day;
	private int Tour_Hour;
	private int Place_Opt_Num;
	
	public PlaceVO() {
		
	}
	
	public PlaceVO(int place_Num, String place_Name, String place_Det, int middle_Num, String image_Path,
			double longi_Coord, double lati_Coord, String open_Time, String close_Time, String break_S_Time,
			String break_F_Time, String place_Tel, int place_Price, String close_day, int tour_Hour,
			int place_Opt_Num) {
		super();
		Place_Num = place_Num;
		Place_Name = place_Name;
		Place_Det = place_Det;
		Middle_Num = middle_Num;
		Image_Path = image_Path;
		Longi_Coord = longi_Coord;
		Lati_Coord = lati_Coord;
		Open_Time = open_Time;
		Close_Time = close_Time;
		Break_S_Time = break_S_Time;
		Break_F_Time = break_F_Time;
		Place_Tel = place_Tel;
		Place_Price = place_Price;
		Close_day = close_day;
		Tour_Hour = tour_Hour;
		Place_Opt_Num = place_Opt_Num;
	}

	public int getPlace_Num() {
		return Place_Num;
	}

	public void setPlace_Num(int place_Num) {
		Place_Num = place_Num;
	}

	public String getPlace_Name() {
		return Place_Name;
	}

	public void setPlace_Name(String place_Name) {
		Place_Name = place_Name;
	}

	public String getPlace_Det() {
		return Place_Det;
	}

	public void setPlace_Det(String place_Det) {
		Place_Det = place_Det;
	}

	public int getMiddle_Num() {
		return Middle_Num;
	}

	public void setMiddle_Num(int middle_Num) {
		Middle_Num = middle_Num;
	}

	public String getImage_Path() {
		return Image_Path;
	}

	public void setImage_Path(String image_Path) {
		Image_Path = image_Path;
	}

	public double getLongi_Coord() {
		return Longi_Coord;
	}

	public void setLongi_Coord(double longi_Coord) {
		Longi_Coord = longi_Coord;
	}

	public double getLati_Coord() {
		return Lati_Coord;
	}

	public void setLati_Coord(double lati_Coord) {
		Lati_Coord = lati_Coord;
	}

	public String getOpen_Time() {
		return Open_Time;
	}

	public void setOpen_Time(String open_Time) {
		Open_Time = open_Time;
	}

	public String getClose_Time() {
		return Close_Time;
	}

	public void setClose_Time(String close_Time) {
		Close_Time = close_Time;
	}

	public String getBreak_S_Time() {
		return Break_S_Time;
	}

	public void setBreak_S_Time(String break_S_Time) {
		Break_S_Time = break_S_Time;
	}

	public String getBreak_F_Time() {
		return Break_F_Time;
	}

	public void setBreak_F_Time(String break_F_Time) {
		Break_F_Time = break_F_Time;
	}

	public String getPlace_Tel() {
		return Place_Tel;
	}

	public void setPlace_Tel(String place_Tel) {
		Place_Tel = place_Tel;
	}

	public int getPlace_Price() {
		return Place_Price;
	}

	public void setPlace_Price(int place_Price) {
		Place_Price = place_Price;
	}

	public String getClose_day() {
		return Close_day;
	}

	public void setClose_day(String close_day) {
		Close_day = close_day;
	}

	public int getTour_Hour() {
		return Tour_Hour;
	}

	public void setTour_Hour(int tour_Hour) {
		Tour_Hour = tour_Hour;
	}

	public int getPlace_Opt_Num() {
		return Place_Opt_Num;
	}

	public void setPlace_Opt_Num(int place_Opt_Num) {
		Place_Opt_Num = place_Opt_Num;
	}
	
	
	
}
