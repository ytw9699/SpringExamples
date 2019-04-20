<%@page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<!-- <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.1.0.js"></script>
<link href="/pet/resources/admincss/bootstrap.min.css" rel="stylesheet">
<link href="/pet/resources/css/reset.css" rel="stylesheet">
<link href="/pet/resources/admincss/sb-admin-2.css" rel="stylesheet"> -->

<script type="text/javascript">
/* 숫자 , 표시 함수 */
	var funcSetCurrency = function($) {
		$('span,p.custom,.custom').each(
				function() {
					if (!isNaN(Number($(this).text())) && $(this).text())
						$(this).text(
								Number($(this).text()).toLocaleString().split('.')[0]);
				});
		
	};

	$(document).ready(function() {
		funcSetCurrency($);
	});
	
	//구매갯수 변환 함수
	function count_change(temp){
		var test=document.goodsform.amount.value;
		var price="${goodsModel.goods_price}";//숫자계산위해필요
			if(temp==0){
				test++;
			}else if(temp==1){
				if(test >1 ) test--;
			}
		if(test>"${goodsModel.goods_amount}"){
			alert("잔여수량만큼 구매하세요");
			test=1;
		}
		
		document.goodsform.amount.value=test;
		var value2 = $("#span1").html(price*test); //숫자계산위해필요
	    var value3 = $("em").html(price*test);//숫자계산위해필요
	    var value4 = $("#am2").html("("+test+"개)");//숫자계산위해필요
	}
	
	//span값변경
	 $(window).load(function(){ 
	    
	    var amount=document.goodsform.amount.value;
	    var price="${goodsModel.goods_price}";
	    var value2 = $("#span1").html(price*amount); 
	    var value3 = $("em").html(price*amount);
	    var value4 = $("#am2").html("("+amount+"개)");
	    
	    $('em, #span1').each(
				function() {
					if (!isNaN(Number($(this).text())) && $(this).text())
						$(this).text(
								Number($(this).text()).toLocaleString().split('.')[0]);
				});
	   
	}); 
	
	//장바구니 처리
		var onBasket = function(){
			
			var num="${goodsModel.goods_num}";
			var amount = document.goodsform.amount.value;
			var id = "${session_member_id}";
			location.href = 'basketAdd.dog?goods_num='+num+'&goods_amount='+amount+'&basket_member_id='+id;
			
		};
		
	//주문처리
      var onOrder = function(){
         
         var num="${goodsModel.goods_num}";
         var amount = document.goodsform.amount.value;
         var id = "${session_member_id}";
         location.href = '/pet/order/orderForm.dog?goods_num='+num+'&goods_amount='+amount+'&basket_member_id='+id;
         
      };
      
      //코멘트 처리
      var onComment = function(){
  		var form = $('.commentForm')[0];
  		form.action = 'commentWrite.dog'; 
  		form.submit();
  	};
	
	
</script>
<style type="text/css"> 
	.soyoon ul {
    list-style:none !important;
    overflow:auto !important;
    
	}

	.soyoon li {
  	display:inline !important;
    float: left !important;
	}
	
	.btn1 {
    display: inline-block;
    vertical-align: middle;
    text-align: center;
    overflow: visible;
}
.btn1 {
    width: 80px;
    height: 70px;
}
.btn-primary1 {
    color: #fff;
    background-color: #2a2e33;
    border-color: #2a2e33;
}
button {
    cursor: pointer;
}

.reply_grp {
    margin-top: 50px;
    margin-bottom: 77px;
}
	
.reply_grp .reply_view .reply_tit .btn {
    position: absolute;
    top: 50%;
    right: 0;
    margin-top: 14px;
    width: 30px;
}

	
</style>

