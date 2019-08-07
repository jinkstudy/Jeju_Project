/*화면 로딩 되자마자 DB 댓글 리스트 출력 해주는 함수 불러오기*/
$(document).ready(function(){
	getCommentList();
});

/*댓글 리스트 출력해주는 함수*/
function getCommentList(){
	$.ajax({
		url:"getCommentList.do", //Controller 에 있는 함수 비동기로 url 전송해서 불러오기
		data: {"reply_Content" : $('#reply_Content').val(),"comm_Mnum": $('#comm_Mnum').val()}, //JSon 구조로 변수명 VO와 일치시킨 후 전송하기
		success: function(result){ // ajax 성공시 Controller의 값을 받아오기
			var htmls = ""; //뷰단에서 동적으로 테이블을 붙이기 위해 변수 선언
			var cCnt = result.length; //댓글 수 표현을 위해 결과값의 길이 가져와서 변수에 담기
			if(result.length > 0){ //댓글이 있을 경우에 반복문 실행
				for(i=0; i< result.length;i++){ // 댓글 수 만큼 반복 실행
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
					htmls +='<input type="button" class="btn btn-xs reply-buttons modifyComment"';
					htmls +='reply_num="'+result[i].reply_Num+'" comm_mnum="'+ result[i].comm_Mnum;
					htmls +='" member_email="'+result[i].member_Email+'" value="수정"/>';
					htmls +='&nbsp;&nbsp;';
					htmls +='<input type="button" class="btn btn-xs reply-buttons deleteComment"';
					htmls +=' reply_num="'+result[i].reply_Num+'" comm_mnum="'+ result[i].comm_Mnum+'" value="삭제"/>';
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
				} //변수를 화면상에서 필요한 위치에 각각 붙여준다.
			}else{
				htmls = '등록된 댓글이 없습니다.'; //댓글이 없을 경우 출력할 문자열 입력

			}//end of if-else
			$("#cCnt").html(cCnt); //화면 단에서 id가 cCnt인 곳에 변수값을 html로 삽입해준다.
			$("#commentList").html(htmls); //화면단에서 id가 commentList인 곳에 설정한 변수를 html로 삽입해준다.


			/*댓글 삭제하기 댓글 관련된 이벤트는 동적 테이블 안에서 실행되므로 모두 댓글 리스트 출력하는 ajax 안에 써준다.*/
			$('.deleteComment').each(function(){
				$(this).on('click', function(){ //클릭 이벤트 발생시 동적으로 실행시키기
					$.ajax({
						url: "deleteComment.do", 
						data: {"reply_Num" : $(this).attr('reply_num'),"comm_Mnum": $(this).attr('comm_mnum')},
						success : function(result){
							if(result=="success"){
								getCommentList(); //성공과 동시에 댓글리스트 불러오기
								$('#commentList').val(""); //댓글리스트 중복 붙이는 것을 방지하기 위해 초기화
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
					htmls +='reply_num="'+$(this).attr('reply_num')+'" comm_mnum="'+ $(this).attr('comm_mnum');
					htmls +='" member_email="'+$(this).attr('member_email')+'" value="저장"/>';
					htmls +='&nbsp;&nbsp;';
					htmls +='<input type="button" class="btn btn-xs reply-buttons cancleModifyComment"';
					htmls +=' value="취소"/>';
					var contentChange = $(this).parent().parent().parent().parent().parent().find("tr:nth-child(2) > td > div")
					contentChange.replaceWith(htmls);
					$('.saveModifyComment').each(function(){
						$(this).on('click',function(){
							$.ajax({
								url: "modifyComment.do",
								data: {"reply_Num" : $(this).attr('reply_num'),"comm_Mnum": $(this).attr('comm_mnum'),
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


$(function(){
	/*
	 * 등록 버튼이 눌렸을때 ajax로 DB에 값 넣어주기
	 * */
	$('#addCommentBtn').click(function(){ //**버튼 이미지를 클릭했을때
		$.ajax({
			url: "addComment.do",
			data: {"reply_Content" : $('#reply_Content').val(),"comm_Mnum": $('#comm_Mnum').val()},
			success : function(result){
				if(result=="success"){ //controller에서 결과값으로 success라는 문자열을 받아올 경우 조건문을 실행한다.
					getCommentList();
					$('#commentList').val(""); 
				}
				document.getElementById("reply_Content").value='';//댓글 입력후 textarea의 내용을 초기화 >자동으로 placeholder의 값이 다시 보인다.
			}	
		});
	});//등록 end
});




