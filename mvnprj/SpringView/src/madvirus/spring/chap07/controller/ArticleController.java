package madvirus.spring.chap07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ArticleController {

	@RequestMapping(value="/article/{id}", method=RequestMethod.GET)
	public String read(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("article", new Article(id));
		return "article/read";
	}
	
	@RequestMapping(value="/article/{id}", method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("article", new Article(id));
		return "article/delete";
	}
	
	@RequestMapping(value="/article/{id}", method=RequestMethod.PUT)
	public String modify(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("article", new Article(id));
		return "article/modify";
	}
	
	@RequestMapping(value="/article", method=RequestMethod.POST)
	public String write(Model model) {
		model.addAttribute("article", new Article(2));
		return "article/write";
	}

	@RequestMapping("/articleForm.do")
	public String testForm(Model model) {
		model.addAttribute("article", new Article(1));
		return "article/testForm";
	}

}
