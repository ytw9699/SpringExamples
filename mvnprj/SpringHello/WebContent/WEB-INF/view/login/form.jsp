<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�α���</title>
</head>
<body>
<form:form commandName="loginCommand">
<%-- <form:form> Ŀ���� �±׿��� ������ Ŀ�ǵ� ��ü�� �⺻���� ����ϱ� ������ path �Ӽ������� ������Ƽ �̸��� �����ϸ�� --%>
<%-- <form:form> Ŀ���� �±״� method �Ӽ��� action �Ӽ��� ǥ������ ������ method �Ӽ��� ���� "post"�Ρڡ� �����ǰ� action �Ӽ��� ���� 
	   ���� ��û URL�� ���� �����ȴ�.  --%>
<font color=red><form:errors element="div"/></font>
<!-- �н��� �Ⱦ� �������� ����Ʈ�޼ҵ�� �޽��� ��� ,element="div"�� �����,�⺻��span-->
<!--reject�޽������� �±��� �Ӽ� div�±׾ȿ� �޽�������-->
	���̵�: <form:input path="userId"/>
	<!-- �̰Ŵ� ����Ʈ�����޼ҵ� �޽��� -->
	<%-- ���̵�:<input type="text" name="userId" value="${loginCommand.userId}" /> --%>
	     <form:errors path="userId" />
	<br/>
	��ȣ:  <form:password path="password" showPassword="false"/>
	      <form:errors path="password" />
	<br/>
	<input type="submit" />
</form:form>
</body>
</html>
