<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>�Խñ� ����</title>
	</head>
	<body>
	newArticleSubmitted.jsp
	�Խñ� ��ϵ�:
	<br/>
	����: ${command2.title} ${requestScope.command2.title}
	<br/>
	����:${command2.content}
	<br/>
	parentId:${command2.parentId}
	<br/>
	����:${newArticleCommand.title}
	</body>
	</html>