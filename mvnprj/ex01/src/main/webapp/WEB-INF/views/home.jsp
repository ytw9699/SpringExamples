<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=utf-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<li><Strong>@RequestMapping("")</Strong>
	<ul>
		<li><a href="sample/">http://localhost:8080/sample/</a>:</li>
	</ul>
</li>
 
<li><Strong>@RequestMapping(value = "/basic", method = { RequestMethod.GET, RequestMethod.POST } </Strong>
	<ul>
		<li><a href="sample/basic">http://localhost:8080/sample/basic</a>:</li>
	</ul>
</li>

<li><Strong>@GetMapping("/basicOnlyGet")</Strong>
	<ul>
		<li><a href="sample/basicOnlyGet">http://localhost:8080/sample/basicOnlyGet</a>:</li>
	</ul>
</li>

<li><Strong>@GetMapping("/ex01")</Strong>
	<ul>
		<li><a href="sample/ex01?name=taewon&age=99">http://localhost:8080/sample/ex01?name=taewon&age=99</a>:</li>
	</ul>
</li>

<li><Strong>@GetMapping("/ex02")</Strong>
	<ul>
		<li><a href="sample/ex02?name=taewon&age=99">http://localhost:8080/sample/ex02?name=taewon&age=99</a>:</li>
	</ul>
</li>

<li><Strong>@GetMapping("/ex02List")</Strong>
	<ul>
		<li><a href="sample/ex02List?ids=111&ids=222&ids=333">http://localhost:8080/sample/ex02List?ids=111&ids=222&ids=333</a>:</li>
	</ul>
</li> 

<li><Strong>@GetMapping("/ex02Array")</Strong>
	<ul>
		<li><a href="sample/ex02Array?ids=111&ids=222&ids=333">http://localhost:8080/ample/ex02Array?ids=111&ids=222&ids=333</a>:</li>
	</ul>
</li> 

<li><Strong>@GetMapping("/ex02Bean")</Strong>
	<ul>
		<li><a href="sample/ex02Bean?list[0].name=aaa&list[2].name=bbb">http://localhost:8080/sample/ex02Bean?list[0].name=aaa&list[2].name=bbb</a>:</li>
	</ul>
</li> 

<li><Strong>@GetMapping("/ex03")</Strong>
	<ul>
		<li><a href="sample/ex03?title=test&dueDate=2018/01/21">http://localhost:8080/sample/ex02Bean?list[0].name=aaa&list[2].name=bbb</a>:</li>
	</ul>
</li> 

<li><Strong>@GetMapping("/ex04")</Strong>
	<ul>
		<li><a href="sample/ex04?name=aaa&age=11&page=9">http://localhost:8080/sample/ex04?name=aaa&age=11&page=9</a>:</li>
	</ul>
</li> 

<li><Strong>@GetMapping("/ex05")</Strong>
	<ul>
		<li><a href="sample/ex05">http://localhost:8080/sample/ex05</a>:</li>
	</ul>
</li> 

<li><Strong>@GetMapping("/ex06")</Strong>
	<ul>
		<li><a href="sample/ex06">http://localhost:8080/sample/ex06</a>:</li>
	</ul>
</li> 

<li><Strong>@GetMapping("/ex07")</Strong>
	<ul>
		<li><a href="sample/ex07">http://localhost:8080/sample/ex07</a>:</li>
	</ul>
</li> 

<li><Strong>@GetMapping("/exUpload")</Strong>
	<ul>
		<li><a href="sample/exUpload">http://localhost:8080/sample/exUpload</a>:</li>
	</ul>
</li> 

<li><Strong>예외처리예제1 500예제</Strong>
	<ul>
		<li><a href="sample/ex04?name=aaa&age=bbb">http://localhost:8080/sample/ex04?name=aaa&age=bbb</a>:</li>
	</ul>
</li> 

<li><Strong>존재하지않는 url 404 예제</Strong>
	<ul>
		<li><a href="dd">http://localhost:8080/dd</a>:</li>
	</ul>
</li> 


</body>
</html>
