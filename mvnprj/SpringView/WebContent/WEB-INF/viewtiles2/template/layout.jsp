<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!--1. Ÿ���� ���õȰ;��ڴٰ� ���� -->
<!--2. ��ü ���� ���̾ƿ��� ��ƺ��� --> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title><tiles:getAsString name="title" /></title>
<!--3. ���� �Ϲ� ���ڿ� �����ö� getAsString ����-->
</head>
<body>
<tiles:insertAttribute name="header" />
<!-- 4.������ jsp������ �����ö� �� insertAttribute -->
<hr />
<tiles:insertAttribute name="body" />
<hr/>
<tiles:insertAttribute name="footer" />
</body>
</html>
