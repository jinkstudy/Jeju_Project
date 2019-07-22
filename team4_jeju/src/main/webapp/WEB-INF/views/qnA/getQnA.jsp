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

<!-- 카카오톡 로그인 관련 스트립트 링크 -->
<script src="
	https://developers.kakao.com/sdk/js/kakao.min.js"></script>

<!-- jQuery 링크 -->
<script src="../resources/js/jquery-3.4.1.js"></script>

<!-- api 적용 스크립트 링크 -->
<script src="../resources/js/jeju_gyubeom_kakao_log_in_out.js"></script>

</head>
<body>


	<!-- header -->
	<jsp:include page="../main/header_of_main.jsp"></jsp:include>

	<!-- main title header -->
	<header
		class="masthead bg-encore_tours_background text-white text-center">
		<div class="container d-flex align-items-center flex-column">

			<!-- Masthead Avatar Image -->
			<img class="masthead-avatar mb-5" src="" alt="">

			<!-- Masthead Heading -->
			<h1 class="masthead-heading text-uppercase mb-0">QA 페이지입니다.</h1>

			<!-- Icon Divider -->
			<div class="divider-custom divider-light">
				<div class="divider-custom-line"></div>
				<div class="divider-custom-icon">
					<i class="fas fa-globe-asia"></i>
				</div>
				<div class="divider-custom-line"></div>
			</div>

			<!-- Masthead Subheading -->
			<p class="masthead-subheading font-weight-light mb-0">Enjoy
				Smarter Travel "Only for You"</p>

		</div>
	</header>
	<!-- //end of header -->

	<!-- Contact Section -->
	<section class="page-section" id="contact">
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
						<input name="qnA_Mnum" type="hidden" value="${qnA.qnA_Mnum}" />
						<div class="control-group">
							<div
								class="form-group floating-label-form-group controls mb-0 pb-2">
								<label>${qnA.writer_Name }</label>
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<div class="control-group">
							<div
								class="form-group floating-label-form-group controls mb-0 pb-2">
								<label>${qnA.member_Email }</label>
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<div class="control-group">
							<div
								class="form-group floating-label-form-group controls mb-0 pb-2">
								<label>${qnA.qnA_Title }</label>
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
								<label>${qnA.qnA_Date }</label>
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<div class="control-group">
							<div
								class="form-group floating-label-form-group controls mb-0 pb-2">
								<label>${qnA.qnA_Cnt }</label>
								<p class="help-block text-danger"></p>
							</div>
						</div>
						
						<div id="success"></div>
						<div class="form-group">
							<button type="submit" class="btn btn-encore_tours btn-lg"
								id="sendMessageButton"
								onclick="location.href='../qnA/updateQnA.do'">글 수정</button>
						</div>
					</form>
					<a href="insertQnA.do">글등록</a>&nbsp;&nbsp;&nbsp; 
					<a href="deleteQnA.do?qnA_Mnum=${qnA.qnA_Mnum }">글삭제</a>&nbsp;&nbsp;&nbsp;
					<a href="getQnAList.do">글목록</a>
				</div>
			</div>

		</div>
	</section>

	<!-- footer -->
	<jsp:include page="../main/footer_of_main.jsp"></jsp:include>


</body>

</html>