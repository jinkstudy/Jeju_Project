<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insertCommunityBoard</title>
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
	<!-- //end of header -->		
	
	<section class="page-section portfolio" id="portfolio">
		<div class="container">
		
			<div class="d-flex align-items-center justify-content-center">
			
			<table class="table table-bordered table-hover"
				   style="width: 350px; text-align: center;">
				<tr>
					<th colspan='2'>글 등록</th>
				</tr>
			</table>
		</div>
		
		<div class="d-flex align-items-center justify-content-center">
			<!-- 1. 폼태그에 속성 추가  -->
		<form action="saveCommunityBoard.do" method="post" enctype="multipart/form-data"> <!-- 파일이 하나라도 포함된 상태로 넘기려면 이 형식을 반드시 지켜줘야한다. --> 
			<table class="no-style">
				<!-- 2. 각 항목에  name 맞추기 -->
				<tr>
					<td width="70">제목</td>
					<td align="left"><input type="text" name="Comm_Title"/></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td align="left"><input type="text" name="Member_Email"/></td>
				</tr>
				<tr>
					<td>내용</td>
					<td align="left"><textarea cols="40" rows="10" name="Comm_Content"></textarea></td>
				</tr>
				<!-- 추가항목 시작 -->
				<tr>
					<td>비밀번호</td>
					<td align="left"><input type="text" name="Comm_Pass" />
					</td>
				</tr>
				<!-- 추가항목 끝 -->
				<tr>
					<td colspan="2" align="center"><input type="submit"	value=" 새글 등록 " /></td>
				</tr>
			</table>
		</form>
		</div>
	</div>
	</section>
	<hr>
		<a href="getCommunityBoardList.do">글 목록 가기</a>
	<!-- footer -->
<jsp:include page="../main/footer_of_main.jsp"></jsp:include>
</body>
</html>