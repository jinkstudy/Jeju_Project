<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<META HTTP-EQUIV="Page-exit" CONTENT="BlendTrans(Duration=0.5)">
<META HTTP-EQUIV="Page-Enter" CONTENT="BlendTrans(Duration=0.5)">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"
	type="text/javascript" charset="utf-8"></script>

<script type="text/javascript">
$(document).ready(function(){

	$("#loginButton").click(function(){

		var member_Email = $("#member_Email").val();
		var password = $("#password").val();

				$.ajax({
				type : 'post',
				url : '${pageContext.request.contextPath}/',
				data : {
					member_Email : member_Email,
					password : password,
					},
					success : function(data) {
						if (data == 0) { //로그인 실패시
// 							location.href = '${pageContext.request.contextPath}/user/redundant?member_Email=' + member_Email + '&password=' + password ;						
						} else { //로그인 성공시
							console.log(data);
							location.href = 'main/main.do';
						}
					}
				});
			});
		
		document.login.action="main.main.do"
		document.login.submit();
	});


</script>
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

<link rel="stylesheet"
	href="/team4_jeju/resources/style/login_gyubeom.css" type="text/css">

<link rel="stylesheet"
	href="/team4_jeju/resources/style/main_gyubeom.css" type="text/css">
<link rel="stylesheet"
	href="/team4_jeju/resources/style/fontawesome-all.css" type="text/css">
<link rel="stylesheet"
	href="/team4_jeju/resources/style/jeju_gyubeom.css" type="text/css">

<link rel="stylesheet"
	href="/team4_jeju/resources/style/style_main_test_jink.css"
	type="text/css">

<!-- 카카오톡 로그인 관련 스트립트 링크 -->
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>

<script src="/team4_jeju/resources/js/jquery-3.4.1.js"></script>
<script src="/team4_jeju/resources/js/bootstrap-4.3.1.js"></script>

<script src="/team4_jeju/resources/js/main_test_jink.js"></script>
<script src="/team4_jeju/resources/js/tourCateMidd_jink.js"></script>

