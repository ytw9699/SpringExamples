package madvirus.spring.chap06.controller;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestMapping;
	import javax.servlet.http.HttpServletRequest;
	import java.util.Enumeration;
	@Controller
	public class HeaderController2 {
		@RequestMapping("/header/check2.do")
		public String check(HttpServletRequest request){
		Enumeration headerEnum = request.getHeaderNames();
		while(headerEnum.hasMoreElements()) {
			String headerName = (String)headerEnum.nextElement();
			String headerValue = request.getHeader(headerName);
			System.out.println(headerName);
			System.out.println(headerValue);
		}
	return "header/pass2";
	}
}
