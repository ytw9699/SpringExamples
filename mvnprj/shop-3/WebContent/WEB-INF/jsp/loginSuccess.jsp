<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<title>로그인화면</title>
</head>
<body>
	<div align="center" class="body">
		<h2>로그인화면</h2>
		환영해요,${loginUser.userName}씨！
					<br/>
				${loginUser.password}
					<br/>
				${loginUser.address}
					<br/>
				${loginUser.email}
					<br/>
				${loginUser.job}
					<br/>
				${loginUser.postCode}
					<br/>
				<fmt:formatDate value="${loginUser.birthDay}" pattern="yyyy-MM-dd" />
	</div>
</body>
</html>