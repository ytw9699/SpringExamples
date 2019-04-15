<%@ page contentType="text/html; charset=EUC-KR" %>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title><spring:message code="login.form.title"/></title>
	<!-- ������Ƽ���� ���ǵȰ� �����پ��� �޽��� �±� -->
	</head>
	<body>
	<form:form commandName="login">
	<font color=red><form:errors /></font>
	<!-- ����Ʈ�κ��� ���⼭��� : �߸��� ID�� ��ȣ�� �Է��ϼ̽��ϴ�. �Է��� ID�� 4�Դϴ�-->
	<p>
	<label for="loginType"><spring:message code="login.form.type" />1</label>
	<!-- label��  html�±� -->
	<form:select path="loginType" items="${loginTypes}" />
	<!-- path="loginType"�� logincommand�ڹٺ��� loginType�� ����Ǿ��ְ�
	label for="loginType�� loginType������� �Ϲ�ȸ���� �����ϰ� �α���Ÿ�Ա۾��� ������
	�Ϲ�ȸ���� ���õ�
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
		<!-- <input type="text" id="id"/>���ڵ�� �̰Ŵ� ������ -->
		<!-- label for="id"�� input id="id"�� ����� id���� �׷��� �α���id2������ ��ǲ�±׾ȿ� Ŀ���Ű��� -->
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