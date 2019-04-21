	<%@ page contentType="text/html; charset=EUC-KR"%>
	<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
											<!-- ���������ݰ��õȰ� Ŀ���� �±� -->
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
	<html>											<!-- �����õȰ� -->
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>���� ����</title>
	</head>
	<body>
	<spring:hasBindErrors name="command" />
	<%-- <spring:hasBindErrors> Ŀ���� �±״� name �Ӽ��� ����� Ŀ�ǵ�(�ڹٺ�) ��ü�� ���� ������ <form:errors>
	Ŀ���� �±׿��� ����� �� �ֵ��� �����Ѵ� --%>
	<!--�������� ���ε� �ѰŸ� ������(������Ƽ���� ������ �������õ� ������� ��jsp�������ڴٶ�°�
	 ,command�� ��Ʈ�ѷ� �ܿ��� �ڹٺ�MemberInfo>command�� �ǹ�-->
	<form:errors path="command" />
	<!-- ������Ƽ���� �ִ� �޽��� ������� ��������� �±׸� ����� ��� -->
	<form method="post">
		���̵�: <input type="text" name="id" value="${command.id}" />
		<font color="red"><form:errors path="command.id" /></font><!-- �� �κп� ��¸޽��� >
		<!-- command�ڹٺ��� �������ִ� id �̰� MemberInfoValidator�� �����Ǵµ�-->
		<br/>
		�̸�: <input type="text" name="name" value="${command.name}" />
		<form:errors path="command.name" />
		<br/>
		�����ȣ: <input type="text" name="address.zipcode" value="${command.address.zipcode}" />
		<form:errors path="command.address.zipcode" />
		<br/>
		�ּ�1: <input type="text" name="address.address1" value="${command.address.address1}" />
		<form:errors path="command.address.address1" />
		<br/>
		�ּ�2: <input type="text" name="address.address2" value="${command.address.address2}" />
		<form:errors path="command.address.address2" />
		<br/>
		<input type="submit" />
	</form>
	</body>
	</html>