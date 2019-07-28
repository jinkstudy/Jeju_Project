$(function(){
	$(".pick-img").each(function(){
		
		$(this).click(function(){
//			alert("확인");
			if($(this).attr("src")=="/team4_jeju/resources/imgs/like_0.png"){
				$(this).attr("src","/team4_jeju/resources/imgs/like_1.png");
				
				var place_Num = $(this).parent().find('.pick_num').val(); 
				//alert(place_Num);
				$.ajax({
			
					url:"insertPick.do", //controller에서 mapping할 주소를 입력한다. 이미 pick까지 갖다왔으므로 insertPick.do만 써준다.
					data : { "member_Email" :"abcd1234@naver.com", "place_Num" :place_Num},
					success: function(){
						
						alert("찜완료");
					}
				});
				
				
				
			}else{
				$(this).attr("src","/team4_jeju/resources/imgs/like_0.png");
			}
			
		
		})
	
	});

});