package net.example17;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class interceptorController {
	@RequestMapping("/example17/interceptor.do")
	public String form() {
		return "example17/interceptor";//포워딩
	}
	@RequestMapping("/example17/interceptor2.do")
	public String form2() {
		return "example17/interceptor2";//포워딩
	}   
}

