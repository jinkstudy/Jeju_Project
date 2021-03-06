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
		
	<!-- jQuery 링크 -->
	<script src="../../resources/js/jquery-3.4.1.js"></script>

	<!-- api 적용 스크립트 링크 -->
	<script src="../../resources/js/jeju_gyubeom_kakao_log_in_out.js"></script>

</head>
<body>
	
	<!-- header -->
	<jsp:include page="../../main/header_of_main.jsp"></jsp:include>
	
	<!-- main title header -->
	<header class="masthead bg-encore_tours_background text-white text-center">
		<div class="container d-flex align-items-center flex-column">

			<!-- Masthead Avatar Image -->
			<img class="masthead-avatar mb-5" src="" alt="">

			<!-- Masthead Heading -->
			<h1 class="masthead-heading text-uppercase mb-0">로그인 페이지입니다.</h1>

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
					<th colspan='2'>log-in</th>
				</tr>
				<tr>
					<th>아이디</th>
					<!-- 카카오톡 -->
					<td><input type="textarea" id="id_text" /></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="textarea" id="password_text" /></td>
				</tr>
				<tr>
					<th>회원명</th>
					<!-- 카카오톡 -->
					<td><input type="textarea" id="name_text" /></td>
				</tr>
				<tr>
					<th>연락처</th>
					<td><input type="textarea" id="contact_text" /></td>
				</tr>
				<tr>
					<th>이메일</th>
					<!-- 카카오톡 -->
					<td><input type="textarea" id="email_text" /></td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td><input type="textarea" id="birthday_text" /></td>
				</tr>
			</table>
		</div>
		
		<div class="d-flex align-items-center justify-content-center">
			<table class="no-style">
				<tr>
					<td colspan='2'>
						<a id="kakao-login-btn"></a>
					</td>
				</tr>
				<tr>
					<td colspan='2'>
						<br/>
						<button type="submit" class="btn btn-encore_tours btn-lg"
						id="sendMessageButton"
						onclick="location.href=''">
						로그아웃</button>
					</td>
				</tr>
			</table>
		</div>
	</div>
			
	</section>
	
	<!-- footer -->
	<jsp:include page="../../main/footer_of_main.jsp"></jsp:include>

</body>
</html>