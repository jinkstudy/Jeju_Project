<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>글 상세 페이지</title>

<!-- 상세페이지용 css -->
<link
	href="/team4_jeju/resources/style/communityBoard_yoonyoung.css"
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
	<!-- //end of header -->		
	
	<section class="page-section portfolio" id="portfolio">
		<div class="container">
		
<!-- 			<div class="d-flex align-items-center justify-content-center"> -->
			
<!-- 			<table class="table table-bordered table-hover" -->
<!-- 				   style="width: 350px; text-align: center;"> -->
<!-- 				<tr> -->
<!-- 					<th colspan='2'>글 상세 페이지</th> -->
<!-- 				</tr> -->
<!-- 			</table> -->
<!-- 		</div> -->

<div class="page-header">
  <h1 align="center"><a href="getCommunityBoardList.do">${community.comm_Title }</a></h1><hr/>
 <p align="right"><small>등록일 : ${community.comm_Date } / 조회수 : ${community.comm_Cnt }</small></p>
	<h6 align="right">작성자 : ${community.member_Email } </h6>
</div>

<div class="d-flex align-items-center justify-content-center">

			<div class="panel panel-default">
			  <div class="panel-body">
			    내용
			  </div>
			  <div class="panel-footer">Panel footer</div>
			</div>
		<table class="no-style" >
 				<tr>
					<td>내용</td>
					<td align="left"><div class="comm-content">${community.comm_Content }</div></td>
				</tr>
	</table>
</div>
		
		<div class="d-flex align-items-center justify-content-center">	
<!-- 		<hr> -->
<!-- 		<form action="updateCommunityBoard.do" method="post"> -->
<%-- 		<input name="member_Email" type="hidden" value="${community.member_Email }"/> --%>
<%-- 		<input name="comm_Mnum" type="hidden" value="${community.comm_Mnum }"/> --%>
		
		
<!-- 			<table class="no-style" > -->
<!-- 				<tr> -->
<!-- 					<td width="70">제목</td> -->
<!-- 					<td align="left"><input name="comm_Title" type="text" -->
<%-- 					value="${community.comm_Title }"/></td>  --%>
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<td>내용</td> -->
<%-- 					<td align="left"><textarea name="comm_Content" cols="40" rows="10">${community.comm_Content }</textarea></td> --%>
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<td>등록일</td> -->
<%-- 					<td align="left">${community.comm_Date }</td> --%>
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<td>조회수</td> -->
<%-- 					<td align="left">${community.comm_Cnt }</td> --%>
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<td colspan="2" align="center"> -->
<!-- 					<input type="submit" value="글 수정" /></td> -->
<!-- 				</tr> -->
<!-- 			</table> -->
<!-- 		</form> -->
<!-- 		<hr> -->
		<a href="deleteCommunityBoard.do?member_Email=${community.member_Email }&comm_Mnum=${community.comm_Mnum}">삭제</a>&nbsp;&nbsp;&nbsp;
		</div>
	</div>
			
	</section>
	
	<!-- footer -->
	<jsp:include page="../main/footer_of_main.jsp"></jsp:include>

</body>
</html>