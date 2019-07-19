<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script src="//code.jquery.com/jquery-3.4.1.min.js"></script>
<script>

$(document).ready(function () {

	$('#pick_img').click(function(){ //**버튼 이미지를 클릭했을때
		
		var pick_img = $('#pick_img') //이미지 id를 변수에 담아준다.
		if(pick_img.attr('src')=='resources/imgs/1.jpg'){ //버튼 이미지가 1.jpg(빈하트)인 경우
			pick_img.attr('src','resources/imgs/2.jpg');// 2.jpg(꽉찬 하트)로 바꿔준다.
			$.ajax({
				url:"pick/inputPick.do", //controller에서 mapping할 주소를 입력한다. controller에서 맨위 경로를 pick으로 줬기때문에 여기서도 앞에  pick까지 써준다
				type:"get",
				data : "",
				
				
			});
		}else{ // 버튼 이미지가 2.jpg(꽉찬 하트)인 경우
			pick_img.attr('src','resources/imgs/1.jpg'); // 1.jpg(빈하트)로 바꿔준다.
			$.ajax({
				url:"",
				type:""
				
			});
		}
	});
});
</script>
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
			<h1 class="masthead-heading text-uppercase mb-0">Pick 페이지입니다.</h1>

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
					<th colspan='2'>Pick</th>
				</tr>
			</table>
		</div>
		
		<div class="d-flex align-items-center justify-content-center">
		<table class="no-style">
		<tr>
		<td align="center">
		<input type='hidden' id='Place_Num' value='Place_Num'/>
		<img id='pick_img' src='resources/imgs/1.jpg'
			width='30px' height='30px' alt='찜목록에 추가하기' />
		</td>
		</tr>
	</table>
			
		<a href="pick/pick_list.do">찜한 목록 보러가기</a>
		</div>
	</div>
			
	</section>
	
	<!-- footer -->
	<jsp:include page="../main/footer_of_main.jsp"></jsp:include>

</body>
</html>