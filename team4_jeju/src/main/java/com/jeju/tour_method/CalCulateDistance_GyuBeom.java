package com.jeju.tour_method;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.io.FileWriter;
import java.util.ArrayList;
import com.jeju.vo.FinalPlaceVO_GyuBeom;
import com.jeju.vo.PlaceNewVO;

public class CalCulateDistance_GyuBeom {
	
	//출발 - 제주 국제 공항 - 국내선터미널
	double first_lati = 33.506996;
	double first_longi = 126.492941;
	
	//테스트
	FileWriter fw;
	
	//경로 순서 알고리즘
	//1. 두 좌표의 거리를 미터로 반환하는 메소드
	//2. 디비에서 넘어오는 값은 아이디와 좌표
	//3. vo list는 TOUR_SEQUENCE_KEY_NUM (등수), PLACE_ID 값으로 가지고 있음.
	// 처음에는 제주 국제 공항이 기준 / 두 번째는 1등이 기준 ...
	// 한번 등수가 매겨진 아이는 다시 비교 대상이 되지 않음.
	// 처음에는 빈 list / 모든 place_id와 tour_sequence_key_num을 넘겨 받은 list 
	// 위 두 list로 시작
	// 끝날때는 값이 찬 list가 바뀌어 있음.
	// 값이 찬 list로 db table - 아이디에 맞게 셋팅 - update
	
	//식당은 다름, 무조건 모든 식당 가운데 가까우면 장땡. 
	//구지 쉬러 갔는데, 멀리까지 가서 밥 먹을 필요가 없죵. 훗.
	
	
	
