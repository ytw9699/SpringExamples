package net.example7;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestMapping;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpSession;
@Controller
	public class SessionController2 {
@RequestMapping("/example7/session/login.do2")
	public String login() {
return "example7/login2";//로그인창
}
@RequestMapping("/example7/session/make.do2")
	public String make(HttpServletRequest request) {
	HttpSession session = request.getSession();
	session.setAttribute("sessionid", "testId");
return "example7/make2";//로그인하고 여부 확인
}

@RequestMapping("/example7/session/logout.do2")
	public String logout(HttpServletRequest request) {
	HttpSession session = request.getSession();
	session.invalidate();
return "example7/login2";//로그아웃후 로그인 여부 확인
}
}
