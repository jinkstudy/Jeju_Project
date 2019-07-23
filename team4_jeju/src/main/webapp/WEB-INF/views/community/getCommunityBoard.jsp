<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>글 상세 페이지</title>

</head>
<body>
	
	<!-- header -->
	<jsp:include page="../main/header_of_main.jsp"></jsp:include>
	
	<!-- main title header -->
	<header class="mastheadd bg-encore_tours_background text-white text-center">
		<div class="container d-flex align-items-center flex-column">

			<!-- Mastheadd Avatar Image -->
			<img class="mastheadd-avatar mb-5" src="" alt="">

			<!-- Mastheadd Heading -->
			<h1 class="mastheadd-heading text-uppercase mb-0">Community 페이지입니다.</h1>

			<!-- Icon Divider -->
			<div class="divider-custom divider-light">
				<div class="divider-custom-line"></div>
				<div class="divider-custom-icon">
					<i class="fas fa-globe-asia"></i>
				</div>
				<div class="divider-custom-line"></div>
			</div>

			<!-- Mastheadd Subheading -->
			<p class="mastheadd-subheading font-weight-light mb-0">
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
					<th colspan='2'>글 상세 페이지</th>
				</tr>
			</table>
		</div>
		
		<div class="d-flex align-items-center justify-content-center">	
		<hr>
		<form action="updateCommunityBoard.do" method="post">
		<input name="member_Email" type="hidden" value="${community.member_Email }"/>
		<input name="comm_Mnum" type="hidden" value="${community.comm_Mnum }"/>
			<table class="no-style" >
				<tr>
					<td width="70">제목</td>
					<td align="left"><input name="comm_Title" type="text"
						value="${community.comm_Title }" /></td>
				</tr>
				<tr>
					<td >작성자</td>
					<td align="left">${community.member_Email }</td>
				</tr>
				<tr>
					<td>내용</td>
					<td align="left"><textarea name="comm_Content" cols="40" rows="10">${community.comm_Content }</textarea></td>
				</tr>
				<tr>
					<td>등록일</td>
					<td align="left">${community.comm_Date }</td>
				</tr>
				<tr>
					<td>조회수</td>
					<td align="left">${community.comm_Cnt }</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<input type="submit" value="글 수정" /></td>
				</tr>
			</table>
		</form>
		<hr>
		<a href="insertCommunityBoard.do">글등록</a>&nbsp;&nbsp;&nbsp; 
		<a href="deleteCommunityBoard.do?member_Email=${community.member_Email }&comm_Mnum=${community.comm_Mnum}">글삭제</a>&nbsp;&nbsp;&nbsp;
		<a href="getCommunityBoardList.do">글목록</a>
		</div>
	</div>
			
	</section>
	
	<!-- footer -->
	<jsp:include page="../main/footer_of_main.jsp"></jsp:include>

</body>
</html>