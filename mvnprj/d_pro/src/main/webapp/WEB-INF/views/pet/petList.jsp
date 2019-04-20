<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.1.0.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<link href="/pet/resources/admincss/bootstrap.min.css" rel="stylesheet">
<link href="/pet/resources/admincss/sb-admin-2.css" rel="stylesheet">


 <style type="text/css">
	tbody>tr:HOVER{color:#da8c92;cursor: pointer;}
	.menu-wrap{text-align: right;}
	.form-wrap{text-align: center;}
	
</style> 
</head>
<body>
<div class="category_top">
	<ul>
	 	<li class="post1">커뮤니티</li><li>></li><li class="post2">분양게시판</li>	
	 			
	</ul>
</div>

			<div class="row">
				<div class="col-lg-12">
										
					<p></p>
					<div class="page-header">
					<img src="/pet/resources/images/SkinImg/123.jpg">
					<strong><font size="6px">분양</font></strong>&nbsp;&nbsp;
					<font color="red">강아지 분양 공간입니다.</font>
					</div>
					
				</div>
			</div>
		
			<div class="row">
				<div class="col-lg-12">
					

					<div class="goods_list">

	
						<c:forEach var="list"  items="${list}"  varStatus="stat">	
			
		
							<ul>
								<li class="box" onclick="onView('${list.no}');">
				
									<div class="box_image">
										<img src="/pet/resources/pet_img_upload/${list.imagefile_savname}" width="300" height="300" alt="" onerror="this.src='/pet/resources/images/noimg_130.gif'" />
										<dl class="price">
										<dt class="name"><span style="font-size:16px;color:#1a1a1a;font-weight:bold;">${list.subject}</span></dt>
										<dd class="price">
											<span class="price-prdc">${list.readcount}</span>&nbsp;Hit<br>
											<fmt:formatDate value="${list.regdate}" pattern="yyyy-MM-dd"/>
										</dd>
										</dl>
									</div>
				
								</li>
							</ul>
						</c:forEach>
					</div>
	
						<c:if test="${fn:length(list) le 0}">
							<br />
								<center>등록된 게시물이 없습니다</center>
							<br />
						</c:if>

				</div>
			</div>
				<div class="menu-wrap">
					<c:if test="${session_member_name != null }">
						<button type="button" onclick="onWrite()" class="btn btn-primary">쓰기</button>
					</c:if>
				</div>
			<div class="row">
				<div style="text-align: center;">
					<div id="dataTables-example_filter" class="dataTables_filter">
						<form method="post">
							<select class="slcte" name="searchNum" id="searchNum">
								<option value="0">제목</option>
								<option value="1">내용</option>
								<option value="2">작성자</option>
							</select> <input class="txte" type="text" name="isSearch" id="isSearch" />
								<span class="btn btnC_03 btnP_04 mr10"> 
									<input type="submit" value="검색" style="font-size: 11px; padding-bottom: 20; vertical-align: middle;" />
								</span>
						</form>
					</div>
				</div>
			</div>


		<div class="paging">
			${pagingHtml}
		</div>
						
</body>


<script type="text/javascript">

$('.searchOption').val($('.searchOptionVal').val());
var onWrite = function(){
	location.href = 'petWriteForm.dog'; 
};
var onList = function(){
	location.href = location.href;
};


var onView = function(no){
	location.href='petView.dog?no='+no;
};
</script>
</html>
