<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<META HTTP-EQUIV="Page-exit" CONTENT="BlendTrans(Duration=0.5)">
<META HTTP-EQUIV="Page-Enter" CONTENT="BlendTrans(Duration=0.5)">

<title>Insert title here</title>

<!-- 카카오 map 링크 -->
<script type="text/javascript"
	    src="//dapi.kakao.com/v2/maps/sdk.js?appkey=95e85aa66afbc7aaf828aa2355f1eb56"></script>

<!-- jQuery 링크 -->
<script src="../resources/js/jquery-3.4.1.js"></script>

<!-- 카카오 map_gyubeom coding 링크 -->
<script src="../resources/js/map_gyubeom_original.js"></script>

<link rel="stylesheet"
	  href="/team4_jeju/resources/style/map_gyubeom.css" type="text/css">

</head>
<body>

	<!-- header -->
	<jsp:include page="../main/header_of_main.jsp"></jsp:include>
	
	
	<!-- start of map title -->
	<div class="text-white text-center"
	     id="jeju-map-head">
	     <hr class="jeju-hr"/>
	     <div class="masthead-heading">	     	
			<div class="jeju-map-background">
				<div class="jeju-title1">Jeju Journey only for Me : 9박 10일</div>
				<div class="jeju-sub-title1">(19.07.02 ~ 19.07.11)</div>
			</div>
	     </div>	     
	</div>
	<!--// The end of map title -->
	
	<hr class="jeju-hr"/>
	
	<!-- start of map drawing -->
	<section class="jeju-map-portfolio" id="portfolio">
		<div class="container">

			<div class="d-flex align-items-center justify-content-center">		
				
				<div class="row">
					<div id="map" style="width: 70rem; height: 23rem;"></div>
				</div>
				
			</div>
		</div>
	</section>
	<!--// The end of map drawing -->
	
	<div class="d-flex align-items-center justify-content-center">		
		<div class="card mb-3">
			<table class="table jeju-table">
				<tr>
					<td>
						<p>
							<a href="MapDrawing.do"
								   target="_blank"
								   id="">
								   Map Test Page로 이동</a>
						</p>
					</td>
					<td>
						<div id="center_coordi_confirm_td"></div>
					</td>
				</tr>
			</table>
		</div> 
	</div>
		
	<div class="jeju-div d-flex align-items-center justify-content-center">
							
		<div class="card mb-3">
			<div class="card-header">
				<i class="fas fa-plane-departure"></i> My Tour Table
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-bordered" id="dataTable" width="100%"
						   cellspacing="0">
						<thead>
							<tr>
								<th>Time</th>
								<th>Picture</th>
								<th>Content</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td></td>
								<td></td>
								<td></td>
							</tr>
						</tbody>
	
						<!-- <tfoot>
	               <tr>
	                 <th>Name</th>
	                 <th>Position</th>
	                 <th>Office</th>
	                 <th>Age</th>
	               </tr>
	             </tfoot> -->
	
					</table>
				</div>
			</div>
		</div>
		<!-- //The End of DataTables -->
		
	</div>
	
	<!-- footer -->
	<jsp:include page="../main/footer_of_main.jsp"></jsp:include>

</body>
</html>