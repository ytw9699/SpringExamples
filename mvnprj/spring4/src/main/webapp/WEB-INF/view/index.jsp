<%@ page contentType="text/html; charset=utf-8" %>
<html>
<body>
<img src="images/spring1.png">
<ul>
<li><Strong>example0: ModelAndView의 기본적 사용 </Strong>
	<ul>
	<li><a href="example0/hello.do">http://localhost:8080/spring4/example0/hello.do</a>:</li>
	</ul>
</li>
<li><Strong>example1: @ModelAttribute("command")로 자바빈꽂기</Strong>
	<ul>
	<li><a href="example1/newArticle.do">http://localhost:8080/spring4/example1/newArticle.do</a>:</li>
		</ul>
</li>
<li><Strong>example2:자바빈 안에 자바빈 값 꽂기 </Strong>
	<ul>
	<li><a href="example2/order.do">http://localhost:8080/spring4/example2/order.do</a>:</li>
		</ul>
</li>
<li><Strong>example3:@RequestParam의 특성 </Strong>
	<ul>
	<li><a href="example3/internal.do?query=q&p=2">http://localhost:8080/spring4/example3/internal.do?query=q&p=2</a>:</li>
	<li><a href="example3/internal.do?query=q">http://localhost:8080/spring4/example3/internal.do?query=q</a>:</li>
	<li><a href="example3/internal.do">http://localhost:8080/spring4/example3/internal.do</a>:</li>
	<li><a href="example3/external.do?query=p&p=22">http://localhost:8080/spring4/example3/external.do?query=p&p=22</a>:</li>
	<li><a href="example3/external.do?query=p">http://localhost:8080/spring4/example3/external.do?query=p</a>:</li>
	<li><a href="example3/external.do">http://localhost:8080/spring4/example3/external.do</a>:</li>
	</ul>
</li>
<li><Strong>example4: 쿠키</Strong>
	<ul>
	<li><a href="example4/cookie/loginForm.do">http://localhost:8080/spring4/example4/cookie/loginForm.do</a>:</li>
	<li><a href="example4/cookie/loginForm.do2">http://localhost:8080/spring4/example4/cookie/loginForm.do2</a>:</li>
	</ul>
</li>
<li><Strong>example5: @PathVariable</Strong>
	<ul>
	<li><a href="example5/member.do/testID/testID">http://localhost:8080/spring4/example5/member.do/{memberId}/{characterId}</a>:기본</li>
	<li><a href="example5/member.do/987654">http://localhost:8080/spring4/example5/member.do/{memberId}</a>:Long형값만 memberId2로 이름 바꿔서 받기</li>
	<li><a href="example5/game/users/testID/characters/testID">http://localhost:8080/spring4/example5/game/users/{userId}/characters/{characterId}</a>:model.addAttribute.addAttribute 체이닝방식</li>
	</ul>
</li>
<li><Strong>example6: GameSearchController </Strong>
	<ul>
	<li><a href="example6/search/main.do">http://localhost:8080/spring4/example6/search/main.do</a>:</li>
	</ul>
</li>
<li><Strong>example7:세션 </Strong>
	<ul>
	<li><a href="example7/session/login.do">http://localhost:8080/spring4/example7/session/login.do</a>: <Strong>HttpSession을 이용</Strong></li> 
	<li><a href="example7/session/login.do2">http://localhost:8080/spring4/example7/session/login.do2</a>: <Strong>request.getSession()을 이용</Strong></li> 
	<li><a href="example7/session/login.do3">http://localhost:8080/spring4/example7/session/login.do3</a>: <Strong>HttpSessionr과 request.getSession()의 차이점</Strong></li> 
	<li><a href="example7/session/step1">http://localhost:8080/spring4/example7/session/step1</a>:<Strong>@SessionAttributes를 이용</Strong></li> 
	</ul>
</li>

<li><Strong>example8:기본 유효성검증 및 초기화 작업 </Strong>
	<ul>
	<li><a href="example8/account/create.do">http://localhost:8080/spring4/example8/account/create.do</a>:</li>
	</ul>
</li>

<li><Strong>example9:풀패스설정 </Strong>
	<ul>
	<li><a href="example9/game/info">http://localhost:8080/spring4/example9/game/info</a>:</li>
	<li><a href="example9/hello/haha">http://localhost:8080/spring4/example9/hello/haha</a>:-스프링4</li>
	<li><a href="example9/hello/haha2">http://localhost:8080/spring4/example9/hello/haha2</a>:-스프링4</li>
	</ul>
</li>
<li><Strong>example10:유효성검증-@Valid이용(@InitBinder),reject를 이용,form:form태그</Strong>
	<ul>
	<li><a href="example10/login.do">http://localhost:8080/spring4/example10/login.do</a>:</li>
	</ul>
</li>
<li><Strong>example11:업로드 <Strong>
	<ul>
	<li><a href="example11/submission.do1">http://localhost:8080/spring4/example11/submission.do1</a>:@RequestParam 사용</li>
	<li><a href="example11/submission.do2">http://localhost:8080/spring4/example11/submission.do2</a>:MultipartHttpServletRequest 사용</li>
	<li><a href="example11/submission.do3">http://localhost:8080/spring4/example11/submission.do3</a>:커맨드 객체 사용</li>
	</ul>
</li>
<li><Strong>example12: date타입을 자바빈에 자동변환해서 꼽기 @InitBinder Annotation과 커스텀 데이터 타입 변환 처리<Strong>
	<ul>
	<li><a href="example12/logquery.do">http://localhost:8080/spring4/example12/logquery.do</a>:</li>
	</ul>
</li>
<li><Strong>example13:겟방식 이용 HttpServletRequest, model이용법 <Strong>
	<ul>
	<li><a href="example13/HttpServletRequest.do?id=testID">http://localhost:8080/spring4/example13/HttpServletRequest.do?id=testID</a>:</li>
	</ul>
</li>
<li><Strong>example14:checkbox의 여러값(String,boolean등)을 리스트와 배열로 가져오기 <Strong>
	<ul>
	<li><a href="example14/Checkbox.do">http://localhost:8080/spring4/example14/Checkbox.do</a>:</li>
	</ul>
</li>
<li><Strong>example15: 다운로드 <Strong>
	<ul>
	<li><a href="example15/DownloadForm">http://localhost:8080/spring4/example15/DownloadForm</a>:</li>
	</ul>
</li>
<li>example 16 웹소켓,SockJS:
	<ul>
	<li><a href="echo-ws.html">/echo-ws.html</a>: 웹 소켓 이용 에코. EchoHandler</li>
	<li><a href="chat-ws.jsp">/chat-ws.jsp</a>: 웹 소켓 이용 채팅. ChatWebSocketHandler</li>
	<li><a href="echo-sockjs.html">/echo-sockjs.html</a>: SockJS 이용 에코</li>
	<li><a href="chat-sockjs.jsp">/chat-sockjs.jsp</a>: SockJS 이용 채팅</li>
	</ul>
</li>
<li><Strong>example17: 인터셉터 <Strong>
	<ul>
	<li><a href="example17/interceptor.do">http://localhost:8080/spring4/example17/interceptor.do</a>:</li>
	<li><a href="example17/interceptor2.do">http://localhost:8080/spring4/example17/interceptor2.do</a>:</li>
	</ul>
</li>
<li><Strong>example18:  <Strong>
	<ul>
	</ul>
</li>

</body>
</html>
