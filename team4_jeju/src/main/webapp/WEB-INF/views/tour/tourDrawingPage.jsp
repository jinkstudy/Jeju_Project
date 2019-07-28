<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<META HTTP-EQUIV="Page-exit" CONTENT="BlendTrans(Duration=0.5)">
<META HTTP-EQUIV="Page-Enter" CONTENT="BlendTrans(Duration=0.5)">

<title>Insert title here</title>

<!-- 카카오 map 링크 -->
<script type="text/javascript"
	    src="//dapi.kakao.com/v2/maps/sdk.js?appkey=95e85aa66afbc7aaf828aa2355f1eb56"></script>

<!-- jQuery 링크 -->
<script src="../resources/js/jquery-3.4.1.js"></script>

<!-- 카카오 map_gyubeom coding 링크 -->
<script src="/team4_jeju/resources/js/map_gyubeom.js"></script>



<link rel="stylesheet"
	  href="/team4_jeju/resources/style/map_gyubeom.css" type="text/css">
<!-- 진경 투어 css -->
<link type="text/css" rel="stylesheet"
	href="/team4_jeju/resources/style/tourSch_jink.css" />
	
<!--   진경 타임테이블 관련 링크 -->
<link rel="stylesheet" href="/team4_jeju/resources/style/jquery.skeduler.css" type="text/css">
<link href="http://www.jqueryscript.net/css/jquerysctipttop.css" rel="stylesheet" type="text/css">

<!-- 진경 pdf관련 -->
<script src="https://unpkg.com/jspdf@latest/dist/jspdf.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/0.4.1/html2canvas.min.js"></script>	

<script type="text/javascript">

var arr = new Array();
var arrlist = new Array();    

<c:forEach items="${onlyFinalResult}" var="f_draw" varStatus="status">
		arr = [];
		arr.push("${f_draw.place_NAME}");
		arr.push("${f_draw.longi_COORD}");
		arr.push("${f_draw.lati_COORD}");
		arr.push("${f_draw.s_out_SEQUENCE}");
		console.log('1차 jstl test' + arr);		
		arrlist.push(arr);		
</c:forEach>

/* 
arr = ['a', 126.570677, 33.450705];
arrlist.push(arr);
arr = ['b', 126.492810, 33.5066211];
arrlist.push(arr);
arr = ['c', 126.322529, 33.2906595];
arrlist.push(arr);
*/

