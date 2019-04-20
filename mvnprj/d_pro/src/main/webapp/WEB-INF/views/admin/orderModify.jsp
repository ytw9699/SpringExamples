<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<head>
<script type="text/javascript">
 window.onload = function(){
	var code ="${orderModel.order_trade_type}"
	for(var i=0; i<2; i++){
	    if(document.joinform.order_trade_type.options[i].value == code){
	        document.joinform.order_trade_type.options[i].selected = true;
	        break;
	    }
	}
	
	var code2 = "${orderModel.order_trade_payer}"
	for(var i=0; i<4; i++){
	    if(document.joinform.order_trade_payer.options[i].value == code2){
	        document.joinform.order_trade_payer.options[i].selected = true;
	        break;
	    }
	}
	var code3 = "${orderModel.order_status}"
		for(var i=0; i<6; i++){
		    if(document.joinform.order_status.options[i].value == code3){
		        document.joinform.order_status.options[i].selected = true;
		        break;
		    }
		}
} 
function validateForm() {
    var x = document.forms["joinform"]["goods_name"].value;
    if (x == null || x == "") {
        alert("상품명은 입력해야합니다");
        return false;
    }
}
</script>
</head>

<!-- 메뉴 시작 -->

<div class="row" style="padding-left:15px;width:900px;">    
	<h1 class="page-header">주문수정</h1>
</div>

<div class="row" style="padding-left:15px;width:900px;">
	<div class="panel panel-default">
		<div class="panel-heading" >주문수정 페이지입니다. 이미지 확인하십시오</div>
			<div class="panel-body">
				<form:form commandName="orderModel" action="orderModify.dog" enctype="multipart/form-data" method="post"name="joinform" onsubmit="return validateForm()">	
				<input type="hidden" name="order_num" value="${orderModel.order_num}">
						<div class="form-group">
                            <label>주문번호</label>
                            <input type="text" class="form-control" value="${orderModel.order_trade_num}" style="width:initial;" readonly/>                             
                        </div>
                        <div class="form-group">
                            <label>상품명</label>
                            <input type="text" class="form-control" value="${orderModel.order_goods_name}" style="width:500px;" readonly/>                             
                        </div>
                        <div style="border:1px;" class="form-group">
                           <label>상품이미지</label>
                           <p><img src="/pet/resources/goods_upload/${orderModel.order_goods_image}" width="100" height="100" alt="" onerror="this.src='/pet/resources/images/noimg_130.gif'" />                                                     
                        </div>	
                        <div class="form-group">
                            <label>상품수량</label>
                            <input type="text" class="form-control" value="${orderModel.order_goods_amount}" style="width:initial;" readonly/>                             
                        </div>
                        <div class="form-group">
                            <label>상품가격</label>
                            <input type="text" class="form-control" value="${orderModel.order_goods_price}" style="width:initial;" readonly/>                             
                        </div>		
                        <div class="form-group" style="border-bottom: 1px dotted #999;width:550px;">
                            <label>총 주문가격</label>
                            <input type="text" class="form-control" value="${orderModel.order_sum_money}" style="width:initial;" readonly/>   
                            <p>                   
                        </div>
                        <div class="form-group">
                            <label>배송이름</label>
 							<form:input type="text" class="form-control" value="${orderModel.order_receive_name}" path="order_receive_name" style="width:initial;"/>
                                               
                        </div>
                        <div class="form-group">
                            <label>전화번호</label>
                            <form:input type="text" class="form-control" value="${orderModel.order_receive_mobile}" path="order_receive_mobile" style="width:initial;"/> 
                                               
                        </div>
                        <div class="form-group">
                            <label>우편번호</label>
                            <form:input type="text" class="form-control" value="${orderModel.order_receive_zipcode}" path="order_receive_zipcode" style="width:initial;"/> 
                                               
                        </div>
                        <div class="form-group" style="border-bottom: 1px dotted #999;width:550px;">
                            <label>주소</label>
                            <form:input type="text" class="form-control" value="${orderModel.order_receive_addr}" path="order_receive_addr" style="width:500px;"/>
                            <p>                   
                        </div>	
                        <div class="form-group">
                            <label>운송장번호</label>
                            <form:input type="text" class="form-control" value="${orderModel.order_trans_num}" path="order_trans_num" style="width:initial;"/>                
                        </div>	
                        <div class="form-group">
                            <label>결재방식</label>
                            <form:select path="order_trade_type" class="form-control" style="width:initial;" name="order_trade_type" >
								<form:option value="무통장입금" label="무통장입금" />
								<form:option value="카드결재" label="카드결재" />
							</form:select>                   
                        </div>
                        <div class="form-group">
                            <label>무통장계좌</label>
                            <form:select path="order_trade_payer" class="form-control" style="width:initial;" name="order_trade_payer" >
								<form:option value="농협은행 : 1207-01-004061 박준영" label="농협은행 : 1207-01-004061 박준영" />
								<form:option value="우리은행 : 1002-834-406482 박준영" label="우리은행 : 1002-834-406482 박준영" />
								<form:option value="경남은행 : 528-22-0247871 박준영" label="경남은행 : 528-22-0247871 박준영" />
							</form:select>                   
                        </div>
                        <div class="form-group">
                            <label>주문상태</label>
                            <form:select path="order_status" class="form-control" style="width:initial;" name="order_status" >
								<form:option value="상품준비" label="상품준비" />
								<form:option value="입금대기" label="입금대기" />
								<form:option value="배송중" label="배송중" />
								<form:option value="배송완료" label="배송완료" />
								<form:option value="구매완료" label="구매완료" />
							</form:select>                   
                        </div>							
						<div class="form-group">
                            <label>주문일자</label>                            
                            <fmt:formatDate value="${orderModel.order_date}" pattern="YYYY.MM.dd" />                            
                        </div>
						
						<button type="submit" class="btn btn-success">주문수정</button>
						<button type="reset" class="btn btn-default">작성취소</button>					
				</form:form>
			</div>
	</div>
</div>






<!-- // container -->
	






