</head>
<body>
	<!-- /* 카테고리 표시부분 */ -->
	<div class="category_top">
	<ul>
	 	<c:if test="${goodsModel.goods_category eq 0}">
			<li>강아지 ></li><li class="post2">사료</li>
		</c:if>
		<c:if test="${goodsModel.goods_category eq 1}">
			<li>강아지 ></li><li class="post2">간식</li>
		</c:if>	
		<c:if test="${goodsModel.goods_category eq 2}">
			<li>강아지 ></li><li class="post2">패션/의류</li>
		</c:if>	
		<c:if test="${goodsModel.goods_category eq 3}">
			<li>강아지 ></li><li class="post2">목줄/야외</li>
		</c:if>
		<c:if test="${goodsModel.goods_category eq 4}">
			<li>강아지 ></li><li class="post2">생활/잡화</li>
		</c:if>				
	</ul>
	</div>
	
	<!-- /* 상품이미지 및 주문하기 */ -->
	<div class="goods_mains">
		<!-- 메인이미지영역 -->
		<div class="imagepart">
			<div class="imagedetail">
				<img src="/pet/resources/goods_upload/${goodsModel.goods_image}" onerror="this.src='/pet/resources/images/noimg_130.gif'" />
			</div>
		</div>
		<form name="goodsform" action="#" method="post" >
			<!-- 상세정보및 주문 영역 -->
			<div class="infoarea">
				<div class="iconb"></div>
			
				<div class="icon">
					<img src="/pet/resources/images/sale5.gif" />
				</div>
		            <h3>${goodsModel.goods_name}</h3>
				<dd class="price">
					<p class="custom"><fmt:formatNumber value="${goodsModel.goods_price * 1.4}" type="number"/>원</p>
					<p>
						<span id="price">${goodsModel.goods_price}</span>원
					</p>
				</dd>
				<div id="totalProducts" class="">
					<p class="info "><img src="http://img.echosting.cafe24.com/skin/base_ko_KR/product/ico_information.gif" alt="" />
						수량을 선택해주세요.
					</p>
					<table summary="">
						<caption>상품 목록</caption>
						<colgroup>
							<col style="width: 284px;" />
							<col style="width: 80px;" />
							<col style="width: 110px;" />
						</colgroup>
						<tbody class="">
							<tr>
								<td class="left">${goodsModel.goods_name}</td>
								
								<td><p class="quantity">
								<input type="text" name="amount" class="quantity_opt" value="1" style="text-align: center; ime-mode:Disabled;" onkeypress="checknum()" readonly  />
								<a href="JavaScript:count_change(0)"><img src="http://img.echosting.cafe24.com/design/skin/default/product/btn_count_up.gif" alt="수량증가" class="up" /></a>
	                            <a href="JavaScript:count_change(1)"><img src="http://img.echosting.cafe24.com/design/skin/default/product/btn_count_down.gif" alt="수량감소" class="down" /></a></p>
									
								</td>
								
								<td class="right">
									<span class="quantity_price" id="span1"></span>원
								</td>
							</tr>
						</tbody>
						<tfoot>
							<tr>
								<td colspan="3"><strong>총 상품금액</strong>(수량) : <span class="total"><strong><em>555</em>원&nbsp;</strong><span id="am2">(${goodsModel.goods_amount}개)</span></span></td>
							</tr>
						</tfoot>
					</table>
				</div>
				<div class="cartbuy">
					<div class="img_on">
						<!-- 잔여수량이 0 이면 솔드아웃 처리 -->
						<c:if test="${goodsModel.goods_amount > 0 }">						
						<a href="JavaScript:onOrder()"><img src="http://okidogki.com/web/upload/goodymall15/layout/btn_prdOrder.gif" alt="바로 구매하기"></a>
						<a href="JavaScript:onBasket()"><img src="http://okidogki.com/web/upload/goodymall15/layout/btn_basket.gif" alt="장바구니 담기"></a> 
						</c:if>
						
						<c:if test="${goodsModel.goods_amount <= 0 }">
						<img src="http://ppoya.co.kr/images/btn_soldout.gif" alt="품절">						
						</c:if>
					</div>
				</div>
			</div>
		</form>	
	</div>
	<!-- 상세정보및 주문 영역 마감///-->
	<!-- 상품정보 -->
	<div class="product_ex">
		<div id="preDetail">
			<ul class="link">
				<img src="/pet/resources/images/detail_14tit.jpg" alt="상품정보">
				&nbsp;<br/>
			</ul>
			<div class="de_detail">
				<p align="center"><img src="/pet/resources/goods_upload/${goodsModel.goods_contentimage}"></p>
			</div>
		</div>
		<div id="preDetail">
			<ul class="link">
				<img src="/pet/resources/images/detail_17tit.jpg" alt="배송정보">
			</ul>
			<div class="de_detail">
				<p align="center"><img src="/pet/resources/goods_upload/${goodsModel.goods_delevimage}"></p>
			</div>
		</div>
	</div>











