<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>step</title>
	</head>
	<body>
	<form action="/spring4/example7/session/step3" method="post">

	�б� <input type="text" name="school" size="10" value="${JoinForm.school}">
	
	���� <input type="text" name="age" size="10" value="${JoinForm.age}">

	<input type="submit" value="�ӽ� ����">
	</form>
	<a href="/spring4/example7/session/step1">[���� �ܰ��]</a>
	</body>
	</html>