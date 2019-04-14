<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>쿠키</title>
	</head>
	<body>
	쿠키 값 확인: ${ID}
	<form method="post">

	아이디 <input type="text" name="khid" size="10" value="${ID}">
	
	암호 <input type="password" name="password" size="10">

	<input type="submit" value="로그인">

	</form>
	</body>
	</html>