$(function(){
	
	
	
	changeMaptype = kakao.maps.MapTypeId.SKYVIEW;
	map.addOverlayMapTypeId(changeMaptype);
	
	
	
	//map draw start - All Thanks to You.
	var distanceOverlay; // 선의 거리정보를 표시할 커스텀오버레이 입니다 
    var dots = {}; // 선이 그려지고 있을때 클릭할 때마다 클릭 지점과 거리를 표시하는 커스텀 오버레이 배열입니다.
 	
    //출발 지점 등록
    var depart_arr = ['제주 국제 공항', 126.492941, 33.506996];
    arrlist.unshift(depart_arr); //배열 가장 앞 push = unshift.
    
  	//시작 지점 마커 생성
	var startImgSrc = '/team4_jeju/resources/imgs/map_gyubeom/start_marker_gyubeom.png';
	var startImgSize = new kakao.maps.Size(50, 50);
	//마커의 좌표와 일치시킬 이미지 안에서의 좌표
	var startImgOption = {offset : new kakao.maps.Point(-10, 50)};
	
	//테스트
	console.log(depart_arr[2]);
	console.log(depart_arr[1]);
	
	//var startMarkerImg = new kakao.maps.MarkerImage(startImgSrc, startImgSize, startImgOption);
	var startMarkerImg = new kakao.maps.MarkerImage(startImgSrc, startImgSize);
	startMarkerPosition = new kakao.maps.LatLng(depart_arr[2], depart_arr[1]);
	
	var start_Marker = new kakao.maps.Marker({
	    position: startMarkerPosition, 
	    image: startMarkerImg // 마커이미지 설정 
	});

	// 마커가 지도 위에 표시되도록 설정합니다
	start_Marker.setMap(map);
    
    //마커를 표시할 위치와 title 객체 배열입니다 
    var positions = new Array();
    var each_posi = {};
    
    //테스트
    //console.log('2차 : data - js로 넘겨받은 직후' + arrlist);
    
    for(var i = 0, max =  arrlist.length; i < max; i++){
    	each_posi = {
    			content : '<div>'+arrlist[i][0]+'</div>'
    			, latlng : new daum.maps.LatLng(arrlist[i][2], arrlist[i][1])
    	};
    	//테스트
        //console.log('3차 : data - json 형태' + each_posi.content 
        //		                           + ' | ' + each_posi.latlng);
    	
    	positions.push(each_posi);
    	
    }
    
    
    
    // 마커 이미지의 이미지 주소입니다
    var imageSrc = "/team4_jeju/resources/imgs/map_gyubeom/blue_circle.png";
 
    for (var i = 0, max= positions.length; i < max; i++) {
    	
    	//테스트
        console.log('4차 : data - json 배열 형태' + positions[i].content 
        		                           + ' | ' + positions[i].latlng);
 
        // 마커 이미지의 이미지 크기 입니다
        var imageSize = new daum.maps.Size(15, 15);
 
        // 마커 이미지를 생성합니다    
        var markerImage = new daum.maps.MarkerImage(imageSrc, imageSize);
 
        // 마커를 생성합니다
        var marker = new daum.maps.Marker({
            map : map, // 마커를 표시할 지도
            position : positions[i].latlng, // 마커를 표시할 위치
            image : markerImage // 마커 이미지         
        });
        
        // 마커에 표시할 인포윈도우를 생성합니다 
        var infowindow = new kakao.maps.InfoWindow({
            content: positions[i].content // 인포윈도우에 표시할 내용
        });
        
        kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
        kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
        
        
    }
 
    // 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
    function makeOverListener(map, marker, infowindow) {
        return function() {
            infowindow.open(map, marker);
        };
    }

    // 인포윈도우를 닫는 클로저를 만드는 함수입니다 
    function makeOutListener(infowindow) {
        return function() {
            infowindow.close();
        };
    }
    
    
    //start of drawing
    var linePath;
    var lineLine = new daum.maps.Polyline();
    //distance 는 반드시 '숫자'로 초기화 해 줄 것.
    var distance = 0;
 
    for (var i = 0, max=positions.length; i < max; i++) {
        if (i != 0) {
            linePath = [ positions[i - 1].latlng, positions[i].latlng ] //라인을 그리려면 두 점이 있어야하니깐 두 점을 지정했습니다
        }
        ;
        lineLine.setPath(linePath); // 선을 그릴 라인을 세팅합니다
 
        var drawLine = new daum.maps.Polyline({
        	map: map, // 선을 표시할 지도입니다 
        	path : linePath, // 선을 구성하는 좌표 배열입니다 클릭한 위치를 넣어줍니다
            strokeWeight: 3, // 선의 두께입니다 
            strokeColor: '#518DFF', // 선의 색깔입니다
            strokeOpacity: 1, // 선의 불투명도입니다 0에서 1 사이값이며 0에 가까울수록 투명합니다
            strokeStyle: 'solid' // 선의 스타일입니다
        });
 
        distance += Math.round(lineLine.getLength());
        //distance 테스트
        //console.log(distance);
        displayCircleDot(positions[i].latlng, 0);
        
        if(i == max-1){
        	displayCircleDot(positions[i].latlng, distance);
        }
         
    }
    
    function displayCircleDot(position, distance) {

	    if (distance > 0) {
	        // 클릭한 지점까지의 그려진 선의 거리를 표시할 커스텀 오버레이를 생성합니다
	        var distanceOverlay = new kakao.maps.CustomOverlay({
	            //content: '<div class="dotOverlay">거리 <span class="number">' + distance + '</span>m</div>',
	        	content : getTimeHTML(distance)
	            , position: position
	            , yAnchor: 1.2
	            , zIndex: 2
	        });

	        //지도에 표시합니다
	        distanceOverlay.setMap(map);
	    }
	}
    
    
	// 선 그리가 종료됐을 때 선의 정보를 표시하는 커스텀 오버레이를 생성하고 지도에 표시하는 함수입니다
	function showDistance(content, position) {
	    
	    if (distanceOverlay) { // 커스텀오버레이가 생성된 상태이면
	        
	        // 커스텀 오버레이의 위치와 표시할 내용을 설정합니다
	        distanceOverlay.setPosition(position);
	        distanceOverlay.setContent(content);
	        
	    } else { // 커스텀 오버레이가 생성되지 않은 상태이면
	        
	        // 커스텀 오버레이를 생성하고 지도에 표시합니다
	        distanceOverlay = new kakao.maps.CustomOverlay({
	            map: map, // 커스텀오버레이를 표시할 지도입니다
	            content: content,  // 커스텀오버레이에 표시할 내용입니다
	            position: position, // 커스텀오버레이를 표시할 위치입니다.
	            xAnchor: 0,
	            yAnchor: 0,
	            zIndex: 3  
	        });      
	    }
	}
	
	// 마우스 우클릭 하여 선 그리기가 종료됐을 때 호출하여 
	// 그려진 선의 총거리 정보와 거리에 대한 도보, 자전거 시간을 계산하여
	// HTML Content를 만들어 리턴하는 함수입니다
	function getTimeHTML(distance) {
		
	    // 도보의 시속은 평균 4km/h 이고 도보의 분속은 67m/min입니다
	    var walkkTime = distance / 67 | 0;
	    var walkHour = '', walkMin = '';

	    // 계산한 도보 시간이 60분 보다 크면 시간으로 표시합니다
	    if (walkkTime > 60) {
	        walkHour = '<span class="number">' + Math.floor(walkkTime / 60) + '</span>시간 '
	    }
	    walkMin = '<span class="number">' + walkkTime % 60 + '</span>분'

	    
	    // 자전거의 평균 시속은 16km/h 이고 이것을 기준으로 자전거의 분속은 267m/min입니다
	    var bycicleTime = distance / 227 | 0;
	    var bycicleHour = '', bycicleMin = '';

	    // 계산한 자전거 시간이 60분 보다 크면 시간으로 표출합니다
	    if (bycicleTime > 60) {
	        bycicleHour = '<span class="number">' + Math.floor(bycicleTime / 60) + '</span>시간 '
	    }
	    bycicleMin = '<span class="number">' + bycicleTime % 60 + '</span>분'
	    	     

	    //(아래 정보 출처) 제주 신문 - 한라 일보 
	    //경찰이 추진하고 있는 제한속도 하향 조정방침을 보면 과속 사고가 많은 평화로의 경우 현재 시속 80km에서 70km로 10km 낮출 예정입니다.
	    //제주시내 동서광로는 시속 70km에서 60km로, 연북로와 노형로 도령로도 70에서 60km로 하향 조정합니다. 
	    //평화로 80km에서 70km로, 동서광로 70km에서 60km로, 대략 60km가 안전한 속도로 볼 수 있음.
	    //제주도에서의 평균 시속은 60km/h 이고 이것을 기준으로 제주도에서의 자동차 분속은 1000m/min입니다
	    var withCarTime = distance / 1000 | 0;
	    var withCarHour = '', withCarMin = '';

	    // 계산한 자전거 시간이 60분 보다 크면 시간으로 표출합니다
	    if (withCarTime > 60) {
	    	withCarHour = '<span class="number">' + Math.floor(withCarTime / 60) + '</span>시간 '
	    }
	    withCarMin = '<span class="number">' + withCarTime % 60 + '</span>분'

	    // 거리와 도보 시간, 자전거 시간을 가지고 HTML Content를 만들어 리턴합니다
	    var content = '<ul class="dotOverlay distanceInfo">';
	    content += '    <li>';
	    content += '        <span class="label">일주시 총&nbsp;</span><span class="number">' + distance + '</span>m';
	    content += '    </li>';
	    content += '    <li>';
	    content += '        <span class="label">도보</span>' + walkHour + walkMin;
	    content += '    </li>';
	    content += '    <li>';
	    content += '        <span class="label">자전거</span>' + bycicleHour + bycicleMin;
	    content += '    </li>';
	    content += '    <li>';
	    content += '        <span class="label">자동차</span>' + withCarHour + withCarMin;
	    content += '    </li>';
	    content += '</ul>'

	    return content;
	    
	}
    
    
});

