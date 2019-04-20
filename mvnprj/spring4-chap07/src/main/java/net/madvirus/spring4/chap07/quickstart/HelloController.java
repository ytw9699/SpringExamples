package net.madvirus.spring4.chap07.quickstart;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
@Controller
public class HelloController {
	@RequestMapping("/hello.do")
	public String hello(HttpServletRequest request, Model model) {
		String id2 = request.getParameter("id");
		model.addAttribute("id", id2);
		return "HttpServletRequest";
	}
}




