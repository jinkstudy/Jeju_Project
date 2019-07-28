<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>Encore Tours</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link type="text/css" rel="stylesheet"
	href="/team4_jeju/resources/style/tourCateMiddle_jink.css" />

</head>

<body>
	<!-- 헤더에 링크 파일 기술 되어 있음. -->
	<jsp:include page="../main/header_of_main.jsp"></jsp:include>
	
	<!-- main title header -->
	<div class="masthead bg-encore_tours_background text-white text-center"
		id="jeju-main-head">
		<img src="/team4_jeju/resources/imgs/main_image-cover.png" alt="" />
		<div class="d-flex align-items-center flex-column">
			<div class="major-bar text-center">
				<i class="fas fa-crown fa-2x"></i>
				<br/>
				<h1>
					제주도 여행지<br />
				</h1>
<!-- 				<h2>Top50</h2> -->

			</div>
		</div>
	</div>
	<!-- //end of main header -->
	<br />
	<br />
	<!-- 카테고리 toggle -->
	<div class="container">

		<div class="row">

			<div class="col-lg-3">

				<h1 class="my-4">카테고리</h1>
				<div class="list-group">
					<a href='#' class="list-group-item major-class text-white"
						data-toggle="collapse" data-target="#hotplace">핫플레이스</a> <a
						href='/team4_jeju/tourCate/selectHotplace.do'
						class="list-group-item" id="hotplace">&nbsp;Top 50</a> <a href="#"
						class="list-group-item major-class text-white"
						data-toggle="collapse" data-target="#midClassName3">가볼거리</a>

					<!-- 각 대분류별 중분류 이름 불러와서 동적으로 list 생성하기. -->
					<div id="midClassName3">
						<a href="/team4_jeju/tourCate/selectMiddleCate.do?major_Num=3"
							class="list-group-item" id="hotplace">&nbsp;전체보기</a>
						<c:forEach items="${midCateName3}" var="midCate3"
							varStatus="status">
							<a
								href='/team4_jeju/tourCate/selectPlacebyMidd.do?middle_Num=${midCate3.middle_Num}'
								class="list-group-item">&nbsp;${midCate3.middle_Name}</a>
						</c:forEach>
					</div>

					<a href="#" class="list-group-item major-class text-white"
						data-toggle="collapse" data-target="#midClassName1">먹을거리</a>
					<div id="midClassName1">
						<a href="/team4_jeju/tourCate/selectMiddleCate.do?major_Num=1"
							class="list-group-item" id="hotplace">&nbsp;전체보기</a>
						<c:forEach items="${midCateName1}" var="midCate1"
							varStatus="status">
							<a
								href='/team4_jeju/tourCate/selectPlacebyMidd.do?middle_Num=${midCate1.middle_Num}'
								class="list-group-item">&nbsp;${midCate1.middle_Name}</a>
						</c:forEach>
					</div>
					<a href="#" class="list-group-item major-class text-white"
						data-toggle="collapse" data-target="#midClassName2">즐길거리</a>
					<div id="midClassName2">
						<a href="/team4_jeju/tourCate/selectMiddleCate.do?major_Num=2"
							class="list-group-item" id="hotplace">&nbsp;전체보기</a>
						<c:forEach items="${midCateName2}" var="midCate2"
							varStatus="status">
							<a
								href='/team4_jeju/tourCate/selectPlacebyMidd.do?middle_Num=${midCate2.middle_Num}'
								class="list-group-item">&nbsp;${midCate2.middle_Name}</a>
						</c:forEach>
					</div>
				</div>


			</div>
			<!-- /.col-lg-3 -->
			<!--중분류별 장소 list 화면에 뿌리기 -->
			<div class="col-lg-9 card-full">
				<div class="row">
					<c:forEach items="${placeList}" var="place" varStatus="status">
						<c:set var="b" value="place-modal${status.index}" />
						<c:set var="c" value="#place-modal${status.index}" />
						<div class="col-lg-4 col-md-6 mb-4">
							<div class="card h-100" style="cursor: pointer"
								data-toggle="modal" data-target="${c}">
													<c:choose>
												<c:when test="${empty place.image_Path}">
												<img class="card-img-top"
												src="/team4_jeju/resources/imgs/NullImg.png"
												alt=""
												>
												</c:when>
												<c:otherwise>
												<img class="card-img-top"
									src="<c:url value="${place.image_Path}"/>" alt="">
												</c:otherwise>
											
											</c:choose>
							
<!-- 								<img class="card-img-top" -->
<%-- 									src="<c:url value="${place.image_Path}"/>" alt=""> --%>
								<div class="card-body place-card-body">
									<h5 class="card-title place-card-title">
										<a href="#">${place.place_Name}</a>
									</h5>
									
									<p class="card-text place-card-text">${place.place_Addr}</p>
								</div>
								<div class="card-footer">
									<small class="text-muted">${place.tags}</small>
								</div>
							</div>
						</div>

						<!-- The Modal -->
						<div class="modal modal-center fade" id="${b}">
							<div class="modal-dialog modal-center">
								<div class="modal-content place-modal-content">

									<!-- Modal Header -->
									<div class="modal-header place-modal-header ">
										<h4 class="modal-title place-modal-title text-white">${place.place_Name}</h4>
										<input type="hidden" class ="pick_num" value="${place.final_Place_Num}">
										<img src="/team4_jeju/resources/imgs/like_0.png" style="cursor: pointer" class="pick-img">
										<button type="button" class="close" data-dismiss="modal">&times;</button>
										
									</div>

									<!-- Modal body -->
									<div class="modal-body place-modal-body">
									<div class="place-det"> ${place.place_Det}</div>
									<hr>
										<div class="place-pic-container">
												<c:choose>
												<c:when test="${empty place.image_Path}">
												<img class="place-pic"
												src="/team4_jeju/resources/imgs/NullImg.png"
												alt=""
												>
												</c:when>
												<c:otherwise>
												<img class="place-pic" alt="" src="${place.image_Path}">
												</c:otherwise>
											
											</c:choose>
										
										<hr>
									</div>
									<h2>이용안내</h2>
									<!-- Icon Divider -->
					<div class="divider-custom">
						<div class="divider-custom-line"></div>
						<div class="divider-custom-icon">
							<i class="fas fa-passport"></i>
						</div>
						<div class="divider-custom-line"></div>
					</div>
									<div>주소 : ${place.place_Addr} <br/>
									연락처 : ${place.place_Tel}<br />
									휴일 : ${place.close_Day} <br />  
									이용시간: ${place.use_Time }</div>
									</div>

									<!-- Modal footer -->
									<div class="modal-footer">
							
										
										<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
									</div>

								</div>
							</div>
						</div>
						<!-- End of The Modal -->
					</c:forEach>
				</div>
				<!-- /.row -->

			</div>
			<!-- /.col-lg-9 -->

		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->

	<br>

	<br>
	<br>

	<!-- footer -->
	<jsp:include page="../main/footer_of_main.jsp"></jsp:include>





</body>
</html>
