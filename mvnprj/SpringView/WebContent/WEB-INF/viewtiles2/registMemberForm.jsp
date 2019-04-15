<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form commandName="memberInfo">
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
	<form:errors path="favorites" />
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