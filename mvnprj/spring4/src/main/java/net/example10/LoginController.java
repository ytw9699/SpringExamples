package net.example10;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
@RequestMapping("/example10/login.do")
public class LoginController {
	@Autowired
	private Authenticator authenticator;//가져다쓸려고 객체선언
	//MockAuthenticator
	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return "example10/form";
	}
	@ModelAttribute
	public LoginCommand formBacking() {
		return new LoginCommand();
	}
	@RequestMapping(method = RequestMethod.POST)//new MemberInfoValidator()객체생성로직이없고
	//LoginCommand자바빈 객체에 대해서 @Valid을 붙임//그러면 자바빈객체는 유효성검증을 하도록 연결됨//뒤에서 더 자세히볼거
	public String submit(@Valid LoginCommand loginCommand,//@Valid유효성검증
			BindingResult result) {
		//@Valid이 붙으면 무조건 유효성검증을해야함 근데 어떤 밸리데이터가 가주고 유효성검증하는지가 없음
			//그부분을 @InitBinder어노테이션이 붙은 메소드가 하는거
	//new LoginCommandValidator().validate(loginCommand, result);//이게 생략
		if (result.hasErrors()) {
			return "example10/form";//유효성검증결과 에러가있으면 다시 포워딩
}
try {
	//로그인폼에 값을 입력안했을대는 rejectvalue를 쓰는거고,입력제대로 다하고 버튼눌렀는데 로그인에 실패할때
	//아니면 주민번호를 입력했는데 앞에는 6자리입력해야하는등 reject라는 걸로 통합해서 에러를 연결해서 작업할수있다
	authenticator.authenticate(loginCommand);//전송된 아이디 패스워드 이용해서 로그인시도
	return "redirect:/index.jsp";//문제없으면 리다이렉트
} catch (AuthenticationException e) {//로그인 도중 문제발생시 에러메시지설정
	result.reject("invalidIdOrPassword", new Object[] { loginCommand.getUserId(),loginCommand.getPassword() }, null);
	//result.reject("invalidIdOrPassword", new Object[] { loginCommand.getUserId()}, "추가메시지");
	//invalidIdOrPassword.loginCommand=\uC544\uC774\uB514({0})\uC640 \uC554\uD638\uAC00({1}) \uC77C\uCE58\uD558\uC9C0 \uC54A\uC2B5\uB2C8\uB2E4.
	return "example10/form"; 
	}
	}
	@InitBinder
	protected void initBinder(WebDataBinder binder) {//이게 스프링답게하는거
		binder.setValidator(new LoginCommandValidator());
	}//이 밸리데이터 객체를 통해서 유효성검증을 하게된다
	//new LoginCommandValidator().validate(loginCommand, result);//이게 생략
	
	public void setAuthenticator(Authenticator loginService) {
		this.authenticator = loginService;//MockAuthenticator
	}
}
/*reject(String errorCode) //자바빈 객체 자체 통으로 에러설정
: 전체 객체에 대한 글로벌 에러 Code를 추가한다.
- reject(String errorCode, String defaultMessage)
: 전체 객체에 대한 글로벌 에러 Code를 추가한다. 에러 Code에 대한 Message가 존재하지 않을 경우 defaultMessage를 사용한다.
- reject(String errorCode, Object[] errorArgs, String defaultMessage)
: 전체 객체에 대한 글로벌 에러 Code를 추가한다. Message 인자로 errorArgs를 전달한다. 에러 Code에 대한 Message가 존재하지 않을
  경우 defaultMessage를 사용한다.
  
- rejectValue(String field, String errorCode)//자바빈안에들어간 변수 하나하나에 대한 에러 설정
: 필드에 대한 에러 Code를 추가한다.
- rejectValue(String field, String errorCode, String defaultMessage)
: 필드에 대한 에러 Code를 추가한다. 에러 Code에 대한 Message가 존재하지 않을 경우 defaultMessage를 사용한다.
- rejectValue(String field, String errorCode, Object[] errorArgs, String defaultMessage)
: 필드에 대한 에러 Code를 추가한다. Message 인자로 errorArgs를 전달한다. 에러 Code에 대한 Message가 존재하지 않을 경우 
  defaultMessage를 사용한다.
*/
/*적용 순서
	[1] 에러 Code + "." + 커맨드 객체 이름 + "." + 필드명
	[2]  에러 Code + "." + 필드명
	[3]  에러 Code + "." + 필드 타입
	[4]  에러 Code 

	[1] required.loginCommand.userId//어떤 자바빈의 어떤 변수인지를 적은게 최우선적용
	[2] required.userId //최소한 변수명 붙인거
	[3] required.java.lang.String//userId의 타입을 적은거
	[4] required*/
