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
<!-- 게시판 새글 등록 모달 스타일 -->
<link href="/team4_jeju/resources/style/insertBoard_yoonyoung.css"
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
				<td align="left"><a href="getCommunityBoard.do?comm_Mnum=${community.comm_Mnum}">
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

	<br> <!-- <a href="insertCommunityBoard.do">새글 등록</a> -->
<a id="alertsDropdown"
					   class="jeju-user py-3 px-0 px-lg-3 rounded"
					   role="button"
					   data-toggle="modal" 
					   data-target="#insertBoard"
					   aria-haspopup="true"
					   aria-expanded="false"
					   href="">새글 등록 </a>
	</section>
<!-- 모달 -->
	<!-- modal start -->
	<div class="com-jeju-modal fade" id="insertBoard">
	  <div class="modal-dialog">
	    <div class="modal-content jeju-modal-padding">
	      <!-- header -->
	      <div class="modal-header jeju-modal">
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	        <h3 class="modal-title">새글 등록</h3>
	      </div>
	      <!-- body -->
	      <div class="modal-body jeju-modal">
<!-- 	      	<div class="jeju-flex-wrap"> -->
	      	<!-- 1. 폼태그에 속성 추가  -->
		        <form action="saveCommunityBoard.do" method="post">
		        <table class="no-style">
				<!-- 2. 각 항목에  name 맞추기 -->
				<tr>
					<td width="70">제목</td>
					<td align="left"><input type="text" name="comm_Title"/></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td align="left"><input type="text" name="member_Email"/></td>
				</tr>
				<tr>
					<td>내용</td>
					<td align="left"><textarea cols="40" rows="10" name="comm_Content"></textarea></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"	value=" 새글 등록 " /></td>
				</tr>
				</table>
		        </form>
			</div>
	      </div>	      
	      <!-- footer -->
	      <div class="modal-footer jeju-modal">
	      </div>
	      
	    </div>
	  </div>
<!-- 	</div> -->
	<!-- // The end of modal start -->
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