package madvirus.spring.chap06.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class NewArticleController2 {
	@RequestMapping(value="/article/newArticle2.do", method = RequestMethod.GET)
	public String form() {
		return "article/newArticleForm2";//이게 model and view에서 view역할만 jsp이름만 알려주는것
	}//http://localhost:8080/SpringHello/article/newArticle2.do

	@RequestMapping(value="/article/newArticle2.do", method = RequestMethod.POST)
	public String submit() {
		return "article/newArticleSubmitted2";
	}
}
/*@Controller
@RequestMapping("/article/newArticle.do")//RequestMapping을 클래스에 걸어둠
public class NewArticleController {
	@RequestMapping(method = RequestMethod.GET)//그리고 여기서 다시 걸어둠
	public String form() {
		...
	}
	@RequestMapping(method = RequestMethod.POST)
	public String submit(@ModelAttribute("command") NewArticleCommand command) {
		articleService.writeArticle(command);
		...
	}
}*/