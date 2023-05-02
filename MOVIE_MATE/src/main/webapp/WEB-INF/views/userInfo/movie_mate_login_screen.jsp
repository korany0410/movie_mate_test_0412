<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="/mate/resources/images/logo_icon_2.png" />
<link rel="apple-touch-icon"
   href="/mate/resources/images/logo_icon_2.png" />
<title>무비메이트</title>
<link
   href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
   rel="stylesheet"
   integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
   crossorigin="anonymous" />
<script
   src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
   integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
   crossorigin="anonymous"></script>
<script
   src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js"
   integrity="sha384-zYPOMqeu1DAVkHiLqWBUTcbYfZ8osu1Nd6Z89ify25QV9guujx43ITvfi12/QExE"
   crossorigin="anonymous"></script>
<script
   src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.min.js"
   integrity="sha384-Y4oOpwW3duJdCWv5ly8SCFYWqFDsfob/3GkgExXKV4idmbt98QcxXYs9UoXAB7BZ"
   crossorigin="anonymous"></script>
<link rel="stylesheet" href="/mate/resources/css/signUp.css?ver=1" />
<link rel="stylesheet" href="/mate/resources/css/reset.css" />
<script type="text/javascript" src="/mate/resources/js/httpRequest.js"></script>
<script>
    function send(f) {
   var email = f.email.value;
   var pwd = f.pwd.value;
   var pathname = "${pathname}";

   if (pathname == "" || pathname == "logout.do") {
       pathname = "movie_mate_main_screen.do";

       url = "login.do";
       param = "email=" + email + "&pwd=" + pwd + "&pathname=" + pathname;
       sendRequest(url, param, resFn, "POST");


   }
    }

    function resFn() {
   if (xhr.readyState == 4 && xhr.status == 200) {
       var result = xhr.responseText;
       if (result != 'fail') {
      alert("로그인 성공했습니다.");
      location.href = result;
       } else {
      alert("아이디 또는 비밀번호가 일치하지 않습니다.");
      return;
       }
   }
    }
</script>
</head>
<body>
   <form>
      <div id="main_box">
         <div class="logo_box input-group mb-2">
            <img class="logo_img" alt=""
               src="/mate/resources/images/logo_sub.png">
         </div>
         <div class="input_box input-group mb-2" id="email_box">
            <input type="email" name="email" class="form-control"
               placeholder="이메일">
         </div>
         <div class="input_box input-group mb-2" id="pwd_box">
            <input type="password" name="pwd" class="form-control"
               placeholder="비밀번호">
         </div>
         <div class="input_box input-group mb-2">
            <input type="button" name="button" value="로그인"
               class="btn btn-outline-danger" onclick="send(this.form);">
         </div>
         <div class="link_box input-group mb-2" id="link_box">
            계정이 없으신가요? <a href="movie_mate_signUp_screen.do">회원가입</a>
         </div>
         <div class="openApi_box input-group mb-2"></div>
      </div>
   </form>
   
<hr>	
<br>
 
<center>
	<c:choose>
		<c:when test="${sessionId != null}">
			<h2> 네이버 아이디 로그인 성공하셨습니다!! </h2>
			<h3>'${sessionId}' 님 환영합니다! </h3>
            	<h3><a href="logout">로그아웃</a></h3>
 
		</c:when>
		<c:otherwise>
			<form action="login.userdo" method="post" name="frm"  style="width:470px;">
				<h2>로그인</h2>
				  <input type="text" name="id" id="id" class="w3-input w3-border" placeholder="아이디" value="${id}"> <br>
				  <input type="password" id="pwd" name="pwd" class="w3-input w3-border" placeholder="비밀번호" >	<br>
				<input type="submit" value="로그인" onclick=""> <br>
			</form>
			<br>
			
			<!-- 네이버 로그인 창으로 이동 -->
			<div id="naver_id_login" style="text-align:center"><a href="${url}">
			<img width="223" src="https://developers.naver.com/doc/review_201802/CK_bEFnWMeEBjXpQ5o8N_20180202_7aot50.png"/></a></div>
			<br>
		
		</c:otherwise>
	</c:choose>
	
</center>
   
</body>
</html>