<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>step</title>
	</head>
	<body>
	�ۼ��� �̸�����
	<br/>
	�̸� : ${requestScope.JoinForm.name}
	<!-- �����Ѱ� request �������� �ö� -->
	<br/>
	�̸� : ${sessionScope.JoinForm.name}
	<br/>
	�ּ� : ${JoinForm.address}
	<br/>
	�б� : ${JoinForm.school}
	<br/>
	���� : ${JoinForm.age}
	<br/>
	<a href="/spring4/example7/session/step2">[���� �ܰ��]</a>
	<br/>
	<a href="/spring4/example7/session/done">[��������]</a>
	</body>
	</html>