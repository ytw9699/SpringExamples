<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
										<!-- 스프링전반관련된것 커스톰 태그 -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
										<!-- 폼관련된것 -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
폼에 데이터를 입력한 후 전송 버튼을 클릭하세요
<form action="Checkbox.do2" method="get">
좋아하는 동물:
	<input type="checkbox" name="pet" value="dog">강아지  
	<input type="checkbox" name="pet" value="cat">고양이
	<input type="checkbox" name="pet" value="pig">돼지
<br>
	<input type="checkbox" name="pet2" value="bird">새
	<input type="checkbox" name="pet2" value="tiger">호랑이
	<input type="checkbox" name="pet2" value="rabbit">토끼
<br>
	<input type="checkbox" name="pet3" value="true"> 이메일 수신여부

<input type="submit" value="전송">
</form>
</body>
</html>


	