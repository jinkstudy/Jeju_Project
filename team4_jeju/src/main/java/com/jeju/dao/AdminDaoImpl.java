package com.jeju.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jeju.vo.AdminSelVO;
import com.jeju.vo.FinalPlaceVO_GyuBeom;
import com.jeju.vo.PlaceNewVO;

//객체 변수명 첫 글자 소문자 주의
@Repository("adminDao")
public class AdminDaoImpl implements AdminDao{
	
	FileWriter fw = null;
	
	//객체 변수명 첫 글자 소문자 주의
	@Autowired
	private SqlSessionTemplate mybatis;
	
	//수정 금지 - getFinalPlaceList
	public List<FinalPlaceVO_GyuBeom> getFinalPlaceList(){
		return mybatis.selectList("finalPlaceMap.selectFinalPlaceAll");
	}
	
	//수정 금지 - updateFinalPlaceSequenceList
	public void updateFinalPlaceSequenceList(List<FinalPlaceVO_GyuBeom> fvolist) {
		try {
			for(FinalPlaceVO_GyuBeom fv : fvolist) {
				mybatis.update("finalPlaceMap.updateTourSeqKeyNum", fv);
				Thread.sleep(50);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//수정 금지 - getDefaultTourPartData
	public List<FinalPlaceVO_GyuBeom> getDefaultTourPartData(){
		return mybatis.selectList("finalPlaceMap.selPartDataExceptRestaurant");
	}	
	
	//수정 금지 - getVisitJejuArray
	public List<AdminSelVO> getVisitJejuArray(){
		return mybatis.selectList("adminSelMap.selectVisitJeju");
	}
	
	//수정 금지 - 
	public void insertVisitJeju(List<AdminSelVO> visitJejuArray) {
		mybatis.delete("adminSelMap.deleteVisitJeju");
		try {
			for(AdminSelVO vo : visitJejuArray) {
				mybatis.insert("adminSelMap.insertVisitJeju", vo);
				Thread.sleep(100);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	//수정 금지 - getApiArray
	public List<PlaceNewVO> getApiArray(){
		return mybatis.selectList("getAPI.selectApiListAll");
	}
	
	//수정 금지 - insertApiList
	public void insertApiList(List<PlaceNewVO> placeListArray) {
		
		mybatis.delete("getAPI.deleteApiListAll");
		
		try {
			
			int i = 0;
			String receipt_name = "D:\\"+"api_test.txt";			
			fw = new FileWriter(receipt_name);
			
			for (PlaceNewVO vo : placeListArray) {
								
				i++;
				
				//test
				System.out.println("\n---------------------------------");
				System.out.println("[ "+ i +" ]");
				System.out.println("---------------------------------");
				System.out.println(vo.getPlace_Num());
				System.out.println(vo.getPlace_Id());
				System.out.println(vo.getPlace_Name());
				System.out.println(vo.getMiddle_Num());
				System.out.println(vo.getImage_Path());
				System.out.println(vo.getLongi_Coord());
				System.out.println(vo.getLati_Coord());
				System.out.println(vo.getPlace_Tel());
				System.out.println(vo.getPlace_Addr());
				System.out.println(vo.getClose_Day());
				System.out.println(vo.getOpen_Time());
				System.out.println(vo.getClose_Time());
				System.out.println(vo.getUse_Time());
				System.out.println(vo.getTour_Hour());
				System.out.println(vo.getPlace_Det());
				System.out.println(vo.getPlace_Price());
				System.out.println(vo.getInfo_Center());
				System.out.println(vo.getOpen_Date());
				System.out.println(vo.getUse_Season());
				System.out.println(vo.getEvent_S_Date());
				System.out.println(vo.getEvent_E_Date());
				System.out.println(vo.getEvent_Homepage());
				System.out.println(vo.getEvent_Place());
				System.out.println(vo.getPlay_Time());
				System.out.println("---------------------------------\n\n");
				
				String apiString = 
				"\n\n---------------------------------"
				+"\n"+"[ "+i +" ]"
				+"\n---------------------------------"
				+"\n"+vo.getPlace_Id()
				+"\n---------------------------------"
				+"\n"+"1 >>>"+vo.getPlace_Num() 
				+"\n"+"2 >>>"+vo.getPlace_Id()
				+"\n"+"3 >>>"+vo.getPlace_Name()
				+"\n"+"4 >>>"+vo.getMiddle_Num()
				+"\n"+"5 >>>"+vo.getImage_Path() 
				+"\n"+"6 >>>"+vo.getLongi_Coord()
				+"\n"+"7 >>>"+vo.getLati_Coord()
				+"\n"+"8 >>>"+vo.getPlace_Tel() 
				+"\n"+"9 >>>"+vo.getPlace_Addr() 
				+"\n"+"10 >>>"+vo.getClose_Day() 
				+"\n"+"11 >>>"+vo.getOpen_Time() 
				+"\n"+"12 >>>"+vo.getClose_Time()
				+"\n"+"13 >>>"+vo.getUse_Time() 
				+"\n"+"14 >>>"+vo.getTour_Hour()
				+"\n"+"15 >>>"+vo.getPlace_Det()
				+"\n"+"16 >>>"+vo.getPlace_Price() 
				+"\n"+"17 >>>"+vo.getInfo_Center() 
				+"\n"+"18 >>>"+vo.getOpen_Date() 
				+"\n"+"19 >>>"+vo.getUse_Season() 
				+"\n"+"20 >>>"+vo.getEvent_S_Date() 
				+"\n"+"21 >>>"+vo.getEvent_E_Date() 
				+"\n"+"22 >>>"+vo.getEvent_Homepage()
				+"\n"+"23 >>>"+vo.getEvent_Place() 
				+"\n"+"24 >>>"+vo.getPlay_Time() 
				+"\n---------------------------------\n\n";				
                
                fw.append(apiString);       
                
				mybatis.insert("getAPI.insertApiList", vo);
				//쓰레드 200 이상으로 줄 것.
				Thread.sleep(200);
			}
		}catch (Exception e) {
			e.printStackTrace();

		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
}









