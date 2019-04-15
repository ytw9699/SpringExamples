package madvirus.spring.chap07.controller;
	import java.util.ArrayList;
	import java.util.List;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.validation.BindingResult;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;

	@Controller
	@RequestMapping("/member/regist.do")
	public class RegistMemberController {

		private String formViewName = "registMemberForm";

		@RequestMapping(method = RequestMethod.GET)
		public String form(Model model) {
			referenceData(model);//@RequestMapping�� �ɷ��ִ� �޼ҵ忡�� �𵨼��������ϱ� ���� ������ ������ ��ܿ��� �ٰ����پ�
		return formViewName;
		}

		private void referenceData(Model model) {
			List<Code> jobCodes = new ArrayList<Code>();
			jobCodes.add(new Code("1", "������"));
			jobCodes.add(new Code("2", "UI ������"));
			jobCodes.add(new Code("3", "�� �����̳�"));
			jobCodes.add(new Code("4", "��ȹ��"));

			String[] favoritesOsNames = { "������XP", "��Ÿ", "������7", "�����", "��" };
			String[] tools = { "Eclipse", "IntelliJ", "NetBeans" };

			model.addAttribute("jobCodes", jobCodes);
			model.addAttribute("favoritesOsNames", favoritesOsNames);
			model.addAttribute("tools", tools);
		}

		@ModelAttribute
		protected Object formBackingObject() throws Exception {
			return new MemberInfo();//�ҹ��ڷιٲ㼭 �����پ� memberInfo
			// MemberInfo member = new MemberInfo();
			// member.setAddress(new Address());
			// return member;
		}
		@RequestMapping(method = RequestMethod.POST)
		public String submit(@ModelAttribute MemberInfo memberInfo,//�ҹ��ڷιٲ㼭 �����پ� memberInfo
				BindingResult result, Model model) {
			new MemberInfoValidator().validate(memberInfo, result);
			checkDuplicateId(memberInfo.getUserId(), result);
			if (result.hasErrors()) {
				referenceData(model);
				return formViewName;
			}
			return "registMember";
		}
		private void checkDuplicateId(String userId, BindingResult errors) {
			if (userId.equals("madvirus")) {
				errors.rejectValue("userId", "duplicate");//�ߺ��� ���Դϴ�. ���̵� �ߺ��Ȱ� ���Ը��ϰ�
	// rejectValue(String field, String errorCode)//�ڹٺ�ȿ��� ���� �ϳ��ϳ��� ���� ���� ����
      //: �ʵ忡 ���� ���� Code�� �߰��Ѵ�.
			}
		}

	}