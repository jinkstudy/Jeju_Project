
$(function(){

	//<![CDATA[
	// 사용할 앱의 JavaScript 키를 설정해 주세요.
	Kakao.init('95e85aa66afbc7aaf828aa2355f1eb56');

	// 카카오 로그인 버튼을 생성합니다.
	Kakao.Auth.createLoginButton({
		container: '#kakao-login-btn',
		success: function(authObj) {

			// 로그인 성공시, API를 호출합니다.
			Kakao.API.request({
				url: '/v1/user/me',
				success: function(res) {
					console.log(res);

					var userID = res.id;      //유저의 카카오톡 고유 id
					//var userProfileImage = res.properties.profile_image; //유저가 등록한 별명
					var userNickName = res.properties.nickname; //유저가 등록한 별명
					//유저의 카카오 계정의 생일
					var userEmail = res.kaccount_email;   //유저의 이메일
					
					//console.log(userProfileImage);
					console.log(userID);
					console.log(userNickName);
					console.log(userEmail);
					
					$('#id_text').val(userID);
					$('#name_text').val(userNickName);
					$('#email_text').val(userEmail);
					
				},
				fail: function(error) {
					alert(JSON.stringify(error));
				}
			});
		},
		fail: function(err) {
			alert(JSON.stringify(err));
		}
	});
	//]]>
	
	
	$('#log_out').on('click', function(){
		var member_input = $('#id_text, #name_text, #contact_text, #email_text, #birthday_text');
		member_input.val('');
		
		//토큰 삭제
		Kakao.Auth.logout(function(){
			location.href="/team4_jeju/member/login/logout.do";
			//setTimeout(function(){location.replace("../../main.jsp")},1);
		});		
	});

});








