package madvirus.spring.chap06.controller;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestMapping;
			
		@Controller
		public class HelloController2 {
			@RequestMapping("/hello2.do")
			public String hello2() {
				return "hello2";//�̰� ���⼱ jsp�� �̸��̴�
			}
		}
	