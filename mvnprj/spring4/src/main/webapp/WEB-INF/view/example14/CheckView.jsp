<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<ul>
<c:forEach var="petname" items="${CheckboxModel.pet}">
<li>${petname}</li>
</c:forEach>
<c:forEach var="petname2" items="${CheckboxModel.pet2}">
<li>${petname2}</li>
</c:forEach>
<c:if test="${CheckboxModel.pet3}">
이메일을 수신합니다 ${CheckboxModel.pet3}
</c:if>
</ul>
</body>
</html>











