<%@ page contentType="text/html; charset=EUC-KR"%>
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>�ֹ�</title>
	</head>
	<body>
<!-- 	http://localhost:8080/spring4/example2/order.do -->
	<!-- url�ִ� �ּ� �״�� �ڱ��ڽ����� ���� -->
	<form method="post">
		��ǰ1: ID - <input type="text" name="orderItems[0].itemId" /> 
		���� - <input type="text" name="orderItems[0].number" />
		���� - <input type="text" name="orderItems[0].remark" />
		<br/>
		��ǰ2: ID - <input type="text" name="orderItems[1].itemId" /> 
		���� - <input type="text" name="orderItems[1].number" />
		���� - <input type="text" name="orderItems[1].remark" />
		<br/>
		��ǰ3: ID - <input type="text" name="orderItems[2].itemId" /> 
		���� - <input type="text" name="orderItems[2].number" />
		���� - <input type="text" name="orderItems[2].remark" />
		<br/>
		�����:
		�����ȣ - <input type="text" name="address.zipcode" />
		�ּ�1 - <input type="text" name="address.address1" />
		�ּ�2 - <input type="text" name="address.address2" />
		<br/>
	<input type="submit" value="����" />
	</form>
	</body>
	</html>
