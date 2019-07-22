$(function(){
	$(".like-btn").each(function(){
		
		$(this).click(function(){
//			alert("확인");
			if($(this).attr("src")=="/team4_jeju/resources/imgs/like_0.png"){
				$(this).attr("src","/team4_jeju/resources/imgs/like_1.png");
			}else{
				$(this).attr("src","/team4_jeju/resources/imgs/like_0.png");
			}
			
		})
	
	});

});