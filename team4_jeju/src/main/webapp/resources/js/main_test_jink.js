$(function(){
	$(".place-opt .col-md-4").each(function(){

		$(this).click(function(){
			$(".place-opt .col-md-4").css("background","#6499ff");
			$(this).css("background","#b7d0ff");
					})
		$(".speed-opt .col-md-4").each(function(){

			$(this).click(function(){
				$(".speed-opt .col-md-4").css("background","#6499ff");
				$(this).css("background","#b7d0ff");
			})

		});
		$(".major-list .col-md-6").each(function(){
			$(this).hover(function(){
							$(this).css("opacity","1")}
				
				, function(){$(this).css("opacity","0.7");}
			);
			
		})
	});
});