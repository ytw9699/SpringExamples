package madvirus.spring.chap06.controller;
	import javax.servlet.http.Cookie;
	import javax.servlet.http.HttpServletResponse;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.CookieValue;
	import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class CookieController {
	@RequestMapping("/cookie/make.do")
	public String make(HttpServletResponse response) {
		response.addCookie(new Cookie("auth", "1"));
		return "cookie/made";
	}
	@RequestMapping("/cookie/view.do")//Ŭ���̾�Ʈ�� ���� auth��Ű�̸��� �ش��ϴ� ��Ű�� ��1�� �޾Ƽ� ��Ʈ����ü�� �����Ѵ�
	public String view(@CookieValue(value = "auth", required=false) String auth) {
		System.out.println("auth ��Ű: " + auth);//��Ű�� �޾Ƽ� ���
		return "cookie/view";    
		//view�޼ҵ尡 �����ϸ鼭 ��û���Ҷ� ��Ű�� �̸� auth��� �̸��� ��Ű�� ������ ��û��������
		//�װ��� ��Ʈ����ü�� �����ض� , Ŭ���̾�Ʈ�� ������ auth �̸��� ��Ű��
		}
	}
//	http://localhost:8080/SpringHello/cookie/make.do
//http://localhost:8080/SpringHello/cookie/view.do