</script>


</head>


<body onload="switchScreen();">

<div id="divLoading" style="position:absolute; top:25rem; left:0; width:100%; text-align:center; margin:0 auto;">
	<img src="/team4_jeju/resources/imgs/image_gyubeom/loading_gyubeom.gif"
	     alt="" />
	나만의 여행 생성중...
</div>

	<!-- header -->
	<jsp:include page="../main/header_of_main.jsp"></jsp:include>
	
	<!-- 진경 투어 js -->
<script src="/team4_jeju/resources/js/tourSch_jink.js"></script>
	
<!--  진경 타임테이블  -->
    <script src="/team4_jeju/resources/js/jquery.skeduler.js"></script>
    <script src="/team4_jeju/resources/js/main_timetable.js"></script>
	<!-- start of map title -->
	<div class="text-white text-center"
	     id="jeju-map-head">
	     <hr class="jeju-hr"/>
	     <div class="masthead-heading">	     	
			<div class="jeju-map-background">
				<div class="jeju-title1">Jeju Journey only for Me : ${rioData.mbakMIl}</div>
				<div class="jeju-sub-title1">(&nbsp;${rioData.startTourDay}&nbsp;~&nbsp;${rioData.endTourDay}&nbsp;)</div>
			</div>
	     </div>	     
	</div>
	<!--// The end of map title -->
	
	<hr class="jeju-hr"/>	
	
	<!-- start of map drawing -->
	<section class="jeju-map-portfolio" id="portfolio">
	
	<div class="d-flex align-items-center justify-content-center">
	<div id="different_map" style="width: 70rem; height: 23rem;"></div>
	</div>
	<div class="d-flex justify-content-center encore-map-status-div">
		<div class="row">
			<div class="col-auto">
				<button class="encore-map-status-button rounded"
				style="width : 230px;"
				onclick="setOverlayMapTypeId('ecore_tours')">Encore default Map</button>
			</div>
			<div class="col-auto">
				<button class="encore-map-status-button rounded"
				style="width : 120px;"
				onclick="setOverlayMapTypeId('traffic')">교통정보 맵</button>
			</div>
			<div class="col-auto">
				<button class="encore-map-status-button rounded"
				style="width : 130px;"
				onclick="setOverlayMapTypeId('roadview')">로드뷰 도로 맵</button>
			</div>
			<div class="col-auto">
				<button class="encore-map-status-button rounded"
				style="width : 120px;"
				onclick="setOverlayMapTypeId('terrain')">지형정보 맵</button>
			</div>
			<div class="col-auto">
				<button class="encore-map-status-button rounded"
				style="width : 130px;"
				onclick="setOverlayMapTypeId('use_district')">지적편집도 맵</button>
			</div>
			<div class="col-auto">
				<button class="encore-map-status-button rounded"
				style="width : 120px;"
				onclick="setOverlayMapTypeId('sky_view')">스카이뷰 맵</button>
			</div>
		</div>

	</div>
		
	</section>
	<!--// The end of map drawing -->
	
	<div id="seleted_opt_info_div"
		 class="jeju-div d-flex align-items-center justify-content-center">							
		<div id="seleted_opt_info"
		     class="card mb-3">
			<div class="card-header">
				<i class="fas fa-plane-departure"></i> 선택하신 옵션
				<div><a href="/team4_jeju/tour/MapDrawing.do">맵 draw 테스트</a></div>
			</div>
				<div class="container">
			        <div>
						<table class='table'>
							<tr>
								<td>
									<div class="row">
										<div class="col-sm-4">
										여행시작일&nbsp;:&nbsp;${rioData.startTourDay}
										</div>
										<div class="col-sm-4">
										성인수&nbsp;:&nbsp;${rioData.choosedAdultNum}
										</div>
										<div class="col-sm-4">
										place옵션&nbsp;:&nbsp;${rioData.placeOptText}
										</div>
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div class="row">
										<div class="col-sm-4">
										여행종료일&nbsp;:&nbsp;${rioData.endTourDay}
										</div>
										<div class="col-sm-4">
										아동수&nbsp;:&nbsp;${rioData.choosedChildrenNum}
										</div>
										<div class="col-sm-4">
										speed옵션&nbsp;:&nbsp;${rioData.speedOptText}
										</div>
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div class="row">
										<div class="col-sm-4">
										총 여행일수(days)&nbsp;:&nbsp;${rioData.tourDaysCnt_Refined}
										</div>
										<div class="col-sm-4">
										총 여행지수(place)&nbsp;:&nbsp;${rioData.total_Row_count_Refined}
										</div>
										<div class="col-sm-4">
										여행 테마 클래스&nbsp;:&nbsp;${rioData.selectedMidClass}
										</div>
									</div>
								</td>
							</tr>
						</table>	
					</div>
				</div>
		</div>
	</div>
		
