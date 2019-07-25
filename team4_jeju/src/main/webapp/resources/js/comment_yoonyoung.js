///*
// * 댓글 등록하기(Ajax)
// */
//function fn_comment(code){
//    
//    $.ajax({
//        type:'POST',
//        url : "addComment.do",
//        data:$("#commentListForm").serialize(),
//        success : function(data){
//            if(data=="success")
//            {
//                getCommentList();
//                $("#comment").val("");
//            }
//        },
//        error:function(request,status,error){
//            //alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
//       }
//        
//    });
//}
 
/*
 * 등록 버튼이 눌렸을때 ajax로 DB에 값 넣어주기
 * */
$(function(){
		$('#addCommentBtn').click(function(){ //**버튼 이미지를 클릭했을때
			$.ajax({
				url: "addComment.do",
				data: {"reply_Content" : $('#reply_Content').val(),"comm_Mnum": $('#comm_Mnum').val()},
				success : function(reply){
				if(reply.length!=0){
					$('#commentList > .table:last').append('<table class="table"><h6><strong>'+$('#member_Email').val()+'</strong></h6><tr><td>' +  $('#reply_Content').val() + '</td></tr></table>');

				}else{
					$('#commentList').append('<table class="table"><h6><strong>'+$('#member_Email').val()+'</strong></h6><tr><td>' +  $('#reply_Content').val() + '</td></tr></table>');
				}
				document.getElementById("reply_Content").value='';//댓글 입력후 textarea의 내용을 초기화 >자동으로 placeholder의 값이 다시 보인다.
				
				var cCnt = $('#cCnt').text(); //화면단에 있는 댓글 수를 가져와서 변수에 담기
				var cChange = parseInt(cCnt)+1; //span 태그 안에 있는 거라서 text 이기 때문에 형변환
				$('#cCnt').text(cChange); //다시 화면단에 변위가 적용된 값을 찍어준다.
				}	
			});
		});

		
});

/*댓글 수정하기*/
/*댓글 삭제하기*/

 