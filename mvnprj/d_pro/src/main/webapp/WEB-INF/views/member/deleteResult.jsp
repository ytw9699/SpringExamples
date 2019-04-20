<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:if test="${deleteCheck == 1 }">
<br />
<div class="sign_grp">
	
	<div class="sign_box">
		<div class="step_03">
			<p class="success">
			<br><br><br><br><br><br><br><br>
			<strong>${member.name}</strong> 고객님 <strong>회원탈퇴</strong>가 <strong>완료</strong>되었습니다.</p>
			
		</div>
	</div>

	<div class="btn_type_04">
		<a href=".." class="btn btnC_04 btnF_02">
			<span>메인으로</span>
		</a>
	</div>
</div>

</c:if>

<c:if test="${deleteCheck == -1 }">

<br/>
<div class="sign_grp">
	
	<div class="sign_box">
		<div class="step_03">
			<p class="success">
			<br><br><br><br><br><br><br><br>
			<strong>${member.name}</strong> 고객님 <strong>비밀번호</strong>가 <strong>틀렸습니다</strong>.</p>
			
		</div>
	</div>

	<div class="btn_type_04">
		<a href=".." class="btn btnC_04 btnF_02" onClick="back()">
			<span>돌아가기</span>
		</a>
	</div>
</div>



</c:if>








<script type="text/javascript">

	function back() {
		history.back();
	}
	
</script>
