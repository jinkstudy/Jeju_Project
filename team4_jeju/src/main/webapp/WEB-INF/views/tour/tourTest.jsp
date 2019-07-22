<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<!-- 카카오톡 로그인 관련 스트립트 링크 -->
<script src="
	https://developers.kakao.com/sdk/js/kakao.min.js"></script>

<!-- 카카오 map 링크 -->
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=95e85aa66afbc7aaf828aa2355f1eb56"></script>

<!-- jQuery 링크 -->
<script src="../resources/js/jquery-3.4.1.js"></script>

<!-- 카카오 map_gyubeom coding 링크 -->
<script src="../resources/js/map_gyubeom.js"></script>


</head>
<body>

	<!-- header -->
	<jsp:include page="../main/header_of_main.jsp"></jsp:include>

	<!-- start of map drawing and title -->
	<section class="page-section portfolio" id="portfolio">
		<div class="container">

			<div class="d-flex align-items-center justify-content-center">

				<div class="jeju-map-background">
					<h2 class="jeju-map-title1">Journey Only for Me</h2>
				</div>

				<div id="map" style="width: 500px; height: 400px;"></div>
			</div>
		</div>

	</section>
	<!--// The end of map drawing and title -->

	<!-- footer -->
	<jsp:include page="../main/footer_of_main.jsp"></jsp:include>

</body>
</html>