<!-- 	<div class="jeju-div d-flex align-items-center justify-content-center"> -->
							
<!-- 		<div class="card mb-3"> -->
<!-- 			<div class="card-header"> -->
<!-- 				<i class="fas fa-plane-departure"></i> My Tour Table -->
<!-- 			</div> -->
<!-- 			<div class="card-body"> -->
<!-- 				<div class="table-responsive"> -->
<!-- 					<table class="table table-bordered" id="dataTable" width="100%" -->
<!-- 						   cellspacing="0"> -->
<!-- 						<thead> -->
<!-- 							<tr> -->
<!-- 								<th>sch_Output_Mnum</th> -->
<!-- 								<th>sch_Input_Mnum</th> -->
<!-- 								<th>place_NAME</th> -->
<!-- 								<th>lati_COORD</th> -->
<!-- 								<th>longi_COORD</th> -->
<!-- 								<th>divided_by_Center</th> -->
<!-- 								<th>s_out_SEQUENCE</th> -->
<!-- 								<th>fore_DISTANCE</th> -->
<!-- 								<th>sch_Date</th> -->
<!-- 								<th>sch_Start_Time</th> -->
<!-- 								<th>sch_Finish_Time</th> -->
<!-- 								<th>place_Num</th> -->
<!-- 							</tr> -->
<!-- 						</thead> -->
<!-- 						<tbody> -->
<%-- 							<c:forEach items="${onlyFinalResult}" var="final_r"> --%>
<!-- 							<tr> -->
<%-- 								<td>${final_r.sch_Output_Mnum}</td> --%>
<%-- 								<td>${final_r.sch_Input_Mnum}</td> --%>
<%-- 								<td>${final_r.place_NAME}</td> --%>
<%-- 								<td>${final_r.lati_COORD}</td> --%>
<%-- 								<td>${final_r.longi_COORD}</td> --%>
<%-- 								<td>${final_r.divided_by_Center}</td> --%>
<%-- 								<td>${final_r.s_out_SEQUENCE}</td> --%>
<%-- 								<td>${final_r.fore_DISTANCE}</td> --%>
<%-- 								<td>${final_r.sch_Date}</td> --%>
<%-- 								<td>${final_r.sch_Start_Time}</td> --%>
<%-- 								<td>${final_r.sch_Finish_Time}</td> --%>
<%-- 								<td>${final_r.place_Num}</td> --%>
<!-- 							</tr> -->
<%-- 							</c:forEach> --%>
<!-- 						</tbody> -->
	
