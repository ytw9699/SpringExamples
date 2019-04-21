<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ page import ="java.util.*,com.test.mybatis.*" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>결과창</title>
</head>
<body>
<a href="main">메인!</a>
<table border="1">
	 <tr>
		 <td width="50px" align="center">이름</td>
		 <td align="center">이메일</td>
		 <td align="center">전화번호</td>
	 </tr>
	 <!-- result는 contoller의 addObject로 부터 가져온다. -->
	 <c:forEach var="member" items="${result}">
		 <tr>
			 <td>${member.name}</td>
			 <td>${member.email}</td>
			 <td>${member.phone}</td>	
		 </tr>
	 </c:forEach>
</table>
</body>
</html>