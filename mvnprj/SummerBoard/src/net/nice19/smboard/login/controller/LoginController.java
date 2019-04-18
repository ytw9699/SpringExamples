package net.nice19.smboard.login.controller;
	import javax.servlet.http.HttpSession;
	import net.nice19.smboard.login.model.LoginSessionModel;
	import net.nice19.smboard.login.service.LoginService;
	import net.nice19.smboard.login.service.LoginValidator;
	import org.springframework.stereotype.Controller;
	import org.springframework.validation.BindingResult;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.servlet.ModelAndView;
	import org.springframework.context.ApplicationContext;
	import org.springframework.context.support.ClassPathXmlApplicationContext;
@Controller
public class LoginController {//로그인,로그아웃
	private ApplicationContext context;
	//applicationContext에있는 db단에 대한 설정도 스프링컨테이너에 올리기 위한 관련 작업
	@RequestMapping("/login.do")
	public String login() {		
		return "/board/login";
	}
	@RequestMapping(value="/login.do", method = RequestMethod.POST)
	public ModelAndView loginProc(@ModelAttribute("LoginModel") LoginSessionModel loginModel,
			BindingResult result, HttpSession session) {//로그인개념 HttpSession session
		ModelAndView mav = new ModelAndView();
		// form validation
		new LoginValidator().validate(loginModel, result);
		if(result.hasErrors()){
			mav.setViewName("/board/login");
			return mav;
		}
		String userId = loginModel.getUserId();//로그인하고자 전송되서 자바빈에 꽃힌 데이타
		String userPw = loginModel.getUserPw();//로그인하고자 전송된 데이타
		//db작업을 할때만 이렇게 꺼내쓰자는 개념
		context = new ClassPathXmlApplicationContext("/config/applicationContext.xml");//인터페이스라 이렇게 구현한 클래스 객체생성
			///config/applicationContext.xml"경로를 넣어 만들면 xml에있는 걸 로딩해서 새로운 스프링 컨테이너 만들고  사용할수있는 객체넣어줌
		LoginService loginService = (LoginService) context.getBean("loginService");//"loginService"꺼내와서 객체생성
		/*<bean id="loginService" class="net.nice19.smboard.login.service.LoginService">
   		<property name="sqlMapClientTemplate" ref="sqlMapClientTemplate" />
   		</bean>*/
		LoginSessionModel loginCheckResult = loginService.checkUserId(userId);//id넣어주면 LoginSessionModel자바빈 리턴
		/*public LoginSessionModel checkUserId(String userId) {//dao로부터 오버라이드
			return (LoginSessionModel) sqlMapClientTemplate.queryForObject("login.loginCheck", userId);//자바빈리턴!			
*/		
		//check joined user
		if(loginCheckResult == null){
			mav.addObject("userId", userId);//이메일주소가 틀려도 그대로 저장되게할려고 값넘김
			mav.addObject("errCode", 1);	// not exist userId in database
			mav.setViewName("/board/login");//로그인으로 넘어가게 //가입된 이메일 주소가 아닙니다!");			
			return mav; 
		}
		//check password
		if(loginCheckResult.getUserPw().equals(userPw)){			
			session.setAttribute("userId", userId);//세션영역에 아이디저장
			session.setAttribute("userName", loginCheckResult.getUserName());
			mav.setViewName("redirect:/board/list.do");
			return mav;
		} else {
			mav.addObject("userId", userId);//비밀번호가 틀려도 아이디는 저장되있게할려고 값넘김
			mav.addObject("errCode", 2);	// not matched password
			mav.setViewName("/board/login");	//"비밀번호가 일치하지 않습니다!");		
			return mav;  
		}	
	}
	@RequestMapping("/logout.do")
	public String logout(HttpSession session){
		session.invalidate();//로그아웃
		return "redirect:login.do";
	}
}