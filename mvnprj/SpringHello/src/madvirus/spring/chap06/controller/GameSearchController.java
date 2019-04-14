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
	//- 3.�ڡ� @ModelAttribute Annotation�� ����� �޼��尡 ������ ��ü
	@ModelAttribute("searchTypeList")
	//ModelAttribute������̼��� �پ jsp���� ��searchTypeList�̸����� list��ü�� �����پ�
	public List<SearchType> referenceSearchTypeList() {//��Ʈ�ѷ��� ��ü�����Ҷ� �� �޼ҵ嵵 �ڵ����� ����
		List<SearchType> options = new ArrayList<SearchType>();
		options.add(new SearchType(1, "��ü"));
		options.add(new SearchType(2, "������"));
		options.add(new SearchType(3, "ĳ����"));
		return options;
	}
	@ModelAttribute("popularQueryList")
	public String[] getPopularQueryList() {
		return new String[] { "����", "âõ2", "�����̵�" };
	}
	@RequestMapping("/search/main.do")
	public String main() {
		return "search/main";
	}
	@RequestMapping("/search/game.do")//2���������پ�     
	public ModelAndView search(@ModelAttribute("command") SearchCommand command) {
		////.1 - 1. Ŀ�ǵ� ��ü(JavaBean)-�޼���� �Ķ����
		ModelAndView mav = new ModelAndView("search/game");
			System.out.println("getQuery�˻��� = " + command.getQuery().toUpperCase());
			System.out.println("getType = " + command.getType());
		SearchResult result = searchService.search(command);
		mav.addObject("searchResult", result);//2.
		return mav;
	}
	@ExceptionHandler(NullPointerException.class)//��Ʈ�ѷ��� �����ϴٰ� ���������̼����� �߻��Ǹ�
	public String handleNullPointerException(NullPointerException ex) {//�̸޼ҵ尡 ó��
		return "error/nullException";//jsp�� ������
	}
	
	public void setSearchService(SearchService searchService) {//��ü���� ���輳��
		this.searchService = searchService;
	}
}