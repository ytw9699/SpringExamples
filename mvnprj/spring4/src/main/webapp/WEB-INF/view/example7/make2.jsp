<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>세션값</title>
	</head>
	<body>
	<c:if test="${sessionScope.sessionid != null}">
	${requestScope.sessionid} 아이디로 로그인 되어있습니다.
	<br/>
	${sessionScope.sessionid} 아이디로 로그인 되어있습니다.
	<br/>
	<input type="button" value="로그 아웃" onClick="javascript:location.href='/spring4/example7/session/logout.do2'"/>
	 </c:if>
	 <c:if test="${sessionScope.sessionid == null}">
		로그인을 다시 해주시기 바랍니다.
		<input type="button" value="로그인" onClick="javascript:location.href='/spring4/example7/session/make.do2'"/>
	 </c:if>
	</body>
	</html>