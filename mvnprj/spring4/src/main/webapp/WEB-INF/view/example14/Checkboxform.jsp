<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
										<!-- ���������ݰ��õȰ� Ŀ���� �±� -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
										<!-- �����õȰ� -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
���� �����͸� �Է��� �� ���� ��ư�� Ŭ���ϼ���
<form action="Checkbox.do2" method="get">
�����ϴ� ����:
	<input type="checkbox" name="pet" value="dog">������  
	<input type="checkbox" name="pet" value="cat">�����
	<input type="checkbox" name="pet" value="pig">����
<br>
	<input type="checkbox" name="pet2" value="bird">��
	<input type="checkbox" name="pet2" value="tiger">ȣ����
	<input type="checkbox" name="pet2" value="rabbit">�䳢
<br>
	<input type="checkbox" name="pet3" value="true"> �̸��� ���ſ���

<input type="submit" value="����">
</form>
</body>
</html>


	