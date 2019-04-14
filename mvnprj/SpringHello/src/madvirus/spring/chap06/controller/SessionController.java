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
	
/*	���ǿ� ���� HttpSession�� �����ؾ� �ϴ� ��츦 ������ ����. �� ������ ������ ���� HttpServletRequest Ÿ����
    �Ķ���͸� ���޹޾ƾ߸� HttpSession�� ���ǿ� ���� �����ϰų� �������� ���� �� �ִ�.
    	@RequestMapping("/someUrl")
    	public ModelAndView process(HttpServletRequest request, ...){
    		if(someCondition){
    			HttpSession session = request.getSession();
    		}
    		...
    	}
    	
    HttpSession Ÿ���� �Ķ���͸� ���� ��� ������ �����ȴٴ� ���� �����ؾ� �Ѵ�. ��, ������ ������ �����Ѵٸ� �ش� ������
    ���޵ǰ� �׷��� �ʴٸ� ���ο� ������ �����ǰ� ���� HttpSession �ν��Ͻ��� �Ķ���Ϳ� ���޵ȴ�. ����, HttpSession
    Ÿ���� �Ķ���ʹ� �׻� null�� �ƴϴ�.

    	 @RequestMapping("/someUrl")
    	 public ModelAndView process(HttpSession session, ...){
    	 	session != null; //�׻� true 
    		...
    	}*/