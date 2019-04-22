package net.example4;
	import java.io.IOException;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.servlet.ModelAndView;
@Controller
public class CookieController {
	@RequestMapping("/example4/cookie/loginForm.do")//첫 로그인 화면 or 아이디 저장후 로그아웃 후 로그인 화면
	public ModelAndView login(HttpServletRequest request) throws IOException{
		CookieBox CookieBox = new CookieBox(request);
		String id = CookieBox.getValue("ID");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("example4/loginForm");
		mav.addObject("KHID",id);
		return mav;
	}
	@RequestMapping("/example4/cookie/make.do")//아이디 쿠키값 저장 and 로그인 시도
	public String make(HttpServletRequest request,HttpServletResponse response)throws IOException{
		String id = request.getParameter("id");
			response.addCookie(CookieBox.createCookie("ID",id));
			return "example4/login";
	}
	@RequestMapping("/example4/cookie/logout.do")//아이디 저장하지않고 로그아웃 후 로그인 화면
	public String logout(HttpServletResponse response) throws IOException{
		response.addCookie(CookieBox.deleteCookie("ID","",0));//쿠키를 시간을 0주고 다시 생성해서 삭제하는것이다.
		return "example4/loginForm";
	}
	}
