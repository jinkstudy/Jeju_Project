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

  <title> Encore Tours - Administrator </title>

<style type="text/css">
	.table-bordered {
	  border: 0.05rem solid #FF7301 !important;
	}
	
	.table-bordered tr,
	.table-bordered td,
	.table-bordered th,
	.table-bordered thead th,
	.table-bordered tbody + tbody,
	.table-bordered tbody tr td,
	.table-bordered tbody td,
	.table-bordered tr td {
	  border: 0.05rem solid #FF7301 !important;
	}
	
	.table-bordered th{
	  border: 0.05rem solid #FF7301 !important;
	  background-color: #FFF2ED;
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
	공공 API 파싱 DATA - 로딩 중...
</div>



  	<!-- 헤더에 링크 파일 기술 되어 있음. -->
	<jsp:include page="../admin/header_of_admin.jsp"></jsp:include>

<div id="wrapper">

	<jsp:include page="../admin/left_sider_of_admin.jsp"></jsp:include>

    <div id="content-wrapper">

      <div class="container-fluid">

        <!-- Breadcrumbs-->
        <ol class="breadcrumb">
          <li class="breadcrumb-item">
            <a href="/team4_jeju/admin/admin/admin.do">Admin</a>
          </li>
          <li class="breadcrumb-item active">공공 API - 파싱 작업 실행</li>
        </ol>
        
        
        <div>
        	<table style="text-align : center">
			<tr>
				<td><br />
					<button type="submit" 
					        class="btn btn-get-api btn-lg"
						    id="dataProcessingButton" 
						    onclick="location.href='/team4_jeju/admin/apiData/insertApiData.do'">
						       공공 API - 파싱 작업 실행</button>
				</td>
				<td>
				&nbsp;&nbsp;
				</td>
				<td><br />
					<button type="submit" 
					        class="btn btn-get-api btn-lg"
						    id="sendMessageButton" 
						    onclick="location.href='/team4_jeju/admin/apiData/selectApiData.do'">
						       공공 API DATA 리스트 - SELECT 갱신</button>
				</td>
			</tr>
		</table>
        </div>
        
        <br/>
        
        <!-- DataTables -->
        <div class="card mb-3">
          <div class="card-header">
            <i class="fas fa-table"></i>
                        공공 API - 파싱 작업 실행 테이블</div>
          <div class="card-body">
            <div class="table-responsive">
              <table class="table table-bordered"
                     id="dataTable" width="100%" cellspacing="0">
                <thead>
					<tr>						
						<th>place_Num</th>
						<th>place_Id</th>
						<th>place_Name</th>
						<th>middle_Num</th>
						<th>image_Path</th>
						<th>longi_Coord</th>
						<th>lati_Coord</th>
						<th>place_Tel</th>
						<th>place_Addr</th>
						<th>close_Day</th>
						<th>open_Time</th>
						<th>close_Time</th>
						<th>use_Time</th>
						<th>tour_Hour</th>
						<th>place_Det</th>
						<th>place_Price</th>
						<th>info_Center</th>
						<th>open_Date</th>
						<th>use_Season</th>
						<th>event_S_Date</th>
						<th>event_E_Date</th>
						<th>event_Homepage</th>
						<th>event_Place</th>
						<th>play_Time</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${apiList}" var="api">
						<tr>
							<td>${api.place_Num}</td>
							<td>${api.place_Id}</td>
							<td>${api.place_Name}</td>
							<td>${api.middle_Num}</td>
							<td>${api.image_Path}</td>
							<td>${api.longi_Coord}</td>
							<td>${api.lati_Coord}</td>
							<td>${api.place_Tel}</td>
							<td>${api.place_Addr}</td>
							<td>${api.close_Day}</td>
							<td>${api.open_Time}</td>
							<td>${api.close_Time}</td>
							<td>${api.use_Time}</td>
							<td>${api.tour_Hour}</td>
							<td>${api.place_Det}</td>
							<td>${api.place_Price}</td>
							<td>${api.info_Center}</td>
							<td>${api.open_Date}</td>
							<td>${api.use_Season}</td>
							<td>${api.event_S_Date}</td>
							<td>${api.event_E_Date}</td>
							<td>${api.event_Homepage}</td>
							<td>${api.event_Place}</td>
							<td>${api.play_Time}</td>
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
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

</body>

</html>