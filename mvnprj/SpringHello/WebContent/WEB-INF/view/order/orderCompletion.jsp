<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>�ֹ� �Ϸ�</title>
	</head>
	<body>
	�ֹ� �Ϸ�
	<br/>
	�ֹ� ������
	<ul>
		<c:forEach var="item" items="${orderCommand.orderItems}">
		 						 <!-- �ҹ��� o, ����Ʈ�� �����ͼ� �ϳ��ϳ����� -->
		<li>${item.itemId} / ${item.number} / ${item.remark}</li>
		<!-- �ڹٺ󿡼� �����ϳ������ -->
		</c:forEach>
	</ul>
	�����: ${orderCommand.address}
			<!-- ����Ʈ����� -->
			${orderCommand.address.zipcode}
			<!-- ���� ��� -->
	</body>
	</html>