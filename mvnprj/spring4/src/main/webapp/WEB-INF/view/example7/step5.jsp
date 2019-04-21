<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>step</title>
	</head>
	<body>
	저희 기업에 지원해주셔셔 감사합니다
	<br/>
	그리고 다시이동하면 리퀘스트영역에서도 삭제됨
	<br/>
	이름 : ${requestScope.JoinForm.name}
	<br/>
	이름 : ${sessionScope.JoinForm.name}
	<br/>
	주소 : ${JoinForm.address}
	<br/>
	학교 : ${JoinForm.school}
	<br/>
	나이 : ${JoinForm.age}
	<br/>
	<a href="/spring4/example7/session/done">[이전 단계로]</a>
	<br/>
	<a href="/spring4/example7/session/step1">[처음으로 돌아가기]</a>
	</body>
	</html>