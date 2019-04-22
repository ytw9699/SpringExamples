<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>step</title>
	</head>
	<body>
	작성본 미리보기
	<br/>
	이름 : ${requestScope.JoinForm.name}
	<!-- 희한한건 request 영역에도 올라감 -->
	<br/>
	이름 : ${sessionScope.JoinForm.name}
	<br/>
	주소 : ${JoinForm.address}
	<br/>
	학교 : ${JoinForm.school}
	<br/>
	나이 : ${JoinForm.age}
	<br/>
	<a href="/spring4/example7/session/step2">[이전 단계로]</a>
	<br/>
	<a href="/spring4/example7/session/done">[최종제출]</a>
	</body>
	</html>