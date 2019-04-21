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
	HttpSession session1 = request.getSession();
	//기존에 세션이 생성되어있으면 그걸 그대로 받고 
	//생성이 안되어있으면 새로 세션 객체를 만듬?
	System.out.println(session1);
	return "example7/make3";//로그인하고 여부 확인
	}
@RequestMapping("/example7/session/check.do3")
public String make3(HttpSession session2) {
	//기존에 세션이 생성되어있으면 그걸 그대로 받고 
	//생성이 안되어있으면 새로 세션 객체를 만들지 않고 선언만 한다?
	System.out.println(session2);
	return "example7/login3";//로그인하고 여부 확인
	}
}
