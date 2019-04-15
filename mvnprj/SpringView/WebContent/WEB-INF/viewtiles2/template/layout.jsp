<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!--1. 타일즈 관련된것쓰겠다고 선언 -->
<!--2. 전체 뼈대 레이아웃을 잡아보자 --> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title><tiles:getAsString name="title" /></title>
<!--3. 먼저 일반 문자열 가져올때 getAsString 쓰자-->
</head>
<body>
<tiles:insertAttribute name="header" />
<!-- 4.나머지 jsp실행결과 가져올때 는 insertAttribute -->
<hr />
<tiles:insertAttribute name="body" />
<hr/>
<tiles:insertAttribute name="footer" />
</body>
</html>
