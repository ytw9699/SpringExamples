<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>로그인</title>
</head>
<body>
<form:form commandName="loginCommand">
<%-- <form:form> 커스텀 태그에서 설정한 커맨드 객체를 기본으로 사용하기 때문에 path 속성에서는 프로퍼티 이름만 설정하면됨 --%>
<%-- <form:form> 커스텀 태그는 method 속성과 action 속성을 표시하지 않으면 method 속성의 값은 "post"로★★ 설정되고 action 속성의 값은 
	   현재 요청 URL의 값이 설정된다.  --%>
<font color=red><form:errors element="div"/></font>
<!-- 패스를 안쓴 에러스가 리젝트메소드로 메시지 출력 ,element="div"는 없어도됨,기본값span-->
<!--reject메시지관련 태그의 속성 div태그안에 메시지가뜸-->
	아이디: <form:input path="userId"/>
	<!-- 이거는 리젝트벨류메소드 메시지 -->
	<%-- 아이디:<input type="text" name="userId" value="${loginCommand.userId}" /> --%>
	     <form:errors path="userId" />
	<br/>
	암호:  <form:password path="password" showPassword="false"/>
	      <form:errors path="password" />
	<br/>
	<input type="submit" />
</form:form>
</body>
</html>
