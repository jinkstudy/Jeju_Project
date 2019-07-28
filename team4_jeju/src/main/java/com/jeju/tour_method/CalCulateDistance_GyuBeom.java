package com.jeju.tour_method;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import com.jeju.vo.FinalPlaceVO_GyuBeom;
import com.jeju.vo.PlaceNewVO;

public class CalCulateDistance_GyuBeom {
	
	//출발 - 제주 국제 공항 - 국내선터미널
	double first_lati = 33.506996;
	double first_longi = 126.492941;
	
	//카카오 api로 구한 중심 좌표
	double center_lati = 33.368957616877644;
	double center_longi = 126.52752300137345;
	
	//NNNW 의 중심 좌표 - 로직 자체를 이제부터 정확한 중심 좌표가 아니어도 경로를 잘 그려 줄 수 있도록 잤다.
	// 중심좌표로부터 지역(지경)의 꼭지점 내부 안에 있는 좌표라면 통과.
	// !다만 위 지역을 벗어나면 안 된다.
	double nnnw_center_lati = 33.437147;
	double nnnw_center_longi = 126.429909;
	
	//WWWS 의 중심 좌표 - 로직 자체를 이제부터 정확한 중심 좌표가 아니어도 경로를 잘 그려 줄 수 있도록 잤다.
	// 중심좌표로부터 지역(지경)의 꼭지점 내부 안에 있는 좌표라면 통과.
	// !다만 위 지역을 벗어나면 안 된다.
	double wwws_center_lati = 33.308499;
	double wwws_center_longi = 126.380033;
	
	//SSSE 의 중심 좌표 - 로직 자체를 이제부터 정확한 중심 좌표가 아니어도 경로를 잘 그려 줄 수 있도록 잤다.
	// 중심좌표로부터 지역(지경)의 꼭지점 내부 안에 있는 좌표라면 통과.
	// !다만 위 지역을 벗어나면 안 된다.
	double ssse_center_lati = 33.332787;
	double ssse_center_longi = 126.680943;
	
	//EEENCC 의 중심 좌표 - 로직 자체를 이제부터 정확한 중심 좌표가 아니어도 경로를 잘 그려 줄 수 있도록 잤다.
	// 중심좌표로부터 지역(지경)의 꼭지점 내부 안에 있는 좌표라면 통과.
	// !다만 위 지역을 벗어나면 안 된다.
	double eeencc_center_lati = 33.460462;
	double eeencc_center_longi = 126.710693;
	
	//테스트
	FileWriter fw;	
	
	
	
	//이 로직을 만든 후, 반환 형태만 바꿔 그대로 사용 가능.
	// 예 > 반환 형태 : public List<FinalPlaceVO_GyuBeom>
	// 예 > 반환 형태 : public List<ScheduleFinalOutputVO>	
	
	
	
