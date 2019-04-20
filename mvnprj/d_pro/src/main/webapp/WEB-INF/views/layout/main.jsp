<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<head>
<script type="text/javascript" src="/pet/resources/js/modernizr.custom.28468.js"></script>
</head>    
    <!-- <link rel="stylesheet" type="text/css" href="/pet/resources/css/demo.css" /> -->
        <link rel="stylesheet" type="text/css" href="/pet/resources/css/style2.css" />
			<div id="da-slider" class="da-slider">
				<div class="da-slide">
					<h2>메라독 익스클루시브 퍼피</h2>
					<p>신선한 원료와 생산  　! <br/> 건강한 성장과 근육발달 강화　 ! <br/> 맛과 건강을 동시에　  !</p>					
					<a href="http://localhost:8080/pet/goods/goodsView.dog?goods_num=6" class="da-link">사러가기 !</a>
					<div class="da-img"><img src="/pet/resources/images/dogrice1.png" alt="image01" /></div>
				</div>
				<div class="da-slide">
					<h2>지위픽 디어후퍼 구강간식</h2>
					<p>뉴질랜드 초원에서 풀을 먹고 자란 사슴 족발의 발굽을 제거한 영양간식 !! <br/> 오래 씹을 수 있고 애견들이 매우 좋아하는 구강 간식 !! <br/> 애견에게 치석 예방과 잇몸 건강에 도움을 주는 구강 간식 !!</p>
					<a href="http://localhost:8080/pet/goods/goodsView.dog?goods_num=13" class="da-link">사러가기 !</a>
					<div class="da-img"><img src="/pet/resources/images/dogpig1.png" alt="image01" /></div>
				</div>
				<div class="da-slide">
					<h2>신한 펫 반자동 급식,급수기</h2>
					<p>건사료를 약 1.5kg을 넣을 수 있습니다 !! <br/> 사료통이 투명이어서 내용량을 쉽게 알 수 있습니다 !! <br/> 급수병은 일반 페트병을 사용하시면 됩니다 !!</p>
					<a href="http://localhost:8080/pet/goods/goodsView.dog?goods_num=49" class="da-link">사러가기 !</a>
					<div class="da-img"><img src="/pet/resources/images/dogwater.png" alt="image01" /></div>
				</div>
				<div class="da-slide">
					<h2>메라독 케어 라이트</h2>
					<p>메라독 만의 건강 설계 !! <br/> 오더 스톱 건강 공식 !! </br> 특별한 메라독 레시피 !! <br/></p>
					<a href="http://localhost:8080/pet/goods/goodsView.dog?goods_num=7" class="da-link">사러가기 !</a>
					<div class="da-img"><img src="/pet/resources/images/dogrice2.png" alt="image01" /></div>
				</div>
				<nav class="da-arrows">
					<span class="da-arrows-prev"></span>
					<span class="da-arrows-next"></span>
				</nav>
			</div>
        
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
		<script type="text/javascript" src="/pet/resources/js/jquery.cslider.js"></script>
		<script type="text/javascript">
			$(function() {
			
				$('#da-slider').cslider({
					autoplay	: true,
					bgincrement	: 450
				});
			
			});
		</script>
		
		
		
		<!-- 상품 뿌려주기 -->
		
		

<div class="goods_list">
<!-- 추천상품 -->
<img class="main" src="/pet/resources/images/title_recommend2.png" alt="추천상품"><br/>&nbsp;

 <c:forEach var="goodsList1"  items="${goodsList1}" varStatus="stat">
		<ul>
			<li class="box">
				<a href="/pet/goods/goodsView.dog?goods_num=${goodsList1.goods_num}"> 
					<div class="box_image">
						<img src="/pet/resources/goods_upload/${goodsList1.goods_image}" width="300" height="300" alt="" onerror="this.src='/pet/resources/images/noimg_130.gif'" />
						<dl class="price">
						<dt class="name"><span style="font-size:16px;color:#1a1a1a;font-weight:bold;">${goodsList1.goods_name}</span></dt>
						</dl>
						<dd class="price">
							<p class="custom"><fmt:formatNumber value="${goodsList1.goods_price * 1.4}" type="number"/>원</p>
							<p><span class="price-prdc"><fmt:formatNumber value="${goodsList1.goods_price}" type="number"/></span>원</p>
							<p class="icon2">  <img src="/pet/resources/images/sale5.gif" alt=""></p>   
						</dd>
					</div>
				</a>
			</li>
		</ul>
	</c:forEach>

<!--  등록된 상품이 없을때 -->
<c:if test="${fn:length(goodsList1) le 0}">
	등록된 상품이 없습니다
</c:if> 

<!-- 베스트상품 -->
<img class="main" src="/pet/resources/images/title_best.png" alt="베스트상품"><br/>&nbsp;
	
 <c:forEach var="goodsList2"  items="${goodsList2}" varStatus="stat">
		<ul>
			<li class="box">
				<a href="/pet/goods/goodsView.dog?goods_num=${goodsList2.goods_num}"> 
					<div class="box_image">
						<img src="/pet/resources/goods_upload/${goodsList2.goods_image}" width="300" height="300" alt="" onerror="this.src='/pet/resources/images/noimg_130.gif'" />
						<dl class="price">
						<dt class="name"><span style="font-size:16px;color:#1a1a1a;font-weight:bold;">${goodsList2.goods_name}</span></dt>
						</dl>
						<dd class="price">
							<p class="custom"><fmt:formatNumber value="${goodsList2.goods_price * 1.4}" type="number"/>원</p>
							<p><span class="price-prdc"><fmt:formatNumber value="${goodsList2.goods_price}" type="number"/></span>원</p>
							<p class="icon2">  <img src="/pet/resources/images/sale5.gif" alt=""></p>   
						</dd>
					</div>
				</a>
			</li>
		</ul>
	</c:forEach>

<!--  등록된 상품이 없을때 -->
<c:if test="${fn:length(goodsList2) le 0}">
	등록된 상품이 없습니다
</c:if> 
<br/>
<!-- 신상품 -->
<img class="main" src="http://okidogki.com/SkinImg/title_listnew.png" alt="신상품"><br/>&nbsp;
	
 <c:forEach var="goodsList3"  items="${goodsList3}" varStatus="stat">
		<ul>
			<li class="box">
				<a href="/pet/goods/goodsView.dog?goods_num=${goodsList3.goods_num}"> 
					<div class="box_image">
						<img src="/pet/resources/goods_upload/${goodsList3.goods_image}" width="300" height="300" alt="" onerror="this.src='/pet/resources/images/noimg_130.gif'" />
						<dl class="price">
						<dt class="name"><span style="font-size:16px;color:#1a1a1a;font-weight:bold;">${goodsList3.goods_name}</span></dt>
						</dl>
						<dd class="price">
							<p class="custom"><fmt:formatNumber value="${goodsList3.goods_price * 1.4}" type="number"/>원</p>
							<p><span class="price-prdc"><fmt:formatNumber value="${goodsList3.goods_price}" type="number"/></span>원</p>
							<p class="icon2">  <img src="/pet/resources/images/sale5.gif" alt=""></p>   
						</dd>
					</div>
				</a>
			</li>
		</ul>
	</c:forEach>

<!--  등록된 상품이 없을때 -->
<c:if test="${fn:length(goodsList3) le 0}">
	등록된 상품이 없습니다
</c:if> 
</div>

		
		
		
		
		
		
		
		
		
		
	