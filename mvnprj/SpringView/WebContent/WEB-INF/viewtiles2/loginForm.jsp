<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form commandName="login">
<form:errors />
<p>
	<label for="loginType"><spring:message code="login.form.type" />1</label>
	<form:select path="loginType" items="${loginTypes}" />
</p>
<p>
	<label for="id"><spring:message code="login.form.id" />2</label>
	<form:input id="id" path="id"/>
	<form:errors path="id" />
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
