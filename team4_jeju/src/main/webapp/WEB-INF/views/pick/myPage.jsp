<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="/team4_jeju/resources/style/myPage_yoonyoung.css" type="text/css">
<!-- 링크 순서 중요 -->

	
<!-- Page level plugin CSS-->
<link
	href="/team4_jeju/resources/style/dataTables.bootstrap4_gyubeom.css"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="/team4_jeju/resources/style/sb-admin_gyubeom.css"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:100,300,400,500,700,900&display=swap&subset=korean"
	rel="stylesheet">
</head>
<body>

	<!-- header -->
	<jsp:include page="../main/header_of_main.jsp"></jsp:include>
<!-- main title header -->
	<header
		class="mastheadd bg-encore_tours_background text-white text-center">
		<div class="container d-flex align-items-center flex-column">

			<!-- Mastheadd Avatar Image -->
			<img class="mastheadd-avatar mb-5" src="" alt="">

			<!-- Mastheadd Heading -->
			<h1 class="mastheadd-heading text-uppercase mb-0">My Page.</h1>

			<!-- Icon Divider -->
			<div class="divider-custom divider-light">
				<div class="divider-custom-line"></div>
				<div class="divider-custom-icon">
					<i class="fas fa-globe-asia"></i>
				</div>
				<div class="divider-custom-line"></div>
			</div>

			<!-- Mastheadd Subheading -->
			<p class="mastheadd-subheading font-weight-light mb-0">Enjoy
				Smarter Travel "Only for You"</p>

		</div>
	</header>
	<!-- //end of header -->
	<!-- start of map drawing and title -->
	<div
		class="container long-height-jeju">
		<div class="mypage-tab" id="mypage-tab">
			<ul class="nav nav-tabs" id="myTab" role="tablist">
				<li class="nav-item"><a class="nav-link active" id="pick-tab"
					data-toggle="tab" href="#tabPickList" role="tab"
					aria-controls="tabPickList" aria-selected="true">내가 찜한 목록</a></li>
					
				<li class="nav-item"><a class="nav-link" id="community-tab"
					data-toggle="tab" href="#tabCommunityBoardList" role="tab"
					aria-controls="tabCommunityBoardList" aria-selected="false">내가 쓴 글</a></li>
					
				<li class="nav-item"><a class="nav-link" id="mylist-tab"
					data-toggle="tab" href="#contact" role="tab"
					aria-controls="contact" aria-selected="false">나의 일정 확인하기</a></li>
					
					
				<li class="nav-item"><a class="nav-link" id="qA-tab"
					data-toggle="tab" href="#tabQnaBoardList" role="tab" aria-controls="tabQnaBoardList"
					aria-selected="false">나의 QnA</a></li>
			</ul>
			<div class="tab-content" id="myTabContent">
			<!-- pickList 시작 -->
				<div class="tab-pane fade show active" id="tabPickList" role="tabpanel"
					aria-labelledby="home-tab">
					<table class="table table-bordered table-hover" id="dataTable" width="100%"
					cellspacing="0">
						<thead>
							<tr>
								<th>장소 이름</th>
								<th>오픈 시간</th>
								<th>마감 시간</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${pickList}" var="pickList">
								<tr>
									<td>${pickList.place_Name}</td>
									<td>${pickList.open_Time}</td>
									<td>${pickList.close_Time}</td>
								</tr>
							</c:forEach>
						</tbody>
						</table>
				</div>
				<!-- communityList -->
				<div class="tab-pane fade" id="tabCommunityBoardList" role="tabpanel"
					aria-labelledby="profile-tab">
						<table class="table table-bordered table-hover" id="dataTable" width="100%"
					cellspacing="0">
						<thead>
							<tr>
								<th>장소 이름</th>
								<th>오픈 시간</th>
								<th>마감 시간</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${pickList}" var="pickList">
								<tr>
									<td>${pickList.place_Name}</td>
									<td>${pickList.open_Time}</td>
									<td>${pickList.close_Time}</td>
								</tr>
							</c:forEach>
						</tbody>
						</table>

				</div>
					
				<!-- my plan List -->
				<div class="tab-pane fade" id="contact" role="tabpanel"
					aria-labelledby="contact-tab">Contact</div>
					
				<!-- myQnaBoardList -->
				<div class="tab-pane fade" id="tabQnaBoardList" role="tabpanel"
					aria-labelledby="qA-tab">QnA</div>
					
			</div>
		</div>
	</div>
	<!--// The end of map drawing and title -->

<!-- 	<section class="page-section portfolio" id="portfolio"> -->
<!-- 		<div class="container"> -->

<!-- 			<div class="d-flex align-items-center justify-content-center"> -->

<!-- 				<table class="table table-bordered table-hover" -->
<!-- 					style="width: 350px; text-align: center;"> -->
<!-- 					<tr> -->
<!-- 						<th colspan='2'>Tour</th> -->
<!-- 					</tr> -->
<!-- 				</table> -->
<!-- 			</div> -->

<!-- 			<div class="d-flex align-items-center justify-content-center"> -->
<!-- 				<table class="no-style"> -->
<!-- 					<tr> -->
<!-- 						<td>Tour Test Page</td> -->
<!-- 					</tr> -->
<!-- 				</table> -->
<!-- 			</div> -->
<!-- 		</div> -->

<!-- 	</section> -->

	<!-- footer -->
	<jsp:include page="../main/footer_of_main.jsp"></jsp:include>

<!-- Page level plugin JavaScript-->
<script src="/team4_jeju/resources/js/jquery.dataTables_gyubeom.js"></script>
<script src="/team4_jeju/resources/js/dataTables.bootstrap4_gyubeom.js"></script>

<!-- Custom scripts for all pages-->
<script src="/team4_jeju/resources/js/sb-admin_gyubeom.js"></script>

<!-- Demo scripts for this page-->
<script src="/team4_jeju/resources/js/datatables-demo_gyubeom.js"></script>

</body>
</html>