$(function(){
		
	//일정 삭제버튼 클릭 시
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
					//alert("ajax 등록 성공" + sch_Output_Mnum);
					button.removeClass("btn-danger").addClass("btn-success");
					button.text("일정추가");
									
				}
			});
			//end of ajax
			
			
		});
		//end of click function
		
		
		//일정 확정버튼 클릭 시
		$(".confirm-btn").click(function(){
			var sch_Input_Mnum = $(this).parent().find("input").val();
			alert(sch_Input_Mnum);
			
			var tasks = [];
			var headers = [];
			
			$.ajax({
				url:"getTimetable.do", //controller에서 mapping할 주소를 입력한다.
				data : {"key_Given_by_Front" : sch_Input_Mnum },
				success: function(result){
					//alert("성공");
				var days= result.daylist;
					
					for(var j=0; j<days.length; j++){
						headers.push(days[j].sch_Date);
						
//						console.log(days[j].sch_Date);
				
					var schPlace = result.schPlaceList;
					for (var i = 0; i < schPlace.length; i++) {
						console.log(schPlace[i].sch_Date +"/" +days[j].sch_Date);
						if(schPlace[i].place_Num != 0 && ((days[j].sch_Date==schPlace[i].sch_Date)) ){
//							console.log(schPlace[i].sch_Date);
//							console.log(schPlace[i].sch_Start_Time);
//							console.log(schPlace[i].sch_Finish_Time);
//							console.log(schPlace[i].finalplacevo.place_Name);
							
							var Stime =	schPlace[i].sch_Start_Time.split(':');
							var Stime_ = parseInt(Stime[0])+parseFloat(Stime[1])/60;
							
							var Ftime =	schPlace[i].sch_Finish_Time.split(':');
							var Ftime_ = parseInt(Ftime[0])+parseFloat(Ftime[1])/60;
							var duration = Ftime_ - Stime_;
							
							var task = {
									startTime:Stime_,
									duration:duration,
									column : j,
									id:schPlace[i].finalplacevo.place_Id,
									title:schPlace[i].finalplacevo.place_Name
							};
							
							 tasks.push(task);	
//							console.log (task.starTime);
						}
					}

//					
					}
//					 console.log("tasks count: " + tasks.length);
					
					 $("#skeduler-container").skeduler({
						    headers: headers,
						    tasks: tasks,
						    cardTemplate: '<div>${title}</div>',
						    onClick: function (e, t) { console.log(e, t); }
						  });
					 
					 $("#timetable-modal").modal('show');
					 
				}
			});
			
			
			
		});
		
		
		//pdf출력
		
		$('.pdf-btn').click(function(){
		
			
				var doc=new jsPDF('p', 'mm', [297, 210]);
				var specialElementHandlers = {
						'#skeduler-container':function(element,renderer){
							return true;
						}
				}
				
				html2canvas($("#skeduler-container"),{
					useCORS:true,
					allowTaint:true,
					onrendered:function(canvas){
						var imgData = canvas.toDataURL('image/jpeg');
						var doc = new jsPDF("p","mm");
						doc.addImage(imgData,'JPEG',10,10);
						doc.save('schedule.pdf');
					}
				})
	
		
		        
		});
	
		
		
		
	});