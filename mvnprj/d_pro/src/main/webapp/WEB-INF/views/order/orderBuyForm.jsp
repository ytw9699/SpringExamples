<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style type="text/css">
	.orderArea h3{
	    margin: 30px 0 5px 5px;
	    font-size: 12px;
	    color: #888;
	    font-weight: bold;
	}
	.orderArea .boardWrite table{
		table-layout: fixed;
	    border-top: 1px solid #ccc;
	    border-bottom: 1px solid #ccc;
	    font-size: 12px;
	    width: 100%;
	    border: 0;
	    border-spacing: 0;
	    border-collapse: collapse;
	    font-weight: 800;
	}
	.orderArea .boardWrite table th{
	    width: 140px;
	    padding: 5px 0 5px 22px;
	    border-top: 1px solid #e7e7e7;
	    background: #FAFAFA;
	    color: #888;
	    text-align: left;
	    line-height: 140%;
	    border-left: 0px;
	}
	.orderArea .boardWrite table td{
		width: auto;
	    padding: 5px 0 3px 22px;
	    border-top: 1px solid #e7e7e7;
	    color: #8f8f8f;
	    line-height: 140%;
	    font-size: 12px;
	    border-right: 0px;
	}
	.boardWrite input[type="text"]{
		text-indent: 5px;
	    font-size: 12px;
	    border: 1px solid #cfcecd;
	    background: #fff;
	}

</style>
<div class="category_top">
	<ul>
	 	<li>강아지 ></li><li>주문하기</li>			
	</ul>
</div>

<div class="basket_list">
	<div class="basket_list_top">
		<h2 class="basketcart"><img src="http://okidogki.com/web/upload/goodymallSkin/title/order.gif" alt="장바구니"></h2>
		<img style="width:1000px;" src="http://okidogki.com/web/upload/goodymall15/layout/img_orderStep2.gif" alt="step 01 장바구니">
	</div>
	<div class="basket_main">
		<table class="basket" style="margin-bottom:15px;">
				<colgroup>
					<col width="22%">
					<col width="42%">
					<col width="12%">
					<col width="12%">
					<col width="12%">
				</colgroup>
				<thead>
					<tr>
						<th scope="col">이미지</th>
						<th scope="col">상품명</th>
						<th scope="col">단일금액</th>
						<th scope="col">수량</th>
						<th scope="col">합계</th>
					</tr>
				</thead>				
					<tr>
						<td align="center"><img src="/pet/resources/goods_upload/${goodsModel.goods_image}" width="90" height="90"></td>
						<td align="center">${goodsModel.goods_name}</td>
						<td align="center"><fmt:formatNumber value="${goodsModel.goods_price}" type="number"/>원</td>
						<td align="center">${orderModel.order_goods_amount}EA</td>
						<td align="center"><strong id="id2"><fmt:formatNumber value="${goodsModel.goods_price * orderModel.order_goods_amount}" type="number"/>원</strong></td>						
						<%-- <c:set var= "sum" value="${sum + (basketList.basket_goods_price * basketList.basket_goods_amount)}"/> --%>
					</tr>
				
				
				<tfoot>
					<tr style="height:30px;">
						<td colspan="6" style="background:#f6f6f6;border-top: 1px solid #e5e5e5; text-align:right;color:black;">
							<strong style="float:left;color:#688abd;">&nbsp;&nbsp;&nbsp;[ 기본배송 ]</strong>
							상품구매금액 <strong><fmt:formatNumber value="${goodsModel.goods_price * orderModel.order_goods_amount}" type="number"/> </strong> + 배송비 <strong>0</strong> = <strong style="color: #f8941d;font-size: 14px;">합계 : <fmt:formatNumber value="${goodsModel.goods_price *orderModel.order_goods_amount}" type="number"/>원 </strong>&nbsp;&nbsp;&nbsp;
						</td>
					</tr>
				</tfoot>
				
			</table>
				
		
		</div>
</div>


<div class="orderArea">
	<h3>배송지 정보</h3>
		<div class="boardWrite">
			<table border="1" summary="">
				<caption>배송지 정보</caption>
				<tbody>
					<tr>
						<th scope="row">주소</th>
						<td>
							${orderModel.order_receive_zipcode}<br>${orderModel.order_receive_addr}
						</td>
					</tr>
					<tr>
						<th scope="row">이름</th>
						<td>${orderModel.order_receive_name}</td>
					</tr>
					<tr>
						<th scope="row">휴대폰</th>
						<td>${orderModel.order_receive_mobile}</td>						
					</tr> 
					<tr>
						<th scope="row">배송요청사항</th>
						<td>
							${orderModel.order_memo}</td>
					</tr>
					<tr>
						<th scope="row">결재방식</th>
						<td>${orderModel.order_trade_type}</td>
					</tr>   
					<tr>
						<th scope="row">입금주소</th>
						<td>${orderModel.order_trade_payer}</td>
					</tr>           
				</tbody>
			</table>
		</div>
</div>

<form action="orderbuyOk.dog" method="post">
<input type="hidden" name="order_goods_num" value="${orderModel.order_goods_num }" />

<input type="hidden" name="order_goods_price" value="${goodsModel.goods_price}" />
<input type="hidden" name="order_goods_amount" value="${orderModel.order_goods_amount }" />
<input type="hidden" name="order_member_id" value="${orderModel.order_member_id }" />
<input type="hidden" name="order_receive_name" value="${orderModel.order_receive_name }" />
<input type="hidden" name="order_receive_addr" value="${orderModel.order_receive_addr }" />
<input type="hidden" name="order_receive_mobile" value="${orderModel.order_receive_mobile }" />
<input type="hidden" name="order_receive_zipcode" value="${orderModel.order_receive_zipcode }" />
<input type="hidden" name="order_memo" value="${orderModel.order_memo }" />
<input type="hidden" name="order_sum_money" value="${orderModel.order_sum_money }" />
<input type="hidden" name="order_trade_type" value="${orderModel.order_trade_type }" />
<input type="hidden" name="order_trade_payer" value="${orderModel.order_trade_payer }" />
<input type="hidden" name="order_goods_name" value="${goodsModel.goods_name}" />
<input type="hidden" name="order_goods_image" value="${goodsModel.goods_image}" />


<div class="basket_button" style="margin-top:5px;">


		<input type="image" src="http://okidogki.com/web/upload/goodymallSkin/product/btn_payment.gif" value="submit" name="submit">					

</div>	
</form>






















