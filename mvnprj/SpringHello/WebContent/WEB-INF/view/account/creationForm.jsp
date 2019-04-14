	<%@ page contentType="text/html; charset=EUC-KR"%>
	<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
											<!-- 스프링전반관련된것 커스톰 태그 -->
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
	<html>											<!-- 폼관련된것 -->
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>계정 생성</title>
	</head>
	<body>
	<spring:hasBindErrors name="command" />
	<%-- <spring:hasBindErrors> 커스텀 태그는 name 속성에 명시한 커맨드(자바빈) 객체와 에러 정보를 <form:errors>
	커스텀 태그에서 사용할 수 있도록 설정한다 --%>
	<!--에러들을 바인드 한거를 가진다(프로퍼티스에 설정한 에러관련된 내용들을 이jsp에서쓰겠다라는것
	 ,command는 컨트롤러 단에들어간 자바빈MemberInfo>command를 의미-->
	<form:errors path="command" />
	<!-- 프로퍼티스에 있는 메시지 출력위해 에러스라는 태그를 사용해 출력 -->
	<form method="post">
		아이디: <input type="text" name="id" value="${command.id}" />
		<font color="red"><form:errors path="command.id" /></font><!-- 이 부분에 출력메시지 >
		<!-- command자바빈이 가지고있는 id 이게 MemberInfoValidator와 연관되는듯-->
		<br/>
		이름: <input type="text" name="name" value="${command.name}" />
		<form:errors path="command.name" />
		<br/>
		우편번호: <input type="text" name="address.zipcode" value="${command.address.zipcode}" />
		<form:errors path="command.address.zipcode" />
		<br/>
		주소1: <input type="text" name="address.address1" value="${command.address.address1}" />
		<form:errors path="command.address.address1" />
		<br/>
		주소2: <input type="text" name="address.address2" value="${command.address.address2}" />
		<form:errors path="command.address.address2" />
		<br/>
		<input type="submit" />
	</form>
	</body>
	</html>