package madvirus.spring.chap06.controller;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import madvirus.spring.chap06.model.Address;
import madvirus.spring.chap06.model.MemberInfo;
import madvirus.spring.chap06.common.CookieBox;
@Controller
public class CookieController2 {//�ٽ�ó������ �غ�����
	@RequestMapping("/cookie2/loginForm.do")
	public String login() {
		return "cookie2/loginForm";
	}
	@RequestMapping("/cookie2/make.do")
	public ModelAndView make(HttpServletRequest request,HttpServletResponse response)throws IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		if(id.equals(password)) {
			response.addCookie(CookieBox.createCookie("ID", id));
			//response.addCookie(new Cookie("ID", URLEncoder.encode(id, "euc-kr")));
			ModelAndView mav = new ModelAndView("cookie2/login");
			mav.addObject("ID2", id);
			return mav;
		}
		ModelAndView mav = new ModelAndView("cookie2/loginForm");
		return mav;
	}
	@ModelAttribute("KHID")//view�޼ҵ尡 �����ϸ鼭 ��û���Ҷ� Ŭ���̾�Ʈ�� ���� ID�̸��� ��Ű���� �޾Ƽ� ��Ʈ����ü�� �����Ѵ�
	public String view(@CookieValue(value = "ID", required=false) String id) {
	//public String view(@CookieValue(value = "ID", defaultValue = "") String id) {
		String id2="";
		if(id !=null) {
		id2 = URLDecoder.decode(id);
		System.out.println(id2);//��Ű�� �޾Ƽ� ���
		return id2; 
		}
		return id2;
	}
	}