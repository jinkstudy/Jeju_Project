<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Encore Tours - Administrator</title>

</head>

<body>
	
	<!-- Sidebar -->
	<ul class="sidebar navbar-nav">
		<li class="nav-item active">
			<a class="nav-link"
			   href="/team4_jeju/main/main.do"> 
					<i class="fas fa-globe-asia"></i> 
					<span>Encore Tours 홈페이지</span>
			</a>
		</li>
		<li class="nav-item">
			<a class="nav-link"
			   href="/team4_jeju/admin/admin.do"> 
					<i class="fas fa-fw fa-tachometer-alt"></i> 
					<span>관리자 대시 보드</span>
			</a>
		</li>		
		<li class="nav-item active">
			<a class="nav-link" 
			   href="/team4_jeju/admin/visitJejuData/visitJejuData.do"> 
				<i class="fas fa-database"></i> 
				<span>Visit Jeju <br/>- 크롤링 작업 실행</span>
			</a>
		</li>
		<li class="nav-item active">
			<a class="nav-link" 
			   href="/team4_jeju/admin/apiData/apiData.do">
				<i class="fas fa-database"></i> 
				<span>공공 API <br/>- 파싱 작업 실행</span>
			</a>
		</li>
		<li class="nav-item active">
			<a class="nav-link" 
			   href="/team4_jeju/admin/placeJoin/placeJoin.do">
				<i class="fas fa-database"></i>
				<span>Place DB <br/>- Table Join (생성) 작업 실행</span>
			</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" 
			   href="/team4_jeju/admin/admin.do"> 
				<i class="fas fa-fw fa-chart-area"></i> 
				<span>방문 카운트 차트</span>
			</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" 
			   href="/team4_jeju/admin/admin.do"> 
				<i class="fas fa-fw fa-table"></i> 
				<span>로그 테이블</span>
			</a>
		</li>
	</ul>

</body>

</html>