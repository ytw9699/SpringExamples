<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<head>
<script type="text/javascript">
function delchk(){
    return confirm("삭제하시겠습니까?");
}
</script>
<style type="text/css">
.paging{text-align:center;height:32px;margin-top:5px;margin-bottom:15px;}
.paging a,
.paging strong{display:inline-block;width:36px;height:32px;line-height:28px;font-size:14px;border:1px solid #e0e0e0;margin-left:5px;
-webkit-border-radius:3px;
   -moz-border-radius:3px;
		border-radius:3px;
-webkit-box-shadow:1px 1px 1px 0px rgba(235,235,235,1);
	-moz-box-shadow:1px 1px 1px 0px rgba(235,235,235,1);
		  box-shadow:1px 1px 1px 0px rgba(235,235,235,1);
}
.paging a:first-child{margin-left:0;}
.paging strong{color:#fff;background:#337AB7;border:1px solid #337AB7;}
.paging .page_arw{font-size:11px;line-height:30px;}
</style>
</head>

<div class="row" style="padding-left:15px;width:900px;">    
	<h1 class="page-header">상품목록</h1>
</div>
<div class="row">
	<div class="panel panel-default">
		<div class="panel-heading">
                         상품목록페이지 검색, 수정, 삭제 기능하는 페이지입니다.
        </div>
        <div class="panel-body">
			<div class="dataTable_wrapper">
				<div id="dataTables-example_wrapper"
					class="dataTables_wrapper form-inline dt-bootstrap no-footer">
					<div class="row" style="margin-bottom:5px;">
						<div class="col-sm-6">
							<a href="/pet/admin/goodsadminList.dog?searchNum=0&isSearch="><button type="button" class="btn btn-outline btn-default">전체</button></a>
							<select class="form-control" name="select" onchange="window.open(value,'_self');">
								<option value ="">--카테고리--</option>
								<option value ="/pet/admin/goodsadminList.dog?searchNum=2&isSearch=0">사료</option>
								<option value ="/pet/admin/goodsadminList.dog?searchNum=2&isSearch=1">간식</option>
								<option value ="/pet/admin/goodsadminList.dog?searchNum=2&isSearch=2">패션의류</option>
								<option value ="/pet/admin/goodsadminList.dog?searchNum=2&isSearch=3">목줄/야외</option>
								<option value ="/pet/admin/goodsadminList.dog?searchNum=2&isSearch=4">생활/잡화</option>
							</select>
							<select class="form-control" name="select" onchange="window.open(value,'_self');">
								<option value ="">--상품구분--</option>
								<option value ="/pet/admin/goodsadminList.dog?searchNum=3&isSearch=1">추천</option>
								<option value ="/pet/admin/goodsadminList.dog?searchNum=3&isSearch=2">베스트</option>
								<option value ="/pet/admin/goodsadminList.dog?searchNum=3&isSearch=3">신상품</option>
							
							</select>						
						</div>
						<div class="col-sm-6" style="text-align:right;">
							<div class="dataTables_info" id="dataTables-example_info" role="status" aria-live="polite">총 상품 등록수 : ${totalCount}</div>
						</div>
						
					</div>
					<div class="row">
						<div class="col-sm-12">
							<table
								class="table table-striped table-bordered table-hover dataTable no-footer"
								id="dataTables-example" role="grid"
								aria-describedby="dataTables-example_info">
								<thead>
									<tr role="row">
										<th style="width: 6%; text-align:center;">번호</th>
										<th style="width: 8%; text-align:center;">상품사진</th>
										<th style="width: 8%; text-align:center;">카테고리</th>										
										<th style="width: 32%; text-align:center;">상품명</th>
										<th style="width: 10%; text-align:center;">가격</th>
										<th style="width: 6%; text-align:center;">수량</th>
										<th style="width: 10%; text-align:center;">상품구분</th>
										<th style="width: 10%; text-align:center;">등록일자</th>
										<th style="width: 10%; text-align:center;">관리</th>
									</tr>
								</thead>
								<tbody>
								<c:forEach var="goodsList"  items="${goodsList}" varStatus="stat">
								<c:url var="viewURL" value="goodsView.dog" >
									<c:param name="goods_num" value="${goodsList.goods_num }" />
								    <c:param name="currentPage" value="${currentPage}" />
								</c:url>									
									<tr class="gradeA even" role="row">
										<td style="text-align:center;vertical-align:middle;">${goodsList.goods_num}</td>
										<td style="text-align:center;vertical-align:middle;"><img src="/pet/resources/goods_upload/${goodsList.goods_image}" width="60" height="60" alt="" onerror="this.src='/pet/resources/images/noimg_130.gif'" /></td>
										<td style="text-align:center;vertical-align:middle;"><c:if test="${goodsList.goods_category eq 0}">사료</c:if>
																							<c:if test="${goodsList.goods_category eq 1}">간식</c:if>
																							<c:if test="${goodsList.goods_category eq 2}">패션의류</c:if>
																							<c:if test="${goodsList.goods_category eq 3}">목줄/야외</c:if>
																							<c:if test="${goodsList.goods_category eq 4}">생활/잡화</c:if></td>										
										<td style="text-align:center;vertical-align:middle;"><a href="/pet/goods/goodsView.dog?goods_num=${goodsList.goods_num }&currentPage=${currentPage}">${goodsList.goods_name}</a></td>
										<td style="text-align:right;vertical-align:middle;"><fmt:formatNumber value="${goodsList.goods_price}" type="number"/></td>
										<td style="text-align:right;vertical-align:middle;">${goodsList.goods_amount}</td>
										<td style="text-align:center;vertical-align:middle;"><c:if test="${goodsList.goods_best eq 0}">기본</c:if>
																							<c:if test="${goodsList.goods_best eq 1}">추천</c:if>
																							<c:if test="${goodsList.goods_best eq 2}">베스트</c:if>
																							<c:if test="${goodsList.goods_best eq 3}">신상</c:if></td>										
										<td style="text-align:center;vertical-align:middle;"><fmt:formatDate value="${goodsList.goods_date}" pattern="YY.MM.dd HH:mm" /></td>
										<td style="text-align:center;vertical-align:middle;">
											<a href="/pet/admin/goodsModifyForm.dog?goods_num=${goodsList.goods_num }"><input type="image" src="https://upload.wikimedia.org/wikipedia/commons/thumb/9/92/Cog_font_awesome.svg/32px-Cog_font_awesome.svg.png"></a>&nbsp;&nbsp;
										<c:url var="viewURL2" value="goodsDelete.dog" >
											<c:param name="goods_num" value="${goodsList.goods_num }" />							
										</c:url>	
										 <a href="${viewURL2}"><input type="image" src="https://upload.wikimedia.org/wikipedia/commons/thumb/7/7d/Trash_font_awesome.svg/32px-Trash_font_awesome.svg.png" onclick="return delchk()"></a></td>									
									</tr>
								</c:forEach>
								<!--  등록된 상품이 없을때 -->
									<c:if test="${fn:length(goodsList) le 0}">
										<tr><td colspan="9" style="text-align:center;">등록된 상품이 없습니다</td></tr>
									</c:if> 
								</tbody>
							</table>
						</div>
					</div>
					<div class="paging">
						${pagingHtml}
					</div>
					<div class="row">
							<div style="text-align:center;">
								<div id="dataTables-example_filter" class="dataTables_filter">
									<form action="">
									<select class="form-control" name="searchNum" id="searchNum">
										<option value="0">상품 제목</option>
										<option value="1">상품 번호</option>
									</select>
										<input class="form-control" type="text" name="isSearch" id="isSearch"/>
										<span>
										<button type="submit" class="btn btn-default">검색</button>
										</span>
									</form>
								</div>							
							</div>
							
					</div>
				</div>
			</div>
			<!-- /.table-responsive -->							
		</div>
	</div>
        <!-- /.panel -->   
</div>
