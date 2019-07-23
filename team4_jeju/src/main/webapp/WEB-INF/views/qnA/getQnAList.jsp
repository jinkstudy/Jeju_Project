<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- 링크 순서 중요 -->

<!-- Page level plugin CSS-->
<link
	href="/team4_jeju/resources/style/dataTables.bootstrap4_gyubeom.css"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="/team4_jeju/resources/style/sb-admin_gyubeom.css"
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
			<h1 class="mastheadd-heading text-uppercase mb-0">QnA 페이지입니다.</h1>

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

	<!-- Contact Section -->
	<section class="page-section" id="contact">
	<div class="card mb-3">
		<div class="card-header">
			<i class="fas fa-table"></i>QnA Board List
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable">
					<thead>
						<tr>
							<th bgcolor="skyblue" width="100">번호</th>
							<th bgcolor="skyblue" width="200">제목</th>
							<th bgcolor="skyblue" width="150">작성자</th>
							<th bgcolor="skyblue" width="150">등록일</th>
							<th bgcolor="skyblue" width="100">조회수</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${qnAList }" var="qnA">
							<tr>
								<td>${qnA.qnA_Mnum }</td>
								<td align="left"><a
									href="getQnA.do?qnA_Mnum=${qnA.qnA_Mnum }"> ${qnA.qnA_Title }</a></td>
								<td>${qnA.writer_Name }</td>
								<td>${qnA.qnA_Date }</td>
								<td>${qnA.qnA_Cnt }</td>
							</tr>

						</c:forEach>
					</tbody>
				</table>
				<br> <a href="../qnA/insertQnA.do">새글 등록</a>

			</div>
		</div>
	</div>
	</section>

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