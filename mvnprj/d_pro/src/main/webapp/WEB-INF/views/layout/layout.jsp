<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<!-- 이미지 롤오버효과 스크립트입니다. -->
<link rel="stylesheet" type="text/css" href="/pet/resources/css/a.css" />
<link rel="stylesheet" type="text/css" href="/pet/resources/css/reset.css" />
<link rel="stylesheet" type="text/css" href="/pet/resources/css/layout.css" />
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" src="/pet/resources/js/common.js"></script>
<script type="text/javascript" src="/pet/resources/js/cc.js"></script>
<title>D-편한세상</title>
</head>
<body>
	<div id="header">
		<tiles:insertAttribute name="header"/><!-- // header -->
	</div>
	 	
	<!-- container --> 
	<div id="container" style="min-height:500px;">
		<tiles:insertAttribute name="body"/><!-- // container -->
	</div>
	<!-- footer --> 
	<tiles:insertAttribute name="footer"/><!-- // footer -->

</body>
</html>