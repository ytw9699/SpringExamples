package net.example1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
@RequestMapping("/example1/newArticle.do")//공통으로 사용할수있는 맵핑
public class NewArticleController {
	@Autowired//이것의 역할 아티클서비스 타입으로 등록된 빈을 찾는거 등록된게있으면 articleService를 가져다가 객체생성해서 쓰겠다
	//dispatcher-servlet.xml설정에서 해줬기때문에 @Autowired빼도 사실 상관없음
	private ArticleService articleService;//앞에서만든 아티클서비스 클래스 객체선언

	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return "example1/newArticleForm";//포워딩
	}    //web
	@RequestMapping(method = RequestMethod.POST)
	public String submit(@ModelAttribute("command2") NewArticleCommand command) {
		//전송되는 데이터를 자바빈에 넣고 싶으면 요청을 처리하는 메소드괄호안에 파라미터로 자바빈만 설정하면 전송된 데이터는 자바빈에 꽃힘!
		//전송된 데이터를 자바빈에 모두 설정하고,jsp에서 "command2"이 이름으로 el로 가져다쓰게끔
		//@ModelAttribute("command2")이걸 지정안하면 ${newArticleCommand.title} 이렇게 앞에만 n을 소문자로해서 jsp에서 가져다씀
		System.out.println(command.getTitle());//이렇게 command객체를 생성해서 내부적으로 가져다쓸수있음!
		System.out.println(command.getContent());//이렇게 내부적으로 가져다씀!
		System.out.println(command.getParentId());//이렇게 내부적으로 가져다씀!
		articleService.writeArticle(command);//자바빈객체넣어주고
		return "example1/newArticleSubmitted";//jsp로 포워딩
	}
	public void setArticleService(ArticleService articleService) {//articleService객체받아서
		this.articleService = articleService;
	}//내가만든 컨트롤러 객체와 내가만든 아티클서비스 객체가 스프링 컨테이너에 올라가게될거
	//그런데 내가작업하는 이 컨트롤러에서 아티클서비스를 가져다쓸거임 가져다쓸때는 new로 객체생성하면 되는데
	//객체선언만 해두고 객체를 받아서 쓰는거,객체를 미리 생성해두고 객체끼리 관계설정하면서 작업하는거 ,객체생성로직이빠짐
	//dispatcher-servlet.xml안에서 설정
	}