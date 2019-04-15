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
			referenceData(model);//@RequestMapping이 걸려있는 메소드에서 모델설정했으니까 모델의 설정된 내용은 뷰단에서 다가져다씀
		return formViewName;
		}

		private void referenceData(Model model) {
			List<Code> jobCodes = new ArrayList<Code>();
			jobCodes.add(new Code("1", "개발자"));
			jobCodes.add(new Code("2", "UI 개발자"));
			jobCodes.add(new Code("3", "웹 디자이너"));
			jobCodes.add(new Code("4", "기획자"));

			String[] favoritesOsNames = { "윈도우XP", "비스타", "윈도우7", "우분투", "맥" };
			String[] tools = { "Eclipse", "IntelliJ", "NetBeans" };

			model.addAttribute("jobCodes", jobCodes);
			model.addAttribute("favoritesOsNames", favoritesOsNames);
			model.addAttribute("tools", tools);
		}

		@ModelAttribute
		protected Object formBackingObject() throws Exception {
			return new MemberInfo();//소문자로바꿔서 가져다씀 memberInfo
			// MemberInfo member = new MemberInfo();
			// member.setAddress(new Address());
			// return member;
		}
		@RequestMapping(method = RequestMethod.POST)
		public String submit(@ModelAttribute MemberInfo memberInfo,//소문자로바꿔서 가져다씀 memberInfo
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
				errors.rejectValue("userId", "duplicate");//중복된 값입니다. 아이디가 중복된걸 가입못하게
	// rejectValue(String field, String errorCode)//자바빈안에들어간 변수 하나하나에 대한 에러 설정
      //: 필드에 대한 에러 Code를 추가한다.
			}
		}

	}