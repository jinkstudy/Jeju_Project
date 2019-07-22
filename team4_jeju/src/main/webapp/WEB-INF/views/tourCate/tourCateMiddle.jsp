<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link type="text/css" rel="stylesheet"
	href="/team4_jeju/resources/style/tourCateMiddle_jink.css" />

</head>

<body>
	<!-- 헤더에 링크 파일 기술 되어 있음. -->
	<jsp:include page="../main/header_of_main.jsp"></jsp:include>

	<div class="jumbotron  text-center">
	<i class="fas fa-crown fa-4x"></i>
		<div class="container text-center">
			<h1>Hot 플레이스</h1>
			<h2>Top50</h2>
		</div>
	</div>


		<div class="container">
			<div class="row">
				<c:forEach items="${hotplace}" var="hotple">
						<div class="col-sm-4">
						<div class="panel panel-primary">
							<div class="panel-heading">${hotple.place_title}
							<img class="like-btn" src="/team4_jeju/resources/imgs/like_0.png" style="cursor: pointer"></div>
							<div class="panel-body">
							
								<img class="img-responsive" style="width: 100%" alt="" src="<c:url value="${hotple.place_img_path}"/>" />
							</div>
							<div class="panel-footer">${hotple.place_tags }
							</div>
							
						</div>
					</div>
				</c:forEach>
			</div>
			</div>
			<br>

	<br>
	<br>

	<!-- footer -->
	<jsp:include page="../main/footer_of_main.jsp"></jsp:include>


</body>
</html>
