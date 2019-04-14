<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>게시글 쓰기</title>
	</head>
	<body>
	newArticleSubmitted.jsp
	게시글 등록됨:
	<br/>
	제목: ${command2.title} ${requestScope.command2.title}
	<br/>
	내용:${command2.content}
	<br/>
	parentId:${command2.parentId}
	<br/>
	제목:${newArticleCommand.title}
	</body>
	</html>