package madvirus.spring.chap06.controller;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.ui.ModelMap;
	import org.springframework.web.bind.annotation.PathVariable;
	//http://localhost:8080/SpringHello/game/users/madvirus/characters/10
	@Controller
	@RequestMapping("/game/users/{userId}")
	public class CharacterInfoController {

		@RequestMapping("/characters/{characterId}")
		public String characterInfo(@PathVariable String userId,
				@PathVariable int characterId, ModelMap model) {
			model.addAttribute("userId", userId);//jsp에서 가져다씀
			model.addAttribute("characterId", characterId);
			return "game/character/users/info";
		}
	}