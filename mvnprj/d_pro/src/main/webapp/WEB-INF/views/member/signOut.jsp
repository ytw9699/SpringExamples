<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<link rel="stylesheet" type="text/css" href="/TorrentBox/resources/css/import.css" />
<link rel="stylesheet" type="text/css" href="/TorrentBox/resources/css/owl.carousel.css" />
<link rel="stylesheet" type="text/css" href="/TorrentBox/resources/css/owl.transitions.css" />
<link rel="stylesheet" type="text/css" href="/TorrentBox/resources/css/default.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript">
	function memberDeleteChk(){
		if(document.memberDeleteform.passwd.value == ""){
			alert("비밀번호를 입력하세요.");
			document.memberDeleteform.passwd.focus();
			return false;
		}
		return true;;
	}
</script>
<div class="mypage_grp">
	
	<div class="mypage_ct">
		<h3 class="sub_tit">회원 탈퇴</h3>
<br/><br/>
<div class="sign_grp">
	<div class="idpw_grp">
		<form action="memberDelete.dog" method="post" name="memberDeleteform" onsubmit="return memberDeleteChk()">
			<fieldset> 
				<div class="tbl_type_01">
				<table style="width:410px; align:center;">
		<tr>
			<td>
			<font size ="2">D-편한세상 회원탈퇴 시 회원님께서 보유하신 정보가 즉시 삭제 됩니다.</font><br><br>
			<font size ="2"><strong>[주의] D-편한세상 탈퇴 전, 아래 사항을 숙지 하여 주시기 바랍니다.</strong></font><br><br>
			<font size="2"><strong> 30일간 회원 재가입이 불가능합니다.</strong></font><br>
			- <font size ="2">회원 탈퇴 후, 30일 경과 후 재가입할 수 있습니다.</font><br><br><br>
			<font size ="2"><strong> 탈퇴 후 삭제 내역</strong></font><br>
			<font size ="2">* 회원 탈퇴를 하시면 회원 정보와 개인 정보가 삭제되며 <br>&nbsp;&nbsp;데이터는 영원히 복구 되지 않습니다.</font><br>
		
			</td>
		</tr>
	</table>
					<table>
					
						<caption>비밀번호입력으로 회원탈퇴하기</caption>
						<colgroup>
							<col style="width:120px;" />
							<col />
						</colgroup>
						<tbody>
		
							<tr>
								<th scope="row">비밀번호</th>
								<td><input type="password" class="txt w220" name="password" /></td>
								
							</tr>
						</tbody>
					</table>
				</div>
				<div class="btn_type_04">
					<a href="/pet/main.dog" class="btn btnC_03 btnF_02 mr10">
						<span>취소</span>
					</a>
					<span class="btn btnC_04 btnF_02">
						<input type="submit" value="탈퇴" name="leave" />
					</span>
				</div>
			</fieldset>
		</form>
	</div>
</div>
</div>
</div>
<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원탈퇴</title>
<script type="text/javascript">
function memberDeleteCheck () {
	if(document.memberDeleteform.passwd.value=="") {
		alert("비밀번호를 입력하세요");
		document.memberDeleteform.passwd.focus();
		return false;
	}
	return true;
}
</script>
</head>
<body>

<form name="memberDeleteform" action="memberDelete.torrent" method="post" onsubmit="return memberDeleteCheck()">
	<img src="/TeraBox/image/h3_mypage_21.gif" alt="회원탈퇴"/>
	<hr width="740" size="2" color="59CABD" /><br>
	<table width="740" cellspacing="0" cellpadding="0" border="0" align="center">
		<tr>
			<td>
			<font size ="2">토렌트 박스 회원탈퇴 시 회원님께 보유하신 정보가 즉시 삭제 됩니다.</font><br><br>
			<strong>[주의] 토렌트 박스 탈퇴 전, 아래 사항을 숙지 하여 주시기 바랍니다.</strong><br><br>
			<img src="/TeraBox/image/bu1.gif"><strong> 30일간 회원 재가입이 불가능합니다.</strong><br>
			- <font size ="2">회원 탈퇴 후, 30일 경과 후 재가입할 수 있습니다.</font><br><br><br>
			<img src="/TeraBox/image/bu1.gif"><strong> 탈퇴 후 삭제 내역</strong><br>
			<font size ="2">* 회원 탈퇴 하시면 회원 정보와 개인 정보가 삭제되며 데이터는 영원히 복구 되지 않습니다.</font><br>
			- <font size ="2">관람권 및 쿠폰</font><br>
			- <font size ="2">영화 관람 내역</font><br><br>
			</td>
		</tr>
	</table>
	<hr width="740" size="2" color="59CABD" /><br>
	<table width="740" cellspacing="0" cellpadding="0" border="0" align="center">
		<tr>
			<td align="left">
			<font size ="2">회원님의 비밀번호를 입력하시고 [탈퇴] 버튼을 클릭해주세요.</font>
			</td>
		</tr>
		<tr>
			<td bgcolor="f5f5f5" align="center">
			<b>비밀번호 입력</b><input type="password" name="passwd" size = "12" maxlength="6"/><br><br>
			</td>
		</tr>
	</table><br>
	<table>
		<tr>
			<td align="right">
			<input type="image" src="/TeraBox/image/bt_out_02.gif">
				<a href="main.torrent"><img src="/TeraBox/image/no.gif" alt="취소"/></a>
			</td>
		</tr>
	</table>
</form>
</body>
</html> --%>