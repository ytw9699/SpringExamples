<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript">

$( document ).ready(function() {
	$('#sum').rowspan(0);
});

$.fn.rowspan = function(colIdx, isStats) {       
	return this.each(function(){      
		var that;     
		$('tr', this).each(function(row) {      
			$('td:eq('+colIdx+')', this).filter(':visible').each(function(col) {
				
				if ($(this).html() == $(that).html()
					&& (!isStats 
							|| isStats && $(this).prev().html() == $(that).prev().html()
							)
					) {            
					rowspan = $(that).attr("rowspan") || 1;
					rowspan = Number(rowspan)+1;

					$(that).attr("rowspan",rowspan);
					
					// do your action for the colspan cell here            
					$(this).hide();
					
					//$(this).remove(); 
					// do your action for the old cell here
					
				} else {            
					that = this;         
				}          
				
				// set the that if not already set
				that = (that == null) ? this : that;      
			});     
		});    
	});  
}; 
function delchk(){
    return confirm("삭제하시겠습니까?");
    
    
}
 function test(orderList)
 {
         var div_test = document.getElementById('test');
         div_test.innerHTML = orderList.order_receive_name;
        
 }
 
</script>

<div class="category_top">
	<ul>
	 	<li>강아지 ></li><li>주문리스트</li>			
	</ul>
</div>
<div class="basket_list">
	<div class="basket_list_top">
		<h2 class="basketcart"><img src="http://okidogki.com/web/upload/goodymallSkin/title/order_list.gif" alt="장바구니"></h2>
	</div>
	<div class="basket_main">
	<form name="basketList" method="post">
		<table class="basket" style="margin-bottom:15px;" id="sum">
				<colgroup>
					<col width="18%">
					<col width="10%">
					<col width="35%">
					<col width="7%">
					<col width="10%">
					<col width="10%">
					<col width="10%">
				</colgroup>
				<thead>
					<tr>
						<th scope="col">주문일자<br/>[주문번호]</th>
						<th scope="col">이미지</th>
						<th scope="col">상품명</th>
						<th scope="col">수량</th>
						<th scope="col">상품구매금액</th>
						<th scope="col">주문처리상태</th>
						<th scope="col">주문취소</th>
					</tr>
				</thead>
				
   
				<c:forEach var="order"  items="${orderList}" varStatus="status">	
					<tr>
						<td align="center"><fmt:formatDate value="${order.order_date}" pattern="YY-MM-dd" /><br/>[ ${order.order_trade_num} ]<br/><br/>
						[ 송장 : ${order.order_trans_num} ]</td>
						<td align="center"><img src="/pet/resources/goods_upload/${order.order_goods_image}" width="90" height="90"></td>
						<td align="center"><a href="/pet/goods/goodsView.dog?goods_num=${order.order_goods_num}"> ${order.order_goods_name}</a></td>
						<td align="center">${order.order_goods_amount}EA</td>
						<td align="center"><strong id="id2"><fmt:formatNumber value="${order.order_sum_money}" type="number"/>원</strong></td>
						<td align="center">${order.order_status}</td>
						<td align="center">
							<a href="orderdelete.dog?order_num=${order.order_num}"><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/7/7d/Trash_font_awesome.svg/32px-Trash_font_awesome.svg.png"onclick="return delchk()" ></a>
						</td>
				
					</tr>
					<c:if test="${orderList[status.index].order_trade_num != orderList[status.index+1].order_trade_num}">
					<tr style="height:30px;">
						<td colspan="7" style="background:#f6f6f6;border-top: 1px solid #e5e5e5; border-bottom: 1px solid #e5e5e5;">
							
						</td>
					</tr>
					</c:if>
				</c:forEach>
					<c:if test="${fn:length(orderList) <= 0}">
						<tr>
							<td colspan="7" align="center"><font size="2">주문리스트 담긴 상품이 없습니다.</font></td>
						</tr>
					</c:if>
				<tfoot>
					<tr style="height:1px;">
						<td colspan="7" style="background:#f6f6f6;border-top: 1px solid #e5e5e5; text-align:right;color:black;">
							
						</td>
					</tr>
				</tfoot>
				
			</table>
			<div class="basket_button">
										
					<a href="/pet/main.dog" ><img src="http://okidogki.com/web/upload/goodymallSkin/product/btn_order_ing.gif" alt="쇼핑계속하기"></a>  		
			</div>		
		</form>
		</div>
</div>



<%-- 

	<form name="orderList" method="post">
		<table width="700" align="center">
			<tr>
				<td colspan="7" align="center">
				주문 리스트
				</td>
			</tr>
			
			
   
				<c:forEach var="order"  items="${orderList}" varStatus="status">	
					<tr>
						<td width="80" align="center"><img src="/pet/resources/goods_upload/${order.order_goods_image}" width="100" height="100"></td>									
						<td width="300" align="center">
						<a href="goodsView.dog?goods_num=${order.order_goods_num}"> 
								${order.order_goods_name}&nbsp;&nbsp;</a>
						</td>
					
						<td width="80"align="center">주문번호 : ${order.order_trade_num}</td>
					
						<td width="80"align="center">${order.order_goods_price}원</td>
						<td width="80"align="center">${order.order_goods_amount}EA</td>
						<td width="80" align="center">${order.order_sum_money}원</td>
						<td width="80" align="center">주문상태 : ${order.order_status}</td>
						<td width="80" align="center">
						<input type="button" onClick="test(${orderList})" value="상세보기"/>
						
						<a href="orderdelete.dog?order_num=${order.order_num} " >삭제</a>
							<!-- 이거는 나중에 없애기 삭제말고 상세보기 -->
							</td>
					</tr> 
					<tr>
					
					</tr>
						<td width="300" align="center">
						송장번호 : ${order.order_trans_num}</td>
					<tr>  
						<td colspan="6" align="center">
						<c:if test="${orderList[status.index].order_trade_num != orderList[status.index+1].order_trade_num}">
							------------------------------------------------------------------------------------
							</c:if>
						</td>
					</tr>
				
					
				</c:forEach>
					<tr>
					<td><br /><br />		</td>
					</tr>
					<c:if test="${fn:length(orderList) <= 0}">
						<tr>
							<td colspan="6" align="center"><font size="2">구매 내역이 없습니다</font></td>
						</tr>
					</c:if>
				<tr height="40">
					<td align="right" colspan="6">
					
					
					<a href="/pet/main.dog" >메인으로</a>
					
					</td>
				</tr>
			</table>
		</form> --%>