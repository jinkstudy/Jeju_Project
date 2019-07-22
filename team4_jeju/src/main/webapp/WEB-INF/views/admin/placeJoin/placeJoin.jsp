<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="ko">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title> Encore Tours - Administrator </title>

<style type="text/css">
	.table-bordered {
	  border: 0.03rem solid #518DFF !important;
	}
	
	.table-bordered tr,
	.table-bordered td,
	.table-bordered th,
	.table-bordered thead th,
	.table-bordered tbody + tbody,
	.table-bordered tbody tr td,
	.table-bordered tbody td,
	.table-bordered tr td {
	  border: 0.03rem solid #518DFF !important;
	}
	
	.table-bordered th{
	  border: 0.03rem solid #518DFF !important;
	  background-color: #E9F1FF;
	}
</style>

</head>

<body id="page-top">

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
          <li class="breadcrumb-item active">Place DB - Table Join (생성) 작업 실행</li>
        </ol>
                
        <div>
		<table style="text-align : center">
			<tr>
				<td><br/>
					<button type="submit" 
					        class="btn btn-encore_tours btn-lg"
						    id="sendMessageButton" 
						    onclick="location.href='/team4_jeju/admin/placeJoin/updateFinalPlace.do'">
						    TOUR_SEQUENCE_KEY_NUM - UPDATE</button>
				</td>
				<td>
				&nbsp;&nbsp;
				</td>			
				<td>
				<br/>
					<button type="submit" 
					        class="btn btn-encore_tours btn-lg"
						    id="sendMessageButton" 
						    onclick="location.href='/team4_jeju/admin/placeJoin/selectFinalPlace.do'">
						    FINAL PLACE TABLE - DATA 리스트 SELECT 갱신</button>						    
				</td>
			</tr>
		</table>
	</div>

	<br />
        
        
        <!-- DataTables -->
        <div class="card mb-3">
          <div class="card-header">
            <i class="fas fa-table"></i>
            FINAL PLACE TABLE - DATA 리스트 테이블            
          </div>
          <div class="card-body">
            <div class="table-responsive">
            	<table class="table table-bordered"
            	       id="dataTable" width="100%" cellspacing="0">
                <thead>
					<tr>
						<th>final_Place_Num</th>
						<th>place_Id</th>
						<th>place_Name</th>
						<th>tour_Key_Num</th>
						<th>next_Distance</th>
						<th>middle_Num</th>
						<th>restaurant_Id</th>
						<th>image_Path</th>
						<th>lati_Coord</th>
						<th>longi_Coord</th>
						<th>place_Tel</th>
						<th>place_Addr</th>
						<th>close_Day</th>
						<th>close_Possible</th>
						<th>open_Time</th>
						<th>close_Time</th>
						<th>use_Time</th>
						<th>tour_Hour</th>
						<th>place_Det</th>
						<th>like_Count</th>
						<th>tags</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${finalPlace}" var="fp">
						<tr>
							<td>${fp.final_Place_Num}</td>
							<td>${fp.place_Id}</td>
							<td>${fp.place_Name}</td>
							<td>${fp.tour_Sequence_Key_Num}</td>
							<td>${fp.next_Distance}</td>
							<td>${fp.middle_Num}</td>
							<td>${fp.restaurant_Place_Id}</td>
							<td>${fp.image_Path}</td>
							<td>${fp.lati_Coord}</td>
							<td>${fp.longi_Coord}</td>
							<td>${fp.place_Tel}</td>
							<td>${fp.place_Addr}</td>
							<td>${fp.close_Day}</td>
							<td>${fp.close_Possible_Day}</td>
							<td>${fp.open_Time}</td>
							<td>${fp.close_Time}</td>
							<td>${fp.use_Time}</td>
							<td>${fp.tour_Hour}</td>
							<td>${fp.place_Det}</td>
							<td>${fp.like_Count}</td>
							<td>${fp.tags}</td>
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