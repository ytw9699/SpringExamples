package net.example5;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.PathVariable;
@Controller
public class PathVariableController {
	@RequestMapping("/example5/member.do/{memberId}/{characterId}")
	public String member(@PathVariable String memberId,@PathVariable String characterId, Model model) {
		model.addAttribute("memberId", memberId);
		//model.addAttribute("characterId", characterId);//사실 이렇게 써주지않아도 위에있는 characterId를 가져다 쓸수있음..참 대단
		return "example5/hello";
	}
	@RequestMapping("/example5/member.do/{memberId}")
		public String member2(@PathVariable("memberId") Long memberId2, Model model) {
			model.addAttribute("memberId", memberId2);
			//memberId2이름이 다르면 이렇게설정, 그리고 스트링으로 전달해서 롱형값으로 자동변환 기본값들은 변경됨
			return "example5/hello";
		}
	//http://localhost:8080/spring4/example5/game/users/{userId}/characters/{characterId}
	@RequestMapping("/example5/game/users/{userId}/characters/{characterId}")
	public String member3(@PathVariable String userId,@PathVariable String characterId, Model model) {
		model.addAttribute("userId", userId).addAttribute("characterId", characterId);
		//체이닝 방식
		return "example5/hello";
	}
}

