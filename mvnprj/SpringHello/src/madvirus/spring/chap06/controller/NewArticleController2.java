package madvirus.spring.chap06.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class NewArticleController2 {
	@RequestMapping(value="/article/newArticle2.do", method = RequestMethod.GET)
	public String form() {
		return "article/newArticleForm2";//�̰� model and view���� view���Ҹ� jsp�̸��� �˷��ִ°�
	}//http://localhost:8080/SpringHello/article/newArticle2.do

	@RequestMapping(value="/article/newArticle2.do", method = RequestMethod.POST)
	public String submit() {
		return "article/newArticleSubmitted2";
	}
}
/*@Controller
@RequestMapping("/article/newArticle.do")//RequestMapping�� Ŭ������ �ɾ��
public class NewArticleController {
	@RequestMapping(method = RequestMethod.GET)//�׸��� ���⼭ �ٽ� �ɾ��
	public String form() {
		...
	}
	@RequestMapping(method = RequestMethod.POST)
	public String submit(@ModelAttribute("command") NewArticleCommand command) {
		articleService.writeArticle(command);
		...
	}
}*/