<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>InsertQnA</title>

<!-- 상세페이지용 css -->
<link
	href="/team4_jeju/resources/style/communityBoard_yoonyoung.css"
	rel="stylesheet">
	
<!-- 게시판 새글 등록 모달 스타일(글 수정에서 활용) -->
<link href="/team4_jeju/resources/style/insertBoard_yoonyoung.css"
	rel="stylesheet">

</head>
<body>


	<!-- header -->
	<jsp:include page="../main/header_of_main.jsp"></jsp:include>
<!-- 댓글 달기 js -->
	<script src="/team4_jeju/resources/js/comment_minhee.js"></script>
	
	<!-- main title header -->
	<header
		class="mastheadd bg-encore_tours_background text-white text-center">
		<div class="container d-flex align-items-center flex-column">

			<!-- Mastheadd Avatar Image -->
			<img class="mastheadd-avatar mb-5" src="" alt="">

			<!-- Mastheadd Heading -->
			<h1 class="mastheadd-heading text-uppercase mb-0">QA 페이지입니다.</h1>

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



<div style="height : 7rem; margin-top : 7rem;"></div>



	<!-- Contact Section -->
	
		<div class="container">
<div class="page-header">
  <h1 align="center"><a href="getQnAList.do">${qnA.qnA_Title }</a></h1><hr/>
 <p align="right"><small>등록일 : ${qnA.qnA_Date } / 조회수 : ${qnA.qnA_Cnt }</small></p>
	<h6 align="right">작성자 : ${qnA.member_Email } </h6>
</div>

<div align="right">
	<!-- 글 수정 모달 불러오기 -->
	<a id="alertsDropdown"
					   class="py-3 px-0 px-lg-3"
					   role="button"
					   data-toggle="modal" 
					   data-target="#modifyBoard"
					   aria-haspopup="true"
					   aria-expanded="false"
					   href="">글 수정 </a>
	<a href="deleteQnA.do?member_Email=${qnA.member_Email }&qnA_Mnum=${qnA.qnA_Mnum}">글 삭제</a>&nbsp;&nbsp;&nbsp;
	</div>
	
		<div class="d-flex align-items-center justify-content-center">
			<table class="comm_content_table">
				<tr>
					<td>내용</td>
					<td>${qnA.qnA_Content}</td>
				</tr>
			</table>	
		</div>

	
	<!-- 글 수정 모달 시작 -->
	<!-- modal start -->
	<div class="com-jeju-modal fade" id="modifyBoard">
	  <div class="modal-dialog">
	    <div class="modal-content jeju-modal-padding">
	      <!-- header -->
	      <div class="modal-header jeju-modal">
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	        <h3 class="modal-title">글 수정</h3>
	      </div>
	      <!-- body -->
	      <div class="modal-body jeju-modal">
	      	<!-- 1. 폼태그에 속성 추가  -->
		       <form action="updateCommunityBoard.do" method="post">
		<input name="member_Email" type="hidden" value="${qnA.member_Email }"/>
		<input name="qnA_Mnum" type="hidden" value="${qnA.qnA_Mnum }"/>
			<table class="no-style" >
				<tr>
					<td width="70">제목</td>
					<td align="left"><input name="qnA_Title" type="text"
					value="${qnA.qnA_Title}"/></td> 
				</tr>
				<tr>
					<td>내용</td>
					<td align="left"><textarea name="qnA_Content" cols="40" rows="10">${qnA.qnA_Content }</textarea></td>
				</tr>
				<tr>
					<td>등록일</td>
					<td align="left">${qnA.qnA_Date }</td>
				</tr>
				<tr>
					<td>조회수</td>
					<td align="left">${qnA.qnA_Cnt }</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<input type="submit" value="글 수정" /></td>
				</tr>
			</table>
		</form>
			</div>
	      </div>
	      
	    </div>
	  </div>
	<!-- // The end of modal start -->
	
	<!-- 댓글달기 시작 -->
	<div class="container">
	
    <form id="commentListForm" name="commentListForm" method="post">
		<div>
                <span><strong>Comments</strong></span> <span id="cCnt"></span>
            </div>
        <div id="commentList">

<%-- 			<c:forEach items="${reply}" var="reply"> --%>
<!-- 				<table class='table' id="reply_table_hoho"> -->
<!-- 					<tr> -->
<!-- 						<td> -->
<!-- 							<div class="row"> -->
<%-- 								<div class="col-md-3">작성자:&nbsp;<strong>${reply.member_Email}</strong></div> --%>
<!-- 								<div class="col-md-3"></div> -->
<!-- 								<div class="col-md-3">									 -->
<!-- 								</div> -->
<!-- 								<div class="col-md-3"> -->
<!-- 									&nbsp;&nbsp; -->
<%-- 									${reply.reply_Date} --%>
<!-- 									&nbsp;&nbsp; -->
<!-- 									<button role="button" class="btn btn-xs reply-buttons" -->
<!-- 									   name="modifyComment" -->
<!-- 									   >수정</button> -->
<!-- 									&nbsp;&nbsp; -->
<!-- 									<button role="button" class="btn btn-xs reply-buttons" -->
<!-- 							           name="deleteComment" -->
<!-- 							           >삭제</button> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 						</td> -->
<!-- 					</tr> -->
<!-- 					<tr> -->
<!-- 						<td> -->
<!-- 							<div class="reply_content"> -->
<%-- 							${reply.reply_Content} --%>
<!-- 							</div> -->
<!-- 						</td> -->
<!-- 					</tr> -->
<!-- 				</table> -->
<%-- 			</c:forEach> --%>
	
		</div>

    </form>
	</div>
	<div class="container">
    <form id="commentForm" name="commentForm" method="post">
    <br><br>
        <div>            
            <div>
                <table class="table">                 
                    <tr>
                        <td>
                            <textarea id="reply_Content" style="width: 100%" rows="3" cols="30" name="comment" placeholder="댓글을 입력하세요"></textarea>
                            <input type="hidden" value="${qnA.qnA_Mnum}" id="qnA_Mnum"/>
                            <input type="hidden" value="${qnA.member_Email}" id="member_Email"/>
                            <br>
                            <div>
                                <a id="addCommentBtn" class="btn pull-right btn-encore_tours">댓글 등록</a>
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </form>
</div>
 <!-- 댓글 달기 끝 -->
		</div>

<div style="height : 7rem; margin-bottom : 7rem;"></div>

	<!-- footer -->
	<jsp:include page="../main/footer_of_main.jsp"></jsp:include>


</body>

</html>