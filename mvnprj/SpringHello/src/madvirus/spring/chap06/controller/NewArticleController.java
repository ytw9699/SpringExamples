package madvirus.spring.chap06.controller;
import madvirus.spring.chap06.service.ArticleService;
import madvirus.spring.chap06.service.NewArticleCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
@RequestMapping("/article/newArticle.do")//GET,POST�������� ����Ҽ��ִ� ����
public class NewArticleController {
	@Autowired//�̰��� ���� ��ƼŬ���� Ÿ������ ��ϵ� ���� ã�°� ��ϵȰ������� articleService�� �����ٰ� ��ü�����ؼ� ���ڴ�
	//dispatcher-servlet.xml�������� ����⶧���� @Autowired���� ��� �������
	private ArticleService articleService;//�տ������� ��ƼŬ���� Ŭ���� ��ü����

	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return "article/newArticleForm";//������
	}    //web
	@RequestMapping(method = RequestMethod.POST)
	public String submit(@ModelAttribute("command2") NewArticleCommand command) {
		//���۵Ǵ� �����͸� �ڹٺ� �ְ� ������ ��û�� ó���ϴ� �޼ҵ��ȣ�ȿ� �Ķ���ͷ� �ڹٺ� �����ϸ� ���۵� �����ʹ� �ڹٺ� ����!
		//���۵� �����͸� �ڹٺ� ��� �����ϰ�,jsp���� "command2"�� �̸����� el�� �����پ��Բ�
		//@ModelAttribute("command2")�̰� �������ϸ� ${newArticleCommand.title} �̷��� �տ��� n�� �ҹ��ڷ��ؼ� jsp���� �����پ�
		System.out.println(command.getTitle());//�̷��� command��ü�� �����ؼ� ���������� �����پ�������!
		System.out.println(command.getContent());//�̷��� ���������� �����پ�!
		System.out.println(command.getParentId());//�̷��� ���������� �����پ�!
		articleService.writeArticle(command);//�ڹٺ�ü�־��ְ�
		return "article/newArticleSubmitted";//jsp�� ������
	}
	public void setArticleService(ArticleService articleService) {//articleService��ü�޾Ƽ�
		this.articleService = articleService;
	}//�������� ��Ʈ�ѷ� ��ü�� �������� ��ƼŬ���� ��ü�� ������ �����̳ʿ� �ö󰡰Եɰ�
	//�׷��� �����۾��ϴ� �� ��Ʈ�ѷ����� ��ƼŬ���񽺸� �����پ����� �����پ����� new�� ��ü�����ϸ� �Ǵµ�
	//��ü���� �صΰ� ��ü�� �޾Ƽ� ���°�,��ü�� �̸� �����صΰ� ��ü���� ���輳���ϸ鼭 �۾��ϴ°� ,��ü���������̺���
	//dispatcher-servlet.xml�ȿ��� ����
	}