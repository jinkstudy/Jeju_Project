


$(function(){
	
	
	function isEmpty(str){
        
        if(typeof str == "undefined" || str == null || str == "")
            return true;
        else
            return false ;
    }
	
	
	$("#sendQnAMessageButton").on('click', function(){

		var writer_N = $("input[name=writer_Name]");
		var member_E = $("input[name=member_Email]");
		var qnA_T = $("input[name=qnA_Title]");
		var qnA_C = $("textarea[name=qnA_Content]");
		var writer_P = $("input[name=writer_Pw]");
		
		if(isEmpty(writer_N.val())){
			swal({
				title : "성함을 적어주세요",
				text : "(Encore Tours Guide)",
				icon : "info",
				button : "OK",
			});
			return false;
		}
		
		if(isEmpty(member_E.val())){
			swal({
				title : "이메일 주소를 적어주세요.",
				text : "(Encore Tours Guide)",
				icon : "info",
				button : "OK",
			});
			return false;
		}
		
		if(isEmpty(qnA_T.val())){
			swal({
				title : "문의 제목을 적어주세요.",
				text : "(Encore Tours Guide)",
				icon : "info",
				button : "OK",
			});
			return false;
		}
		
		if(isEmpty(qnA_C.val())){
			swal({
				title : "문의 내용을 적어주세요.",
				text : "(Encore Tours Guide)",
				icon : "info",
				button : "OK",
			});
			return false;
		}
		
		if(isEmpty(writer_P.val())){
			swal({
				title : "암호를 입력해주세요.",
				text : "(Encore Tours Guide)",
				icon : "info",
				button : "OK",
			});
			return false;
		}
		
		$("#encoreQnAForm").submit();
		
	});
	
	
	
	
});