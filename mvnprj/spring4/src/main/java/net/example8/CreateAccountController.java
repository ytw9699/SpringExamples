package net.example8;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
@RequestMapping("/example8/account/create.do")
public class CreateAccountController {
@ModelAttribute("command")//MemberInfo자바빈객체를 jsp에서 command이름으로 접근
//맨 아래 코드 @ModelAttribute("command") MemberInfo memberInfo,와 통일성있게 만들어둠 
//그래야 나중에 jsp에서 초기화됨
public MemberInfo formBacking(HttpServletRequest request) {//그냥 폼만띄울때도 자바빈 사용하기위해
if (request.getMethod().equalsIgnoreCase("GET")) {//겟방식으로 요청이 맞으면 자바빈을 설정
	//System.out.println(request.getMethod());//GET
	//equalsIgnoreCase는 대소문자 구문안하고 같은지 비교 equals는 대소문자 구별해서 같은지 비교
	MemberInfo mi = new MemberInfo();
	Address address = new Address();
	address.setZipcode("00-000");//임시 우편번호 초기화 설정
	
	mi.setAddress(address);
	return mi;//command
} else {
return new MemberInfo();
}
}
/*	
@ModelAttribute Annotation이 적용된 메서드가
@RequestMapping Annotation이 적용된 메서드 보다 먼저 호출되기 때문에,
커맨드 객체에 대한 초기화 작업이 필요하다면 객체와 동일한 이름을 갖는 @ModelAttribute Annotation이 적용된 메서드를
이용하면 된다.*/
@RequestMapping(method = RequestMethod.GET)
public String form() {
	return "example8/creationForm";
}
@RequestMapping(method = RequestMethod.POST)
public String submit(@ModelAttribute("command") MemberInfo memberInfo,
		BindingResult result) {//밸리데이터와연관//에러즈라는 클래스를 상속받아서 만든게 BindingResult
	//BindingResult Interface는 Errors Interface를 상속받았기 때문에 두 번째 파라미터로 전달 가능하다.
	new MemberInfoValidator().validate(memberInfo, result);
	//매개변수로 유효성검증은 자바빈객체와 처리된오류결과는 BindingResult에 저장해라
	if (result.hasErrors()) {//에러가담겨있으면 폼으로 돌아가고
		return "example8/creationForm";
	}
	return "example8/created";//에러없으면 일로가자
}
}