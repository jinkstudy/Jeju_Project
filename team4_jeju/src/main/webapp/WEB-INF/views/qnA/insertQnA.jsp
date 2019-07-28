<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>

<title>InsertQnA</title>

<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

</head>
<body>


	<!-- header -->
	<jsp:include page="../main/header_of_main.jsp"></jsp:include>

	<div style="margin-top : 17rem;"></div>
	

	<!-- Contact Section -->
	
		<div class="container">

			<!-- Contact Section Heading -->
			<h2	class="page-section-heading text-center text-uppercase text-secondary mb-0">
			무엇이든 물어보세요</h2>

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
					<form action="/team4_jeju/qnA/saveQnA.do" 
					      method="post" 
					      id="encoreQnAForm" novalidate="novalidate">
						<div class="control-group">
							<div
								class="form-group floating-label-form-group controls mb-0 pb-2">
								<label>Name</label> 
								<input value="" required class="form-control" 
								name="writer_Name"
									type="text" placeholder="Name" required="required"
									data-validation-required-message="Please enter your name.">
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<div class="control-group">
							<div
								class="form-group floating-label-form-group controls mb-0 pb-2">
								<label>Email Address</label> <input value="" required class="form-control"
									name="member_Email" type="email" placeholder="Email Address">
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<div class="control-group">
							<div
								class="form-group floating-label-form-group controls mb-0 pb-2">
								<label>Title</label> 
								<input value="" required class="form-control" 
								name="qnA_Title"
									type="text" placeholder="Title" required="required"
									data-validation-required-message="Please enter your title.">
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<div class="control-group">
							<div
								class="form-group floating-label-form-group controls mb-0 pb-2">
								<label>Message</label>
								<textarea value="" required class="form-control" 
								name="qnA_Content" rows="5"
									placeholder="Message" required="required"
									data-validation-required-message="Please enter a message."></textarea>
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<div class="control-group">
							<div
								class="form-group floating-label-form-group controls mb-0 pb-2">
								<label>Password</label> 
								<input value="" required class="form-control"
									name="writer_Pw" type="password" placeholder="Password"
									required="required"
									data-validation-required-message="Please enter your Password.">
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<br>
						<div id="success"></div>						
					</form>
					<div class="form-group">
							<button type="submit" 
							class="btn btn-encore_tours btn-lg" 
							id="sendQnAMessageButton" >문의하기</button>
					</div>
				</div>
			</div>

		</div>
	
	
	<div style="margin-bottom : 17rem;"></div>
	
	<!-- footer -->
	<jsp:include page="../main/footer_of_main.jsp"></jsp:include>

</body>

</html>