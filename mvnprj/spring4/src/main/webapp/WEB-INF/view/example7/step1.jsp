<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>step</title>
	</head>
	<body>
		<form action="/spring4/example7/session/step2" method="post">
	
			이름 <input type="text" name="name" size="10" value="${JoinForm.name}">
			
			주소 <input type="text" name="address" size="10" value="${JoinForm.address}">
		
			<input type="submit" value="다음 단계">
		</form>
	</body>
	</html>