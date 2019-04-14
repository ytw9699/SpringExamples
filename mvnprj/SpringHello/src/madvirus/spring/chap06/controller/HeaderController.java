package madvirus.spring.chap06.controller;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestHeader;
	import org.springframework.web.bind.annotation.RequestMapping;
	@Controller
	public class HeaderController {
		@RequestMapping("/header/check.do")
		public String check(@RequestHeader(value = "Accept-Language", required=false) String languageHeader) {
		//public String check(@RequestHeader("Accept-Language") String languageHeader) {
			/*üũ��� �޼ҵ尡 �����ϸ� Ŭ���̾�Ʈ�� ��û�� ������Ʈ��ü�κ��� ������Ʈ ������ ������̼��� ���̰�
			�׾ȿ� ����� ����̸��߿� Accept-Language�̸��� �־��ָ� ���� ��Ʈ�������� �ٷβ������ִ�*/
		//   @RequestHeader Annotation�� @RequestCookie Annotation�� ���������� �ش� �ش��� �������� ������ 500
		 //���� ���� Code�� �����Ѵ�. ����, required �Ӽ��� defalutValue �Ӽ��� �̿��ؼ� �ʼ� ���ο� �⺻ ���� ������ �� �ִ�.
		System.out.println(languageHeader);
	return "header/pass";
	}
}



