<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>로그인</title>
	</head>
	<body>
	http://localhost:8080/spring4/example7/session/login.do2실행 <br/>
	현재 페이지 login.jsp<br/>
	<br/>
	 <c:if test="${sessionScope.sessionid == null}">
	 로그인을 해주시기 바랍니다.
	<input type="button" value="로그인" onClick="javascript:location.href='/spring4/example7/session/make.do3'"/>
	 </c:if>
	 <c:if test="${sessionScope.sessionid != null}">
	${requestScope.sessionid} 아이디로 로그인 되어있습니다.
	${sessionScope.sessionid} 아이디로 로그인 되어있습니다.
	<br/>
	로그아웃<input type="button" value="로긴 아웃" onClick="javascript:location.href='/spring4/example7/session/logout.do3'"/>
	 </c:if>
	</body>
	</html>