<!-- 						<tfoot>
<!-- 	               <tr> -->
<!-- 	                 <th>Name</th> -->
<!-- 	                 <th>Position</th> -->
<!-- 	                 <th>Office</th> -->
<!-- 	                 <th>Age</th> -->
<!-- 	               </tr> -->
<!-- 	             </tfoot> --> -->
	
<!-- 					</table> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 		<!-- //The End of DataTables --> -->
		
<!-- 	</div> -->


<div class="card-header text-center tour-table-text">
		<i class="fas fa-plane-departure "></i> My Tour TimeLine
	</div>
	<div class = "confbtn" style="text-align:right">
	<input type="hidden" class="schInputNum" value="${schInputNum.key_Given_by_Front}">
	 <button  type="button" class="btn btn-success confirm-btn" data-toggle="modal" data-target="timetable-modal">일정 확정 하기</button>
	
<a id="kakao-link-btn" href="javascript:;">
<input type="hidden" class="schInputNum" value="${schInputNum.key_Given_by_Front}">
<img src="//developers.kakao.com/assets/img/about/logos/kakaolink/kakaolink_btn_medium.png" style="padding-top :40px"/>
</a>
	</div>

	
	
	<!-- timeline 시작 -->
	<section class="page-section sch-page-section">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<!-- timeline_ul  -->
					<c:forEach items="${daylist}" var="day"  varStatus="status"> 
					<ul class="cbp_tmtimeline">
					
							<li>
						
							<div class="cbp_tmtime" value="2017-11-04">
								<span class="hidden">${day.sch_Date}</span> <span class="large"></span>
							</div>
							<div class="cbp_tmicon">
								<i class="zmdi zmdi-account"></i>
							</div>
							<div class="cbp_tmlabel emptyv day-count">

								<span>${status.index+1}일차  시작</span>
							</div>
						 </li>
							
 					<c:forEach items="${schPlaceList}" var="schlist" 	varStatus="status1"> 
 					<c:if test="${schlist.sch_Date eq day.sch_Date}">
							<li><time class="cbp_tmtime" datetime="2017-11-04T03:45">
									<span>${schlist.sch_Start_Time}</span> <span></span>
								</time>
								<div class="cbp_tmicon  bg-blush">
									<i class="zmdi zmdi-label"></i>
								</div>
								<div class="cbp_tmlabel">
									<div class="row">
										<div class="col-lg-4 col-md-4 col-4 ">
											<a href="javascript:void(0);">
											<c:choose>
												<c:when test="${empty schlist.finalplacevo.image_Path}">
												<img
												src="/team4_jeju/resources/imgs/NullImg.png"
												alt="${schlist.finalplacevo.place_Name}"
												class="img-fluid img-thumbnail m-t-30">
												</c:when>
												<c:otherwise>
													<img
												src="${schlist.finalplacevo.image_Path }"
												alt="${schlist.finalplacevo.place_Name}"
												class="img-fluid img-thumbnail m-t-30">
												</c:otherwise>
											
											</c:choose>
											
										</a>
										</div>
										<div class="col-lg-6 col-md-6 col-6 sch-place-name">
											<a href="javascript:void(0);"><div class="sch-place-name">${schlist.finalplacevo.place_Name}</div></a>
											<p>
											<ul class="sch-place-info">
												<li>${schlist.finalplacevo.place_Addr}</li>
												<li>평균 관광 소요시간 : ${schlist.finalplacevo.tour_Hour}시간</li>
											</ul>
											</p>
										</div>
										<div class="col-lg-2 col-md-2 col-2">
										<div class="delete-btn">
											<input type="hidden" class ="deleteSchPlace" value="${schlist.sch_Output_Mnum}">
											<c:choose>
											<c:when test="${schlist.place_Num eq 0}">
														<button type="button" class="btn btn-success delete_b">일정추가</button>
											</c:when>
											<c:otherwise>
											<button type="button" class="btn btn-danger delete_b">안갈래요!</button>
											</c:otherwise>
											</c:choose>
											
											
											</div>
										</div>	
									</div>

								</div></li>
							
								</c:if>
						</c:forEach>
						</ul>
							<br/>
						</c:forEach> 
					
					
					
						
					
				</div>
			</div>
		</div>


	</section>
	<!-- timeline 끝 -->


