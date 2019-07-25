<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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

<title>Encore Tours - Administrator</title>

<style type="text/css">
	.table-bordered {
	  border: 0.03rem solid #FFB100 !important;
	}
	
	.table-bordered tr,
	.table-bordered td,
	.table-bordered th,
	.table-bordered thead th,
	.table-bordered tbody + tbody,
	.table-bordered tbody tr td,
	.table-bordered tbody td,
	.table-bordered tr td {
	  border: 0.03rem solid #FFB100 !important;
	}
	
	.table-bordered th{
	  border: 0.03rem solid #FFB100 !important;
	  background-color: #FFE2A3;
	}
	
	#divLoading{
		z-index : 1700;
		color : #00BFFF;
		font-size : 2.7rem;
		font-weight : 700;
	}
</style>

<script>
	function switchScreen(){
	    $("#divLoading").hide();
	}
</script>

</head>

<body id="page-top" onload="switchScreen();">

<div id="divLoading" style="position:absolute; top:12rem; left:0; width:100%; text-align:center; margin:0 auto;">
	<img src="/team4_jeju/resources/imgs/image_gyubeom/loading_gyubeom.gif"
	     alt="" />
	공공 기관 SITE : VISIT JEJU DATA - 로딩 중...
</div>

<!-- 헤더에 링크 파일 기술 되어 있음. -->
<jsp:include page="../admin/header_of_admin.jsp"></jsp:include>

<div id="wrapper">

<jsp:include page="../admin/left_sider_of_admin.jsp"></jsp:include>

<!-- data 작업시 - fakeLoader -->
<div id="fakeLoader"></div>

<div id="content-wrapper">

	<div class="container-fluid">

	<!-- Breadcrumbs-->
	<ol class="breadcrumb">
		<li class="breadcrumb-item active">
			<a href="/team4_jeju/admin/admin/admin.do">Admin</a></li>
		<li class="breadcrumb-item active">Visit Jeju - 크롤링 작업 실행</li>
	</ol>

	<div>
		<table style="text-align : center">
			<tr>
				<td><br />
					<button type="submit" 
					        class="btn btn-visit-jeju btn-lg"
						    id="dataProcessingButton" 
						    onclick="location.href='/team4_jeju/admin/visitJejuData/insertVisitJeju.do'">
						    Visit Jeju - 크롤링 작업 실행 버튼</button>
				</td>
				<td>
				&nbsp;&nbsp;
				</td>
				<td><br />
					<button type="submit" 
					        class="btn btn-visit-jeju btn-lg"
						    id="sendMessageButton" 
						    onclick="location.href='/team4_jeju/admin/visitJejuData/selectVisitJeju.do'">
						    DATA 리스트 SELECT 갱신</button>
				</td>
			</tr>
		</table>
	</div>

	<br />

	<!-- DataTables -->
	<div class="card mb-3">
		<div class="card-header">
			<i class="fas fa-table"></i> Visit Jeju - 크롤링 작업 실행 테이블
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					   cellspacing="0">
					<thead>
						<tr>
							<th>ADMIN_VISIT_JEJU_ID</th>
							<th>ADMIN_VISIT_JEJU_TITLE</th>
							<th>LIKE_COUNT</th>
							<th>CATEGORY_TAGS</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${visitJeju}" var="vjd">
							<tr>
								<td>${vjd.admin_SEL_ID}</td>
								<td>${vjd.admin_SEL_TITLE}</td>
								<td>${vjd.admin_SEL_LIKE}</td>
								<td>${vjd.admin_SEL_TAGS}</td>
							</tr>
						</c:forEach>
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
	<!-- /.container-fluid -->

	<!-- 헤더에 링크 파일 기술 되어 있음. -->
	<jsp:include page="../admin/footer_of_admin.jsp"></jsp:include>

</div>
<!-- /.content-wrapper -->

</div>
<!-- /#wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top"> <i
	class="fas fa-angle-up"></i>
</a>


</body>

</html>