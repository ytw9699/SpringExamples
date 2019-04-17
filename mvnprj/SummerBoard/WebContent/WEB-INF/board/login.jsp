<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link href="<%=request.getContextPath()%>/css/main.css" rel="stylesheet" type="text/css">
				<!-- /SummerBoard  -->
<c:if test="${errCode == null}">
	<c:set var="errCode" value="\"\""></c:set>
	<!-- 에러코드가 널이면 ""이값만 가지게 하겠다 -->
</c:if>
<%-- <c:forEach var="petname" items="${CheckboxModel.pet}">
<li>${petname}</li>
</c:forEach> --%>
<script type="text/javascript">
	function checkErrCode(){
		var errCode = ${errCode};
		if(errCode != null || errCode != ""){
			switch (errCode) {
			case 1:
				alert("가입된 이메일 주소가 아닙니다!");
				break;
			case 2:
				alert("비밀번호가 일치하지 않습니다!");
				break;
			case 3:
				alert("회원가입 처리가 완료되었습니다! 로그인 해 주세요!");
	<%-- 		location.href = "<%=request.getContextPath()%>/login.do"; 
	이거 안들어가도됨--%>
				break;
			}
		}
	}
</script>
</head>
<body onload="checkErrCode()">
<div class="wrapper">
<h3>스프링 게시판1</h3>
	<spring:hasBindErrors name="LoginModel" />
	<form:errors path="LoginModel" />
	<form action="login.do" method="post">
		<fieldset>
			<label for="userId">메일주소 : </label>
			<input type="text" id="userId" name="userId" class="loginInput" value="${userId}" />
													<!-- {userId}는//이메일주소가 틀려도 그대로 저장되게할려고 값넘김 -->
			<span class="error"><form:errors path="LoginModel.userId" /></span><br />
			<label for="userPw">비밀번호 : </label>
			<input type="password" id="userPw" name="userPw" class="loginInput"/>
			<span class="error"><form:errors path="LoginModel.userPw" /></span><br /><br />
			<center>
			<input type="submit" value="로그인" class="submitBt"/><br /><br />
			<a href="<%=request.getContextPath()%>/member/join.do">회원가입</a>		
			</center>		
		</fieldset>			
	</form>
</div>
</body>
</html>