package madvirus.spring.chap06.controller;
	import java.util.ArrayList;
	import java.util.List;
	import madvirus.spring.chap06.service.SearchCommand;
	import madvirus.spring.chap06.service.SearchResult;
	import madvirus.spring.chap06.service.SearchService;
	import madvirus.spring.chap06.service.SearchType;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.ExceptionHandler;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.servlet.ModelAndView;
@Controller
public class GameSearchController {
	@Autowired
	private SearchService searchService;
	//- 3.★★ @ModelAttribute Annotation이 적용된 메서드가 리턴한 객체
	@ModelAttribute("searchTypeList")
	//ModelAttribute어노테이션이 붙어서 jsp에서 이searchTypeList이름으로 list객체를 가져다씀
	public List<SearchType> referenceSearchTypeList() {//컨트롤러가 객체생성할때 이 메소드도 자동으로 동작
		List<SearchType> options = new ArrayList<SearchType>();
		options.add(new SearchType(1, "전체"));
		options.add(new SearchType(2, "아이템"));
		options.add(new SearchType(3, "캐릭터"));
		return options;
	}
	@ModelAttribute("popularQueryList")
	public String[] getPopularQueryList() {
		return new String[] { "게임", "창천2", "위메이드" };
	}
	@RequestMapping("/search/main.do")
	public String main() {
		return "search/main";
	}
	@RequestMapping("/search/game.do")//2가지가져다씀     
	public ModelAndView search(@ModelAttribute("command") SearchCommand command) {
		////.1 - 1. 커맨드 객체(JavaBean)-메서드안 파라미터
		ModelAndView mav = new ModelAndView("search/game");
			System.out.println("getQuery검색어 = " + command.getQuery().toUpperCase());
			System.out.println("getType = " + command.getType());
		SearchResult result = searchService.search(command);
		mav.addObject("searchResult", result);//2.
		return mav;
	}
	@ExceptionHandler(NullPointerException.class)//컨트롤러가 동작하다가 널포인터이센셥이 발생되면
	public String handleNullPointerException(NullPointerException ex) {//이메소드가 처리
		return "error/nullException";//jsp로 포워딩
	}
	
	public void setSearchService(SearchService searchService) {//객체주입 관계설정
		this.searchService = searchService;
	}
}