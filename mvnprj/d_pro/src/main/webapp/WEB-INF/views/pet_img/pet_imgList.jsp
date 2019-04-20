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
<title>Insert title here</title>
<style type="text/css">
	thead>tr>th{text-align: center;}
	tbody>tr>td:nth-child(1){width:80px; text-align: center;}
	tbody>tr>td:nth-child(3){width:110px; text-align: center;}
	tbody>tr>td:nth-child(4){width:130px; text-align: center;}
	tbody>tr>td:nth-child(5){width:70px; text-align: center;}
	tbody>tr:HOVER{color:#da8c92;cursor: pointer;}
	.menu-wrap{text-align: right;}
	.form-wrap{text-align: center;}
	
</style>
</head>
<body>
<div class="category_top">
	<ul>
	 	<li class="post1">커뮤니티</li><li>></li><li class="post2">마이펫갤러리</li>	
	 			
	</ul>
</div>
	<div id="wrapper">

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
				<p></p>
					<div class="page-header">
					<img src="/pet/resources/images/SkinImg/mypet.jpg">
					<strong><font size="6px">My Pet</font></strong>&nbsp;&nbsp;
					<font color="red">나의 강아지 자랑 공간입니다.</font>
					</div>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">

						<!-- /.panel-heading -->

						<div class="dataTable_wrapper">
							<table class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<thead>
									<tr class="danger">
										<th width="10%">글번호</th>
										<th width="40%">제목</th>
										<th width="20%">작성자</th>
										<th width="20%">작성일</th>
										<th width="10%">조회수</th>
									</tr>
								</thead>
								<tbody>

									<c:forEach items="${list }" var="list">
										<tr class="odd gradeX" onclick="onView('${list.no}');">
											<td>${list.no }</td>
											<td>${list.subject }</td>
											<td>${list.name }</td>
											<td class="center"><fmt:formatDate
													value="${list.regdate }" pattern="YYYY-MM-dd" /></td>
											<td class="center">${list.readcount }</td>
										</tr>
									</c:forEach>

								</tbody>
							</table>
						</div>
						
					</div>
						<div class="menu-wrap">
								<c:if test="${session_member_name != null }">
									<button type="button" onclick="onWrite()"
										class="btn btn-primary">쓰기</button>
								</c:if>

								
							</div>
				</div>
			
			</div>


			<c:if test="${fn:length(list) le 0}">
				<br />
				<center>등록된 게시물이 없습니다</center>
				<br />
			</c:if>

	
	
		<div class="row">
			<div style="text-align: center;">
				<div id="dataTables-example_filter" class="dataTables_filter">



					<form method="post">
						<select class="slcte" name="searchNum" id="searchNum">
							<option value="0">제목</option>
							<option value="1">내용</option>
							<option value="2">작성자</option>
						</select> <input class="txte" type="text" name="isSearch" id="isSearch" />
						<span class="btn btnC_03 btnP_04 mr10"> <input
							type="submit" value="검색"
							style="font-size: 11px; padding-bottom: 20; vertical-align: middle;" />
						</span>
					</form>
				</div>
			</div>

		</div>
	
	
		<div class="paging">
			${pagingHtml}
		</div>
	
		</div>
					</div>
						
						
</body>
<script type="text/javascript">

$('.searchOption').val($('.searchOptionVal').val());
var onWrite = function(){
	location.href = 'pet_imgWriteForm.dog'; 
};
var onList = function(){
	location.href = location.href;
};
var goPage = function(page){
	var form = $('.form-wrap')[0];
	$('.page').val(page);
	form.submit();
};

var onSearch = function(){
	var form = $('.form-wrap')[0];
	form.submit();
};

var onView = function(no){
	location.href='pet_imgView.dog?no='+no;
};
</script>
</html>
