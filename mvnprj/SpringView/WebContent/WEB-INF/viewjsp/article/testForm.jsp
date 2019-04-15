<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
	String servletPath = request.getRequestURI();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>테스트 코드</title>
</head>
<body>
<form:form action="/SpringView/jsp/article/${article.id}" commandName="article" method="delete">
<input type="submit" value="삭제">
</form:form>

<form:form action="/SpringView/jsp/article/${article.id}" commandName="article" method="put">
<input type="submit" value="수정">
</form:form>

<form:form action="/SpringView/jsp/article" commandName="article" method="post">
<input type="submit" value="생성">
</form:form>
</body>
</html>






