<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>���� ����</title>
	</head>
	<body>
	���� ������
	<ul>
	 <li>���̵�: ${command.id}</li>
	 <li>�̸�: ${command.name}</li>
	 <li>�����ȣ: ${command.address.zipcode}</li>
	 <li>�ּ�: ${command.address.address1} ${command.address.address2}</li>
	</ul>
	</body>
	</html>