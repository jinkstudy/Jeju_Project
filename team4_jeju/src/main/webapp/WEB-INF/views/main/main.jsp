<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<META HTTP-EQUIV="Page-exit" CONTENT="BlendTrans(Duration=0.5)">
<META HTTP-EQUIV="Page-Enter" CONTENT="BlendTrans(Duration=0.5)">

<title>Encore Tours</title>

<!-- 하기 수정 금지. -->
<style type="text/css">
	.swal-overlay {
	  background-color: rgba(43, 165, 137, 0.45);
	}
	
	#divLoading{
		z-index : 1700;
		color : #00BFFF;
		font-size : 4rem;
		font-weight : 700;
	}
</style>



</head>

<body id="page-top">

<div id="divLoading" style="position:absolute; top:25rem; left:0; width:100%; text-align:center; margin:0 auto;">
	<img src="/team4_jeju/resources/imgs/image_gyubeom/loading_gyubeom.gif"
	     alt="" />
	LOADING 중 입니다...
</div>
	
	<!-- 헤더에 링크 파일 기술 되어 있음. -->
	<jsp:include page="./header_of_main.jsp"></jsp:include>

	<!-- main title header -->
	<div class="masthead bg-encore_tours_background text-white text-center"
	     id="jeju-main-head">
	     <img src="/team4_jeju/resources/imgs/main_image-cover.png"
	     	  alt="" />
		<div class="d-flex align-items-center flex-column">
			
			<!-- start of booking container -->
			<div class="container"
			     id="jeju-booking-container">
				<div class="row">
					
					<!-- Home title -->
					<div id="jeju-home-title">
							Encore Tours<br>
							<h1>Journey for not others</h1>
							<h1>but Only for 'You'</h1>
					</div>
				
					<div class="booking-form">
										
 						<!-- <div class="booking-bg"></div> -->
						
						
						
						<!-- The start of input form -->
						<!-- test -->
						<!-- <form id="jeju_journey_input_form"
						      action="/team4_jeju/tour/insertTourSchTestPage.do"
						      method="POST"> -->
						
						<form id="jeju_journey_input_form"
						      action="/team4_jeju/tour/insertTourSchTestPage.do"
						      method="POST">						      
							
						
						      <div class="form-header">
								<h3></h3>
							</div>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<span class="form-label">여행 시작일</span> 
										<input class="form-control"
										       id="start_Date"
										       name="start_Date"
										       type="date" required />
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<span class="form-label">여행 종료일</span> 
										<input class="form-control"
										       id="finish_Date"
										       name="finish_Date"
										       type="date" required />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<span class="form-label">성인수</span> 
										<input class="form-control"
										       id = "adultNum"
										       name="adultNum"
										       value=1
										       type="number" required />
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<span class="form-label">아동수</span> 
										<input class="form-control" 
										       id="childrenNum"
										       name="childrenNum"
										       value=0
										       type="number" required />
									</div>
								</div>
							</div>
							<div class="form-group">
								<span class="form-label">- Options -</span>
								<div class="row place-opt"
								     id="tour_place_opt">
									<a class="select-button col-md-4 btn-outline-light" 
						     		   style="cursor: pointer"
						     		   id="hot_place_option">핫플레이스</a>
									<a class="select-button col-md-4 btn-outline-light" 
						               style="cursor: pointer"
						               id="moderately_place_option">적당히</a>
									<a class="select-button col-md-4 btn-outline-light"
						     		   style="cursor: pointer"
						     		   id="hide_place_option">숨은 명소</a>								
								</div>
								<div class="row speed-opt"
								     id="tour_speed_opt">
									<a class="select-button col-md-4 btn-outline-light"
									     style="cursor: pointer"
									     id="slow_speed_option">여유롭게</a>
									<a class="select-button col-md-4 btn-outline-light"
									     style="cursor: pointer"
									     id="moderately_speed_option">보통</a>
									<a class="select-button col-md-4 btn-outline-light"
									     style="cursor: pointer"
									     id="quickly_speed_option">휙 빠르게</a>
								</div>

							</div>

							<div class="form-group">
								<div class="row sch-opt">
									<div class="col-md-4">
										<input type="checkbox" name="romantic"
										       id="romantic_check_option"
										       name="romantic_check_option"
										       value="romantic" />
										&nbsp;로맨틱
									</div>
									<div class="col-md-4">
										<input type="checkbox" name="photo" 
										       id="photospot_check_option"
										       name="photospot_check_option"								
										       value="photo" />
										&nbsp;포토스팟
									</div>
									<div class="col-md-4">
										<input type="checkbox" name="healing" 
										       id="healing_check_option"
										       name="healing_check_option"
										       value="healing" />
										&nbsp;힐링
									</div>
								</div>
								<div class="row sch-opt">
									<div class="col-md-4">
										<input type="checkbox" name="culture" 
										       id="culture_exep_check_option"
										       name="culture_exep_check_option"
										       value="culture" />
										&nbsp;문화/체험
									</div>
									<div class="col-md-4">
										<input type="checkbox" name="indoor" 
										       id="inner_check_option"
										       name="inner_check_option"
										       value="indoor" />
										&nbsp;실내
									</div>
									<div class="col-md-4">
										<input type="checkbox" name="shopping" 
										       id="activity_check_option"
										       name="activity_check_option"
											   value="activity" />
										&nbsp;액티비티
									</div>
								</div>


							</div>

							<div class="form-btn">
								<button class="submit-btn btn btn-outline-light"
								        id="pleaseMakeMap"
								        type="button">
								        <!-- href="/team4_jeju/tour/tourDrawingPage.do"> -->
								      나만의 여행 만들기
								</button>
							</div>
							
							<!-- hidden -->
							<input type="hidden"
							       name="key_Given_by_Front"
							       id="key_Given_by_Front" />
							<input type="hidden"
							       name="place_Opt_Num"
							       id="place_Opt_Num" />
							<input type="hidden"
							       name="speed_Opt_Num"
							       id="speed_Opt_Num" />
							<input type="hidden"
							       name="middle_Class_List"
							       id="middle_Class_List" />
							
						</form>
						<!-- The end of input form -->
						
					</div>
				</div>
			</div>
			<!-- start of booking container -->
			
		</div>		
	</div>
	<!-- //end of header -->	
	
	<!-- Portfolio Section -->
   <section class="page-section portfolio" id="portfolio">
      <div class="container">

         <div class="major-cate">
            <div class="container">
               <h2
                  class="page-section-heading text-center text-uppercase text-secondary mb-0">
                  여행 카테고리</h2>
      
               <!-- Icon Divider -->
               <div class="divider-custom">
                  <div class="divider-custom-line"></div>
                  <div class="divider-custom-icon">
                     <i class="fas fa-passport"></i>
                  </div>
                  <div class="divider-custom-line"></div>
               </div>
      
               <div class="row major-list">
                  <div class="col-md-6 major-odd"
                     onclick="location.href='/team4_jeju/tourCate/selectHotplace.do'"
                     style="cursor: pointer">
                     <div class="major1" >
                        <div class="text-center text-white">
                           <i class="fas fa-crown fa-2x">&nbsp;핫플레이스 TOP 50</i>
                        </div>
                     </div>
                  </div>
                  <div class="col-md-6"
                     onclick="location.href='/team4_jeju/tourCate/selectMiddleCate.do?major_Num=3'" 
                     style="cursor: pointer">
                     <div class="major2">
                        <div class="text-center text-white">
                           <i class="fas fa-plane fa-2x">&nbsp;가볼거리</i>
                        </div>
                     </div>
                  </div>
                  </div>
                  <div class="row major-list">
                  <div class="col-md-6"
                     onclick="location.href='/team4_jeju/tourCate/selectMiddleCate.do?major_Num=1'" 
                     style="cursor: pointer">
                     <div class="major3">
                        <div class="text-center text-white">
                           <i class="fas fa-utensils fa-2x">&nbsp;먹을거리</i>
                        </div>
                     
                     </div>
                  </div>
                  <div class="col-md-6"
                     onclick="location.href='/team4_jeju/tourCate/selectMiddleCate.do?major_Num=2'"
                     style="cursor: pointer">
                     <div class="major4">
                        <div class="text-center text-white">
                           <i class="fas fa-grin-hearts fa-2x">&nbsp;즐길거리</i>
                        </div>
                     
                     </div>
                  </div>      
               </div>
            </div>
         </div>
         
      </div>         
   </section>
   <!-- The end of Category section -->



	<!-- fake section -->
	<section id="about" 
	         class="bg-encore_tours_title">
		<div style="height : 5rem;">
		</div>
	</section>

	<!-- About Section -->
	<section class="page-section bg-encore_tours_title text-white mb-0" id="about">
		<div class="container">

			<!-- About Section Heading -->
			<h2 class="page-section-heading text-center text-uppercase text-white">
			Encore Tours 소개</h2>

			<!-- Icon Divider -->
			<div class="divider-custom divider-light">
				<div class="divider-custom-line"></div>
				<div class="divider-custom-icon">
					<i class="fas fa-envelope-open"></i>
				</div>
				<div class="divider-custom-line"></div>
			</div>

			<!-- About Section Content -->
			<div class="row">
				<div class="col-lg-4 ml-auto">
					<p class="lead">설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명</p>
				</div>
				<div class="col-lg-4 mr-auto">
					<p class="lead">설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명</p>
				</div>
			</div>

			<!-- About Section Button -->
			<div class="text-center mt-4">
				<a class="btn btn-xl btn-outline-light" href=""> <i
					class="fas fa-plane mr-2"></i> Encore Tours 경험해보기
				</a>
			</div>

		</div>
	</section>
	
	<!-- 수정 금지 -->
	<!-- fake section -->
	<section id="contact">
		<div style="height : 5rem;">
		</div>
	</section>

	
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


	<!-- 수정 금지 -->
	<!-- fake section -->
	<section id="contactForm">
		<div style="height : 5rem;">
		</div>
	</section>


			<!-- Contact Section Form -->
			<div class="row">
				<div class="col-lg-8 mx-auto">
					<!-- To configure the contact form email address, go to mail/contact_me.php and update the email address in the PHP file on line 19. -->
					<form action="../qnA/saveQnA.do"
					      method="post" 
					      id="contactForm"
					      novalidate="novalidate">
						<div class="control-group">
							<div
								class="form-group floating-label-form-group controls mb-0 pb-2">
								<label>Name</label> <input value="" required class="form-control" name="writer_Name"
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
								<label>Title</label> <input value="" required class="form-control" name="qnA_Title"
									type="text" placeholder="Title" required="required"
									data-validation-required-message="Please enter your title.">
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<div class="control-group">
							<div
								class="form-group floating-label-form-group controls mb-0 pb-2">
								<label>Message</label>
								<textarea value="" required class="form-control" name="qnA_Content" rows="5"
									placeholder="Message" required="required"
									data-validation-required-message="Please enter a message."></textarea>
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<div class="control-group">
							<div
								class="form-group floating-label-form-group controls mb-0 pb-2">
								<label>Password</label> <input value="" required class="form-control"
									name="writer_Pw" type="password" placeholder="Password"
									required="required"
									data-validation-required-message="Please enter your Password.">
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<br>
						<div id="success"></div>
						<div class="form-group">
							<button type="submit" class="btn btn-encore_tours btn-lg" id="sendMessageButton"  >Send</button>
						</div>
					</form>
				</div>
			</div>
		</div>

	
		
		<!-- Scroll to Top Button-->
		<a class="scroll-to-top rounded" href="#page-top">
		  <i class="fas fa-angle-up"></i>
		</a>
		
		<div class="modal fade" id="modal_layout">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- close button -->
				<button type="button" class="close" data-dismiss="modal">
				x</button>
				<div class="jeju-flex-wrap">
				    <fieldset>
				        <form action novalidate>
				            <input type="radio" 
				                   class="jeju-input"
				                   name="rg" id="sign-in" checked/>
				            <input type="radio" 
				                   class="jeju-input"
				                   name="rg" id="sign-up" />
				            <input type="radio" 
				                   class="jeju-input"
				                   name="rg" id="reset" />        
				
				            <label for="sign-in"
				                   class="jeju-label">Sign in</label>
				            <label for="sign-up"
				                   class="jeju-label">Sign up</label>
				            <label for="reset"
				                   class="jeju-label">Reset</label>  
				
				            <input class="sign-up sign-in reset" type="email" placeholder="Email" />
				            <input class="sign-up sign-in" type="password" placeholder ="Password" />
				            <input class="sign-up" type="password" placeholder ="Repeat Password" />
				            <button class="jeju-button">Submit</button>
				        </form>
				    </fieldset>
				</div>
			</div>
		</div>
	</div>
		
	</section>
	
	<jsp:include page="./footer_of_main.jsp"></jsp:include>
	
</body>

</html>
