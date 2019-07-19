package com.jeju.tour_method;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.jeju.vo.PlaceNewVO;

public class GetAPI {


	StringBuilder sb = null ;
	BufferedReader rd = null;
	HttpURLConnection conn = null;
	String baseUrl="http://api.visitkorea.or.kr/openapi/service/rest/KorService/";
	StringBuilder urlBuilder = null;  /*URL*/
	String serviceKey="IV2iM5P1kI0MHEiFd4nBauHiRAOzgoa9ZRUrhvxanXwo9mmLOMYbfRYDn5QBAQEZE7Npqnax%2BEFr3iNsTs9jUQ%3D%3D";



	//////////////////////////////////////////////////////////////////////////////////////////

	
	public GetAPI(){

		System.out.println("시작");
		System.out.println("==========================");
	}


	//API 전체 data parcing 해서 ArrayList에 담기 
	public List<PlaceNewVO> parce()  {
		PlaceNewVO vo=null;
		List<PlaceNewVO> PlaceListArray = new ArrayList<PlaceNewVO>();
		try {
			String json = getApi_areaBasedList();
			JSONObject items=jsonparce(json);
			JSONArray item = (JSONArray)items.get("item");

			System.out.println("==========================");

			for(int i = 0,k=0 ; i <item.size(); i++){
			//for(int i = 126 ,k=0 ; i < 156; i++){
				JSONObject entity = (JSONObject)item.get(i);

				String contenttypeid=(String.valueOf(entity.get("contenttypeid")));
				
				if(!(contenttypeid.equals("25")) && !(contenttypeid.equals("32"))) {
					k++;
					vo=new PlaceNewVO();
					
					String contentid = (String.valueOf(entity.get("contentid")));

					// vo - db table col
					//setPlace_Id - PLACE_ID
					vo.setPlace_Id(String.valueOf(entity.get("contentid")));

					//place_Name
					vo.setPlace_Name(String.valueOf(entity.get("title")));


					vo.setImage_Path(String.valueOf(entity.get("firstimage")));

					//Double.parseDouble(String.valueOf(entity.get("mapx")));
					if(entity.get("mapx") !=null) {
						vo.setLongi_Coord(Double.parseDouble(String.valueOf(entity.get("mapx"))));
						vo.setLati_Coord(Double.parseDouble(String.valueOf(entity.get("mapy"))));
					}

					vo.setPlace_Tel(String.valueOf(entity.get("tel")));
					vo.setPlace_Addr(String.valueOf(entity.get("addr1")));


					String cat1 =(String.valueOf(entity.get("cat1")));
					String cat2 =(String.valueOf(entity.get("cat2")));
					String cat3 =(String.valueOf(entity.get("cat3")));

					vo.setMiddle_Num(getMiddle_Num(cat1,cat2,cat3));

					System.out.println("==========================");
					System.out.println(k);


					//contentid,contenttypeid로 세부정보 가져오기.
					String json1 = getApi_detailIntro(contentid,contenttypeid);
					JSONObject items1=jsonparce(json1);
					JSONObject item1 = (JSONObject)items1.get("item");
					
					String json2=get_Infotext(contentid,contenttypeid);
					JSONObject items2=jsonparce(json2);
					JSONObject item2 = (JSONObject)items2.get("item");
					
					//15번 데이터 : overview
					String overView;
					String shortOverView = null;
					
					if((String.valueOf(item2.get("overview"))) instanceof String) {
						overView = String.valueOf(item2.get("overview"));
						if(overView != null && overView.contains(".")) {
							int idx = overView.indexOf(".") + 1;
							shortOverView = overView.substring(0, idx); 
						}
					}else {
						overView = null;
					}					
					
					
					vo.setPlace_Det(shortOverView);
					//System.out.println(vo.getPlace_Det());
					
					
					//14번 데이터 : usetimeculture
					String useTimeCulture;
					if((String.valueOf(item1.get("usetimeculture"))) instanceof String) {
						useTimeCulture = String.valueOf(item1.get("usetimeculture"));
					}else {
						useTimeCulture = null;
					}
					
					//14번 데이터 : infoCenterCul			
					String infoCenterCul;
					if((String.valueOf(item1.get("infocenterculture"))) instanceof String) {
						infoCenterCul = String.valueOf(item1.get("infocenterculture"));
					}else {
						infoCenterCul = null;
					}
					
					//14번 데이터 : restDateCul				
					String restDateCul;
					if((String.valueOf(item1.get("restdateculture"))) instanceof String) {
						restDateCul = String.valueOf(item1.get("restdateculture"));
					}else {
						restDateCul = null;
					}
					
					
					//28번 데이터 : infoCenterLepo					
					String infoCenterLepo;
					if((String.valueOf(item1.get("infocenterleports"))) instanceof String) {
						infoCenterLepo = String.valueOf(item1.get("infocenterleports"));
					}else {
						infoCenterLepo = null;
					}
					
					//28번 데이터 : restDateLepo						
					String restDateLepo;
					if((String.valueOf(item1.get("restdateleports"))) instanceof String) {
						restDateLepo = String.valueOf(item1.get("restdateleports"));
					}else {
						restDateLepo = null;
					}
					
					
					//38번 데이터 : opentime
					String openTime;
					if((String.valueOf(item1.get("opentime"))) instanceof String) {
						openTime = String.valueOf(item1.get("opentime"));
					}else {
						openTime = null;
					}
					
					//38번 데이터 : infoCenterShopping
					String infoCenterShopping;
					if((String.valueOf(item1.get("infocentershopping"))) instanceof String) {
						infoCenterShopping = String.valueOf(item1.get("infocentershopping"));
					}else {
						infoCenterShopping = null;
					}
					
					//38번 데이터 : restDateShopping					
					String restDateShopping;
					if((String.valueOf(item1.get("restdateshopping"))) instanceof String) {
						restDateShopping = String.valueOf(item1.get("restdateshopping"));
					}else {
						restDateShopping = null;
					}
					
					//39번 데이터 : openTimeFood
					String openTimeFood;
					if((String.valueOf(item1.get("opentimefood"))) instanceof String) {
						openTimeFood = String.valueOf(item1.get("opentimefood"));
					}else {
						openTimeFood = null;
					}
					
					//39번 데이터 : firstMenu
					String firstMenu;
					if((String.valueOf(item1.get("firstmenu"))) instanceof String) {
						firstMenu = String.valueOf(item1.get("firstmenu"));
					}else {
						firstMenu = null;
					}
					
					//39번 데이터 : infoCenterFood					
					String infoCenterFood;
					if((String.valueOf(item1.get("infocenterfood"))) instanceof String) {
						infoCenterFood = String.valueOf(item1.get("infocenterfood"));
					}else {
						infoCenterFood = null;
					}
					
					//39번 데이터 : restDateFood
					String restDateFood;
					if((String.valueOf(item1.get("restdatefood"))) instanceof String) {
						restDateFood = String.valueOf(item1.get("restdatefood"));
					}else {
						restDateFood = null;
					}
					
					//default 데이터 : useTim
					String useTim;
					if((String.valueOf(item1.get("usetime"))) instanceof String) {
						useTim = String.valueOf(item1.get("usetime"));
					}else {
						useTim = null;
					}
					
					
					//default 데이터 : infoCenter					
					String infoCenter;
					if((String.valueOf(item1.get("infocenter"))) instanceof String) {
						infoCenter = String.valueOf(item1.get("infocenter"));
					}else {
						infoCenter = null;
					}
					
					//default 데이터 : restDate					
					String restDate;
					if((String.valueOf(item1.get("restdate"))) instanceof String) {
						restDate = String.valueOf(item1.get("restdate"));
					}else {
						restDate = null;
					}
					
//					vo.setClose_Day(null);
//					vo.setUse_Time(null);
//					vo.setInfo_Center(null);
//					vo.setOpen_Date(null);
//					vo.setUse_Season(null);
//					vo.setTour_Hour("1");
//					vo.setPlace_Price("");
//					vo.setEvent_S_Date(null);
//					vo.setEvent_E_Date(null);
//					vo.setEvent_Homepage(null);
//					vo.setEvent_Place(null);
//					vo.setPlay_Time(null);

					switch (String.valueOf(item1.get("contenttypeid"))) {

					case "14": 
						vo.setClose_Day(restDateCul);
						vo.setUse_Time(useTimeCulture);
						//주석 처리 한 것들 풀지 마세요.
						//vo.setTour_Hour(String.valueOf(item1.get("spendtime")));
						//vo.setPlace_Price(String.valueOf(item1.get("usefee")));
						vo.setInfo_Center(infoCenterCul);
						//list1 = new ArrayList<String>( Arrays.asList("restdateculture","usetimeculture","spendtime","usefee","infocenterculture"));break;
					case "15":
						//vo.setTour_Hour(String.valueOf(item1.get("spendtimefestival")));
						//vo.setPlace_Price(String.valueOf(item1.get("usefeefestival")));
						vo.setEvent_S_Date(String.valueOf(item1.get("eventstartdate")));
						vo.setEvent_E_Date(String.valueOf(item1.get("eventenddate")));
						vo.setEvent_Homepage(String.valueOf(item1.get("eventhomepage")));
						vo.setEvent_Place(String.valueOf(item1.get("eventplad")));
						vo.setPlay_Time(String.valueOf(item1.get("playtime")));

						//list1 =  new ArrayList<String>(Arrays.asList("spendtimefestival","usefeefestival","eventstartdate","eventenddate","eventhomepage","eventplad","playtime"));break;
					case "28": 
						vo.setClose_Day(restDateLepo);
						vo.setPlace_Price(String.valueOf(item1.get("usefeeleports")));
						vo.setInfo_Center(infoCenterLepo);
						vo.setUse_Season(String.valueOf(item1.get("openperiod")));

						//list1 = new ArrayList<String>(Arrays.asList("restdateleports","usefeeleports","infocenterleports","openperiod"));break;
					case "38": 
						vo.setClose_Day(restDateShopping);
						vo.setUse_Time(openTime);
						vo.setInfo_Center(infoCenterShopping);
						vo.setOpen_Date(String.valueOf(item1.get("opendateshopping")));

						//list1 =  new ArrayList<String>(Arrays.asList("restdateshopping","opentime","infocentershopping","opendateshopping"));break;
					case "39": 
						vo.setClose_Day(restDateFood);
						vo.setUse_Time(openTimeFood);
						vo.setPlace_Det(firstMenu);
						vo.setInfo_Center(infoCenterFood);

						//list1 = new ArrayList<String>(Arrays.asList("restdatefood","opentimefood","firstmenu","treatmenu","infocenterfood"));break;	

					default: 
						vo.setClose_Day(restDate);
						vo.setUse_Time(useTim);
						vo.setInfo_Center(infoCenter);
						vo.setOpen_Date(String.valueOf(item1.get("opendate")));
						vo.setUse_Season(String.valueOf(item1.get("useseason")));


						//list1 =new ArrayList<String>( Arrays.asList("restdate","usetime","overview","infocenter","opendate","useseason"));
						break;
					}
					//System.out.println("vo.담기 2단계 성공");

					System.out.println(vo.toString());


					System.out.println("==========================");
					PlaceListArray.add(vo);
				}
				//System.out.println(PlaceListArray.get(i).toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}


		return PlaceListArray;
	}


	//DB중분류코드와 API중분류 코드 MAPPING
	public int getMiddle_Num(String cat1,String cat2,String cat3) {
		int middle_num=13;
		if(cat3.equals("A05020900")||cat3.equals("A05021000")) {
			middle_num=1;
		}else if(cat3.equals("A05020300")) {
			middle_num=2;
		}else if(cat3.equals("A05020200")||cat3.equals("A05020600")) {
			middle_num=3;
		}else if(cat3.equals("A05020100")) {
			middle_num=4;
		}else if(cat3.equals("A05020400")) {
			middle_num=5;
		}else if(cat3.equals("A05020500")||cat3.equals("A05020700")||cat3.equals("A05020800")) {
			middle_num=6;
		}else if(cat2.equals("A0303")) {
			middle_num=7;
		}else if(cat2.equals("A0302")||cat2.equals("A0304")) {
			middle_num=8;
		}else if(cat2.equals("A0203")) {
			middle_num=9;
		}else if(cat2.equals("A0206")) {
			middle_num=10;
		}else if(cat2.equals("A0208")) {
			middle_num=11;
		}else if(cat2.equals("A0207")) {
			middle_num=12;
		}else if(cat3.equals("A01011100")||cat3.equals("A01011200")||cat3.equals("A01011400")||cat3.equals("A01011500")||cat3.equals("A01011600")) {
			middle_num=14;
		}else if(cat2.equals("A0201")) {
			middle_num=15;
		}else if(cat2.equals("A0101")) {
			middle_num=16;
		}else if(cat1.equals("A04")) {
			middle_num=17;
		}else if(cat2.equals("A0202")) {
			middle_num=18;
		}else {
			middle_num=13;
		}
		return middle_num;
	}




	//API Json 파싱
	public JSONObject jsonparce(String json) {
		JSONParser jsonparser = new JSONParser();
		JSONObject jsonobject;
		JSONObject items=new JSONObject();
		try {
			jsonobject = (JSONObject)jsonparser.parse(json);
			JSONObject response =  (JSONObject) jsonobject.get("response");
			JSONObject body =  (JSONObject) response.get("body");
			items =  (JSONObject) body.get("items");

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return items;
	}



	//지역 기반 관광정보 조회 API활용
	public String getApi_areaBasedList() throws Exception {

		try {
			urlBuilder = new StringBuilder(baseUrl);
			urlBuilder.append("areaBasedList");
			urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "="+serviceKey); /*Service Key*/
			urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("1032", "UTF-8")); /*한 페이지 결과 수*/
			urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
			urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS (아이폰), AND (안드로이드),WIN (원도우폰), ETC*/
			urlBuilder.append("&" + URLEncoder.encode("arrange","UTF-8") + "=" + URLEncoder.encode("O", "UTF-8")); /*(A=제목순, B=조회순, C=수정일순, D=생성일순) , 대표이미지가 반드시 있는 정렬 (O=제목순, P=조회순, Q=수정일순, R=생성일순)*/
			urlBuilder.append("&" + URLEncoder.encode("areaCode","UTF-8") + "=" + URLEncoder.encode("39", "UTF-8")); /*지역코드*/
			urlBuilder.append("&" + URLEncoder.encode("listYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*목록 구분 (Y=목록, N=개수)*/
			urlBuilder.append("&_type=json");
			URL url = new URL(urlBuilder.toString());
			System.out.println(url);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			System.out.println("Response code: " + conn.getResponseCode());
			//int i =0;
			if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				//i++;
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
			sb = new StringBuilder();
			String line;

			while ((line = rd.readLine()) != null) {
				//System.out.println(i);
				sb.append(line);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			rd.close();
			conn.disconnect();
			//System.out.println(sb.toString());
		}

		return sb.toString();
	}


	//공통정보조회 API 활용
	public String getApi_detailIntro(String contentId,String contenttypeid) throws Exception {
		try {
			urlBuilder = new StringBuilder(baseUrl);
			urlBuilder.append("detailIntro"); /*URL*/
			urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "="+serviceKey); /*Service Key*/
			urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS (아이폰), AND (안드로이드), WIN (원도우폰), ETC*/
			urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
			urlBuilder.append("&" + URLEncoder.encode("contentId","UTF-8") + "=" + URLEncoder.encode(contentId, "UTF-8")); /*콘텐츠 ID*/
			urlBuilder.append("&" + URLEncoder.encode("contentTypeId","UTF-8") + "=" + URLEncoder.encode(contenttypeid, "UTF-8")); /*관광타입(관광지, 숙박 등) ID*/
			urlBuilder.append("&_type=json");

			URL url = new URL(urlBuilder.toString());
			System.out.println("2"+url);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			System.out.println("Response code: " + conn.getResponseCode());

			if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
			sb = new StringBuilder();
			String line;
			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}

		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			rd.close();
			conn.disconnect();
			System.out.println(sb.toString());
		}
		return sb.toString();
	}
	
	public String get_Infotext(String contentId,String contenttypeid) throws Exception {

		urlBuilder = new StringBuilder(baseUrl);
		urlBuilder.append("detailCommon"); /*URL*/
		urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "="+serviceKey); 
	    urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS(아이폰),AND(안드로이드),WIN(원도우폰),ETC*/
	    urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
	   urlBuilder.append("&" + URLEncoder.encode("contentId","UTF-8") + "=" + URLEncoder.encode(contentId, "UTF-8")); /*콘텐츠 ID*/
	    urlBuilder.append("&" + URLEncoder.encode("contentTypeId","UTF-8") + "=" + URLEncoder.encode(contenttypeid, "UTF-8")); /*관광타입(관광지, 숙박 등)ID*/
	    urlBuilder.append("&" + URLEncoder.encode("defaultYN","UTF-8") + "=" + URLEncoder.encode("N", "UTF-8")); /*기본정보 조회여부*/
        urlBuilder.append("&" + URLEncoder.encode("firstImageYN","UTF-8") + "=" + URLEncoder.encode("N", "UTF-8")); /*원본, 썸네일 대표이미지 조회여부*/
        urlBuilder.append("&" + URLEncoder.encode("areacodeYN","UTF-8") + "=" + URLEncoder.encode("N", "UTF-8")); /*지역코드, 시군구코드 조회여부*/
        urlBuilder.append("&" + URLEncoder.encode("catcodeYN","UTF-8") + "=" + URLEncoder.encode("N", "UTF-8")); /*대,중,소분류코드 조회여부*/
        urlBuilder.append("&" + URLEncoder.encode("addrinfoYN","UTF-8") + "=" + URLEncoder.encode("N", "UTF-8")); /*주소, 상세주소 조회여부*/
        urlBuilder.append("&" + URLEncoder.encode("mapinfoYN","UTF-8") + "=" + URLEncoder.encode("N", "UTF-8")); /*좌표 X,Y 조회여부*/
        urlBuilder.append("&" + URLEncoder.encode("overviewYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*콘텐츠 개요 조회여부*/
        urlBuilder.append("&_type=json");

	        URL url = new URL(urlBuilder.toString());
	        System.out.println(url);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type", "application/json");
	        System.out.println("Response code: " + conn.getResponseCode());
	        BufferedReader rd;
	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        } else {
	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	        }
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = rd.readLine()) != null) {
	            sb.append(line);
	        }
	        rd.close();
	        conn.disconnect();

	       // System.out.println(sb.toString());

	    return sb.toString();

	}



//		public static void main(String[] args) {
//			try {
//				GetAPI cis = new GetAPI();
//				cis.parce();
//				System.out.println("끝");
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}




}
