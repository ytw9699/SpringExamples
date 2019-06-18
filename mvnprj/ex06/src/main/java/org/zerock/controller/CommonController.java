package org.zerock.controller;
	import org.springframework.security.core.Authentication;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PostMapping;
	import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class CommonController {

	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
		//는 Authentication 타입의 파라미터를 받도록 설계해서 필요한 경우에 사용자의 정보를 확인할 수 있도록 합니
		log.info("access Denied : " + auth);

		model.addAttribute("msg", "Access Denied 로그인 권한이 없습니다.");
	}

	@GetMapping("/customLogin")//URI는 반드시 GET 방식으로 접근하는 URI를 지정
	public void loginInput(String error, String logout, Model model) {
						//에러 메시지와 로그아웃 메시지를 파라미터로사용
		log.info("error: " + error);
		log.info("logout: " + logout);

		if (error != null) {
			model.addAttribute("error", "Login Error Check Your Account");
		}

		if (logout != null) {
			model.addAttribute("logout", "Logout!!");
		}
	}

	@GetMapping("/customLogout")
	public void logoutGET() {

		log.info("custom logout");
	}

	@PostMapping("/customLogout")
	public void logoutPost() {

		log.info("post custom logout");
	}

}