	//--------------------------------------------------------
	//start of updateTourSeqKeyNum 메소드 시작
	//--------------------------------------------------------
	public List<FinalPlaceVO_GyuBeom> updateTourSeqKeyNum(List<FinalPlaceVO_GyuBeom> flist){
		
		FinalPlaceVO_GyuBeom v = new FinalPlaceVO_GyuBeom();
		
		//편리성과 속도를 위해 arraylist가 아닌 array 사용.
		FinalPlaceVO_GyuBeom[] now_number1_place = new FinalPlaceVO_GyuBeom[1];
		
		//1등이 여러 아이일 수 있다.
		//임시 1등을 담기 위한 변수
		List<FinalPlaceVO_GyuBeom> tempNumber1s = new ArrayList<FinalPlaceVO_GyuBeom>();
		
		//최종 리스트를 받기 위한 변수 (table_id place_id tour_sequence_key_num).
		List<FinalPlaceVO_GyuBeom> afterUpdateList = new ArrayList<FinalPlaceVO_GyuBeom>();
		
		//first Standard Registration - Jeju International Airport
		v.setLati_Coord(first_lati);
		v.setLongi_Coord(first_longi);		
		now_number1_place[0] = v;
		
		//처음 고정 카운트 숫자 - 메모리 업로드. 
		int fixed_count = flist.size();
		
		//시퀀스 작업에 따라 변하는 숫자
		int change_count = 0;
		
		//rank 등수 숫자 2등 부터 시작 (1등은 공항 / 혹은 항구 등 도착지점)
		int rank = 2;
		
		//경도 최소값 -180
		double lat1 = -181;

		
		double now_number1_distance = 0;
		
		
		//start of final for
		//fixced count를 다 채울 때까지 ranking 작업 계속 반복.
		for(; afterUpdateList.size() < fixed_count;) {
			
			//북극에서 남극까지의 거리 : 18,750 km
			double standard_distance = 20000000;
			
			//start of 1st for
			//이 for문이 끝날 때까지는 1등이 바뀌면 안 된다. (비교 대상(기준)은 하기 for문 내에서 계속 changed)
			for(FinalPlaceVO_GyuBeom fvo : flist) {			
				
				change_count++;
				
				double now_Distance = Math.ceil(calDistance(now_number1_place[0].getLati_Coord()
												, now_number1_place[0].getLongi_Coord()
												, fvo.getLati_Coord()
												, fvo.getLongi_Coord()));
				
				if(now_Distance < standard_distance) {
					now_number1_distance = now_Distance;
					standard_distance = now_Distance; //1등 되는 순간 기준이 됨.
					tempNumber1s.clear(); //새로운 1등이 생기는 순간, 기존 1등 data 초기화.
					tempNumber1s.add(fvo); //1등이 여러명일 수 있다.
				}else if(now_Distance == standard_distance) {
					tempNumber1s.add(fvo); //1등이 여러명일 수 있다.
				}
				
//				//테스트
//				if(tempNumber1s.size() > 1) {
//					System.out.println("\n----------------------------------");
//					System.out.println(change_count);
//					System.out.println("----------------------------------");
//					System.out.println("현재 1등 거리 : " + standard_distance);
//					System.out.println("현재 1등 명수 : " + tempNumber1s.size());
//					for(int i = 0; i < tempNumber1s.size(); i++) {
//						System.out.println(tempNumber1s.get(i).getPlace_Id());
//						System.out.println(tempNumber1s.get(i).getPlace_Name());
//						System.out.println(tempNumber1s.get(i).getLati_Coord());
//						System.out.println(tempNumber1s.get(i).getLongi_Coord());
//						System.out.println("&");
//					}
//					System.out.println("----------------------------------\n");				
//				}else{
//					System.out.println("\n----------------------------------");
//					System.out.println(change_count);
//					System.out.println("----------------------------------");
//					System.out.println("현재 1등 거리 : " + standard_distance);
//					System.out.println("현재 1등 명수 : " + tempNumber1s.size());
//					System.out.println(tempNumber1s.get(0).getPlace_Id());
//					System.out.println(tempNumber1s.get(0).getPlace_Name());
//					System.out.println(tempNumber1s.get(0).getLati_Coord());
//					System.out.println(tempNumber1s.get(0).getLongi_Coord());
//					System.out.println("----------------------------------\n");
//				}
				
				//테스트
//				System.out.println(fvo.getPlace_Id() 
//						           + " | " + fvo.getPlace_Name()
//						           + " | " + now_Distance
//						           + " | " + fvo.getLati_Coord()
//						           + " | " + fvo.getLongi_Coord());
				
			}//end of 1st for
			
			
			//start of processing for
			//1등 구했으면 이제 담자.
			for(int i = 0; i < tempNumber1s.size(); i++) {
				tempNumber1s.get(i).setTour_Sequence_Key_Num(rank); //ranking
				tempNumber1s.get(i).setNext_Distance(standard_distance);
				rank++; //그 다음 ranking 받을 준비.
				
				//확정 리스트에 ranking이 매겨진 아이들 최종 담기.
				afterUpdateList.add(tempNumber1s.get(i));				
				
				//담았으면 이제 1등 아이는 쉬게 해주자. flist에서 제거.
				flist.remove(tempNumber1s.get(i));
								
				//경도 값이 작아질 수록 왼쪽 변두리부터 경로를 그려 더 원 모양의 경로 가능.				
				if(tempNumber1s.get(i).getLongi_Coord() < lat1) {
					//new 1등(기준) 세팅.
					now_number1_place[0].setLati_Coord(tempNumber1s.get(i).getLati_Coord());
					now_number1_place[0].setLongi_Coord(tempNumber1s.get(i).getLongi_Coord());
				}
				lat1 = tempNumber1s.get(i).getLongi_Coord();				
				
			}// end of processing for
			
			
			//test of processing 
			//(test 완료 항목 : flist remove 확인
			//               )
//			try {
//				
//				int i = 0;
//				String processing_receipt_name = "D:\\"+"tour_processing_test.txt";			
//				fw = new FileWriter(processing_receipt_name);
//								
//				for (FinalPlaceVO_GyuBeom vo : flist) {
//									
//					i++;
//					
//					//test
//					System.out.println("\n---------------------------------");
//					System.out.println("[ "+ i +" ]");
//					System.out.println("---------------------------------");
//					System.out.println(vo.getFinal_Place_Num());
//					System.out.println(vo.getPlace_Id());
//					System.out.println(vo.getPlace_Name());
//					System.out.println(vo.getTour_Sequence_Key_Num());
//					System.out.println(vo.getNext_Distance());
//					System.out.println(vo.getLati_Coord());
//					System.out.println(vo.getLongi_Coord());
//					System.out.println("---------------------------------\n\n");
//					
//					String apiString = 
//					"\n\n---------------------------------"
//					+"\n"+"[ "+ i +" ]"
//					+"\n---------------------------------"
//					+"\n"+vo.getPlace_Id()
//					+"\n---------------------------------"
//					+"\n"+"1 >>>"+vo.getFinal_Place_Num()
//					+"\n"+"2 >>>"+vo.getPlace_Id()
//					+"\n"+"3 >>>"+vo.getPlace_Name()
//					+"\n"+"4 >>>"+vo.getTour_Sequence_Key_Num()
//					+"\n"+"5 >>>"+vo.getNext_Distance()
//					+"\n"+"6 >>>"+vo.getLati_Coord()
//					+"\n"+"7 >>>"+vo.getLongi_Coord()
//					+"\n---------------------------------\n\n";				
//	                
//	                fw.append(apiString);
//				}
//				
//				fw.close();
//			}catch (Exception e) {
//				e.printStackTrace();
//			}
			
			
			
		}
		//end of final for
						
		
		//-----------------------------------------------------------		
		//FINAL TEST
		//-----------------------------------------------------------		
		try {
			
			int i = 0;
			String receipt_name = "D:\\"+"tour_logic_test.txt";			
			fw = new FileWriter(receipt_name);
			
			String apiString = "최초 요청 건수 count : " + fixed_count;
			apiString += "\n최종 처리 건수 count : " + afterUpdateList.size();
			fw.append(apiString);
			
			for (FinalPlaceVO_GyuBeom vo : afterUpdateList) {
								
				i++;
				
				//test
				System.out.println("\n---------------------------------");
				System.out.println("[ "+ i +" ]");
				System.out.println("---------------------------------");
				System.out.println(vo.getFinal_Place_Num());
				System.out.println(vo.getPlace_Id());
				System.out.println(vo.getPlace_Name());
				System.out.println(vo.getTour_Sequence_Key_Num());
				System.out.println(vo.getNext_Distance());
				System.out.println(vo.getLati_Coord());
				System.out.println(vo.getLongi_Coord());
				System.out.println("---------------------------------\n\n");
				
				apiString = 
				"\n\n---------------------------------"
				+"\n"+"[ "+ i +" ]"
				+"\n---------------------------------"
				+"\n"+vo.getPlace_Id()
				+"\n---------------------------------"
				+"\n"+"1 >>>"+vo.getFinal_Place_Num()
				+"\n"+"2 >>>"+vo.getPlace_Id()
				+"\n"+"3 >>>"+vo.getPlace_Name()
				+"\n"+"4 >>>"+vo.getTour_Sequence_Key_Num()
				+"\n"+"5 >>>"+vo.getNext_Distance()
				+"\n"+"6 >>>"+vo.getLati_Coord()
				+"\n"+"7 >>>"+vo.getLongi_Coord()
				+"\n---------------------------------\n\n";				
                
                fw.append(apiString);
			}
			
			fw.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		

		
		
		return afterUpdateList;
		
	}
	//--------------------------------------------------------
	//메소드 끝 - end of updateTourSeqKeyNum 
	//--------------------------------------------------------
	
	
	
	
	
	//latitude와 longitude를 받아 거리를 계산하는 메소드.
	public double calDistance(double lat1, double lon1, double lat2, double lon2){  
	    
	    double theta, dist;
	    
	    //경도(longitude) 간의 차이
	    theta = lon1 - lon2;  
	    
	    //라디언으로 변환 후, 디스턴스 계산
	    dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) 
	    	   + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
	    
	    //역코사인(acos)으로 변환
	    dist = Math.acos(dist);
	    
	    //라디언으로 계산된 값을 디그리로 변환
	    dist = rad2deg(dist);  
	      
	    dist = dist * 60 * 1.1515; //디그리에서 마일 거리로 변환. 
	    dist = dist * 1.609344;    // 단위 mile 에서 km 변환.  
	    dist = dist * 1000.0;      // 단위  km 에서 m 로 변환  
	  
	    return dist;
	}  
	  
	    // 주어진 도(degree) 값을 라디언으로 변환  
	private double deg2rad(double deg){  
	    return (double)(deg * Math.PI / (double)180d);  
	}  
	  
	    // 주어진 라디언(radian) 값을 도(degree) 값으로 변환  
	private double rad2deg(double rad){  
	    return (double)(rad * (double)180d / Math.PI);  
	} 
	
	public String WhatIsYourType(Object ob) {
		if (ob instanceof Integer) { 
			return "int";
		}else if (ob instanceof Double) {
			return "double";
		}else if (ob instanceof String) {
			return "String";
		}
		return "maybe... it's null";
	}
	
}
