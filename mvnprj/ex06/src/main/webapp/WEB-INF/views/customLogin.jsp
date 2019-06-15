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
					<!-- 	   실제로 로그인의 처리 작업은 ’/login’을
					통해서 이루어지는데 반드시 POST 방식으로 데이터를 전송해야만. -->
	  <form method='post' action="/login">
		  <div>
		    <input type='text' name='username' value='admin'>
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
			    <!-- 공격자의 입장에서는 CSRF 공격을 하려면 변경되는 CSRF 토큰의 값을 알아야만 한다. -->
	  </form>
</body>
</html>