<!-- timetable 그리기 -->
<!-- The Modal -->
	<div class="modal modal-center fade" id="timetable-modal">
		<div class="modal-dialog modal-center">
			<div class="modal-content timetable-modal-content">
			<!-- Modal Header -->
				<div class="modal-header timetable-modal-header">
					<h4 class="modal-title timetable-modal-title text-white">나의 여행 스케줄</h4>
					<button  type="button" class="btn  pdf-btn">파일만들기</button>
					
				</div>
				<!-- Modal body -->
				<div class="modal-body timetable-modal-body">
					<div id="skeduler-container"></div>
				</div>
				
					<!-- Modal footer -->
				<div class="modal-footer">
				<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
				</div>
				</div>
				</div>
		</div>
<!-- End of The Modal -->
	

	
	<script type="text/javascript">
  //<![CDATA[
    // // 사용할 앱의 JavaScript 키를 설정해 주세요.
    Kakao.init('95e85aa66afbc7aaf828aa2355f1eb56');
    // // 카카오링크 버튼을 생성합니다. 처음 한번만 호출하면 됩니다.
    var input_Num = $("#kakao-link-btn").find('input').val();
    Kakao.Link.createDefaultButton({
      container: '#kakao-link-btn',
      objectType: 'feed',
      content: {
        title:"나의 제주여행",
        description: '#여행,#제주,#타임라인',
        imageUrl: "https://t1.daumcdn.net/cfile/tistory/2740EF3458DE033006",
        link: {
          webUrl: "http://localhost:8080/team4_jeju/tour/kakao.do?key_Given_by_Front="+input_Num,
          mobileWebUrl: "http://localhost:8080/team4_jeju/tour/kakao.do?key_Given_by_Front="+input_Num
        }
      },
//       social: {
//         likeCount: 286,
//         commentCount: 45,
//         sharedCount: 845
//       },
      buttons: [
        {
          title: '여행일정보기',
          link: {
            mobileWebUrl: "http://localhost:8080/team4_jeju/tour/kakao.do?key_Given_by_Front="+input_Num,
            webUrl: "http://localhost:8080/team4_jeju/tour/kakao.do?key_Given_by_Front="+input_Num
          }
        }  
      ]
    });
  //]]>
