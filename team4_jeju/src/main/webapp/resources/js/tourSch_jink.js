$(function(){
		
		$(".delete_b").click(function () {
			var row_total =  $(this).parent().parent().parent();
			var imgA = row_total.find("img");
			var sch_Output_Mnum = $(this).parent().find("input").val();
			var button = $(this);
			//alert(sch_Output_Mnum);
		
			//ajax 시작 -- > 일정삭제 클릭 시 db에서 내용 업데이트
			$.ajax({
				url:"updateDelSch.do", //controller에서 mapping할 주소를 입력한다.
				data : {"sch_Output_Mnum" : sch_Output_Mnum},
				success: function(){
					imgA.attr("src","https://pgnqdrjultom1827145.cdn.ntruss.com/img/1e/b0/1eb0fcb24b6cdc1c050aff37f3a2dd2cf7b871244edb392eb5b0430ecf6a3397_v1.jpg");
		
					
					
					var info = row_total.find(".sch-place-name");
					info.html("<p>일정이 없습니다.<br/> 새로운 일정을 추가하세요.</p>");
					//$(this).removeClass("btn-danger").addClass("btn-success");
					alert("ajax 등록 성공" + sch_Output_Mnum);
					button.removeClass("btn-danger").addClass("btn-success");
					button.text("일정추가");
									
				}
			});
			//end of ajax
			
			
		});
		//end of click function
	});