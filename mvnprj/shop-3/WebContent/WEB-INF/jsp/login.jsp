<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp"%>
<html>
<head>
<title>로그인 화면</title>
</head>
<body>
<div align="center" class="body">
<h2>로그인 화면</h2>
<form:form modelAttribute="user" method="post" action="login.html">
	<spring:hasBindErrors name="user">
		<font color="red"><c:forEach var="error" items="${errors.globalErrors}">
			<spring:message code="${error.code}"  />
		</c:forEach> </font>
	</spring:hasBindErrors>
	<table>
		<tr height="40px">
			<td>유저ID</td>
			<td><form:input path="userId" cssClass="userId" />
			<font color="red"><form:errors path="userId" /></font></td>
		</tr>
		<tr height="40px">
			<td>패스워드</td>
			<td><form:password path="password" cssClass="password" />
			<font color="red"><form:errors path="password" /></font></td>
		</tr>
	</table>
	<table>
		<tr>
			<td align="center"><input type="submit" value="로그인"></td>
			<td align="center"><input type="reset" value="리셋"></td>
		</tr>
	</table>
</form:form></div>
</body>
</html>