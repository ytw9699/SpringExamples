package madvirus.spring.chap06.controller;

	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestMapping;

	@Controller
	public class GameInfoController {

		@RequestMapping("/game/info")
		public String gameInfo() {
			return "game/users/info";//포워딩
		}
		
		@RequestMapping("/game/list")
		public String gameList() {
			return "game/list";//포워딩
		}
	}
