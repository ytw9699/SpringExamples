<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<div class="category_top">
	<ul>
	 	<li>강아지 ></li><li>장바구니</li>			
	</ul>
</div>
<div class="basket_list">
	<div class="basket_list_top">
		<h2 class="basketcart"><img src="http://okidogki.com/web/upload/goodymallSkin/title/cart.gif" alt="장바구니"></h2>
		<img style="width:1000px;" src="http://okidogki.com/web/upload/goodymall15/layout/img_orderStep1.gif" alt="step 01 장바구니">
	</div>
	<div class="basket_main">
	<form name="basketList" method="post">
		<table class="basket" style="margin-bottom:15px;">
				<colgroup>
					<col width="20%">
					<col width="40%">
					<col width="10%">
					<col width="10%">
					<col width="10%">
					<col width="10%">
				</colgroup>
				<thead>
					<tr>
						<th scope="col">이미지</th>
						<th scope="col">상품명</th>
						<th scope="col">단일금액</th>
						<th scope="col">수량</th>
						<th scope="col">합계</th>
						<th scope="col">설정</th>
					</tr>
				</thead>
				
   
				<c:forEach var="basketList"  items="${basketList}" varStatus="stat">	
					<tr>
						<td align="center"><img src="/pet/resources/goods_upload/${basketList.basket_goods_image}" width="90" height="90"></td>
						<td align="center">${basketList.basket_goods_name}</td>
						<td align="center"><fmt:formatNumber value="${basketList.basket_goods_price}" type="number"/>원</td>
						<td align="center">${basketList.basket_goods_amount}EA</td>
						<td align="center"><strong id="id2"><fmt:formatNumber value="${basketList.basket_goods_price*basketList.basket_goods_amount}" type="number"/>원</strong></td>
						<td align="center">
							<a href="basketdelete.dog?basket_num=${basketList.basket_num}"><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/7/7d/Trash_font_awesome.svg/32px-Trash_font_awesome.svg.png" ></a>
						</td>
						<c:set var= "sum" value="${sum + (basketList.basket_goods_price * basketList.basket_goods_amount)}"/>
					</tr>
				</c:forEach>
					<c:if test="${fn:length(basketList) <= 0}">
						<tr>
							<td colspan="6" align="center"><font size="2">장바구니에 담긴 상품이 없습니다.</font></td>
						</tr>
					</c:if>
				<tfoot>
					<tr style="height:30px;">
						<td colspan="6" style="background:#f6f6f6;border-top: 1px solid #e5e5e5; text-align:right;color:black;">
							<strong style="float:left;color:#688abd;">&nbsp;&nbsp;&nbsp;[ 기본배송 ]</strong>
							상품구매금액 <strong><fmt:formatNumber value="${sum}" type="number"/> </strong> + 배송비 <strong>0</strong> = <strong style="color: #f8941d;font-size: 14px;">합계 : <fmt:formatNumber value="${sum}" type="number"/>원 </strong>&nbsp;&nbsp;&nbsp;
						</td>
					</tr>
				</tfoot>
				
			</table>
			<div class="basket_button">
										
					<a href="/pet/main.dog" ><img src="http://okidogki.com/web/upload/goodymallSkin/product/btn_order_ing.gif" alt="쇼핑계속하기"></a>
					<a href="/pet/order/basketorderForm.dog" ><img src="http://okidogki.com/web/upload/goodymallSkin/product/btn_order_all.gif" alt="전체상품주문"></a>  		
			</div>		
		</form>
		</div>
</div>







