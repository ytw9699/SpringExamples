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
public class LoginController {//�α���,�α׾ƿ�
	private ApplicationContext context;
	//applicationContext���ִ� db�ܿ� ���� ������ �����������̳ʿ� �ø��� ���� ���� �۾�
	@RequestMapping("/login.do")
	public String login() {		
		return "/board/login";
	}
	@RequestMapping(value="/login.do", method = RequestMethod.POST)
	public ModelAndView loginProc(@ModelAttribute("LoginModel") LoginSessionModel loginModel,
			BindingResult result, HttpSession session) {//�α��ΰ��� HttpSession session
		ModelAndView mav = new ModelAndView();
		// form validation
		new LoginValidator().validate(loginModel, result);
		if(result.hasErrors()){
			mav.setViewName("/board/login");
			return mav;
		}
		String userId = loginModel.getUserId();//�α����ϰ��� ���۵Ǽ� �ڹٺ� ���� ����Ÿ
		String userPw = loginModel.getUserPw();//�α����ϰ��� ���۵� ����Ÿ
		//db�۾��� �Ҷ��� �̷��� �������ڴ� ����
		context = new ClassPathXmlApplicationContext("/config/applicationContext.xml");//�������̽��� �̷��� ������ Ŭ���� ��ü����
			///config/applicationContext.xml"��θ� �־� ����� xml���ִ� �� �ε��ؼ� ���ο� ������ �����̳� �����  ����Ҽ��ִ� ��ü�־���
		LoginService loginService = (LoginService) context.getBean("loginService");//"loginService"�����ͼ� ��ü����
		/*<bean id="loginService" class="net.nice19.smboard.login.service.LoginService">
   		<property name="sqlMapClientTemplate" ref="sqlMapClientTemplate" />
   		</bean>*/
		LoginSessionModel loginCheckResult = loginService.checkUserId(userId);//id�־��ָ� LoginSessionModel�ڹٺ� ����
		/*public LoginSessionModel checkUserId(String userId) {//dao�κ��� �������̵�
			return (LoginSessionModel) sqlMapClientTemplate.queryForObject("login.loginCheck", userId);//�ڹٺ���!			
*/		
		//check joined user
		if(loginCheckResult == null){
			mav.addObject("userId", userId);//�̸����ּҰ� Ʋ���� �״�� ����ǰ��ҷ��� ���ѱ�
			mav.addObject("errCode", 1);	// not exist userId in database
			mav.setViewName("/board/login");//�α������� �Ѿ�� //���Ե� �̸��� �ּҰ� �ƴմϴ�!");			
			return mav; 
		}
		//check password
		if(loginCheckResult.getUserPw().equals(userPw)){			
			session.setAttribute("userId", userId);//���ǿ����� ���̵�����
			session.setAttribute("userName", loginCheckResult.getUserName());
			mav.setViewName("redirect:/board/list.do");
			return mav;
		} else {
			mav.addObject("userId", userId);//��й�ȣ�� Ʋ���� ���̵�� ������ְ��ҷ��� ���ѱ�
			mav.addObject("errCode", 2);	// not matched password
			mav.setViewName("/board/login");	//"��й�ȣ�� ��ġ���� �ʽ��ϴ�!");		
			return mav;  
		}	
	}
	@RequestMapping("/logout.do")
	public String logout(HttpSession session){
		session.invalidate();//�α׾ƿ�
		return "redirect:login.do";
	}
}