<%@ page contentType="text/html; charset=EUC-KR" %>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title><spring:message code="login.form.title"/></title>
	<!-- 프로퍼티스에 정의된거 가져다쓰는 메시지 태그 -->
	</head>
	<body>
	<form:form commandName="login">
	<font color=red><form:errors /></font>
	<!-- 리젝트부분은 여기서출력 : 잘못된 ID나 암호를 입력하셨습니다. 입력한 ID는 4입니다-->
	<p>
	<label for="loginType"><spring:message code="login.form.type" />1</label>
	<!-- label은  html태그 -->
	<form:select path="loginType" items="${loginTypes}" />
	<!-- path="loginType"은 logincommand자바빈의 loginType과 연결되어있고
	label for="loginType의 loginType과연결됨 일반회원을 선택하고 로그인타입글씨를 누르면
	일반회원이 선택됨
	<!--<select name="type">
	<c:forEach var="searchType" items="${searchTypeList}">
	<option value="${searchType.code}" <c:if test="${command.type == searchType.code}">selected</c:if>>
	${searchType.text}</option>
	</c:forEach>
	</select>-->
	</p>
	<p>
		<label for="id"><spring:message code="login.form.id" />2</label>
		<form:input id="id" path="id"/>
		<!-- <input type="text" id="id"/>위코드와 이거는 같은거 -->
		<!-- label for="id"와 input id="id"는 연결됨 id끼리 그래서 로그인id2누르면 인풋태그안에 커서옮겨짐 -->
		<font color=red><form:errors path="id" /></font>
	</p>
	<p>
		<label for="password"><spring:message code="login.form.password" />3</label>
		<form:password id="password" path="password"/>
		<form:errors path="password" />
	</p>
	<p>
		<input type="submit" value="<spring:message code="login.form.submit" />">
	</p>
	</form:form>
	</body>
	</html>