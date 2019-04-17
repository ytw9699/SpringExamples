<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>알람</title>
</head>
<body>
	
	<c:if test="${alarmList.size() > 0}">
		
	<c:forEach var="alarm" items="${alarmList}">
	<c:if test="${alarm.kind == 0}">
	
	<a href="view.do?idx=${alarm.productnumber}&alarmidx=${alarm.idx}&BackPush=0"><font color=red>댓글이 등록되었습니다</font></a><br/>
	
	</c:if>
	</c:forEach>
	</c:if>
	
	
	
<%-- 	<c:if test="${pushList.size() > 0}">
	<c:forEach var="push" items="${pushList}">
	
	<c:forEach var="i" begin="1" end="${push.push}"> 
		<a href="view.do?idx=${push.idx}&BackPush=0"><font color=red>${push.subject}글에 댓글이 등록되었습니다</font></a><br/>
	</c:forEach>
	
	</c:forEach>
	</c:if> --%>

</body>
</html>
