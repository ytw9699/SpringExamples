<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
    										<!-- 스프링 시큐리티와 관련된 정보를 출력하 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>admin page</title>
</head>
<body>
<h1>/sample/admin page</h1>
 
	<p>principal : <sec:authentication property="principal"/></p>
	<!-- principal은 UserDetailsService에서 반환된 객체입니다 CustomUser 객체-->
	<p>MemberVO : <sec:authentication property="principal.member"/></p> 
	<!-- ’principal.member'는 CustomUser 객체의 getMember( )를 호출 -->
	<p>사용자이름 : <sec:authentication property="principal.member.userName"/></p>
	<p>사용자아이디 : <sec:authentication property="principal.member.userid"/></p>
	<p>사용자아이디 : <sec:authentication property="principal.username"/></p>
							<!-- 스프링 시큐리티에서는 username을 id로 본다 -->
	<p>사용자아이디  : <sec:authentication property="principal.member.authList[0].userid"/></p>
	
	<p>사용자 권한 리스트  : <sec:authentication property="principal.member.authList"/></p>
	
	<a href="/customLogout">Logout</a>
</body>
</html>
