<%@ page contentType="text/html; charset=EUC-KR" %>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>회원 등록 폼</title>
	</head>
	<body>
	<form:form commandName="memberInfo">
	<!-- 소문자바뀐걸로 -->
	<p>
		<form:label path="userId">회원 ID</form:label>
		<form:input path="userId" />
		<form:errors path="userId" />
	</p>
	<p>
		<form:label path="name">이름</form:label>
		<form:input path="name" />
		<form:errors path="name" />
	</p>
	<p>
		<form:label path="address.address1">주소1</form:label>
		<form:input path="address.address1" />
		<form:errors path="address.address1" />
	</p>
	<p>
		<form:label path="address.address2">주소2</form:label>
		<form:input path="address.address2" />
		<form:errors path="address.address2" />
	</p>
	<p>
<%-- <label for="loginType"><spring:message code="login.form.type" />1</label>
	 <form:select path="loginType" items="${loginTypes}" /> --%>
		<form:label path="jobCode">직업</form:label>
		<form:select path="jobCode" >
			<option value="">--- 선택하세요 ---</option>
			<form:options items="${jobCodes}" itemLabel="label" itemValue="code" />
		</form:select>
		<form:errors path="jobCode" />
	</p>
	<p>
		<form:label path="favorites">선호 OS</form:label>
		<form:checkboxes items="${favoritesOsNames}" path="favorites" />
		<%--
		<form:checkbox path="favorites" value="윈도우XP" label="윈도우XP" />
		<form:checkbox path="favorites" value="비스타" label="비스타" />
		<form:checkbox path="favorites" value="윈도우7" label="윈도우7" />
		<form:checkbox path="favorites" value="우분투" label="우분투" />
		<form:checkbox path="favorites" value="맥" label="맥" />
		--%>
		<font color=red><form:errors path="favorites"/></font>
	</p>
	<p>
		<form:label path="tool">주로 사용하는 개발툴</form:label>
		<form:radiobuttons items="${tools}" path="tool" />
	</p>
	<p>
		<form:label path="etc">기타</form:label>
		<form:textarea path="etc" cols="20" rows="3"/>
	</p>
	<p>
		<form:checkbox path="contractAgreement" label="약관에 동의합니다."/>
	</p>
	<p>
		<input type="submit" value="회원 등록">
	</p>
	</form:form>
	</body>
	</html>