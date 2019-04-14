<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>주문 완료</title>
	</head>
	<body>
	주문 완료
	<br/>
	주문 아이템
	<ul>
		<c:forEach var="item" items="${orderCommand.orderItems}">
		 						 <!-- 소문자 o, 리스트를 가져와서 하나하나꺼냄 -->
		<li>${item.itemId} / ${item.number} / ${item.remark}</li>
		<!-- 자바빈에서 변수하나씩출력 -->
		</c:forEach>
	</ul>
	배송지: ${orderCommand.address}
			<!-- 투스트링출력 -->
			${orderCommand.address.zipcode}
			<!-- 변수 출력 -->
	</body>
	</html>