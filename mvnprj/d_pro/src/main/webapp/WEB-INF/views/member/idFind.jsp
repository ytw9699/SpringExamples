
 <%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<script type="text/javascript" src="/pet/resources//js/common.js"></script>
<!-- 해당 JS는 플래시를 사용하기 위한 스크립트입니다. -->


<script type="text/javascript" src="/pet/resources/js/cc.js"></script>


<div id="container">
	<div class="contents1">

		<form action="memberIdFind.dog" method="post" name="memberFindForm"
			onsubmit="return memberFindChk()">
			<fieldset>
				<h3><center>
					<img src="/pet/resources/images/SkinImg/h3_find_id.GIF"
						alt="아이디 찾기" />
				</center></h3>

				<div class="findId">
					<table>

						<colgroup>
							<col style="width: 120px;" />
							<col />
						</colgroup>
						<tbody>
							<tr>
								<th scope="row">이름</th>
								<td><input type="text" class="txt w220" name="name" /></td>
							</tr>
							<tr>
								<th scope="row">이메일</th>
								<td><input type="text" class="txt w220" name="email" /></td>
							</tr>
						</tbody>
					</table>
				</div>
				
	
				
				<div class="btn_type_04">

					<span class="btn btnC_04 btnF_02"> <input type="submit"
						value="찾기" />
					</span> <a href="javascript:this.close();">닫기</a>
				</div>
			</fieldset>
		</form>
	</div>
</div>

