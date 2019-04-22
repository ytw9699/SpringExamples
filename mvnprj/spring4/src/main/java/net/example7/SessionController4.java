package net.example7;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.SessionAttributes;
	import org.springframework.web.bind.support.SessionStatus;
@Controller
	@SessionAttributes("JoinForm")
	public class SessionController4 {
	@ModelAttribute("JoinForm")
	public JoinForm formData() {//리퀘스트 영역에 두번째로올려줌//세션에 값이있으면 그걸올려줌!
		return new JoinForm();
	}
	@RequestMapping("/example7/session/step1")
	public String step1() {
		return "example7/step1";//로그인창
	}
	/*@RequestMapping("/example7/session/step1")//이 메소드는 위 두 메소드와 같은것!
	public String step1(Model model){
	model.addAttribute("JoinForm",new JoinForm());
	return "example7/step1";//로그인창
	}*/
	@RequestMapping("/example7/session/step2")//여기서 리퀘스트영역에 첫번째올려주고
	public String step2(@ModelAttribute("JoinForm") JoinForm JoinForm) {
		return "example7/step2";
	}
	@RequestMapping("/example7/session/step3")
	public String step3(@ModelAttribute("JoinForm") JoinForm JoinForm) {
		return "example7/step3";//작성본 미리보기
	}
	@RequestMapping("/example7/session/done")
	public String done(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "example7/step4";//최종제출본 보기
	}
	@RequestMapping("/example7/session/step5")
	public String step5() {
		return "example7/step5";
	}
}
