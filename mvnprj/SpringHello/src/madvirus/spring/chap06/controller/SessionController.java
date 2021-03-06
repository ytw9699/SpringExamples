	package madvirus.spring.chap06.controller;

	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestMapping;
	import javax.servlet.http.HttpSession;

	@Controller
	public class SessionController {

@RequestMapping("/session/make.do")
public String make(HttpSession session) {
	session.setAttribute("sessionid", "id2");
	return "session/make";
	}
@RequestMapping("/session/check.do")
public String check() {
	return "session/check";
	}
}
/*	@RequestMapping("/someUrl")
   	public ModelAndView process(HttpServletRequest request, ...){
   		if(someCondition){
   			HttpSession session = request.getSession();
   		}*/
	
/*	조건에 따라서 HttpSession을 생성해야 하는 경우를 생각해 보자. 이 때에는 다음과 같이 HttpServletRequest 타입의
    파라미터를 전달받아야만 HttpSession을 조건에 따라 생성하거나 생성하지 않을 수 있다.
    	@RequestMapping("/someUrl")
    	public ModelAndView process(HttpServletRequest request, ...){
    		if(someCondition){
    			HttpSession session = request.getSession();
    		}
    		...
    	}
    	
    HttpSession 타입의 파라미터를 가질 경우 세션이 생성된다는 점에 유의해야 한다. 즉, 기존에 세션이 존재한다면 해당 세션이
    전달되고 그렇지 않다면 새로운 세션이 생성되고 관련 HttpSession 인스턴스가 파라미터에 전달된다. 따라서, HttpSession
    타입의 파라미터는 항상 null이 아니다.

    	 @RequestMapping("/someUrl")
    	 public ModelAndView process(HttpSession session, ...){
    	 	session != null; //항상 true 
    		...
    	}*/