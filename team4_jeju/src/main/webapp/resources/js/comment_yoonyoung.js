/*화면 로딩 되자마자 DB 댓글 리스트 출력 해주는 함수 불러오기*/
$(document).ready(function(){
	getCommentList();
});

/*댓글 리스트 출력해주는 함수*/
function getCommentList(){
	$.ajax({
		url:"getCommentList.do",
		data: {"reply_Content" : $('#reply_Content').val(),"comm_Mnum": $('#comm_Mnum').val()},
		success: function(result){
			var htmls = "";
			var cCnt = result.length;
			if(result.length > 0){
				for(i=0; i< result.length;i++){
					htmls +='<table class="table" id="reply_table_hoho">';
					htmls +='<tr>';
					htmls +='<td>';
					htmls +='<div class="row">';
					htmls +='<div class="col-md-3">작성자:&nbsp;<strong>'+result[i].member_Email+'</strong></div>';
					htmls +='<div class="col-md-3"></div>';
					htmls +='<div class="col-md-3">';									
					htmls +='</div>';	
					htmls +='<div class="col-md-3">';	
					htmls +='&nbsp;&nbsp;';
					htmls +=result[i].reply_Date;
					htmls +='&nbsp;&nbsp;';
					htmls +='<a role="button" class="btn btn-xs reply-buttons"';
					htmls +='id="modifyComment"';
					htmls +='href="">수정</a>';
					htmls +='&nbsp;&nbsp;';
					htmls +='<a role="button" class="btn btn-xs reply-buttons"';
					htmls +=' id="deleteComment"';
					htmls +=' href="">삭제</a>';
					htmls +='</div>';
					htmls +='</div>';
					htmls +='</td>';
					htmls +='</tr>';
					htmls +='<tr>';
					htmls +='<td>';
					htmls +='<div class="reply_content">';
					htmls +=result[i].reply_Content;
					htmls +='</div>';
					htmls +='</td>';
					htmls +='</tr>';
					htmls +='</table>';
				}
			}else{
				htmls = '등록된 댓글이 없습니다.';
//				$(result).each(function(){
//				});	//end of each
			}//end of if-else
			$("#cCnt").html(cCnt);
			$("#commentList").html(htmls);
			
		}//end of success function
	});
}

/*
 * 등록 버튼이 눌렸을때 ajax로 DB에 값 넣어주기
 * */
$(function(){
	$('#addCommentBtn').click(function(){ //**버튼 이미지를 클릭했을때
		$.ajax({
			url: "addComment.do",
			data: {"reply_Content" : $('#reply_Content').val(),"comm_Mnum": $('#comm_Mnum').val()},
			success : function(result){
				if(result=="success"){
				getCommentList();
				$('#commentList').val("");
				}
				document.getElementById("reply_Content").value='';//댓글 입력후 textarea의 내용을 초기화 >자동으로 placeholder의 값이 다시 보인다.

			}	
		});
	});
});

/*댓글 수정하기*/
/*댓글 삭제하기*/

