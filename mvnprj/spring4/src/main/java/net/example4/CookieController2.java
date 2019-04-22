package net.example4;
	import javax.servlet.http.Cookie;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.CookieValue;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.servlet.ModelAndView;
@Controller
public class CookieController2 {
	@RequestMapping("/example4/cookie/loginForm.do2")//첫 로그인 화면 or 아이디 저장후 로그아웃 후 로그인 화면
	public ModelAndView login(@CookieValue(value = "ID", required=false) String id) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("example4/loginForm2");
		mav.addObject("KHID",id);
		return mav;
	}
	@RequestMapping("/example4/cookie/make.do2")//아이디 쿠키값 저장 and 로그인 시도
	public String make(HttpServletRequest request,HttpServletResponse response){
		String id = request.getParameter("id");
			response.addCookie(new Cookie("ID",id));
			return "example4/login2";
	}
	@RequestMapping("/example4/cookie/logout.do2")//아이디 저장하지않고 로그아웃 후 로그인 화면
	public String logout(HttpServletResponse response) {
		Cookie DeleteCookie = new Cookie("ID","");
		DeleteCookie.setMaxAge(0);//쿠키삭제
		response.addCookie(DeleteCookie);
		return "example4/loginForm2";
	}
}