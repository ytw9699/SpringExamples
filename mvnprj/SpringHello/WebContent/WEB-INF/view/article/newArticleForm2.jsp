<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>게시글 쓰기</title>
	</head>
	<body>
	게시글 쓰기 입력 폼: newArticleForm2.jsp//get방식 정상동작
	<form action="/SpringHello/article/newArticle2.do" method="post">
		     <input type="hidden" name="parentId" value="0" />
		제목: <input type="text" name="title" /><br/>
		내용: <textarea name="content"></textarea><br/>
				<input type="submit" />
	</form>
	</body>
	</html>