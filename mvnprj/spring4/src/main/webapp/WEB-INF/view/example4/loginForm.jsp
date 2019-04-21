<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>쿠키</title>
	</head>
	<body>
	<form action="/spring4/example4/cookie/make.do">

	아이디 <input type="text" name="id" size="10" value="${KHID}">
	
	암호 <input type="password" name="password" size="10">

	<input type="submit" value="로그인">
	</body>
	</html>