<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>



<style type="text/css">

.btn-encore_tours {
  color: #fff;
  background-color: #518DFF;
  border-color: #518DFF;
}

.btn-encore_tours:hover {
  color: #fff;
  box-shadow: 0 80px 0 0 rgba(233,241,255,0.25) inset, 0 -80px 0 0 rgba(233,241,255,0.25) inset;
  border-color: #e9f1ff;
}

.jeju-radio-input {
  position: fixed;
  left: -100px;
  border: 0.125rem solid #ced4da;
  border-radius: 0.5rem;
}

.jeju-f-input {
  appearance: none;
  background-color: #fff;
  display: block;
  transition: 300ms ease;
  border-radius: 7px;
  border: 0;
  max-height: 0;
  margin: 0;
  padding: 0 10px;
  overflow: hidden;
  width: 250px;
  opacity: 0;
  font-size: 16px;
  text-align: center;
  outline: 0;
}

[id=jeju-sign-in]:checked ~ input.jeju-sign-in,
[id=jeju-sign-up]:checked ~ input.jeju-sign-up,
[id=jeju-reset]:checked ~ input.jeju-reset {
  max-height: 40px;
  padding: 10px;
  margin: 10px 0;
  opacity: 1;
}

.jeju-f-button {
  width: 250px;
  height: 40px;
  border-radius: 7px;
  font-size: 0;
}
.jeju-f-button:before {
  font-size: 16px;
}

[id=jeju-sign-in]:checked ~ button:before {
  content: "로그인";
}

[id=jeju-sign-up]:checked ~ button:before {
  content: "회원가입";
}

[id=jeju-reset]:checked ~ button:before {
  content: "jeju-reset password";
}

.jeju-f-label {
  position: relative;
  display: inline-block;
  text-align: center;
  font-weight: 700;
  cursor: pointer;
  color: #97b9ff;
  transition: 300ms ease;
  width: calc(100% / 3 - 4px);
}
.jeju-f-label:after {
  content: "";
  border: 10px solid transparent;
  position: absolute;
  bottom: -10px;
  left: calc(50% - 10px);
  transition: inherit;
}

[id=jeju-sign-in]:checked ~ [for=jeju-sign-in],
[id=jeju-sign-up]:checked ~ [for=jeju-sign-up],
[id=jeju-reset]:checked ~ [for=jeju-reset] {
  color: #518DFF;
}
[id=jeju-sign-in]:checked ~ [for=jeju-sign-in]:after,
[id=jeju-sign-up]:checked ~ [for=jeju-sign-up]:after,
[id=jeju-reset]:checked ~ [for=jeju-reset]:after {
  border-bottom-color: #fff;
}

.jeju-login-form{
	padding : 2rem;
	background-color : #E9F1FF;	
}

.jeju-flex-wrap {
	font-size : 17px;
	display: flex;
	justify-content: center;
	align-items: center;
	flex-wrap: wrap;
	height: 300px;
	text-align: center;
}

.jeju-login-fieldset{
	border-color : #fff;
}
</style>

</head>
<body>

<div class="jeju-flex-wrap">
        <form action novalidate
              class="jeju-login-form">
            <input type="radio"
                   class="jeju-f-input jeju-radio-input" 
                   name="rg"
                   id="jeju-sign-in" checked/>
            <input type="radio"
                   class="jeju-f-input jeju-radio-input" 
                   name="rg" 
                   id="jeju-sign-up" />
            <input type="radio" 
                   class="jeju-f-input jeju-radio-input" 
                   name="rg" 
                   id="jeju-reset" />        

            <label for="jeju-sign-in"
                   class="jeju-f-label"
                   >로그인</label>
            <label for="jeju-sign-up"
                   class="jeju-f-label"
                   >회원가입</label>
            <!-- <label for="jeju-reset"
            	   class="jeju-f-label"
            	   >Reset</label> -->

            <input class="jeju-sign-up jeju-sign-in jeju-reset jeju-f-input" 
                   type="email" placeholder="Email" />
            <input class="jeju-sign-up jeju-sign-in jeju-f-input" 
                   type="password" placeholder ="Password" />
            <input class="jeju-sign-up jeju-f-input" 
                   type="password" placeholder ="Repeat Password" />
            <button class="btn-encore_tours jeju-f-button">Submit</button>
        </form>
</div>

</body>
</html>