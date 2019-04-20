<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<style type="text/css">
 .orderInfo{
	margin: 10px 0 0;
    padding: 90px 0;
    border: 1px solid #f0f0f0;
    background: #f6f6f6;
    color: #202020; 	
 }
 .orderInfo .complete{
 	width: 323px;
    height: 151px;
    margin: 0 auto;
    padding: 30px 0 0 160px;
    background: url("http://img.echosting.cafe24.com/design/skin/default/order/bg_complete.gif") no-repeat 0 0;
 }
 .orderInfo p{
    padding: 0 70px 0 0;
    background: url("http://img.echosting.cafe24.com/design/skin/default/order/ico_complete.gif") no-repeat 240px 0;
    font-weight: bold;
    font-size: 30px;
    color: #464c4e;
    height: 70px;
 }
 .orderInfo li{
 	margin: 5px 0 0;	
 }
</style>

<div class="basket_list" style="margin-top:35px;margin-bottom:35px;">
	<div class="basket_list_top">
		<h2 class="basketcart"><img src="http://okidogki.com/web/upload/goodymallSkin/title/order_end.gif" alt="��ٱ���"></h2>
		<img style="width:1000px;" src="http://okidogki.com/web/upload/goodymall15/layout/img_orderStep3.gif" alt="step 01 ��ٱ���">
	</div>
	<div class="basket_main">
		<div class="orderInfo">
	        <div class="complete">
	        <p>������ �ֹ���<br/><br/>�Ϸ� �Ǿ����ϴ�.</p>
			<ul>
				<li class="number">
				<strong>�ֹ���ȣ</strong>&nbsp;&nbsp;&nbsp;<span>${orderModel3.order_trade_num}</span>
				</li>
				<li class="date">
				<strong>�ֹ�����</strong>&nbsp;&nbsp;&nbsp;<span><fmt:formatDate value="${orderModel3.order_trade_date}" pattern="YY.MM.dd HH:mm" /></span>
				</li>
				<li class="date">
				<strong>�Աݰ��¹�ȣ</strong>&nbsp;&nbsp;&nbsp;<span>${orderModel3.order_trade_payer}</span>
				</li>
				
			</ul>
			</div>
	    </div>
	    
	    <div style="margin-top:15px; text-align:center;">
			<span class="btn btnC_04 btnP_04"><a href="/pet/main.dog"><input type="button" value="����ȭ������"></a></span>
			<span class="btn btnC_04 btnP_04">
			<a href="${contextPath}/pet/order/orderList.dog"><input type="button" value="���ų���"></a>	
			</span>	
		</div>
	</div>
</div>
