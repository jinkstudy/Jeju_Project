package com.jeju.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScheduleOutputVO {

   private String sch_Output_Mnum;
   private String sch_Input_Mnum;
   private double s_out_Sequence; //0.00001 단위 - 정하기 나름.
   private String sch_Date;
   private String sch_Start_Time;
   private String sch_Finish_Time;
   private int place_Num;
   
   private FinalPlaceVO_GyuBeom finalplacevo; //join 하기 위함.
   
   public ScheduleOutputVO() {
      
   }

   public ScheduleOutputVO(String sch_Output_Mnum, String sch_Input_Mnum, double s_out_Sequence, String sch_Date,
         String sch_Start_Time, String sch_Finish_Time, int place_Num) {
      super();
      this.sch_Output_Mnum = sch_Output_Mnum;
      this.sch_Input_Mnum = sch_Input_Mnum;
      this.s_out_Sequence = s_out_Sequence;
      this.sch_Date = sch_Date;
      this.sch_Start_Time = sch_Start_Time;
      this.sch_Finish_Time = sch_Finish_Time;
      this.place_Num = place_Num;
      
      
   }

   public String getSch_Output_Mnum() {
      return sch_Output_Mnum;
   }

   public void setSch_Output_Mnum(String sch_Output_Mnum) {
      this.sch_Output_Mnum = sch_Output_Mnum;
   }

   public String getSch_Input_Mnum() {
      return sch_Input_Mnum;
   }

   public void setSch_Input_Mnum(String sch_Input_Mnum) {
      this.sch_Input_Mnum = sch_Input_Mnum;
   }

   public double getS_out_Sequence() {
      return s_out_Sequence;
   }

   public void setS_out_Sequence(double s_out_Sequence) {
      this.s_out_Sequence = s_out_Sequence;
   }

   public String getSch_Date() {
	     
      return sch_Date;
   }

   public void setSch_Date(String sch_Date) {
	   String newstring=sch_Date;
	   Date date;
	try {
		date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(sch_Date);
		newstring = new SimpleDateFormat("yyyy-MM-dd").format(date);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  	  	   
      this.sch_Date = newstring;
   }

   public String getSch_Start_Time() {
      return sch_Start_Time;
   }

   public void setSch_Start_Time(String sch_Start_Time) {
      this.sch_Start_Time = sch_Start_Time;
   }

   public String getSch_Finish_Time() {
      return sch_Finish_Time;
   }

   public void setSch_Finish_Time(String sch_Finish_Time) {
      this.sch_Finish_Time = sch_Finish_Time;
   }

   public int getPlace_Num() {
      return place_Num;
   }

   public void setPlace_Num(int place_Num) {
      this.place_Num = place_Num;
   }

public FinalPlaceVO_GyuBeom getFinalplacevo() {
	return finalplacevo;
}

public void setFinalplacevo(FinalPlaceVO_GyuBeom finalplacevo) {
	this.finalplacevo = finalplacevo;
}
   
   
   
   
}