</script>
	
	
<!-- Map Draw 시작. -->

<script>

var mapContainer = document.getElementById('different_map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(33.368957616877644, 126.52752300137345), // 지도의 중심좌표
        level: 10 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

//일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성
var mapTypeControl = new kakao.maps.MapTypeControl();
map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

// 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성
var zoomControl = new kakao.maps.ZoomControl();
map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

// 지도에 추가된 지도타입정보를 가지고 있을 변수입니다
var currentTypeId;

// 버튼이 클릭되면 호출되는 함수입니다
function setOverlayMapTypeId(maptype) {
    var changeMaptype;
    
    // maptype에 따라 지도에 추가할 지도타입을 결정합니다
    if (maptype === 'traffic') {     
        changeMaptype = kakao.maps.MapTypeId.TRAFFIC;         
    } else if (maptype === 'roadview') { 
        changeMaptype = kakao.maps.MapTypeId.ROADVIEW; 
    } else if (maptype === 'terrain') {
        changeMaptype = kakao.maps.MapTypeId.TERRAIN;    
    } else if (maptype === 'use_district') {
        changeMaptype = kakao.maps.MapTypeId.USE_DISTRICT;           
    } else if (maptype === 'ecore_tours'){
    	changeMaptype = kakao.maps.MapTypeId.NORMAL; 
    } else if (maptype === 'sky_view'){
    	changeMaptype = kakao.maps.MapTypeId.SKYVIEW; 
    }
    
    // 이미 등록된 지도 타입이 있으면 제거합니다
    if (currentTypeId) {
        map.removeOverlayMapTypeId(currentTypeId);    
    }
    
    // maptype에 해당하는 지도타입을 지도에 추가합니다
    map.addOverlayMapTypeId(changeMaptype);
    
    // 지도에 추가된 타입정보를 갱신합니다
    currentTypeId = changeMaptype;	
    
}
</script>	
<!-- 맵 그리기 끝. -->	
	
	
	<!-- footer -->
	<jsp:include page="../main/footer_of_main.jsp"></jsp:include>


</body>
</html>