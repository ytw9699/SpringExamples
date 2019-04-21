<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*,com.test.mybatis.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>main</title>
<a href="main">메인!</a>
</head>
<body>
	<table border="1">
		<tr>
			<td>이름</td>
			<td>이메일</td>
			<td>전화번호</td>
			<td></td>
		</tr>
<form method="post" action="/mybatis/insert">
 <!-- mybatis이부분 내프로젝트명.<artifactId>mybatis</artifactId> -->
		<tr>
			<td><input type="text" name="name" id="name"></td>
			<td><input type="text" name="email" id="email"></td>
			<td><input type="text" name="phone" id="phone"></td>
			<td colspan="2" align="center">
			<input type="submit" value="추가">
			</td>
		</tr>
</form>
<c:forEach var="member" items="${result}" >
	<tr>
		<td>${member.name}</td>
		<td>${member.email}</td>
		<td>${member.phone}</td>
		<td><input type="button" value="삭제" onclick="deleting(1)"/>
		<input type="button" value="삭제" onClick="javascript:location.href='delete?name=${member.name}'"/>
		<a href="updateForm?name=${member.name}">수정</a>
		<a href="delete?name=${member.name}">삭제</a>
		</td>
	</tr>
			<script type="text/javascript">
				function deleting(where){
					switch (where) {
					case 1:	
				location.href = "delete?name=${member.name}";
				break;
					}
				}
			</script>
</c:forEach>
	</table>
</body>
</html>