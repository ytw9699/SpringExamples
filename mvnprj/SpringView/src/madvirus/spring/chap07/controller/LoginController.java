package madvirus.spring.chap07.controller;
	import java.util.ArrayList;
	import java.util.List;
	import org.springframework.stereotype.Controller;
	import org.springframework.validation.BindingResult;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
@Controller
@RequestMapping("/login/login.do")
public class LoginController {

	private Authenticator authenticator;

	@ModelAttribute("login")//login이름 동일
	public LoginCommand formBacking() {
		return new LoginCommand();//자바빈
	}
	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return "loginForm";//이부분이 타일즈 정의를 뒤지는것  <definition name="loginForm"
	}
	@RequestMapping(method = RequestMethod.POST)
	public String submit(@ModelAttribute("login") LoginCommand loginCommand,//login이름 동일
			BindingResult result) {//유효성검증
		new LoginCommandValidator().validate(loginCommand, result);
		if (result.hasErrors()) {
			return "loginForm";
		}
		try {
			authenticator.authenticate(loginCommand.getId(), loginCommand.getPassword());
			return "loginSuccess";
		} catch (AuthenticationException ex) {
			result.reject("invalidIdOrPassword", new Object[] { loginCommand.getId() }, null);
			return "loginForm";
		}
	}
	@ModelAttribute("loginTypes")
	protected List<String> referenceData() throws Exception {
		List<String> loginTypes = new ArrayList<String>();
		loginTypes.add("일반회원");
		loginTypes.add("기업회원");
		loginTypes.add("헤드헌터회원");
		return loginTypes;
	}
	public void setAuthenticator(Authenticator authenticator) {
		this.authenticator = authenticator;
	}

	}