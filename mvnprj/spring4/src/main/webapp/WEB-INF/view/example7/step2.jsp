<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>step</title>
	</head>
	<body>
	<form action="/spring4/example7/session/step3" method="post">

	학교 <input type="text" name="school" size="10" value="${JoinForm.school}">
	
	나이 <input type="text" name="age" size="10" value="${JoinForm.age}">

	<input type="submit" value="임시 제출">
	</form>
	<a href="/spring4/example7/session/step1">[이전 단계로]</a>
	</body>
	</html>