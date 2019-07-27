<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<META HTTP-EQUIV="Page-exit" CONTENT="BlendTrans(Duration=0.5)">
<META HTTP-EQUIV="Page-Enter" CONTENT="BlendTrans(Duration=0.5)">

<title>Encore tours</title>

<!-- 카카오 map 링크 -->
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=95e85aa66afbc7aaf828aa2355f1eb56"></script>

<!-- jQuery 링크 -->
<script src="../resources/js/jquery-3.4.1.js"></script>

<!-- 카카오 map_gyubeom coding 링크 -->
<script src="../resources/js/map_gyubeom_original.js"></script>

<link rel="stylesheet"
	href="/team4_jeju/resources/style/map_gyubeom.css" type="text/css">
<link type="text/css" rel="stylesheet"
	href="/team4_jeju/resources/style/tourSch_jink.css" />
<!-- 타임테이블 관련 링크 -->
<link rel="stylesheet" href="/team4_jeju/resources/style/jquery.skeduler.css" type="text/css">
<link href="http://www.jqueryscript.net/css/jquerysctipttop.css" rel="stylesheet" type="text/css">

<!-- pdf관련 -->
<script src="https://unpkg.com/jspdf@latest/dist/jspdf.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/0.4.1/html2canvas.min.js"></script>

</head>
<body>

	<!-- header -->
	<jsp:include page="../main/header_of_main.jsp"></jsp:include>
	<script src="/team4_jeju/resources/js/tourSch_jink.js"></script>
	
<!-- 타임테이블  -->
    <script src="/team4_jeju/resources/js/jquery.skeduler.js"></script>
    <script src="/team4_jeju/resources/js/main_timetable.js"></script>

	<!-- start of map title -->
	<div class="text-white text-center" id="jeju-map-head">
		<hr class="jeju-hr" />
		<div class="masthead-heading">
			<div class="jeju-map-background">
				<div class="jeju-title1">Jeju Journey only for Me : 9박 10일</div>
				<div class="jeju-sub-title1">(19.07.02 ~ 19.07.11)</div>
			</div>
		</div>
	</div>
	<!--// The end of map title -->

	<hr class="jeju-hr" />

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


	<div class="card-header text-center tour-table-text">
		<i class="fas fa-plane-departure "></i> My Tour TimeLine
	</div>
	<div class = "confbtn" style="text-align:right">
	<input type="hidden" class="schInputNum" value="${schInputNum.sch_Input_Mnum}">
	 <button  type="button" class="btn btn-success confirm-btn" data-toggle="modal" data-target="timetable-modal">일정 확정 하기</button>
	
<a id="kakao-link-btn" href="javascript:;">
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
			</div>
		</div>
	</div>

	<!-- footer -->
	<jsp:include page="../main/footer_of_main.jsp"></jsp:include>
	<script type="text/javascript">
  //<![CDATA[
    // // 사용할 앱의 JavaScript 키를 설정해 주세요.
    Kakao.init('f91d9fd8759d4ae645a990bf6cb797cf');
    // // 카카오링크 버튼을 생성합니다. 처음 한번만 호출하면 됩니다.
    Kakao.Link.createDefaultButton({
      container: '#kakao-link-btn',
      objectType: 'feed',
      content: {
        title: document.title,
        description: '내용, 주로 해시태그',
        imageUrl: document.images[0].src,
        link: {
          webUrl: document.location.href,
          mobileWebUrl: document.location.href
        }
      },
      social: {
        likeCount: 286,
        commentCount: 45,
        sharedCount: 845
      },
      buttons: [
        {
          title: 'Open!',
          link: {
            mobileWebUrl: document.location.href,
            webUrl: document.location.href
          }
        }  
      ]
    });
  //]]>
</script>
	

</body>
</html>