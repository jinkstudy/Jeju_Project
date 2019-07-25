


$(function(){
		
	var loadingInterval;
		
	$("#dataProcessingButton").on('click', function(){
		setInterval(function(){
			$("#divLoading").show();
		}, 500);
	});		
	
});