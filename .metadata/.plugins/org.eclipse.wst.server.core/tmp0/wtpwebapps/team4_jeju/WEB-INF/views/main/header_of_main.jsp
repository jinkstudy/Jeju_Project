<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Encore Tours</title>

<!-- 링크 순서 중요합니다. <<< 4조, 순서 지켜주세용 -->
<!-- 스프링 뷰 내부에 있기 때문에, 링크는 절대 경로로 기술. -->

<link
	href="https://fonts.googleapis.com/css?family=Nanum+Gothic+Coding:400,700&display=swap&subset=korean"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:100,300,400,500,700,900&display=swap&subset=korean"
	rel="stylesheet">

<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic"
	rel="stylesheet" type="text/css">

<link rel="stylesheet" href="/team4_jeju/resources/style/main_gyubeom.css"
	  type="text/css">
<link rel="stylesheet" href="/team4_jeju/resources/style/fontawesome-all.css"
	  type="text/css">
<link rel="stylesheet" href="/team4_jeju/resources/style/jeju_gyubeom.css"
	  type="text/css">

<script src="/team4_jeju/resources/js/jquery-3.4.1.js"></script>
<script src="/team4_jeju/resources/js/bootstrap-4.3.1.js"></script>

</head>
<body>

	<!-- Navigation -->
	<header>
		<nav
			class="navbar navbar-expand-lg bg-encore_tours_title text-uppercase fixed-top"
			id="mainNav">
			<div class="container">
				<!-- 스프링 뷰 내부 연동 중 오류 대비하여 main.do 절대 경로로 기술. -->
				<a class="navbar-brand js-scroll-trigger encore-home-title py-3 px-0 px-lg-3"
				   href="/team4_jeju/main/main.do" />
				   Encore Tours</a>
				<button
					class="navbar-toggler navbar-toggler-right text-uppercase font-weight-bold bg-encore_tours text-white rounded"
					type="button" data-toggle="collapse" data-target="#navbarResponsive"
					aria-controls="navbarResponsive" aria-expanded="false"
					aria-label="Toggle navigation">
					Menu <i class="fas fa-bars"></i>
				</button>
				<div class="collapse navbar-collapse" id="navbarResponsive">
					<ul class="navbar-nav ml-auto">
						<li class="nav-item mx-0 mx-lg-1">
							<a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger"
							   href="">나의 여행 페이지</a>
						</li>
						<li class="nav-item mx-0 mx-lg-1">
							<a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger"
							   href="#about">Encore Tours 소개</a>
						</li>
						<li class="nav-item mx-0 mx-lg-1">
							<a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger"
							   href="#contact">무엇이든 물어보세요</a>
						</li>
						<li class="nav-item mx-0 mx-lg-1">
							<a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger"
							   href="/team4_jeju/member/login/login.do">로그인</a>
						</li>
						<li class="nav-item mx-0 mx-lg-1">
							<a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger"
							   href="">회원가입</a>
						</li>
					</ul>
				</div>
			</div>
		</nav>
	</header>
	
</body>
</html>