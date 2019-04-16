<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp"%>
<html>
<head>
<title>유저 등록 완료 화면</title>
</head>
<body>
<div align="center" class="body">
<h2>유저 등록 완료 화면</h2>
<b><font color="red">유저 등록이 완료되었습니다.</font></b><br>
<table>
	<tr height="40px">
		<td>유저ID</td>
		<td>${user.userId}</td>
	</tr>
	<tr height="40px">
		<td>패스워드</td>
		<td>${user.password}</td>
	</tr>
	<tr height="40px">
		<td>이름</td>
		<td>${user.userName}</td>
	</tr>
	<tr height="40px">
		<td>우편번호</td>
		<td>${user.postCode}</td>
	</tr>
	<tr height="40px">
		<td>주소</td>
		<td>${user.address}</td>
	</tr>
	<tr height="40px">
		<td>E-MAIL</td>
		<td>${user.email}</td>
	</tr>
	<tr height="40px">
		<td>직업</td>
		<td>${user.job}</td>
	</tr>
	<tr height="40px">
		<td>생년월일</td>
		<td><f:formatDate value="${user.birthDay}" pattern="yyyy년MM월dd일" /></td>
	</tr>
</table>
</div>
</body>
</html>