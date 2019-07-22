<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
 
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>InsertQnA</title>

	<!-- 카카오톡 로그인 관련 스트립트 링크 -->
	<script src="
	https://developers.kakao.com/sdk/js/kakao.min.js"></script>
		
	<!-- jQuery 링크 -->
	<script src="../resources/js/jquery-3.4.1.js"></script>

	<!-- api 적용 스크립트 링크 -->
	<script src="../resources/js/jeju_gyubeom_kakao_log_in_out.js"></script>

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
			<h1 class="masthead-heading text-uppercase mb-0">QA 페이지입니다.</h1>

			<!-- Icon Divider -->
			<div class="divider-custom divider-light">
				<div class="divider-custom-line"></div>
				<div class="divider-custom-icon">
					<i class="fas fa-globe-asia"></i>
				</div>
				<div class="divider-custom-line"></div>
			</div>

<!-- 			<!-- Masthead Subheading --> 
<!-- 			<p class="masthead-subheading font-weight-light mb-0"> -->
<!-- 			Enjoy Smarter Travel "Only for You"</p> -->

		</div>
	</header>
	<!-- //end of header -->		

	<!-- Contact Section -->
	<section class="page-section" id="contact">
		<div class="container">
	<table border="1">
			<tr>
				<th bgcolor="skyblue" width="100">번호</th>
				<th bgcolor="skyblue" width="200">제목</th>
				<th bgcolor="skyblue" width="150">작성자</th>
				<th bgcolor="skyblue" width="150">등록일</th>
				<th bgcolor="skyblue" width="100">조회수</th>
			</tr>
			<c:forEach items="${qnAList }" var="qnA">
				<tr>
					<td>${qnA.qnA_Mnum }</td>
					<td align="left"><a href="getQnA.do?qnA_Mnum=${qnA.qnA_Mnum }">
							${qnA.qnA_Title }</a></td>
					<td>${qnA.writer_Name }</td>
					<td>${qnA.qnA_Date }</td>
					<td>${board.qnA_Cnt }</td>
				</tr>
			</c:forEach>
		</table>
		<br> <a href="../qnA/insertQnA.do" >새글 등록</a>


		</div>
	</section>
	
	<!-- footer -->
	<jsp:include page="../main/footer_of_main.jsp"></jsp:include>
	

</body>

</html>