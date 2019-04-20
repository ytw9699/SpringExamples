<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<head>
<script type="text/javascript">
/* function validateForm() {
    var x = document.forms["joinform"]["goods_name"].value;
    if (x == null || x == "") {
        alert("상품명은 입력해야합니다");
        return false;
    }
} */
</script>
</head>

<!-- 메뉴 시작 -->

<div class="row" style="padding-left:15px;width:700px;">    
	<h1 class="page-header">회원수정</h1>
</div>

<div class="row" style="padding-left:15px;width:700px;">
	<div class="panel panel-default">
		<div class="panel-heading" >회원수정 페이지입니다.</div>
			<div class="panel-body">
				<form:form commandName="member" action="adminmemberModifyEnd.dog" enctype="multipart/form-data" method="post"name="joinform" onsubmit="return validateForm()">	
				<input type="hidden" name="id" value="${member.id}">	
                        <div class="form-group">
                            <label>아이디</label>                            
                            <input type="text" class="form-control" value="${member.id}" style="width:initial;" readonly/>                            
                        </div>
                       
                        <div class="form-group">
                            <label>비밀번호</label>
                            <form:input type="password" class="form-control" path="password"  value="${member.password}" style="width:initial;"/>
                        </div>
                        <div class="form-group">
                            <label>이름</label>
                            <form:input type="text" class="form-control" value="${member.name}" path="name" style="width:100px;"/>
                        </div>
                        <div class="form-group">
                            <label>우편번호</label>
                            <form:input type="text" class="form-control" value="${member.zipcode}" path="zipcode" style="width:100px;"/>
                            <p class="help-block">133-221 형식 입니다</p>
                        </div>
                        <div class="form-group">
                            <label>주소</label>
                            <form:input type="text" class="form-control" value="${member.addr}" path="addr" style="width:400px;"/>
                        </div>
                        <div class="form-group">
                            <label>휴대전화</label>
                            <form:input type="text" class="form-control" value="${member.phone}" path="phone" style="width:initial;"/>
                            <p class="help-block">01000000000  ,- 없이 입력합니다</p>
                        </div>
                         <div class="form-group">
                            <label>이메일</label>
                            <form:input type="text" class="form-control" value="${member.email}" path="email" style="width:250px;"/>
                        </div>
                        <div class="form-group">
                            <label>포인트</label>
                            <form:input type="text" class="form-control" value="${member.point}" path="point" style="width:initial;"/>
                        </div>
                        <div class="form-group">
                            <label>가입일자</label>                            
                            <fmt:formatDate value="${member.join_date}" pattern="YYYY.MM.dd" />                            
                        </div>
						<button type="submit" class="btn btn-success">회원등록</button>
						<button type="reset" class="btn btn-default">작성취소</button>					
				</form:form>
			</div>
	</div>
</div>






<!-- // container -->
	






























