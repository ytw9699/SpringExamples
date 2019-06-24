<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	  <h1>Custom Login Page</h1>
	  <h2><c:out value="${error}"/></h2>
	  <h2><c:out value="${logout}"/></h2>
					<!-- 	  특이한점은 실제로 로그인의 처리 작업은 ’/login’을
					통해서 이루어지는데 반드시 POST 방식으로 데이터를 전송해야만. -->
	  <form method='post' action="/login">
	  <!-- 만일 사용자가 패스워드 등을 잘못 입력하는 경우에는 자동으로 다시 로그인 페이지로 이동 -->
		  <div>   
		    <input type='text' name='username' value='admin'>   
		    <!-- 〈input〉태그의 name 속성은 기본적으로는 username과 password 속성을 이용합니다 
		    username이름을 바꾸면 동작을 안하네..
		    -->
		  </div>
		  <div>
		    <input type='password' name='password' value='admin'>
		  </div>
		  <div>
		    <input type='checkbox' name='remember-me'> Remember Me
		  </div>
		  <div>
		    <input type='submit'>
		  </div>
		    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		    <%-- 〈input type=’hidden〉태그는 조금 특이하게도 ${_csrf.parameterName}으로 처리합니다. 이 EL의 값은 실제 브라우저에서는 ’_csrf라는 이름으로 처리 --%>
			     <!-- name="_csrf" value="3b02c62d-cb68-4a1b-813a_08bd3baf6ac1" / -->
			    <!-- 공격자의 입장에서는 CSRF 공격을 하려면 변경되는 CSRF 토큰의 값을 알아야만 한다. -->
<!-- 			    CSRF 토큰은 사용자가 임의로 변하는 특정한 토큰값을 서버에서 체크하는 방식입니다.
서버에는 브라우저에 데이터를 전송할 때 CSRF 토큰을 같이 전송 . 사용자가
POST 방식 등으로 특정한 작업을 할 때는 브라우저에서 전송된 CSRF 토큰의 값과 서버
가 보관하고 있는 토큰의 값을 비교합니-->
<!-- 			    스프링 시큐리티에서 POST 방식을 이용하는 경우 기본적으로 CSRF 토큰이라는 것을
이용하게 됩니다. 별도의 설정이 없다면 스프링 시큐리티가 적용된 사이트의 모든 POST
방식에는 CSRF 토큰이 사용되는데 ’사이트간 위조 방지’를 목적으로 특정한 값의 토큰을
사용하는 방식 입니다 -->
	  </form>
</body>
</html>
