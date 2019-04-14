package madvirus.spring.chap06.controller;
	import java.util.Calendar;
	import org.springframework.stereotype.Controller;//스프링관련된 라이브러리 임포트 3개
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.servlet.ModelAndView;
	//Annotation은 주석이라는뜻
	@Controller//HandlerMapping이 요청이오면 1000개 다뒤지지말고 @Controller가 붙은것만 찾게할려고
	public class HelloController{//액션과 같다고 보자
	@RequestMapping("/hello.do")//annotation//HandlerMapping이 이것도 두번째로 찾아서 동작시킨다//hello.do"가 요청이 오면 이 메소드로로 처리하자
	public ModelAndView hello(){//이 메소드가 처리하고 ModelAndView 데이터타입 리턴 
		//@RequestMapping("/hello.do")과 hello메소드는 붙어있어야함
		ModelAndView mav = new ModelAndView(); 
		mav.setViewName("hello");//jsp이름만 따오는거 어떤 jsp로 보여주고//prefix,suffix와관련
		mav.addObject("greeting", getGreeting());//jsp가 쓰고자하는 객체 영역에 저장//이게모델
		//대장컨트롤러가 이 모델을 jsp에 전달 jsp는 greeting이이름으로 영역에서 가져다씀
		mav.addObject("greeting2", getGreeting());
		return mav;
	}
	private String getGreeting() {
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		//System.out.println(hour);
		if (hour >= 6 && hour <= 10) {
			return "좋은 아침입니다.";
		} else if (hour >= 12 && hour <= 15) {
			return "점심 식사는 하셨나요?";
		} else if (hour >= 18 && hour <= 22) {
			return "좋은 밤 되세요";
		}
		return "안녕하세요";
	}
	}