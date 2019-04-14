package madvirus.spring.chap06.controller;

import javax.validation.Valid;

import madvirus.spring.chap06.service.AuthenticationException;
import madvirus.spring.chap06.service.Authenticator;
import madvirus.spring.chap06.service.LoginCommand;
import madvirus.spring.chap06.validator.LoginCommandValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login/login.do")
public class LoginController {

	private String formViewName = "login/form";
	
	@Autowired
	private Authenticator authenticator;//�����پ����� ��ü����
	//MockAuthenticator
	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return formViewName;//"login/form";
	}

	@ModelAttribute
	public LoginCommand formBacking() {
		return new LoginCommand();
	}

	@RequestMapping(method = RequestMethod.POST)//new MemberInfoValidator()��ü���������̾���
	//LoginCommand�ڹٺ� ��ü�� ���ؼ� @Valid�� ����//�׷��� �ڹٺ�ü�� ��ȿ�������� �ϵ��� �����//�ڿ��� �� �ڼ�������
	public String submit(@Valid LoginCommand loginCommand, //@Valid��ȿ������
			BindingResult result) {
		//@Valid�� ������ ������ ��ȿ���������ؾ��� �ٵ� � �븮�����Ͱ� ���ְ� ��ȿ�������ϴ����� ����
			//�׺κ��� @InitBinder������̼��� ���� �޼ҵ尡 �ϴ°�
	//new LoginCommandValidator().validate(loginCommand, result);//�̰� ����
		if (result.hasErrors()) {
			return formViewName;//��ȿ��������� ������������ �ٽ� ������
}
try {
	//�α������� ���� �Է¾�������� rejectvalue�� ���°Ű�,�Է������ ���ϰ� ��ư�����µ� �α��ο� �����Ҷ�
	//�ƴϸ� �ֹι�ȣ�� �Է��ߴµ� �տ��� 6�ڸ��Է��ؾ��ϴµ� reject��� �ɷ� �����ؼ� ������ �����ؼ� �۾��Ҽ��ִ�
	authenticator.authenticate(loginCommand);//���۵� ���̵� �н����� �̿��ؼ� �α��νõ�
	return "redirect:/index.jsp";//���������� �����̷�Ʈ
} catch (AuthenticationException e) {//�α��� ���� �����߻��� �����޽�������
	result.reject("invalidIdOrPassword", new Object[] { loginCommand.getUserId(),loginCommand.getPassword() }, null);
	//result.reject("invalidIdOrPassword", new Object[] { loginCommand.getUserId()}, "�߰��޽���");
	return formViewName;  //System.out.println(classGroup[0]);//����
}
	}
	@InitBinder
	protected void initBinder(WebDataBinder binder) {//�̰� ����������ϴ°�
		binder.setValidator(new LoginCommandValidator());
	}//�� �븮������ ��ü�� ���ؼ� ��ȿ�������� �ϰԵȴ�
	//new LoginCommandValidator().validate(loginCommand, result);//�̰� ����
	public void setAuthenticator(Authenticator loginService) {
		this.authenticator = loginService;//MockAuthenticator
	}
}
/*reject(String errorCode) //�ڹٺ� ��ü ��ü ������ ��������
: ��ü ��ü�� ���� �۷ι� ���� Code�� �߰��Ѵ�.
- reject(String errorCode, String defaultMessage)
: ��ü ��ü�� ���� �۷ι� ���� Code�� �߰��Ѵ�. ���� Code�� ���� Message�� �������� ���� ��� defaultMessage�� ����Ѵ�.
- reject(String errorCode, Object[] errorArgs, String defaultMessage)
: ��ü ��ü�� ���� �۷ι� ���� Code�� �߰��Ѵ�. Message ���ڷ� errorArgs�� �����Ѵ�. ���� Code�� ���� Message�� �������� ����
  ��� defaultMessage�� ����Ѵ�.
- rejectValue(String field, String errorCode)//�ڹٺ�ȿ��� ���� �ϳ��ϳ��� ���� ���� ����
: �ʵ忡 ���� ���� Code�� �߰��Ѵ�.
- rejectValue(String field, String errorCode, String defaultMessage)
: �ʵ忡 ���� ���� Code�� �߰��Ѵ�. ���� Code�� ���� Message�� �������� ���� ��� defaultMessage�� ����Ѵ�.
- rejectValue(String field, String errorCode, Object[] errorArgs, String defaultMessage)
: �ʵ忡 ���� ���� Code�� �߰��Ѵ�. Message ���ڷ� errorArgs�� �����Ѵ�. ���� Code�� ���� Message�� �������� ���� ��� 
  defaultMessage�� ����Ѵ�.
*/
/*DefaultMessageCodesResolver�� ���� Code�κ��� Message Code�� ������ ��, Message Code�� �ش��ϴ� Message�� �ε��Ѵ�. reject() �޼��带 
�̿��Ͽ� Ŀ�ǵ� ��ü ��ü�� ���� ���� Code�� �Է��� ���, ������ ������ Message Code�� �����Ѵ�.
	//�����ڵ�=required
	[1] ���� Code + "." + Ŀ�ǵ� ��ü �̸� invalidIdOrPassword.loginCommand=
	[2] ���� Code

rejectValue() �޼��带 �̿��Ͽ� Ư�� �ʵ忡 ���� ���� Code�� �Է��ߴٸ�, ������ ������ Message Code�� �����Ѵ�.

	[1] ���� Code + "." + Ŀ�ǵ� ��ü �̸� + "." + �ʵ��
	[2]  ���� Code + "." + �ʵ��
	[3]  ���� Code + "." + �ʵ� Ÿ��
	[4]  ���� Code 
	
����, ù ��°�� ����� Message Code�� �������� ������, �� ��° Message Code�� ����Ѵ�. ����� ������� Message Code�� �߰ߵ� ������
�� ��°�� �� ��° Message Code�� ���ʴ�� ����ϰ� �ȴ�.

���� ���, Ŀ�ǵ� ��ü�� �̸��� "loginCommand"�̰�, ������ ���� rejectValue() �޼��带 ����Ͽ� "userId" ������Ƽ(�ʵ�)�� ���Ͽ�
���� Code "required"�� �߰��ߴٰ� ����.

	errors.rejectValue("userId", "required");

�� ���, ���Ǵ� Message Code�� ���� ������ ������ ����.
	[1] required.loginCommand.userId//� �ڹٺ��� � ���������� ������ �ֿ켱����
	[2] required.userId //�ּ��� ������ ���ΰ�
	[3] required.java.lang.String//userId�� Ÿ���� ������
	[4] required*/
