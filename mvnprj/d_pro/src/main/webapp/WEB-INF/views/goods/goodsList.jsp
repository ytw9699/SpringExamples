<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
/* 숫자 , 표시 함수 */
	var funcSetCurrency = function($) {
		$('.price-prdc').each(
				function() {
					if (!isNaN(Number($(this).text())) && $(this).text())
						$(this).text(
								Number($(this).text()).toLocaleString().split('.')[0]);
				});
	};

	$(document).ready(function() {
		funcSetCurrency($);
	});
	

</script>
</head>
<div class="category_top">
	<ul>
	 	<c:if test="${cate eq 0}">
			<li>강아지 ></li><li class="post2">사료</li>
		</c:if>
		<c:if test="${cate eq 1}">
			<li>강아지 ></li><li class="post2">간식</li>
		</c:if>	
		<c:if test="${cate eq 2}">
			<li>강아지 ></li><li class="post2">패션/의류</li>
		</c:if>	
		<c:if test="${cate eq 3}">
			<li>강아지 ></li><li class="post2">목줄/야외</li>
		</c:if>
		<c:if test="${cate eq 4}">
			<li>강아지 ></li><li class="post2">생활/잡화</li>
		</c:if>		
	</ul>
	
</div>

<div class="goods_list">

<img class="main" src="http://okidogki.com/SkinImg/title_recommend.png" alt="추천상품"><br/>&nbsp;
<!-- <h3 class="goods_title">상품리스트</h3><br/> -->

	
<c:forEach var="goodsList"  items="${goodsList}" varStatus="stat">	
	
		<ul>
			<li class="box">
				<a href="goodsView.dog?goods_num=${goodsList.goods_num}"> 
					<div class="box_image">
						<img src="/pet/resources/goods_upload/${goodsList.goods_image}" width="300" height="300" alt="" onerror="this.src='/pet/resources/images/noimg_130.gif'" />
						<dl class="price">
						<dt class="name"><span style="font-size:16px;color:#1a1a1a;font-weight:bold;">${goodsList.goods_name}</span></dt>
						</dl>
						<dd class="price">
							<p class="custom"><fmt:formatNumber value="${goodsList.goods_price * 1.4}" type="number"/>원</p>
							<p><span class="price-prdc">${goodsList.goods_price}</span>원</p>
							<p class="icon2">  <img src="/pet/resources/images/sale5.gif" alt=""></p>   
						</dd>
					</div>
				</a>
			</li>
		</ul>
	</c:forEach>

<!--  등록된 상품이 없을때 -->
<c:if test="${fn:length(goodsList) le 0}">
	등록된 상품이 없습니다
</c:if> 
</div>

</html>