</head>
<body>

	<header>

		<!-- admin / user 네비게이션 시작 -->
		<nav class="navbar navbar-expand navbar-dark bg-jeju fixed-top-admin">
			<!-- Navbar -->
			<div class="navbar-nav ml-auto ml-md-0">
				<div class="nav-item no-arrow">
					<a class="nav-link" href="/team4_jeju/admin/admin/admin.do"
						role="button"> <i class="fas fa-user fa-fw admin"></i> admin
					</a>
				</div>
			</div>

		</nav>
		<!-- //end of admin -->


		<!-- 실제 헤더 네비게이션 시작 -->
		<nav class="navbar navbar-expand-lg bg-encore_tours_title fixed-top"
			id="mainNav">

			<div class="container">

				<!-- 스프링 뷰 내부 연동 중 오류 대비하여 main.do 절대 경로로 기술. -->
				<a class="navbar-brand js-scroll-trigger encore-home-title py-3 px-0 px-lg-3"
					href="/team4_jeju/main/main.do" > Encore Tours</a>
				<button
					class="navbar-toggler navbar-toggler-right text-uppercase font-weight-bold bg-encore_tours text-white rounded"
					type="button" data-toggle="collapse"
					data-target="#navbarResponsive" aria-controls="navbarResponsive"
					aria-expanded="false" aria-label="Toggle navigation">
					Menu <i class="fas fa-bars"></i>
				</button>
				<div class="collapse navbar-collapse jeju-background"
					id="navbarResponsive">
					<ul class="navbar-nav ml-auto">
						<li class="nav-item mx-0 mx-lg-1"><a
							class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger"
							href="/team4_jeju/main/main.do#about"
							id="introductionEncoreTours"> Encore Tours 소개 </a></li>
						<li class="nav-item mx-0 mx-lg-1"><a
							class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger"
							href="/team4_jeju/pick/myPage.do">나의 여행 페이지 </a></li>
						<li class="nav-item mx-0 mx-lg-1"><a
							class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger"
							href="/team4_jeju/community/getCommunityBoardList.do">엔코아
								커뮤니티 </a></li>
						<li class="nav-item mx-0 mx-lg-1">
						<li class="nav-item mx-0 mx-lg-1"><a
							class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger"
							href="/team4_jeju/qnA/getQnAList.do"> 무엇이든 물어보세요 </a></li>
						</li>
					</ul>
				</div>
			</div>
		</nav>


		<!-- 검색창 내비게이션 navigation 시작 -->
		<nav class="navbar navbar-expand navbar-dark bg-white jeju-top-search">

			<!-- 검색창 -->
			<!-- Navbar Search -->
			<form
				class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
				<div class="input-group">
					<input type="text" class="form-control" placeholder="Search for..."
						aria-label="Search" aria-describedby="basic-addon2">
					<div class="input-group-append nav-item">
						<button class="btn btn-encore_tours" type="button">
							<i class="fas fa-search"></i>
						</button>
					</div>
				</div>
			</form>

		<!-- Navbar -->
			<!-- 하기 주석까지도 수정 금지! -->
			<ul class="navbar-nav ml-auto ml-md-0">
				<c:choose>
					<c:when test="${ user == null}">
						<li class="nav-item dropdown no-arrow mx-1">
							<!-- 여러 기능을 원할 경우 하기 클래스 추가 후 사용 --> <!-- class="dropdown-toggle" -->
							<a id="alertsDropdown"
							class="jeju-user py-3 px-0 px-lg-3 rounded" role="button"
							data-toggle="modal" data-target="#login" aria-haspopup="true"
							aria-expanded="false" href="">로그인 </a> 
						</li>
					</c:when>
					<c:otherwise>
						<li class="nav-item dropdown no-arrow mx-1">
							<form action='logout.do' id="logout">
								<a class="jeju-user py-3 px-0 px-lg-3 rounded" href="logout.do">로그아웃
								</a>
							</form>
						</li>
					</c:otherwise>
				</c:choose>
				

				<li class="nav-item dropdown no-arrow mx-1"><a
					id="alertsDropdown" class="jeju-user py-3 px-0 px-lg-3 rounded"
					role="button" data-toggle="modal" data-target="#signUp"
					aria-haspopup="true" aria-expanded="false" href="">회원가입 </a></li>


				<li class="nav-item dropdown no-arrow"><a
					class="nav-link dropdown-toggle" href="#" id="userDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <i
						class="fas fa-user-circle fa-fw jeju-user"></i>
				</a>
					<div class="dropdown-menu dropdown-menu-right"
						aria-labelledby="userDropdown">
						<a class="dropdown-item" href="#">Settings</a> <a
							class="dropdown-item" href="#">Activity Log</a>
						<div class="dropdown-divider"></div>
					</div>
				</li>
			</ul>

		</nav>
		<!-- //end of search -->

	</header>




	<!-- 모달 -->
	<!-- modal start -->
	<div class="modal fade" id="login">
		<div class="modal-dialog">
			<div class="modal-content jeju-modal-padding">
				<!-- header -->
				<div class="modal-header jeju-modal">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h3 class="modal-title">Login Form</h3>
				</div>
				<!-- body -->
				<div class="modal-body jeju-modal">
					<div class="jeju-flex-wrap">
						<form action='loginCheck.do' id="loginCheck"
							class="jeju-login-form" method="post">
							<input type="radio" class="jeju-f-input jeju-radio-input"
								id="jeju-sign-in" checked /> <label for="jeju-sign-in"
								class="jeju-f-label">로그인</label> <input
								class="jeju-sign-up jeju-sign-in jeju-reset jeju-f-input"
								type="email" placeholder="Email" name="member_Email" /> <input
								class="jeju-sign-up jeju-sign-in jeju-f-input" type="password"
								placeholder="Password" name="password" />
							<button class="btn-encore_tours jeju-f-button" type="submit"
								id='loginButton'>Submit</button>
						</form>
					</div>
				</div>
				<!-- footer -->
				<div class="modal-footer jeju-modal"></div>
			</div>
		</div>
	</div>
	<!-- // The end of modal start -->
	<!-- 모달 -->
	<!-- modal start -->
	<div class="modal fade" id="signUp">
		<div class="modal-dialog">
			<div class="modal-content jeju-modal-padding">
				<!-- header -->
				<div class="modal-header jeju-modal">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h3 class="modal-title">Login Form</h3>
				</div>
				<!-- body -->
				<div class="modal-body jeju-modal">
					<div class="jeju-flex-wrap">
						<form action='signUp.do' id="signUp" class="jeju-login-form"
							method="post">
							<input type="radio" class="jeju-f-input jeju-radio-input"
								id="jeju-sign-in" checked /> <label for="jeju-sign-in"
								class="jeju-f-label">회원가입</label> <input
								class="jeju-sign-up jeju-sign-in jeju-reset jeju-f-input"
								type="email" placeholder="Email" name="member_Email" /> <input
								class="jeju-sign-up jeju-sign-in jeju-f-input" type="password"
								placeholder="Password" name="password" />
							<button class="btn-encore_tours jeju-f-button" type="submit"
								id='signUpButton'>Submit</button>
						</form>
					</div>
				</div>
				<!-- footer -->
				<div class="modal-footer jeju-modal"></div>
			</div>
		</div>
	</div>
	<!-- // The end of modal start -->

</body>
</html>