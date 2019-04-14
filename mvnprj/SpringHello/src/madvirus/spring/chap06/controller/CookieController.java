package madvirus.spring.chap06.controller;
	import javax.servlet.http.Cookie;
	import javax.servlet.http.HttpServletResponse;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.CookieValue;
	import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class CookieController {
	@RequestMapping("/cookie/make.do")
	public String make(HttpServletResponse response) {
		response.addCookie(new Cookie("auth", "1"));
		return "cookie/made";
	}
	@RequestMapping("/cookie/view.do")//클라이언트가 보낸 auth쿠키이름에 해당하는 쿠키의 값1을 받아서 스트링객체에 저장한다
	public String view(@CookieValue(value = "auth", required=false) String auth) {
		System.out.println("auth 쿠키: " + auth);//쿠키값 받아서 출력
		return "cookie/view";    
		//view메소드가 동작하면서 요청을할때 쿠키의 이름 auth라는 이름의 쿠키를 가지고 요청을했으면
		//그값을 스트링객체에 저정해라 , 클라이언트가 가져온 auth 이름의 쿠키를
		}
	}
//	http://localhost:8080/SpringHello/cookie/make.do
//http://localhost:8080/SpringHello/cookie/view.do
