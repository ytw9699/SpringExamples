<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  
<h1> Logout Page</h1>
	<!-- . POST 방식으로 처리되기 때문에 CSRF 토큰값을 같이 지정 -->
<form action="/customLogout" method='post'>
	<input type="hidden"name="${_csrf.parameterName}"value="${_csrf.token}"/>
	 <input type='submit' value="로그아웃">
	<button>로그아웃</button>
</form>
<!-- ’/customLogout’에서 POST 방식으로 로그아웃을 하게 되면  내부적으로
는 자동으로 로그인 페이지를 호출
로그인 페이지는 스프링 시큐리티의 기본 설정 
이므로 필요하다면 xml에서 logout-success-url 속성 등을 이용해서 변경
 <security:logout logout-url="/customLogout" invalidate-session="true"  logout-success-url="/" />
-->
</body>
</html>
