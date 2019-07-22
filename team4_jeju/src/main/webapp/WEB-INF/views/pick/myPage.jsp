<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="/team4_jeju/resources/style/myPage_yoonyoung.css" type="text/css">

<link
	href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:100,300,400,500,700,900&display=swap&subset=korean"
	rel="stylesheet">
</head>
<body>

	<!-- header -->
	<jsp:include page="../main/header_of_main.jsp"></jsp:include>

	<!-- start of map drawing and title -->
	<div
		class="container long-height-jeju">
		<div class="mypage-tab" id="mypage-tab">
			<ul class="nav nav-tabs" id="myTab" role="tablist">
				<li class="nav-item"><a class="nav-link active" id="home-tab"
					data-toggle="tab" href="#home" role="tab"
					aria-controls="home" aria-selected="true">내가 찜한 목록</a></li>
				<li class="nav-item"><a class="nav-link" id="profile-tab"
					data-toggle="tab" href="#profile" role="tab"
					aria-controls="profile" aria-selected="false">내가 쓴 글</a></li>
				<li class="nav-item"><a class="nav-link" id="contact-tab"
					data-toggle="tab" href="#contact" role="tab"
					aria-controls="contact" aria-selected="false">나의 일정 확인하기</a></li>
				<li class="nav-item"><a class="nav-link" id="qA-tab"
					data-toggle="tab" href="#qA" role="tab" aria-controls="contact"
					aria-selected="false">나의 QnA</a></li>
			</ul>
			<div class="tab-content" id="myTabContent">
				<div class="tab-pane fade show active" id="home" role="tabpanel"
					aria-labelledby="home-tab">
					<div class="d-flex align-items-center justify-content-center">
						<table class="pick_list_table">
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
				<div class="tab-pane fade" id="profile" role="tabpanel"
					aria-labelledby="profile-tab">Profile</div>
				<div class="tab-pane fade" id="contact" role="tabpanel"
					aria-labelledby="contact-tab">Contact</div>
				<div class="tab-pane fade" id="qA" role="tabpanel"
					aria-labelledby="qA-tab">QnA</div>
			</div>
		</div>
	</div>
	<!--// The end of map drawing and title -->

	<section class="page-section portfolio" id="portfolio">
		<div class="container">

			<div class="d-flex align-items-center justify-content-center">

				<table class="table table-bordered table-hover"
					style="width: 350px; text-align: center;">
					<tr>
						<th colspan='2'>Tour</th>
					</tr>
				</table>
			</div>

			<div class="d-flex align-items-center justify-content-center">
				<table class="no-style">
					<tr>
						<td>Tour Test Page</td>
					</tr>
				</table>
			</div>
		</div>

	</section>

	<!-- footer -->
	<jsp:include page="../main/footer_of_main.jsp"></jsp:include>

</body>
</html>