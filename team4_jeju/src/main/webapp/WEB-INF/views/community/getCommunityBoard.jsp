<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
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
	<!-- 댓글 달기 js -->
<script src="/team4_jeju/resources/js/comment_yoonyoung.js"></script>
	
			<!-- main title header -->
	<header
		class="mastheadd bg-encore_tours_background text-white text-center">
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
			<p class="mastheadd-subheading font-weight-light mb-0">Enjoy
				Smarter Travel "Only for You"</p>

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
			<table class="comm_content_table">
				<tr>
					<td>내용</td>
					<td>${community.comm_Content}</td>
				</tr>
			</table>	
		</div>
	<div align="right">
	<a href="deleteCommunityBoard.do?member_Email=${community.member_Email }&comm_Mnum=${community.comm_Mnum}">글 삭제</a>&nbsp;&nbsp;&nbsp;
	</div>				
<!-- 		<div class="d-flex align-items-center justify-content-center">	 -->
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
	
<!-- 		</div> -->
	
	<!-- 댓글달기 시작 -->
	<div class="container">
    <form id="commentListForm" name="commentListForm" method="post">

        <div id="commentList">
 
          	<c:forEach items="${reply}" var="reply">

          	
          	<table class='table'><h6><strong>${reply.member_Email}</strong></h6>
          	<tr><td>${reply.reply_Content}</td></tr>
          	</table>
          	
    		</c:forEach>
    		
        </div>

    </form>
	</div>
	<div class="container">
    <form id="commentForm" name="commentForm" method="post">
    <br><br>
        <div>
            <div>
                <span><strong>Comments</strong></span> <span id="cCnt"></span>
            </div>
            <div>
                <table class="table">                    
                    <tr>
                        <td>
                            <textarea id="reply_Content" style="width: 100%" rows="3" cols="30" name="comment" placeholder="댓글을 입력하세요"></textarea>
                            <input type="hidden" value="${community.comm_Mnum}" id="comm_Mnum"/>
                            <input type="hidden" value="${community.member_Email}" id="member_Email"/>
                            <br>
                            <div>
                                <a id="addCommentBtn" class="btn pull-right btn-success">등록</a>
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
        <input type="hidden" id="b_code" name="b_code" value="${result.code }" />        
    </form>
</div>
 <!-- 댓글 달기 끝 -->
	</div>
			
	</section>
	
	<!-- footer -->
	<jsp:include page="../main/footer_of_main.jsp"></jsp:include>

</body>
</html>