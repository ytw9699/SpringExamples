<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
	<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>로그 목록</title>
	</head>
	<body>
	값을 입력하세요
	<br/>
	<input type="button" value="다시입력" 
	onClick="javascript:location.href='/spring4/example12/logquery.do'"/>
	<br/>
	<a href="/spring4/example12/logquery.do">다시입력</a>
	<br/>
	<a href="logquery.do">다시입력</a>
	</body>
	</html>