<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>찜목록 추가하기 페이지</title>
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


	<table border='1px' style="width: 200px; height: 500px;">
		<tr>
		<td align="center">
		<input type='hidden' id='Place_Num' value='Place_Num'/>
		<img id='pick_img' src='resources/imgs/1.jpg'
			width='30px' height='30px' alt='찜목록에 추가하기' />
		</td>
		</tr>
	</table>
			
		<a href="pick/pick_list.do">찜한 목록 보러가기</a>


</body>
</html>