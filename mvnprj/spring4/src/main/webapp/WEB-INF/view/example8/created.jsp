<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>계정 생성</title>
	</head>
	<body>
	계정 생성됨
	<ul>
	 <li>아이디: ${command.id}</li>
	 <li>이름: ${command.name}</li>
	 <li>우편번호: ${command.address.zipcode}</li>
	 <li>주소: ${command.address.address1} ${command.address.address2}</li>
	</ul>
	</body>
	</html>