	// 필요한 요소 - 시퀀스를 만들 때 (맵을 그릴 때)
	// 1. 
	// 2. area 정보 필요 - NNNW / WWWS / SSSE / EEENCC 등 세분화 되면 될 수록 더욱 세밀하게 그려짐. (단 구역으로 나누어 그릴 시, 최단 경로가 아닌 숙박 이동 중심의 경로임.)
	
	
	//--------------------------------------------------------
	//start of updateTourSeqKeyNum 메소드 시작
	//--------------------------------------------------------
	public List<FinalPlaceVO_GyuBeom> updateTourSeqKeyNumAndArea(List<FinalPlaceVO_GyuBeom> flist){
		
				
		
		//경로 순서 알고리즘 1
		//1-1. 방법에는 최단 거리를 구하는 방법 (특정 출발 지점 기준) 과 <<< 직전 지점과의 거리가 최단 거리가 아닐수도 있음.
		//1-2. 직전(이전) 거리와의 거리를 줄이는 방법이 있다.
		//위 1-2 방법 중에 내가 택한 방법은 
		//중심 좌표를 기준으로 NN, NW, WW, WS, SS, SE, EE, EN, CC
		// 9구역으로 나누고 위 지역 순으로(지역 내 순으로) 최단 거리를 구하는 것이다.
		FinalPlaceVO_GyuBeom vo = new FinalPlaceVO_GyuBeom();
		
		
		
		//구역 정보를 담기 위한 클래스 배열 리스트 변수
		//구역 정보를 가진 place들끼리 비교 예정.
		List<FinalPlaceVO_GyuBeom> area_list = new ArrayList<FinalPlaceVO_GyuBeom>();
		
		//deep copy
		area_list.addAll(flist);
		
		int max_cnt = area_list.size();
		
		for(int i = 0; i < max_cnt; i++) {
			
			//1 구역 : NNNW
			// A. NN - 중심 좌표와 비교시, 위도가 크고 경도가 같은 경우
			// B. NW - 중심 좌표와 비교시, 위도가 크고 경도가 작은 경우
			if((area_list.get(i).getLati_Coord() > center_lati) && (area_list.get(i).getLongi_Coord() <= center_longi)) {
				area_list.get(i).setDivided_by_Center("NNNW");
				//테스트
				System.out.println(area_list.get(i).getPlace_Name() + " : " + area_list.get(i).getDivided_by_Center());
			}
			
			//2구역 : WWWS
			// C. WW - 중심 좌표와 비교시, 위도가 같고 경도가 작은 경우
			// D. WS - 중심 좌표와 비교시, 위도가 작고 경도가 작은 경우
			else if((area_list.get(i).getLati_Coord() <= center_lati) && (area_list.get(i).getLongi_Coord() < center_longi)) {
				area_list.get(i).setDivided_by_Center("WWWS");
				//테스트
				System.out.println(area_list.get(i).getPlace_Name() + " : " + area_list.get(i).getDivided_by_Center());
			}
			
			//3. 구역 : SSSE
			// E. SS - 중심 좌표와 비교시, 위도가 작고 경도가 같은 경우
			// F. SE - 중심 좌표와 비교시, 위도가 작고 경도가 큰 경우
			else if((area_list.get(i).getLati_Coord() < center_lati) && (area_list.get(i).getLongi_Coord() >= center_longi)) {
				area_list.get(i).setDivided_by_Center("SSSE");
				//테스트
				System.out.println(area_list.get(i).getPlace_Name() + " : " + area_list.get(i).getDivided_by_Center());
			}
			
			//4. 구역 : EEENCC
			// G. EE - 중심 좌표와 비교시, 위도가 같고 경도가 큰 경우
			// H. EN - 중심 좌표와 비교시, 위도가 크고 경도가 큰 경우
			// I. CC - 중심 좌표와 비교시, 위도가 같고 경도가 같은 경우
			else if((area_list.get(i).getLati_Coord() >= center_lati) && (area_list.get(i).getLongi_Coord() >= center_longi)) {
				area_list.get(i).setDivided_by_Center("EEENCC");
				//테스트
				System.out.println(area_list.get(i).getPlace_Name() + " : " + area_list.get(i).getDivided_by_Center());
			}	
		}
		
		
		
		
		//4구역으로 쪼갰으면 이제 16구역으로 세분화 하자.
		for(int i = 0; i < max_cnt; i++) {
			
			// 1구역 nnnw1
			if( (area_list.get(i).getDivided_by_Center().equals("NNNW"))
			    && (area_list.get(i).getLati_Coord() >= nnnw_center_lati)
			    && (area_list.get(i).getLongi_Coord() > nnnw_center_longi) ) {
				area_list.get(i).setDivided_by_Center("NNNW1");
			}
			// 2구역 nnnw2
			else if( (area_list.get(i).getDivided_by_Center().equals("NNNW"))
				    && (area_list.get(i).getLati_Coord() > nnnw_center_lati)
				    && (area_list.get(i).getLongi_Coord() <= nnnw_center_longi) ) {
				area_list.get(i).setDivided_by_Center("NNNW2");
			}
			// 3구역 nnnw3
			else if( (area_list.get(i).getDivided_by_Center().equals("NNNW"))
				    && (area_list.get(i).getLati_Coord() <= nnnw_center_lati)
				    && (area_list.get(i).getLongi_Coord() < nnnw_center_longi) ) {
				area_list.get(i).setDivided_by_Center("NNNW3");
			}
			// 4구역 nnnw4
			else if( (area_list.get(i).getDivided_by_Center().equals("NNNW"))
				    && (area_list.get(i).getLati_Coord() < nnnw_center_lati)
				    && (area_list.get(i).getLongi_Coord() >= nnnw_center_longi) ) {
				area_list.get(i).setDivided_by_Center("NNNW4");
			}
			// 5구역 wwws5
			else if( (area_list.get(i).getDivided_by_Center().equals("WWWS"))
				    && (area_list.get(i).getLati_Coord() > wwws_center_lati)
				    && (area_list.get(i).getLongi_Coord() <= wwws_center_longi) ) {
				area_list.get(i).setDivided_by_Center("WWWS5");
			}
			// 6구역 wwws6
			else if( (area_list.get(i).getDivided_by_Center().equals("WWWS"))
				    && (area_list.get(i).getLati_Coord() <= wwws_center_lati)
				    && (area_list.get(i).getLongi_Coord() < wwws_center_longi) ) {
				area_list.get(i).setDivided_by_Center("WWWS6");
			}
			// 7구역 wwws7
			else if( (area_list.get(i).getDivided_by_Center().equals("WWWS"))
				    && (area_list.get(i).getLati_Coord() < wwws_center_lati)
				    && (area_list.get(i).getLongi_Coord() >= wwws_center_longi) ) {
				area_list.get(i).setDivided_by_Center("WWWS7");
			}
			// 8구역 wwws8
			else if( (area_list.get(i).getDivided_by_Center().equals("WWWS"))
				    && (area_list.get(i).getLati_Coord() >= wwws_center_lati)
				    && (area_list.get(i).getLongi_Coord() > wwws_center_longi) ) {
				area_list.get(i).setDivided_by_Center("WWWS8");
			}
			// 9구역ssse9
			else if( (area_list.get(i).getDivided_by_Center().equals("SSSE"))
				    && (area_list.get(i).getLati_Coord() <= ssse_center_lati)
				    && (area_list.get(i).getLongi_Coord() < ssse_center_longi) ) {
				area_list.get(i).setDivided_by_Center("SSSE9");
			}
			// 10구역ssse10
			else if( (area_list.get(i).getDivided_by_Center().equals("SSSE"))
				    && (area_list.get(i).getLati_Coord() < ssse_center_lati)
				    && (area_list.get(i).getLongi_Coord() >= ssse_center_longi) ) {
				area_list.get(i).setDivided_by_Center("SSSE10");
			}
			// 11구역ssse11
			else if( (area_list.get(i).getDivided_by_Center().equals("SSSE"))
				    && (area_list.get(i).getLati_Coord() >= ssse_center_lati)
				    && (area_list.get(i).getLongi_Coord() > ssse_center_longi) ) {
				area_list.get(i).setDivided_by_Center("SSSE11");
			}
			// 12구역ssse12
			else if( (area_list.get(i).getDivided_by_Center().equals("SSSE"))
				    && (area_list.get(i).getLati_Coord() > ssse_center_lati)
				    && (area_list.get(i).getLongi_Coord() <= ssse_center_longi) ) {
				area_list.get(i).setDivided_by_Center("SSSE12");
			}
			// 13구역 eeencc13
			else if( (area_list.get(i).getDivided_by_Center().equals("EEENCC"))
				    && (area_list.get(i).getLati_Coord() < eeencc_center_lati)
				    && (area_list.get(i).getLongi_Coord() >= eeencc_center_longi) ) {
				area_list.get(i).setDivided_by_Center("EEENCC13");
			}
			// 14구역 eeencc14
			else if( (area_list.get(i).getDivided_by_Center().equals("EEENCC"))
				    && (area_list.get(i).getLati_Coord() >= eeencc_center_lati)
				    && (area_list.get(i).getLongi_Coord() > eeencc_center_longi) ) {
				area_list.get(i).setDivided_by_Center("EEENCC14");	
			}
			// 15구역 eeencc15
			else if( (area_list.get(i).getDivided_by_Center().equals("EEENCC"))
				    && (area_list.get(i).getLati_Coord() <= eeencc_center_lati)
				    && (area_list.get(i).getLongi_Coord() < eeencc_center_longi) ) {
				area_list.get(i).setDivided_by_Center("EEENCC15");	
			}
			// 16구역 eeencc16
			else if( (area_list.get(i).getDivided_by_Center().equals("EEENCC"))
				    && (area_list.get(i).getLati_Coord() > eeencc_center_lati)
				    && (area_list.get(i).getLongi_Coord() <= eeencc_center_longi) ) {
				area_list.get(i).setDivided_by_Center("EEENCC16");
			}
			
		}
		
		
		
		
		
		
		//경로 순서 알고리즘 2
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
		
		
		
		
		
		//-----------------------------------------------------------------------
		// 이하부터 구역 정보를 가진 아이들을 가지고 진행한다.
		//-----------------------------------------------------------------------
		
		
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
		int fixed_count = area_list.size();
		
		//시퀀스 작업에 따라 변하는 숫자 - for 테스트.
		int change_count = 0;
		
		//(1등은 공항 / 혹은 항구 등 도착지점)
		//항상 로직이 이런 식으로 1등(출발지점은) 무조건 비워놓는 것으로.
		//후에는 고객이 원하는 곳이 1등으로 들어갈 수 있게.
		//rank 등수 숫자 2등 부터 시작 (아래 숫자 2 수정 금지.)
		int rank = 2;
		
		//경도 최소값 -180
		double mini_longi = -181;
		
		double now_number1_distance = 0;
		

//테스트 standard_distance
String standard_distance_log = "D:\\"+"standard_dis_log.txt";			
try {
	FileWriter sdisfw = new FileWriter(standard_distance_log);
	String s_distance = "";
		
		
	
	

	
	
	
		//start of final for
		//fixced count를 다 채울 때까지 ranking 작업 계속 반복.
		for(; afterUpdateList.size() < fixed_count;) {
			
			//북극에서 남극까지의 거리 : 18,750 km
			double standard_distance = 20000000;
			
			//start of 1st for
			//이 for문이 끝날 때까지는 1등이 바뀌면 안 된다. (비교 대상(기준)은 하기 for문 내에서 계속 changed)
			//구역 정보를 가진 아이들을 가지고 비교한다.
			for(FinalPlaceVO_GyuBeom fvo : area_list) {			
				
				//테스트용 숫자.
				change_count++;
				
				String d_Area = fvo.getDivided_by_Center();
				
				//출발점(공항)이 거의 north에 있기 때문에
				//기존 area_list.remove(tempNumber1s.get(i));에서 하나씩 제거해주기 때문에 가능한 로직.
				//NNNW 구역 부터 시작.
				if(d_Area.equals("NNNW")) {
					
				}
				
				
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
				
				//테스트
//				System.out.println("------------------------------");
//				System.out.println("standard_distance" + standard_distance);
//				System.out.println("now_Distance" + now_Distance);
//				System.out.println("------------------------------\n");
				
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

			
//테스트 standard_distance
//자바에서 "\n" 엔터 쳐도 메모장에 엔터 안 쳐지니까
//다음부터 이 것 때문에 밤 새지 마세요.
s_distance = Double.toString(standard_distance);
System.out.println("-------------------------");
System.out.println("part standard distance : " + Double.toString(standard_distance));
System.out.println("-------------------------\n");
s_distance += "\n";
sdisfw.append(s_distance);

			
			int max = tempNumber1s.size();
			//start of processing for
			//1등 구했으면 이제 담자.
			for(int i = 0; i < max; i++) {
				
				//다수 1등 확인 여부 test
				System.out.println("--------------------------------------");
				System.out.println("다수 1등 확인 여부 test");
				System.out.println("--------------------------------------");
				System.out.println(tempNumber1s.get(i).getLati_Coord());
				System.out.println(tempNumber1s.get(i).getLongi_Coord());
				
				tempNumber1s.get(i).setTour_Sequence_Key_Num(rank); //ranking
				tempNumber1s.get(i).setFore_Distance(standard_distance);
				rank++; //그 다음 ranking 받을 준비.
				
				//확정 리스트에 ranking이 매겨진 아이들 최종 담기.
				afterUpdateList.add(tempNumber1s.get(i));				
				
				//담았으면 이제 1등 아이는 쉬게 해주자. area_list에서 제거.
				area_list.remove(tempNumber1s.get(i));
				
			}// end of processing for
			System.out.println("--------------------------------------\n");
			
			//new 1등(기준) 세팅.
			now_number1_place[0].setLati_Coord(tempNumber1s.get(max-1).getLati_Coord());
			now_number1_place[0].setLongi_Coord(tempNumber1s.get(max-1).getLongi_Coord());
			
			
			
			//test of processing 
			//(test 완료 항목 : area_list remove 확인
			//               )
//			try {
//				
//				int i = 0;						
//				String processing_receipt_name = "D:\\"+"tour_processing_test.txt";			
//				fw = new FileWriter(processing_receipt_name);
//								
//				for (FinalPlaceVO_GyuBeom vo : area_list) {
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

		
//테스트 standard_distance
sdisfw.close();
} catch (IOException e) {
	e.printStackTrace();
}

		
		//-----------------------------------------------------------		
		//FINAL TEST
		//-----------------------------------------------------------		
//		try {
//		
//			int i = 0;
//			String receipt_name = "D:\\"+"tour_logic_test.txt";			
//			fw = new FileWriter(receipt_name);			
//			
//			String apiString = "최초 요청 건수 count : " + fixed_count;
//			apiString += "\n최종 처리 건수 count : " + afterUpdateList.size();
//			fw.append(apiString);
//			
//			for (FinalPlaceVO_GyuBeom vo : afterUpdateList) {
//								
//				i++;
//				
//				//test
//				System.out.println("\n---------------------------------");
//				System.out.println("[ "+ i +" ]");
//				System.out.println("---------------------------------");
//				System.out.println(vo.getFinal_Place_Num());
//				System.out.println(vo.getPlace_Id());
//				System.out.println(vo.getPlace_Name());
//				System.out.println(vo.getTour_Sequence_Key_Num());
//				System.out.println(vo.getFore_Distance());
//				System.out.println(vo.getLati_Coord());
//				System.out.println(vo.getLongi_Coord());
//				System.out.println("---------------------------------\n\n");
//				
//				apiString = 
//				"\n\n---------------------------------"
//				+"\n"+"[ "+ i +" ]"
//				+"\n---------------------------------"
//				+"\n"+vo.getPlace_Id()
//				+"\n---------------------------------"
//				+"\n"+"1 >>>"+vo.getFinal_Place_Num()
//				+"\n"+"2 >>>"+vo.getPlace_Id()
//				+"\n"+"3 >>>"+vo.getPlace_Name()
//				+"\n"+"4 >>>"+vo.getTour_Sequence_Key_Num()
//				+"\n"+"5 >>>"+vo.getFore_Distance()
//				+"\n"+"6 >>>"+vo.getLati_Coord()
//				+"\n"+"7 >>>"+vo.getLongi_Coord()
//				+"\n---------------------------------\n\n";				
//                
//                fw.append(apiString);
//			}
//			
//			fw.close();
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
		

		
		//시퀀스 업데이트 완료 리스트 - 리턴!
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
	
	//나만의 자료형 타입 확인하기 - 규범.
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

