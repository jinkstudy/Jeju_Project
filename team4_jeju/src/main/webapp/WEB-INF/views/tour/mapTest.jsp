<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- 카카오 map 링크 -->
<script type="text/javascript"
	    src="//dapi.kakao.com/v2/maps/sdk.js?appkey=95e85aa66afbc7aaf828aa2355f1eb56"></script>

<!-- jQuery 링크 -->
<script src="/team4_jeju/resources/js/jquery-3.4.1.js"></script>

<!-- 카카오 map_gyubeom coding 링크 -->
<script src="/team4_jeju/resources/js/map_gyubeom.js"></script>

<!-- css 링크 일부러 아래에다 둠. 순서 수정 금지. kakao deny 때문에. -->
<link rel="stylesheet"
	  href="/team4_jeju/resources/style/map_gyubeom.css" type="text/css">

</head>


<script type="text/javascript">

var arr = new Array();
var arrlist = new Array();    

<c:forEach items="${mapList}" var="ml" varStatus="status">
		arr = [];
		arr.push("${ml.place_Name}");
		arr.push("${ml.longi_Coord}");
		arr.push("${ml.lati_Coord}");
		arr.push("${ml.tour_Sequence_Key_Num}");
		//console.log('1차 jstl test' + arr);		
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
	
    var mapContainer = document.getElementById('map'); // 지도를 표시할 div
    
    var mapOption = {
    		center: new kakao.maps.LatLng(33.368957616877644, 126.52752300137345), // 지도의 중심좌표
    		level: 10
    // 지도의 확대 레벨
    };
 
    var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
    
    // 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성
	var mapTypeControl = new kakao.maps.MapTypeControl();
	map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);
	
	// 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성
	var zoomControl = new kakao.maps.ZoomControl();
	map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
    
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


<body onload="switchScreen();">

<div id="divLoading" style="position:absolute; top:25rem; left:0; width:100%; text-align:center; margin:0 auto;">
	<img src="/team4_jeju/resources/imgs/image_gyubeom/loading_gyubeom.gif"
	     alt="" />
	나만의 여행 생성중...
</div>

	<!-- header -->
	<jsp:include page="../main/header_of_main.jsp"></jsp:include>
	
	
	<!-- start of map title -->
	<div class="text-white text-center"
	     id="jeju-map-head">
	     <hr class="jeju-hr"/>
	     <div class="masthead-heading">	     	
			<div class="jeju-map-background">
				<div class="jeju-title1">Jeju Journey only for Me : 9박 10일</div>
				<div class="jeju-sub-title1">(19.07.02 ~ 19.07.11)</div>
			</div>
	     </div>	     
	</div>
	<!--// The end of map title -->
	
	<hr class="jeju-hr"/>
	
	<!-- start of map drawing -->
	<section class="jeju-map-portfolio" id="portfolio">
		<div class="container">

			<div class="d-flex align-items-center justify-content-center">		
				
				<div class="row">
					<div id="map" style="width: 70rem; height: 23rem;"></div>
				</div>
								
			</div>
		</div>
	</section>
	<!--// The end of map drawing -->
	
	<div class="d-flex align-items-center justify-content-center">		
		<div class="card mb-3">
			<table class="table jeju-table">
				<tr>
					<td>
						<div id="center_coordi_confirm_td">
							<a href="MapDrawing.do" 
							   target="_blank"
							   id="">
							      맵 그리기 시작</a>
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div id="center_coordi_confirm_td">
							<button id="map_jquery_test">
							   MAP JQUERY TEST</button>
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div id="center_coordi_confirm_td">
							<a href="tourDrawingPage.do" 
							   target="_blank"
							   id="">
							   tour Test _ (original) Page로 이동</a>
						</div>
					</td>
				</tr>
			</table>
		</div> 
	</div>
		
	<div class="jeju-div d-flex align-items-center justify-content-center">
							
		<div class="card mb-3">
			<div class="card-header">
				<i class="fas fa-plane-departure"></i> My Tour Table
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-bordered" id="dataTable" width="100%"
						   cellspacing="0"
						   id="map_drawing_list_table">
						<thead>
							<tr>
								<th>tour_Sequence_Key_Num</th>
								<th>final_Place_Num</th>
								<th>place_Id</th>
								<th>place_Name</th>								
								<th>image_Path</th>
								<th>lati_Coord</th>
								<th>longi_Coord</th>
								<th>open_Time</th>
								<th>close_Time</th>
								<th>place_Det</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${mapList}" var="ml">
							<tr>
								<td>${ml.tour_Sequence_Key_Num}</td>
								<td>${ml.final_Place_Num}</td>
								<td>${ml.place_Id}</td>
								<td>${ml.place_Name}</td>								
								<td>${ml.image_Path}</td>
								<td>${ml.lati_Coord}</td>
								<td>${ml.longi_Coord}</td>
								<td>${ml.open_Time}</td>
								<td>${ml.close_Time}</td>
								<td>${ml.place_Det}</td>
							</tr>
						</c:forEach>
						</tbody>
	
						<!-- <tfoot>
	               <tr>
	                 <th>Name</th>
	                 <th>Position</th>
	                 <th>Office</th>
	                 <th>Age</th>
	               </tr>
	             </tfoot> -->
	
					</table>
				</div>
			</div>
		</div>
		<!-- //The End of DataTables -->
		
	</div>
	
	<!-- footer -->
	<jsp:include page="../main/footer_of_main.jsp"></jsp:include>

</body>
</html>