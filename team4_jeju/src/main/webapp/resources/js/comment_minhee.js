
/*화면 로딩 되자마자 DB 댓글 리스트 출력 해주는 함수 불러오기*/
$(document).ready(function(){
	qnACommentList();
});

/*댓글 리스트 출력해주는 함수*/
function qnACommentList(){
	$.ajax({
		url:"qnACommentList.do",
		data: {"reply_Content" : $('#reply_Content').val(),"qnA_Mnum": $('#qnA_Mnum').val()},
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
			}//end of if-else
			$("#cCnt").html(cCnt);
			$("#qnACommentList").html(htmls);



			/*댓글 삭제하기*/
			$('.DeleteComment').each(function(){
				$(this).on('click', function(){
					$.ajax({
						url: "qnADeleteComment.do",
						data: {"reply_Num" : $(this).attr('reply_num'),"qnA_Mnum": $(this).attr('qnA_Mnum')},
						success : function(result){
							if(result=="success"){
								qnACommentList();
								$('#qnACommentList').val("");
							}
						}
					});// end of delete-ajax
				});
			}); // end of deleteComment

			
			
			/*댓글 수정하기*/
			$('.modifyComment').each(function(){
				$(this).on('click',function(){
					var htmls = "";
					htmls+='<textarea class="modifyCommentContent" style="width: 100%" rows="3" cols="30"/>';
					htmls +='<input type="button" class="btn btn-xs reply-buttons saveModifyComment"';
					htmls +='reply_num="'+$(this).attr('reply_num')+'" qnA_Mnum="'+ $(this).attr('qnA_Mnum');
					htmls +='" member_email="'+$(this).attr('member_email')+'" value="저장"/>';
					htmls +='&nbsp;&nbsp;';
					htmls +='<input type="button" class="btn btn-xs reply-buttons cancleModifyComment"';
					htmls +=' value="취소"/>';
					var contentChange = $(this).parent().parent().parent().parent().parent().find("tr:nth-child(2) > td > div")
					contentChange.replaceWith(htmls);
					$('.saveModifyComment').each(function(){
						$(this).on('click',function(){
							$.ajax({
								url: "qnAModifyComment.do",
								data: {"reply_Num" : $(this).attr('reply_num'),"qnA_Mnum": $(this).attr('qnA_Mnum'),
									"member_Email": $(this).attr('member_email'),"reply_Content":$('.modifyCommentContent').val()},
									success : function(result){
										alert("성공");
										if(result=="success"){
											getCommentList();
										}		
									}
							});//end of modify-ajax
						});
					});//end of saveModifyComment
					$('.cancleModifyComment').each(function(){
						$(this).on('click',function(){
							getCommentList();
						});
					});//end of cancleModifyComment
				});
			});// end of modifyComment

		}//end of success function
	});
}

/*
 * 등록 버튼이 눌렸을때 ajax로 DB에 값 넣어주기
 * */
$(function(){
	$('#qnACommentBtn').click(function(){ //**버튼 이미지를 클릭했을때
		$.ajax({
			url: "qnAComment.do",
			data: {"reply_Content" : $('#reply_Content').val(),"qnA_Mnum": $('#qnA_Mnum').val()},
			success : function(result){
				if(result=="success"){
					qnACommentList();
					$('#qnACommentList').val("");
				}
				document.getElementById("reply_Content").value='';//댓글 입력후 textarea의 내용을 초기화 >자동으로 placeholder의 값이 다시 보인다.

			}	
		});
	});//등록 end
});


