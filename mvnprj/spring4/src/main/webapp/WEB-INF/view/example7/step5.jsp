<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>step</title>
	</head>
	<body>
	���� ����� �������ּż� �����մϴ�
	<br/>
	�׸��� �ٽ��̵��ϸ� ������Ʈ���������� ������
	<br/>
	�̸� : ${requestScope.JoinForm.name}
	<br/>
	�̸� : ${sessionScope.JoinForm.name}
	<br/>
	�ּ� : ${JoinForm.address}
	<br/>
	�б� : ${JoinForm.school}
	<br/>
	���� : ${JoinForm.age}
	<br/>
	<a href="/spring4/example7/session/done">[���� �ܰ��]</a>
	<br/>
	<a href="/spring4/example7/session/step1">[ó������ ���ư���]</a>
	</body>
	</html>