<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Page level plugin CSS-->
<link
	href="/team4_jeju/resources/style/dataTables.bootstrap4_gyubeom.css"
	rel="stylesheet">
	
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
			<h1 class="masthead-heading text-uppercase mb-0">Community 페이지입니다.</h1>

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

	<!-- DataTables -->
	<div class="card mb-3">
		<div class="card-header">
			<i class="fas fa-table"></i>Community Board List
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
			<thead>
				<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>등록일</th>
				<th>조회수</th>
			</thead>
			<tbody>
				<c:forEach items="${community}" var="community">
				<td>${community.comm_Mnum }</td>
				<td align="left"><a href="getCommunityBoard.do?member_Email=${community.member_Email }&comm_Mnum=${community.comm_Mnum}">
							${community.comm_Title }</a></td>
				<td>${community.member_Email }</td>
				<td>${community.comm_Date }</td>
				<td>${community.comm_Cnt }</td>	
				</tr>
				</c:forEach>
				</tbody>
			</table>
			<!-- Scroll to Top Button-->
		<a class="scroll-to-top rounded" href="#page-top"> <i
			class="fas fa-angle-up"></i>
		</a>
			</div>
		</div>
	</div>
			  <!-- Page level plugin JavaScript-->
  <script src="/team4_jeju/resources/js/jquery.dataTables_gyubeom.js"></script>
  <script src="/team4_jeju/resources/js/dataTables.bootstrap4_gyubeom.js"></script>		
		<br> <a href="insertCommunityBoard.do">새글 등록</a>

	</section>

	<!-- footer -->
	<jsp:include page="../main/footer_of_main.jsp"></jsp:include>

</body>
</html>