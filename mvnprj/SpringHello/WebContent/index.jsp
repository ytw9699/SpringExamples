<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>스프링 3, 6장 예제</title>
    </head>
    <body>
    	<ul>
    		<li><a href="<c:url value='/hello.do' />">/hello.do</a> (HelloController)</li>
    		<li><a href="<c:url value='/hello2.do' />">/hello2.do</a> (HelloController2)</li>
    		<li><a href="<c:url value='/article/newArticle2.do?parentId=0&title=aa&content=bb' />">/article/newArticle2.do</a> (NewArticleController2, get,post방식예제)</li>
    		<li><a href="<c:url value='/article/newArticle.do' />">/article/newArticle.do</a> (NewArticleController, 커맨드 객체(자바빈),객체관계설정DI,get,post방식예제)</li>
    		<li><a href="<c:url value='/order/order.do' />">/order/order.do</a> (OrderController, 커맨드 객체로 List 받기 예제)</li>
    		<li><a href="<c:url value='/search/internal.do' />?query=q&p=2">/search/internal.do?query=q&p=2</a></li>
    		<li><a href="<c:url value='/search/internal.do' />?query=q">/search/internal.do?query=q</a></li>  
    		<li><a href="<c:url value='/search/internal.do' />">/search/internal.do</a></li>  
    		<li><a href="<c:url value='/search/external.do' />">/search/external.do</a>(SearchController, @RequestParam 예제)</li>  
    		<li><a href="<c:url value='/search/external.do' />?query=p">/search/external.do?query=p</a></li>
    		<li><a href="<c:url value='/search/external.do' />?query=p&p=22">/search/external.do?query=p&p=22</a></li> 
    		<li><a href="<c:url value='/cookie/make.do' />">/cookie/make.do</a></li>
    		<li><a href="<c:url value='/cookie/view.do' />">/cookie/view.do</a>
    		 (CookieController, @CookieValue 예제)</li>
    		<li><a href="<c:url value='/header/check.do' />">/header/check.do</a>
    		 (HeaderController, @RequestHeader 예제)</li>
    		 <li><a href="<c:url value='/header/check2.do' />">/header/check2.do</a>
    		 (HeaderController, @RequestHeader 예제)</li>
    		<li><a href="<c:url value='/search/main.do' />">/search/main.do</a>
    		 (GameSearchController, @ModelAttribute 예제)</li>
    		<li><a href="<c:url value='/account/create.do' />">/account/create.do</a>
    		 (CreateAccountController, 자바빈 기본값 설정 , @ModelAttribute 및 폼 값 검증 예제)</li>
    		<li><a href="<c:url value='/game/info/madvirus' />">/game/info/madvirus</a>
    		 (GameInfoController,전체 경로와 Servlet 기반 경로 매칭 설정)</li>
    		 <li><a href="<c:url value='game/list' />">/game/list</a>
    		 (GameInfoController,전체 경로와 Servlet 기반 경로 매칭 설정)</li>
    		<li><a href="<c:url value='/game/users/madvirus/characters/10' />">/game/users/{userId}/characters/{characterId}</a>
    		 (GameInfoController, @PathVariable 예제)</li>
    		<li><a href="<c:url value='/login/login.do' />">/login/login.do</a>
    		 (LoginController, @InitBinder 및 @Valid를 이용한 폼 값 검증,유효성검증)</li>
    		<li><a href="<c:url value='/report/submission.do' />">/report/submission.do</a>
    		 (ReportSubmissionController, 파일 업로드 예제)</li>
    		<li><a href="<c:url value='/log/query.do' />?from=2010-04-01&to=2010-04-30">/log/query.do</a>
    		 (QueryLogController, @InitBinder 및 WebBindingInitializer 예제)</li>
    		<li><a href="<c:url value='/event/list.do' />">/event/list.do</a>
    		 (EventController, HandlerInterceptor 예제)</li>
    		<li><a href="<c:url value='/search/game.do' />">/search/game.do</a>
    		 (GameSearchController, @ExceptionHandler 예제)</li>
    		<li><a href="<c:url value='/math/divide.do' />?op1=1&op2=0">/math/divide.do?op1=1&amp;op2=0</a>
    		 (ArithmeticOperatorController, SimpleMappingExceptionResolver 예제)</li>
    		<li><a href="<c:url value='/guestmessage/xml.do' />">/guestmessage/xml.do</a>
    		 (GuestMessageController, @ResponseBody 예제)</li>
    	</ul>
    </body>
</html>
