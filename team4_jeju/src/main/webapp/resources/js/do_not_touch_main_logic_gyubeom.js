
$(function() {
	
	
	
	$("#divLoading").hide();
	
	
	//게시판 형태의 경우, 눈에 보이는 리스트를 클릭하는 케이스라서
	//pk를 db단 (백엔드) 단에서 만들어도 상관이 없다.
	//하지만 여행 스케쥴러의 경우, 프론트에서 만들어서 보내는 것이 맞다는 본인은 생각.
	//따라서 1000000000 단위의 랜덤수를 발행하고
	// 이 수를 YYYYMMDDHHMMSS 에 붙힌 후에 이 수를 PK로 사용할 예정.
	var randomKey = Math.round( Math.random()*1000000000000 );
	
	
	
	// 오늘 날짜
	var now_Date = new Date();

	var tomorrowDate = now_Date.getTime() + (1 * 24 * 60 * 60 * 1000);
	// var tomorrowDate = formatDate(now_Date.setDate(now_Date.getDate() + 1));
	// /* 날짜 + 1일 */
	now_Date.setTime(tomorrowDate);

	// 여행 시작일 default 값 테스트
	console.log(now_Date);
	
	
	var year = now_Date.getFullYear();
	var mon = (now_Date.getMonth() + 1) > 9 ? '' + (now_Date.getMonth() + 1) : '0' + (now_Date.getMonth() + 1);
	var day = now_Date.getDate() > 9 ? '' + now_Date.getDate() : '0'
			+ now_Date.getDate();
	var time = now_Date.getHours() + now_Date.getMinutes() + now_Date.getSeconds();

	
	var tomorrow_day = year + '-' + mon + '-' + day;
	
	
	
	
	//우리가 가지고 있는 콘텐츠로 최대 서비스 가능한 일자를 계산하여
	//그 이상의 일자 서비스를 요구할 때 양해의 말을 할 수 있도록 한 것. - 수정 금지
	//우리가 현재 가지고 있는 플레이스 콘텐츠 수를 입력하면 자동으로 최대 여행 일자를 사용자에게 알려줌.
	var place_content_num = 400;
	var service_possible_day = Math.floor(place_content_num / 4);
	
	// 서비스 날짜 셋팅을 위한 변수.
	var service_Date = new Date();

	var servicePossibleDate = now_Date.getTime() + (service_possible_day * 24 * 60 * 60 * 1000);
	
	service_Date.setTime(servicePossibleDate);

	// 여행 시작일 default 값 테스트
	console.log(service_Date);
		
	var s_year = service_Date.getFullYear();
	var s_mon = (service_Date.getMonth() + 1) > 9 ? '' + (service_Date.getMonth() + 1) : '0' + (service_Date.getMonth() + 1);
	var s_day = service_Date.getDate() > 9 ? ''+service_Date.getDate() : '0'+service_Date.getDate();
	var s_time = service_Date.getHours() + service_Date.getMinutes() + service_Date.getSeconds();
	
	var service_possi_day = s_year + '-' + s_mon + '-' + s_day;
	
	
	
	
	
	//pk를 발행하기 위한 - time 적용 후 새로운 변수에 담기
	var startFullDay = year + mon + day + time;
	
	//프론트 pk 발행. (백엔드 서버 db에서 반영하는 pk와는 전혀 무관. 별개.)
	var tourInputPK = startFullDay + randomKey;
	
	//pk 테스트
	console.log(tourInputPK);

	$("#start_Date").val(tomorrow_day);

	// 69 e(지수) / 190 소수점 / 109 마이너스 / 189 중간 키보드에 있는 - 마이너스
	$("#adultNum, #childrenNum").on(
			"change click input keyup keydown mouseup mouseover paste",
			function(e) {

				if (e.keyCode == 69 || e.keyCode == 190 || e.keyCode == 189
						|| e.keyCode == 109) {
					return false;
				}
			});

	$("#adultNum").on(
			"change click input keyup keydown mouseup mouseover paste",
			function(e) {

				if ($(this).val() < 1) {
					swal({
						title : "성인 1명 이상부터 여행 가능합니다.",
						text : "(Encore Tours Guide)",
						icon : "info",
						button : "OK",
					});
					$("#adultNum").val(1);
					return false;
				}
			});

	$("#childrenNum").on(
			"change click input keyup keydown mouseup mouseover paste",
			function(e) {
				
				if ($(this).val() < 0) {
					swal({
						title : "0명 미만은 불가능합니다.",
						text : "(Encore Tours Guide)",
						icon : "info",
						button : "OK",
					});
					$("#childrenNum").val(0);
					return false;
				}
				
				if ($(this).val() == '') {
					$("#childrenNum").val(0);
					return false;
				}
			});

	
	
	// ------------------------------------
	// 옵션 get - start
	// ------------------------------------
	var tour_place_option = 2; //선택 안 한 경우, 기본값 적용.
	var tour_speed_option = 2; //선택 안 한 경우, 기본값 적용.

	$("#tour_place_opt a").eq(0).on('click', function() {
		// alert(1 + '번째 tour_place_opt event arise');
		tour_place_option = 3;
	});

	$("#tour_place_opt a").eq(1).on('click', function() {
		// alert(2 + '번째 tour_place_opt event arise');
		tour_place_option = 2;
	});

	$("#tour_place_opt a").eq(2).on('click', function() {
		// alert(3 + '번째 tour_place_opt event arise');
		tour_place_option = 1;
	});

	$("#tour_speed_opt a").eq(0).on('click', function() {
		// alert(1 + '번째 tour_speed_opt event arise');
		tour_speed_option = 3;
	});

	$("#tour_speed_opt a").eq(1).on('click', function() {
		// alert(2 + '번째 tour_speed_opt event arise');
		tour_speed_option = 2;
	});

	$("#tour_speed_opt a").eq(2).on('click', function() {
		// alert(3 + '번째 tour_speed_opt event arise');
		tour_speed_option = 1;
	});

	// 테스트
	// console.log('----------------------------------------------\n');
	// var place_opt_len = $("#tour_place_opt a").length;
	// var speed_opt_len = $("#tour_speed_opt a").length;
	// console.log(place_opt_len);
	// console.log(speed_opt_len);
	// console.log('----------------------------------------------\n');

	// ------------------------------------
	// The end of 옵션 get
	// ------------------------------------

	
	
	
	
	// ------------------------------------
	// 나만의 여행 만들기 - 버튼 클릭시.
	// ------------------------------------
	$("#pleaseMakeMap").on('click', function() {
		
		var start_d = $("#start_Date").val();
		var end_d = $("#finish_Date").val();

		if (start_d < tomorrow_day) {
			$("#start_Date").val(tomorrow_day);
			swal({
				title : "여행 시작일은 내일부터 가능합니다.",
				text : "(Encore Tours Guide)",
				icon : "info",
				button : "OK",
			});			
			return false;
		}
		
		if (end_d < start_d) {
			swal({
				title : "종료일은 시작일보다 작을 수 없습니다.",
				text : "(Encore Tours Guide)",
				icon : "info",
				button : "OK",
			});
			return false;
		}
		
		if(end_d > service_possi_day){
			$("#finish_Date").val(service_possi_day);
			swal({
				title : "120일 이후 콘텐츠는 준비 중입니다.",
				text : "(빠르게 준비하겠습니다. 감사드립니다.)",
				icon : "info",
				button : "OK",
			});
			return false;
		}

		if (start_d == '') {
			swal({
				title : "여행 시작일을 입력해주세요.",
				text : "(Encore Tours Guide)",
				icon : "info",
				button : "OK",
			});
			return false;
		} else if (end_d == '') {
			swal({
				title : "여행 종료일을 입력해주세요.",
				text : "(Encore Tours Guide)",
				icon : "info",
				button : "OK",
			});
			return false;
		}

		var romantic_check_option = 'not';
		var photospot_check_option = 'not';
		var healing_check_option = 'not';
		var culture_exep_check_option = 'not';
		var inner_check_option = 'not';
		var activity_check_option = 'not';

		// if문 붙히지 마세요.
		if ($('input:checkbox[id="romantic_check_option"]').is(
				":checked")) {
			romantic_check_option = 'romantic';
		}

		if ($('input:checkbox[id="photospot_check_option"]')
				.is(":checked")) {
			photospot_check_option = 'photospot';
		}

		if ($('input:checkbox[id="healing_check_option"]').is(
				":checked")) {
			healing_check_option = 'healing';
		}

		if ($('input:checkbox[id="culture_exep_check_option"]')
				.is(":checked")) {
			culture_exep_check_option = 'culture';
		}

		if ($('input:checkbox[id="inner_check_option"]').is(
				":checked")) {
			inner_check_option = 'inner';
		}

		if ($('input:checkbox[id="activity_check_option"]').is(
				":checked")) {
			activity_check_option = 'activity';
		}

		var every_check_option = romantic_check_option
				+ '_' + photospot_check_option + '_'
				+ healing_check_option + '_'
				+ culture_exep_check_option + '_'
				+ inner_check_option + '_'
				+ activity_check_option;
		
		$('#jeju_journey_input_form input[name="place_Opt_Num"]').val(tour_place_option);
		$('#jeju_journey_input_form input[name="speed_Opt_Num"]').val(tour_speed_option);
		$('#jeju_journey_input_form input[name="middle_Class_List"]').val(every_check_option);
		$('#jeju_journey_input_form input[name="key_Given_by_Front"]').val(tourInputPK);
		
//		// 제이슨 이전 스트링 형태
//		// 이후 JSON 객체로 JSON CONVERT 예정
//		var gyubeom_param = {
//			"start_Date" : $("#start_Date").val(),
//			"finish_Date" : $("#finish_Date").val(),
//			"adultNum" : $("#adultNum").val(),
//			"childrenNum" : $("#childrenNum").val(),
//			"place_Opt_Num" : tour_place_option,
//			"speed_Opt_Num" : tour_speed_option,
//			"middle_Class_List" : every_check_option
//		};
//		// MappingJackson2HttpMessageConverter을 이용하지 않고 JSON으로
//		// 연동하는 방법
//		// pom.xml과 server.xml에 설정할 필요가 없이 JS파일에만 처리해주면 된다.
//		// data부분을 JSON.stringfy로 변환해주고
//		// contentType에 application/json;charset=UTF-8만 추가해주면
//		// 간단하게 처리된다.
//
//		// 하기 방법은 정말 위험할 수 있다.
//		// 사용자가 할 수 있는 모든 돌발 상황을 제거한 후에야 사용 가능한 방법.
//		// form으로 보내는 경우, 태그 name과 VO 변수명을 일치시키면 가능한 일이지만
//		// 지금 화면 디자인 상 불가능한 상황.
//		// 우선 object 변수명은 VO와 맞춰놓기는 하였다.
//		$.ajax({
//			type : "POST",
//			url : "/team4_jeju/tour/insertTourSchTestPage.do",
//			async : false,
//			data : JSON.stringify(gyubeom_param),
//			contentType : "application/json; charset=UTF-8",
//			cache : false,
//			success : function(data) {
//				swal({
//					title : "나만의 여행을 만들러 Go! :D",
//					text : "(Encore Tours Guide)",
//					icon : "info",
//					button : "OK",
//				});
//				location.href = "/team4_jeju/tour/insertTourSchTestPage.do";
//			},
//			error : function(data) {
//				swal({
//					title : "Network Error - insert 737",
//					text : "(Encore Tours Guide)",
//					icon : "warning",
//					button : "OK",
//				});
//				return false;
//			}
//		});

		// 테스트
		console.log('----------------------------------------------');
		console.log($("#key_Given_by_Front").val()); // 프론트 발행 pk
		console.log($("#start_Date").val()); // 여행 시작일
		console.log($("#finish_Date").val()); // 여행 종료일
		console.log($("#adultNum").val()); // 성인수
		console.log($("#childrenNum").val()); // 아동수
		console.log($("#place_Opt_Num").val()); // 핫플레이스 //적당히 (place option) // 숨은 명소
		console.log($("#speed_Opt_Num").val()); // 여유롭게 // 보통 (speed option) // 휙 빠르게
		console.log($("#middle_Class_List").val()); // 로맨틱 체크 옵션 //포토스팟 // 체크 옵션 //힐링 체크 옵션
		// 문화/체험 체크 옵션 //실내 체크 옵션 //액티비티 체크 옵션
		console.log('----------------------------------------------\n');
		
		
		
		
		swal({
			  title : "나만의 여행을 만들러 Let's Go! :D",
			  text : "(Encore Tours Guide)",
			  icon : "info",
			  buttons: {
			    catch: {
			      text: "OK",
			      value: "catch",
			    }
			  },
		}).then((value) => {
			  switch (value) {
			    case "catch":
			    	$("#divLoading").show();
			    	$("#jeju_journey_input_form").submit();
			      break;
			  }
		});
		

	});
	// ------------------------------------
	// The end of 나만의 여행 만들기 - 버튼 클릭시.
	// ------------------------------------

});
