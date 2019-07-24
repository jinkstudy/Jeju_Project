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
				success : function(){
					$('#commentList > .table:last').append('<table class="table"><h6><strong>'+$('#member_Email').val()+'</strong></h6><tr><td>' +  $('#reply_Content').val() + '</td></tr></table>');
				}	
			});
		});

});
//
///**
// * 초기 페이지 로딩시 댓글 불러오기
// */
//$(function(){
//    
//    getCommentList();
//    
//});
// 
///**
// * 댓글 불러오기(Ajax)
// */
//function getCommentList(){
//    
//    $.ajax({
//        type:'GET',
//        url : "getCommunityBoard.do",
//        dataType : "json",
//        data:$("#commentList").serialize(),
//        contentType: "application/x-www-form-urlencoded; charset=UTF-8", 
//        success : function(reply){
//            
//            var html = "";
//            var cCnt = reply.length;
//            
//            if(reply.length > 0){
//                
//                for(i=0; i<reply.length; i++){
//                    html += "<div>";
//                    html += "<div><table class='table'><h6><strong>"+reply[i].member_Email+"</strong></h6>";
//                    html += reply[i].reply_Content + "<tr><td></td></tr>";
//                    html += "</table></div>";
//                    html += "</div>";
//                }
//                
//            } else {
//                
//                html += "<div>";
//                html += "<div><table class='table'><h6><strong>등록된 댓글이 없습니다.</strong></h6>";
//                html += "</table></div>";
//                html += "</div>";
//                
//            }
//            
//            $("#cCnt").html(cCnt);
//            $("#commentList").html(html);
//            
//        },
//        error:function(request,status,error){
//            alert(error)
//       }
//        
//    });
//}
 