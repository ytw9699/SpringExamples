package net.example13;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.RequestMapping;
	import javax.servlet.http.HttpServletRequest;
@Controller
public class HttpServletRequestController {
	@RequestMapping("/example13/HttpServletRequest.do")
	public String hello(HttpServletRequest request, Model model) {
		String id2 = request.getParameter("id");
		model.addAttribute("id", id2);
		return "example13/HttpServletRequest";
	}
}