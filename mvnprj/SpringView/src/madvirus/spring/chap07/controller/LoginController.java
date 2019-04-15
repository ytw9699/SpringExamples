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

	@ModelAttribute("login")//login�̸� ����
	public LoginCommand formBacking() {
		return new LoginCommand();//�ڹٺ�
	}
	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return "loginForm";//�̺κ��� Ÿ���� ���Ǹ� �����°�  <definition name="loginForm"
	}
	@RequestMapping(method = RequestMethod.POST)
	public String submit(@ModelAttribute("login") LoginCommand loginCommand,//login�̸� ����
			BindingResult result) {//��ȿ������
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
		loginTypes.add("�Ϲ�ȸ��");
		loginTypes.add("���ȸ��");
		loginTypes.add("�������ȸ��");
		return loginTypes;
	}
	public void setAuthenticator(Authenticator authenticator) {
		this.authenticator = authenticator;
	}

	}