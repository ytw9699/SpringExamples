<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ page import="java.util.*,com.test.mybatis.*"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>updateForm</title>
</head>


<body>
<input type="button" value="새로고침" onclick="location.reload()" />
<a href="main">메인!</a>
	<form method="post" action="/mybatis/update">
		<table border="1">
			<tr>
				<td>이름</td>
				<td>이메일</td>
				<td>전화번호</td>
				<td></td>
			</tr>
			<tr>
				<td><input type="text" name="name" id="name" value="${member.name}"></td>
				<td><input type="text" name="email" id="email" value="${member.email}"></td>
				<td><input type="text" name="phone" id="phone" value="${member.phone}"></td>
				<td colspan="2" align="center">
				<input type="submit" value="수정">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>