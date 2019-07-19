<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>찜한 목록 리스트</title>
</head>
<body>
<!-- header -->
	<jsp:include page="../main/header_of_main.jsp"></jsp:include>
	
	<!-- main title header -->
	<header class="masthead bg-encore_tours_background text-white text-center">
		<div class="container d-flex align-items-center flex-column">

			<!-- Masthead Avatar Image -->
			<img class="masthead-avatar mb-5" src="" alt="">

			<!-- Masthead Heading -->
			<h1 class="masthead-heading text-uppercase mb-0">찜 목록 페이지 입니다.</h1>

			<!-- Icon Divider -->
			<div class="divider-custom divider-light">
				<div class="divider-custom-line"></div>
				<div class="divider-custom-icon">
					<i class="fas fa-globe-asia"></i>
				</div>
				<div class="divider-custom-line"></div>
			</div>

			<!-- Masthead Subheading -->
			<p class="masthead-subheading font-weight-light mb-0">
			Enjoy Smarter Travel "Only for You"</p>

		</div>
	</header>
	<!-- //end of header -->		
	
	<section class="page-section portfolio" id="portfolio">
		<div class="container">
		
			<div class="d-flex align-items-center justify-content-center">
			
			<table class="table table-bordered table-hover"
				   style="width: 350px; text-align: center;">
				<tr>
					<th colspan='2'>Pick List</th>
				</tr>
			</table>
		</div>
		
		<div class="d-flex align-items-center justify-content-center">
<!-- 		********************<<여기에 테이블 넣기>> -->
		<table class="no-style">
			<tr>
			<th>장소 이름</th>
			<th>오픈 시간</th>
			<th>마감 시간</th>
			</tr>
			<c:forEach items="${pickList}" var="pickList">
			<tr>
			<td>${pickList.place_Name}</td>
			<td>${pickList.open_Time}</td>
			<td>${pickList.close_Time}</td>		
			</tr>
			</c:forEach>
		</table>
		</div>
	</div>
	</section>

	<!-- footer -->
	<jsp:include page="../main/footer_of_main.jsp"></jsp:include>
		

</body>
</html>