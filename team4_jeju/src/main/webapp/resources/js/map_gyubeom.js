
$(function(){
	
	var container = document.getElementById('map');
	
	var options = {
		center: new kakao.maps.LatLng(33.368957616877644, 126.52752300137345),
		level: 10
	};
	
	//카카오 맵 객체 생성.
	var map = new kakao.maps.Map(container, options);
	
	// 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성
	var mapTypeControl = new kakao.maps.MapTypeControl();
	map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);
	
	// 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성
	var zoomControl = new kakao.maps.ZoomControl();
	map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
	
	
//	//맵 정보 getMapInfo 메소드
//	var getMapInfo = function getInfo() {
//	    // 지도의 현재 중심좌표를 얻어옵니다 
//	    var center = map.getCenter(); 
//	    
//	    // 지도의 현재 영역을 얻어옵니다 
//	    var bounds = map.getBounds();
//	    
//	    // 영역정보를 문자열로 얻어옵니다. ((남,서), (북,동)) 형식입니다
//	    var boundsStr = bounds.toString();
//	    
//	    
//	    var message = '현재 지도 중심좌표의 위도 : ' + center.getLat() + '\n';
//	    message += '현재 지도 중심좌표의 경도 : ' + center.getLng() + '\n';
//	    
//	    alert(message);
//	    console.log(message);
//	    
//	    // 개발자도구를 통해 직접 message 내용을 확인해 보세요.
//	    // ex) console.log(message);
//	}
//	
//	$('#center_coordi_confirm').on('click', function(){
//		getMapInfo();		
//	});
	    
});