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


<!-- jQuery 링크 -->
<script src="../resources/js/jquery-3.4.1.js"></script>



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

	<!-- Contact Section -->
	
		<div class="container">

			<!-- Contact Section Heading -->
			<h2
				class="page-section-heading text-center text-uppercase text-secondary mb-0">무엇이든
				물어보세요</h2>

			<!-- Icon Divider -->
			<div class="divider-custom">
				<div class="divider-custom-line"></div>
				<div class="divider-custom-icon">
					<i class="fas fa-comments"></i>
				</div>
				<div class="divider-custom-line"></div>
			</div>

			<!-- Contact Section Form -->
			<div class="row">
				<div class="col-lg-8 mx-auto">
					<!-- To configure the contact form email address, go to mail/contact_me.php and update the email address in the PHP file on line 19. -->
					<form action="updateQnA.do" method="post" id="contactForm"
						novalidate="novalidate">
<%-- 						<input name="qnA_Cnt" type="hidden" value="${qnA.qnA_Cnt }"/> --%>
						<input name="qnA_Mnum" type="hidden" value="${qnA.qnA_Mnum}" />
						<div class="control-group">
							<div
								class="form-group floating-label-form-group controls mb-0 pb-2">
								<div>${qnA.writer_Name }</div>
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<div class="control-group">
							<div
								class="form-group floating-label-form-group controls mb-0 pb-2">
								<div>${qnA.member_Email }</div>
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<div class="control-group">
							<div
								class="form-group floating-label-form-group controls mb-0 pb-2">
								<div>${qnA.qnA_Title }</div>
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<div class="control-group">
							<div
								class="form-group floating-label-form-group controls mb-0 pb-2">
								<label>Message</label>
								<textarea class="form-control" name="qnA_Content" rows="5"
									placeholder="Message" required="required"
									data-validation-required-message="Please enter a message.">${qnA.qnA_Content }</textarea>
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<div class="control-group">
							<div
								class="form-group floating-label-form-group controls mb-0 pb-2">
								<div>${qnA.qnA_Date }</div>
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<div class="control-group">
							<div
								class="form-group floating-label-form-group controls mb-0 pb-2">
								<div>${qnA.qnA_Cnt }</div>
								<p class="help-block text-danger"></p>
							</div>
						</div>
						
						<div id="success"></div>
						<div class="form-group">
							<button type="submit" class="btn btn-encore_tours btn-lg"
								id="sendMessageButton">글 수정</button>
						</div>
					</form>
					<a href="insertQnA.do">글등록</a>&nbsp;&nbsp;&nbsp; 
					<a href="deleteQnA.do?qnA_Mnum=${qnA.qnA_Mnum }">글삭제</a>&nbsp;&nbsp;&nbsp;
					<a href="getQnAList.do">글목록</a>
				</div>
			</div>

		</div>

	<!-- footer -->
	<jsp:include page="../main/footer_of_main.jsp"></jsp:include>


</body>

</html>