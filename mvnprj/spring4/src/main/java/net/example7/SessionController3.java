package net.example7;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class SessionController3 {
@RequestMapping("/example7/session/login.do3")
public String login() {
return "example7/login3";//로그인창
}
@RequestMapping("/example7/session/make.do3")
public String make(HttpServletRequest request) {
	HttpSession session1 = request.getSession();//여기서는 세션을 직접적으로 받아주거나 새로 생성한거고?
	System.out.println(session1);
	return "example7/make3";//로그인하고 여부 확인
	}
@RequestMapping("/example7/session/check.do3")
public String make3(HttpSession session2) {
	 /*HttpSession 타입의 파라미터를 가질 경우 알아서 세션이 생성된다는 점에 유의해야 한다. 즉, 기존에 세션이 존재한다면 해당 세션이
	 전달되고 그렇지 않다면 새로운 세션이 생성되고 관련 HttpSession 인스턴스가 파라미터에 전달된다. 따라서, HttpSession
	 타입의 파라미터는 항상 null이 아니다.*/
	System.out.println(session2);
	return "example7/login3";//로그인하고 여부 확인
	}
}
