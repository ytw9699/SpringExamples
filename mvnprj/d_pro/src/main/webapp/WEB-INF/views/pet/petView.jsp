<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.1.0.js"></script>
<link href="/pet/resources/admincss/bootstrap.min.css" rel="stylesheet">
<link href="/pet/resources/css/reset.css" rel="stylesheet">
<link href="/pet/resources/admincss/sb-admin-2.css" rel="stylesheet">

<script type="text/javascript">
	var onModify = function(no){
		var form = $('.viewForm')[0];
		form.action = 'petUpdate.dog?no='+no;
		form.submit();
	};
	
	var onComment = function(){
		var form = $('.commentForm')[0];
		form.action = 'commentWrite.dog'; 
		form.submit();
	};
	
	var onList = function(){
		location.href='petList.dog';
	};
	
	
	var onDelete = function(no){
		var num = no;
		if(confirm("삭제 하시겠습니까?") == true){
			
		location.href='petDelete.dog?no='+num;
	}else {
		return; }
	}
	
</script>



<style type="text/css"> 

	.contents-wrap{margin:30px 0 0 0;min-height: 500px;}
	.contents{ margin: 60px 0 0 0;}
	.recode-wrap{text-align: right; color: #888;}
	.hit-wrap{color:#888; margin: 10px 0;}
	.viewForm{margin: 20px 0 0 0;}
</style>
</head>

<body>


<div id="wrapper">

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<p></p>
					<div class="page-header">
					<img src="/pet/resources/images/SkinImg/123.jpg">
					<strong><font size="6px">분양</font></strong>&nbsp;&nbsp;
					<font color="red">강아지 분양 공간입니다.</font>
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
										<th> ${item.subject }</th>
										
									</tr>
								</thead>
								<tbody>

									<tr>
										<td align=right><strong>${item.name }</strong>&nbsp;&nbsp;|&nbsp;&nbsp;<fmt:formatDate
												value="${item.regdate }" pattern="yyyy-MM-dd" />&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;${item.readcount }&nbsp;&nbsp;&nbsp;&nbsp;</td>
									</tr>
									<tr>
										<td>${item.content }</td>

									</tr>

								</tbody>
							</table>
						</div>
						
					</div>
		
	</div>
	<div>
		<form class="viewForm" method="post">
			<input type="hidden" name="${item.no }" />
			
			
		<c:if test="${session_member_id == item.id }">	
			&nbsp;&nbsp;&nbsp;&nbsp;<button type="button" onclick="onModify(${item.no })" class="btn btn-primary">수정</button>
			<button type="button" onclick="onDelete(${item.no })" class="btn btn-primary">삭제</button>
			<button type="button" onclick="onList()" class="btn btn-primary" >목록</button>
		</c:if>
		<c:if test="${session_member_id == null || session_member_id != item.id}">
			&nbsp;&nbsp;&nbsp;&nbsp;<button type="button" onclick="onList()" class="btn btn-primary" >목록</button>
		</c:if>
		
		
		
		</form>	
	</div>
	

<!-- 코멘트 달기 -->
<div class="inner">
		<!-- reply_grp -->
		<form class="commentForm" method="post">
		<input type="hidden" name="item_no" value="${item.no}"/>
		<input type="hidden" name="currentPage" value="${currentPage}"/>
	
		
				<div class="reply_grp">
					<div class="reply_form">
						<div class="reply_write">
							<c:if test="${session_member_id == null}">
                  				<input type="text" style="align:center; margin: 10px; width: 950px; height: 55px;" value="로그인 후에  댓글 작성이 가능합니다." readonly="readonly"/>
	      	 				</c:if>
	      	 				<c:if test="${session_member_id != null}">
								<div class="textarea_grp" style="width: 1000px;">
									<textarea name="commentt" style="margin: 10px; width: 849px; height: 55px;"></textarea><button type="button" class="btn1 btn-primary1" onclick="onComment()">입력	</button>
								</div>
							</c:if>
						</div>
						
					</div>




<c:if test="${fn:length(commentlist) ge 0}"><!-- ge -->
		<p class="reply_num"> <strong>${cmtcount}</strong></p>
		</c:if> 
	<c:forEach var="commentlist" items="${commentlist }" varStatus="stat">

	
			
			<!-- <p class="reply_num">댓글 수 <strong>1</strong></p> -->
			<div class="reply_view">
				<div class="reply_tit">
					<p class="tit"><strong>${commentlist.cmter }</strong>님  <fmt:formatDate value="${commentlist.cmt_date}" pattern="yy.MM.dd"></fmt:formatDate><span class="ip"></span> </p>
					<c:if test="${session_member_id == commentlist.cmter}">
					<a href="commentDelete.dog?comment_num=${commentlist.comment_num}&pet_no=${item.no}" class="btn btnC_01 btnP_02">
						<span class="btn btnC_05 reply_btn">
						삭제</span>
					</a>
					</c:if>
				</div>
				
				<div class="reply_cts">
					<p>${commentlist.commentt}</p>
				</div>
			</div>

		</c:forEach>	
		</div><!-- // reply_grp -->
		
	</div>

</form>

</div>
</div>
</div>



<br /><br /><br />

	
</body>

</html>


