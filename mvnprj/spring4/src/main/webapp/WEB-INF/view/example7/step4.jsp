<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>step</title>
	</head>
	<body>
	다음과 같이 최종 제출되었습니다
	<br/>
	이름 : ${requestScope.JoinForm.name} //포워딩이라 페이지 이동해도 리퀘스트영역에는 남아있음 단 딱 한번만 페이지 이동 가능
	<!-- request 영역에도 올라감 -->
	<br/>
	이름 : ${sessionScope.JoinForm.name} //세션영역에서는 삭제됨
	<br/>
	주소 : ${JoinForm.address}
	<br/>
	주소 : ${sessionScope.JoinForm.address}//세션영역에서는 삭제됨
	<br/>
	학교 : ${JoinForm.school}
	<br/>
	나이 : ${requestScope.JoinForm.age}
	<br/>
	<a href="/spring4/example7/session/step3">[이전 단계로]</a>
	<br/>
	<a href="/spring4/example7/session/step5">[다음 단계로]</a>
	<br/>
	<a href="/spring4/example7/session/step1">[처음으로 돌아가기]</a>
	</body>
	</html>