<div id="wrapper">
	<div id="page-wrapper">

		 
		 <!-- 코멘트 달기 -->
<div class="inner">
		<!-- reply_grp -->
		<form class="commentForm" method="post">
		<input type="hidden" name="item_no" value="${goodsModel.goods_num}"/>
		
	
		
				<div class="reply_grp">
					<div class="reply_form">
				
						<div class="reply_write">
							<c:if test="${session_member_id == null}">
                  				<input type="text" style="align:center; margin: 10px; width: 950px; height: 55px;" value="로그인 후에  댓글 작성이 가능합니다." readonly="readonly"/>
	      	 				</c:if>
	      	 				<c:if test="${session_member_id != null}">
							<div class="soyoon" style="align: center">
								<img src="/pet/resources/images/goods/commentlogo.png"></img>
		<ul>
		<li>&nbsp;&nbsp; <input type="radio" name="goods_point" value="1" height="1" class="radio">
      <img src="/pet/resources/images/goods/star_on1.gif" border="0"><img src="/pet/resources/images/goods/star_off1.gif" border="0"><img src="/pet/resources/images/goods/star_off1.gif" border="0"><img src="/pet/resources/images/goods/star_off1.gif" border="0"><img src="/pet/resources/images/goods/star_off1.gif" border="0">
       </li>
       
      		<li><input type="radio" name="goods_point" value="2" height="1" class="radio">
      <img src="/pet/resources/images/goods/star_on1.gif" border="0"><img src="/pet/resources/images/goods/star_on1.gif" border="0"><img src="/pet/resources/images/goods/star_off1.gif" border="0"><img src="/pet/resources/images/goods/star_off1.gif" border="0"><img src="/pet/resources/images/goods/star_off1.gif" border="0">
     	</li>
       
      		<li><input type="radio" name="goods_point" value="3" height="1" class="radio">
      <img src="/pet/resources/images/goods/star_on1.gif" border="0"><img src="/pet/resources/images/goods/star_on1.gif" border="0"><img src="/pet/resources/images/goods/star_on1.gif" border="0"><img src="/pet/resources/images/goods/star_off1.gif" border="0"><img src="/pet/resources/images/goods/star_off1.gif" border="0">
      		</li>
      
     		<li><input type="radio" name="goods_point" value="4" height="1" class="radio">
      <img src="/pet/resources/images/goods/star_on1.gif" border="0"><img src="/pet/resources/images/goods/star_on1.gif" border="0"><img src="/pet/resources/images/goods/star_on1.gif" border="0"><img src="/pet/resources/images/goods/star_on1.gif" border="0"><img src="/pet/resources/images/goods/star_off1.gif" border="0">
       		</li>
      		<li><input type="radio" name="goods_point" value="5" height="1" checked="" class="radio">
      <img src="/pet/resources/images/goods/star_on1.gif" border="0"><img src="/pet/resources/images/goods/star_on1.gif" border="0"><img src="/pet/resources/images/goods/star_on1.gif" border="0"><img src="/pet/resources/images/goods/star_on1.gif" border="0"><img src="/pet/resources/images/goods/star_on1.gif" border="0">
		 		</li></ul>			
		 						</div>
							
							<div class="textarea_grp" style="width: 1000px;">
								<textarea name="commentt" style="margin: 10px; width: 849px; height: 55px;"></textarea><button type="button" class="btn1 btn-primary1" onclick="onComment()">입력	</button>
							</div>
							</c:if>
						</div>
						
					</div>




