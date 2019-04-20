<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />

</head>

<body>

<div class="tac">
	<center><img src="/pet/resources/images/SkinImg/h3_find_pw.GIF" alt="비번 찾기"/></center>
	<p class="fz15"><center>${member.name}님의 비밀번호는 <strong>${member.password}</strong>입니다.</center></p>
				<%-- 	비밀번호는 <strong>${member.passwd}</strong>입니다.</p> --%>
	<div class="btn_type_04">
		<center><a href="javascript:this.close();"><img src="/pet/resources/images/SkinImg/close.GIF"></a>
					</center>
	</div>
</div>