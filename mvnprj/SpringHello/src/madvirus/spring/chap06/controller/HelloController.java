package madvirus.spring.chap06.controller;
	import java.util.Calendar;
	import org.springframework.stereotype.Controller;//���������õ� ���̺귯�� ����Ʈ 3��
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.servlet.ModelAndView;
	//Annotation�� �ּ��̶�¶�
	@Controller//HandlerMapping�� ��û�̿��� 1000�� �ٵ��������� @Controller�� �����͸� ã���ҷ���
	public class HelloController{//�׼ǰ� ���ٰ� ����
	@RequestMapping("/hello.do")//annotation//HandlerMapping�� �̰͵� �ι�°�� ã�Ƽ� ���۽�Ų��//hello.do"�� ��û�� ���� �� �޼ҵ�η� ó������
	public ModelAndView hello(){//�� �޼ҵ尡 ó���ϰ� ModelAndView ������Ÿ�� ���� 
		//@RequestMapping("/hello.do")�� hello�޼ҵ�� �پ��־����
		ModelAndView mav = new ModelAndView(); 
		mav.setViewName("hello");//jsp�̸��� �����°� � jsp�� �����ְ�//prefix,suffix�Ͱ���
		mav.addObject("greeting", getGreeting());//jsp�� �������ϴ� ��ü ������ ����//�̰Ը�
		//������Ʈ�ѷ��� �� ���� jsp�� ���� jsp�� greeting���̸����� �������� �����پ�
		mav.addObject("greeting2", getGreeting());
		return mav;
	}
	private String getGreeting() {
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		//System.out.println(hour);
		if (hour >= 6 && hour <= 10) {
			return "���� ��ħ�Դϴ�.";
		} else if (hour >= 12 && hour <= 15) {
			return "���� �Ļ�� �ϼ̳���?";
		} else if (hour >= 18 && hour <= 22) {
			return "���� �� �Ǽ���";
		}
		return "�ȳ��ϼ���";
	}
	}