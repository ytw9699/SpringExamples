<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<script type="text/javascript">
	
	
	var onSearch = function(){
		
		submit();
	};
	
		
</script>



<!-- header_area -->
<div class="header_area">
	<h1><a href="/pet/main.dog" title="개편한세상"><img src="/pet/resources/images/SkinImg/mainlogo.png" alt="개편한세상" style="width:250px;" /></a></h1>		
	<div class="search_main">
		<div class="search_inner">
			<form action="/pet/goods/goodsSearchList.dog" method="post" >
				<fieldset>
					<legend>검색</legend>
					<input type="text" class="txt" placeholder="상품전체검색 ex) 공, 옷, 간식" name="search"/>&nbsp;
					<input type="button" value="검색" class="search_btn" onClick="onSearch()"/>
				</fieldset>
			</form>
		</div>
	</div>
	<div class="util_menu">
		<ul>
			<c:if test="${session_member_name == null }">
			<li><a href="${contextPath}/pet/member/login.dog" class="log">로그인</a></li> 
			<li><a href="${contextPath}/pet/member/member.dog">회원가입</a> </li>
			<li><a href="${contextPath}/pet/logchek.dog">장바구니</a></li>
			<li><a href="${contextPath}/pet/logchek.dog">주문조회</a></li> 
			</c:if>
			<c:if test="${session_member_name != null }">
			<li>${session_member_name}&nbsp;님</li>	
				<c:if test="${session_member_name == 'admin' }">
					<li><a href="/pet/admin/admin.dog">관리자페이지</a></li> 	
				</c:if>
			<li><a href="${contextPath}/pet/member/logout.dog" class="log">로그아웃</a></li> 
			<li><a href="${contextPath}/pet/member/memberModify.dog">마이페이지</a></li>
			<li><a href="${contextPath}/pet/basket/basketList.dog">장바구니</a></li>
			<li><a href="${contextPath}/pet/order/orderList.dog">주문조회</a></li>  
			</c:if>
		</ul>
	</div>

	
</div><!-- // header_area -->

<!-- 메뉴 시작 -->    
<div class="tab_cate">    
	<div class="tabs_area">  
		<ul class="tabs">
			<li><a href="#tab1" class="tab_a1"><span>쇼핑몰</span></a></li>
			<li><a href="#tab2" class="tab_a2"><span>커뮤니티</span></a></li>
		</ul>
	</div>
    
	<div class="tab_container">
		<div class="con_position">
			<div id="tab1" class="tab_content">
				<div class="xans-element- xans-layout xans-layout-category">
					<div class="postion">
				        <ul>
							<li class="pst pst1 xans-record-"><a href="/pet/goods/goodsCategoryList.dog?goods_category=0">사료</a></li>
				            <li class="pst pst2 xans-record-"><a href="/pet/goods/goodsCategoryList.dog?goods_category=1">간식</a></li>
				            <li class="pst pst3 xans-record-"><a href="/pet/goods/goodsCategoryList.dog?goods_category=2">패션/의류</a></li>
				            <li class="pst pst4 xans-record-"><a href="/pet/goods/goodsCategoryList.dog?goods_category=3">목줄/야외</a></li>
				            <li class="pst pst5 xans-record-"><a href="/pet/goods/goodsCategoryList.dog?goods_category=4">생활/잡화</a></li>
				            <li class="pst pst6 xans-record-"><a href="#"><span>준비중</span></a></li>
							<li class="pst pst7 xans-record-"><a href="#"><span>준비중</span></a></li>
				        </ul>
					</div>
				</div>
			</div><!--//tab1 끝-->
		
			<div id="tab2" class="tab_content" style="display:none;">
				<div class="xans-element- xans-layout xans-layout-boardinfo board_postion">
					<ul>
						<li class="pst pst0"><a href="/pet/notice/noticeList.dog">공지사항</a></li>
			            <li class="pst pst1"><a href="/pet/pet_img/pet_imgList.dog">마이펫갤러리</a></li>
			            <li class="pst pst2"><a href="/pet/pet/petList.dog">분양게시판</a></li>
			            <li class="pst pst3"><a href="/pet/QnA/QnAList.dog">Q&amp;A</a></li>
			            <li class="pst pst4"><a href="/pet/review/reviewList.dog">구매후기</a></li>
			            <li class="pst pst5"><a href="#"><span>준비중</span></a></li>
						<li class="pst pst6"><a href="#"><span>준비중</span></a></li>
						<!-- <li class="pst pst7"><a href="/board/product/list.html?board_no=4"><span>구매후기</span></a></li>
						<li class="pst pst8"><a href="/front/php/b/board_list.php?board_no=3"><span>문의답변</span></a></li>
						<li class="pst pst9"><a href="/front/php/b/board_list.php?board_no=3"><span>문의답변</span></a></li> -->
					</ul>
				</div>
			</div>
		</div>
	</div>
</div><!--//메뉴 끝-->