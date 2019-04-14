package madvirus.spring.chap06.controller;
import javax.servlet.http.HttpServletRequest;
import madvirus.spring.chap06.model.Address;
import madvirus.spring.chap06.model.MemberInfo;
import madvirus.spring.chap06.validator.MemberInfoValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 @Controller
 @RequestMapping("/account/create.do")
	public class CreateAccountController {
	@ModelAttribute("command")//MemberInfo�ڹٺ�ü�� jsp���� command�̸����� ����
	//�Ʒ� �ڵ� @ModelAttribute("command") MemberInfo memberInfo,�� ���ϼ��ְ� ������ 
	//�׷��� ���߿� jsp���� ���� ���Է��ϰ� ����Դ����� ���� ������ ���� ������ ���ִ°���
	public MemberInfo formBacking(HttpServletRequest request) {//�׳� ������ﶧ�� �ڹٺ� ����ϱ�����
		if (request.getMethod().equalsIgnoreCase("GET")) {//�ٹ������ ��û�� ������ �ڹٺ��� ����
			//System.out.println(request.getMethod());//GET
			//equalsIgnoreCase�� ��ҹ��� �������ϰ� ������ �� equals�� ��ҹ��� �����ؼ� ������ ��
			MemberInfo mi = new MemberInfo();
			Address address = new Address();
			address.setZipcode(autoDetectZipcode(request.getRemoteAddr()));//�����ȣ����
			//System.out.println(request.getRemoteAddr());
			mi.setAddress(address);
			return mi;//command
		} else {
	return new MemberInfo();//private String id;//private String name;//private Address address;
		}
	}/*	
	@ModelAttribute Annotation�� ����� �޼��尡
	@RequestMapping Annotation�� ����� �޼��� ���� ���� ȣ��Ǳ� ������,
	    Ŀ�ǵ� ��ü�� ���� �ʱ�ȭ �۾��� �ʿ��ϴٸ� ��ü�� ������ �̸��� ���� @ModelAttribute Annotation�� ����� �޼��带
	    �̿��ϸ� �ȴ�.*/
		private String autoDetectZipcode(String remoteAddr) {
			return "000000";//�� �޴� �����ȣ�� 00000
		}
		@RequestMapping(method = RequestMethod.GET)
		public String form() {
			return "account/creationForm";
		}
		@RequestMapping(method = RequestMethod.POST)
		public String submit(@ModelAttribute("command") MemberInfo memberInfo,
				BindingResult result) {//�븮�����ͿͿ���//�������� Ŭ������ ��ӹ޾Ƽ� ����� BindingResult
			//BindingResult Interface�� Errors Interface�� ��ӹ޾ұ� ������ �� ��° �Ķ���ͷ� ���� �����ϴ�.
			new MemberInfoValidator().validate(memberInfo, result);
			//�Ű������� ��ȿ�������� �ڹٺ�ü�� ó���ȿ�������� BindingResult�� �����ض�
			if (result.hasErrors()) {//��������������� ������ ���ư���
				return "account/creationForm";
			}
			return "account/created";//���������� �Ϸΰ���
		}
	}