<c:if test="${fn:length(commentlist) ge 0}">
		<p class="reply_num"> </p>
		</c:if> 
	<c:forEach var="commentlist" items="${commentlist }" varStatus="stat">

	
			
			<!-- <p class="reply_num">댓글 수 <strong>1</strong></p> -->
			<div class="reply_view">
				<div class="reply_tit">
					<div class="tit"><strong>${commentlist.cmter} </strong>님  
					<div class="so">
					 <c:if test='${commentlist.goods_point == 1}'>
      &nbsp;<img src="/pet/resources/images/goods/star_on2.gif" border="0" /><img src="/pet/resources/images/goods/star_off2.gif" border="0" /><img src="/pet/resources/images/goods/star_off2.gif" border="0" /><img src="/pet/resources/images/goods/star_off2.gif" border="0" /><img src="/pet/resources/images/goods/star_off2.gif" border="0" />
      </c:if>
      <c:if test='${commentlist.goods_point == 2}'>
     &nbsp; <img src="/pet/resources/images/goods/star_on2.gif" border="0"><img src="/pet/resources/images/goods/star_on2.gif" border="0"><img src="/pet/resources/images/goods/star_off2.gif" border="0"><img src="/pet/resources/images/goods/star_off2.gif" border="0"><img src="/pet/resources/images/goods/star_off2.gif" border="0">
      </c:if>
      <c:if test='${commentlist.goods_point == 3}'>
     &nbsp; <img src="/pet/resources/images/goods/star_on2.gif" border="0"><img src="/pet/resources/images/goods/star_on2.gif" border="0"><img src="/pet/resources/images/goods/star_on2.gif" border="0"><img src="/pet/resources/images/goods/star_off2.gif" border="0"><img src="/pet/resources/images/goods/star_off2.gif" border="0">
      </c:if>
      <c:if test='${commentlist.goods_point == 4}'>
     &nbsp; <img src="/pet/resources/images/goods/star_on2.gif" border="0"><img src="/pet/resources/images/goods/star_on2.gif" border="0"><img src="/pet/resources/images/goods/star_on2.gif" border="0"><img src="/pet/resources/images/goods/star_on2.gif" border="0"><img src="/pet/resources/images/goods/star_off2.gif" border="0">
      </c:if>
      <c:if test='${commentlist.goods_point == 5}'>
       &nbsp; <img src="/pet/resources/images/goods/star_on2.gif" border="0"><img src="/pet/resources/images/goods/star_on2.gif" border="0"><img src="/pet/resources/images/goods/star_on2.gif" border="0"><img src="/pet/resources/images/goods/star_on2.gif" border="0"><img src="/pet/resources/images/goods/star_on2.gif" border="0">
      </c:if>
      <fmt:formatDate value="${commentlist.cmt_date}" pattern="yy.MM.dd"></fmt:formatDate></div>
					</div>
					<c:if test="${session_member_id == commentlist.cmter}">
					<a href="commentDelete.dog?comment_num=${commentlist.comment_num}&goods_no=${goodsModel.goods_num}" class="btn btnC_01 btnP_02">
						<span class="btn btnC_05 reply_btn">삭제</span>
					</a>
					</c:if>
				</div>
				
				<div class="reply_cts">
					<p>${commentlist.commentt}</p>
				</div>
			</div>

		</c:forEach>	
		</div><!-- // reply_grp -->
		</form>
		</div>
	</div>
	</div>	
		 
		 
		 

</body>
</html>