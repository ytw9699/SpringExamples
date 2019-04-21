package net.example9;

	import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

	@Controller
	public class FullpathController {

		@RequestMapping("/example9/game/info")
		public String gameInfo() {
			return "example9/info";//포워딩
		}
		@RequestMapping({"/example9/hello/haha"
				,"/example9/hello/haha2"})//여러 경로 집어넣기
		public String hello(Model model) {
			model.addAttribute("greeting", "안녕하세요");
			return "example9/hello";
		}
	}
