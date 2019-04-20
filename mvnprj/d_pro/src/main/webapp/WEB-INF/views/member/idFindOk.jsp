<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />

</head>

<body>

<div class="tac">
	<h3><center>
					<img src="/pet/resources/images/SkinImg/h3_find_id.GIF"
						alt="아이디 찾기" />
				</center></h3>

	<p class="fz15"><center>${member.name}님의 아이디는 <strong>${member.id}</strong>입니다.</center></p>
				<%-- 	비밀번호는 <strong>${member.passwd}</strong></p> --%>
	<div class="btn_type_04">
	<center><a href="javascript:this.close();"><img src="/pet/resources/images/SkinImg/close.GIF"></a>
					</center>
	</div>
</div>