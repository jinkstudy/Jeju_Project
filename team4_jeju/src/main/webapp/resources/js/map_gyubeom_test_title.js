function switchScreen(){
    $("#divLoading").hide();
}

var arrlist = new Array();    
var arr;

arr = ['a', 126.570677, 33.450705];
arrlist.push(arr);
arr = ['b', 126.492810, 33.5066211];
arrlist.push(arr);
arr = ['c', 126.322529, 33.2906595];
arrlist.push(arr);


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
 
    //마커를 표시할 위치와 title 객체 배열입니다 
    var positions = new Array();
    var each_posi = {};
    
    //테스트
    console.log(arrlist);
    
    for(var i = 0, max =  arrlist.length; i < max; i++){
    	each_posi = {
    			content : '<div>'+arrlist[i][0]+'</div>'
    			, latlng : new daum.maps.LatLng(arrlist[i][2], arrlist[i][1]) 
    	};
    	positions.push(each_posi);
    }
    
    //테스트
    console.log(positions);
    
    // 마커 이미지의 이미지 주소입니다
    var imageSrc = "/team4_jeju/resources/imgs/map_gyubeom/blue_circle.png";
 
    for (var i = 0, max= positions.length; i < max; i++) {
 
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
    var distance;
 
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
 
        distance = Math.round(lineLine.getLength());
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