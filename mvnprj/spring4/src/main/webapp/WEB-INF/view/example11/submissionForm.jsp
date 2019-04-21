<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>����Ʈ ����</title>
</head>
<body>
<h3>@RequestParam ���</h3>
<!-- ���� ���ε尡 �ʿ��� ��� HTML ���� �Ӽ��� method="post", "multipart/form-data"�� �����ؾ� �Ѵ�. -->
<form action="submitReport.do1" method="post" enctype="multipart/form-data">
	�й�: <input type="text" name="studentNumber" />
	<br/>
	����Ʈ����: <input type="file" name="report" />
	<br/>
	<input type="submit" />
</form>

<h3>MultipartHttpServletRequest ���</h3>
<form action="submitReport.do2" method="post" enctype="multipart/form-data">
	�й�: <input type="text" name="studentNumber" />
	<br/>
	����Ʈ����: <input type="file" name="report" />
	<br/>
	<input type="submit" />
</form>

<h3>Ŀ�ǵ� ��ü ���</h3>
<form action="submitReport.do3" method="post" enctype="multipart/form-data">
	�й�: <input type="text" name="studentNumber" />
	<br/>
	����Ʈ����: <input type="file" name="report" />
	<br/>
	<input type="submit" />
</form>
</body>
</html>
