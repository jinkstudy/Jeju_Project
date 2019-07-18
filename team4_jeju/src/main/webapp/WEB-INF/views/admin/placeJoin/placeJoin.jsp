<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title> Encore Tours - Administrator </title>

</head>

<body id="page-top">

  	<!-- 헤더에 링크 파일 기술 되어 있음. -->
	<jsp:include page="../header_of_admin.jsp"></jsp:include>

<div id="wrapper">

	<jsp:include page="../left_sider_of_admin.jsp"></jsp:include>

    <div id="content-wrapper">

      <div class="container-fluid">

        <!-- Breadcrumbs-->
        <ol class="breadcrumb">
          <li class="breadcrumb-item">
            <a href="/team4_jeju/admin/admin.do">Admin</a>
          </li>
          <li class="breadcrumb-item active">Place DB - Table Join (생성) 작업 실행</li>
        </ol>
        
        
        <div>
        	<td colspan='2'>
						<br/>
						<button type="submit" class="btn btn-encore_tours btn-lg"
						id="sendMessageButton"
						onclick="location.href=''">
						Visit Jeju - 크롤링 작업 실행 버튼</button>
					</td>
        </div>
        
        
        <!-- DataTables -->
        <div class="card mb-3">
          <div class="card-header">
            <i class="fas fa-table"></i>
            Data Table Example</div>
          <div class="card-body">
            <div class="table-responsive">
              <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                  <tr>
                    <th>Name</th>
                    <th>Position</th>
                    <th>Office</th>
                    <th>Age</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>Tiger Nixon</td>
                    <td>System Architect</td>
                    <td>Edinburgh</td>
                    <td>61</td>
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
      <!-- /.container-fluid -->

    <!-- 헤더에 링크 파일 기술 되어 있음. -->
	<jsp:include page="../footer_of_admin.jsp"></jsp:include>

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