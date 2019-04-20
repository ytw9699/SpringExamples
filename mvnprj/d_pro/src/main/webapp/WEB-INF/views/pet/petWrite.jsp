<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="/pet/resources/se/js/HuskyEZCreator.js" charset="utf-8" ></script>
<script type="text/javascript" src="/pet/resources/se/js/jindo.min.js" charset="utf-8" ></script>
<link href="/pet/resources/admincss/bootstrap.min.css" rel="stylesheet">
<link href="/pet/resources/admincss/sb-admin-2.css" rel="stylesheet">

<style type="text/css">
#boardWriteForm{margin: 30px 0;}
.menu-wrap{text-align: right;}
</style>
</head>
<body>
<div class="container">
	<form id="boardWriteForm" method="post">
	<input type="hidden" name="id" value="${session_member_id}" />
	<input type="hidden" name="name" value="${session_member_name}" />
		<div>
	<div class="col-lg-12">
					<p></p>
					<div class="page-header">
					<img src="/pet/resources/images/SkinImg/123.jpg">
					<strong><font size="6px">분양</font></strong>&nbsp;&nbsp;
					<font color="red">강아지 분양 공간입니다.</font>
					</div>
					
				</div>
			<input type="text" id="title" name="subject" value="" maxlength="100" style="height: 25px; width: 100%;"/>
		</div>
		<br/>
		<div class="contentDiv">
		 	<textarea id="txtContent" name="content" rows="20" style="width:100%;"></textarea>
		 	
		<div class="menu-wrap">
			<c:if test="${modify == 'true'}">
			<input type="hidden" name="no" value="${item.no }" />
				<button type="button" class="btn btn-primary" onclick="onModify()" >수정</button>
			</c:if>
			<c:if test="${modify != 'true'}">
				<button type="button" class="btn btn-primary" onclick="onWrite()" >쓰기</button>
			</c:if>
			 <button type="button" class="btn btn-primary" onclick="history.go(-1);" > 취소</button>
			<%--  <input type="hidden" name="seq" value="${board.seq}"/>  --%>
		</div>
		</div>
		
	</form>
</div>
</body>
<script type="text/javascript">
var oEditors = [];
	nhn.husky.EZCreator.createInIFrame({
	oAppRef: oEditors,
	elPlaceHolder: document.getElementById('txtContent'), // html editor가 들어갈 textarea id
	sSkinURI: "/pet/resources/se/SmartEditor2Skin.html",  // html editor가 skin url
	fOnAppLoad: function () { 
        //수정모드를 구현할 때 사용할 부분. 로딩이 끝난 후 값이 체워지게 하는 구현을 하면 된다.
         var subject = '${item.subject}';               
         var content = '${item.content}';         //db에서 불러온 값을 여기에서 체워넣으면 됨.
         document.getElementById("title").value = subject;     
         oEditors.getById["txtContent"].exec("PASTE_HTML", [content]); //로딩이 끝나면 contents를 txtContent에 넣음
     },
     fCreator: "createSEditor2"
 });

var onWrite = function(){
	oEditors.getById["txtContent"].exec("UPDATE_CONTENTS_FIELD", []); // 에디터의 내용이 textarea에 적용됨
	var boardWriteForm = document.getElementById("boardWriteForm");  
	boardWriteForm.action ="petWriteForm.dog";              
	boardWriteForm.submit();  
};

var onModify = function(){
	oEditors.getById["txtContent"].exec("UPDATE_CONTENTS_FIELD", []); // 에디터의 내용이 textarea에 적용됨
	var boardWriteForm = document.getElementById("boardWriteForm");  
	boardWriteForm.action ="petUpdateAction.dog";              
	boardWriteForm.submit();  
};

var pasteHTML = function(filename){
    var sHTML = '<img src="${pageContext.request.contextPath}/resources/pet_img_upload/'+filename+'">';
    oEditors.getById["txtContent"].exec("PASTE_HTML", [sHTML]);
};
</script>
</html>