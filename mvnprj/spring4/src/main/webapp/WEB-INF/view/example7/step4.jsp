<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>step</title>
	</head>
	<body>
	������ ���� ���� ����Ǿ����ϴ�
	<br/>
	�̸� : ${requestScope.JoinForm.name} //�������̶� ������ �̵��ص� ������Ʈ�������� �������� �� �� �ѹ��� ������ �̵� ����
	<!-- request �������� �ö� -->
	<br/>
	�̸� : ${sessionScope.JoinForm.name} //���ǿ��������� ������
	<br/>
	�ּ� : ${JoinForm.address}
	<br/>
	�ּ� : ${sessionScope.JoinForm.address}//���ǿ��������� ������
	<br/>
	�б� : ${JoinForm.school}
	<br/>
	���� : ${requestScope.JoinForm.age}
	<br/>
	<a href="/spring4/example7/session/step3">[���� �ܰ��]</a>
	<br/>
	<a href="/spring4/example7/session/step5">[���� �ܰ��]</a>
	<br/>
	<a href="/spring4/example7/session/step1">[ó������ ���ư���]</a>
	</body>
	</html>