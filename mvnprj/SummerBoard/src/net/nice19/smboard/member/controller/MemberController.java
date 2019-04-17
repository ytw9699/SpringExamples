package net.nice19.smboard.member.controller;

import net.nice19.smboard.member.model.MemberModel;
import net.nice19.smboard.member.service.MemberService;
import net.nice19.smboard.member.service.MemberValidatior;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
@Controller
@RequestMapping("/member")//http://localhost:8080/SummerBoard/member/join.do
public class MemberController {
	private ApplicationContext context;
	@RequestMapping("/join.do")//http://localhost:8080/SummerBoard/member/join.do로 요청해야함
	public String memberJoin(){
		return "/board/join";
	}
	@RequestMapping(value="/join.do", method = RequestMethod.POST)
	public ModelAndView addMember(@ModelAttribute("MemberModel") MemberModel memberModel, BindingResult result){
		ModelAndView mav = new ModelAndView();
		new MemberValidatior().validate(memberModel, result);
		if(result.hasErrors()){
			mav.setViewName("/board/join");
			return mav;
		}
		//db에붙어야하니까 수동적으로 꺼내오자
		context = new ClassPathXmlApplicationContext("/config/applicationContext.xml");
		MemberService memberService = (MemberService) context.getBean("memberService");
		MemberModel checkMemberModel = memberService.findByUserId(memberModel.getUserId());//id에해당하는 한줄
		
		if(checkMemberModel != null){//이미회원가입됨
			mav.addObject("errCode", 1); // userId already exist 
			mav.setViewName("/board/join");
			return mav;
		}		
		if(memberService.addMember(memberModel)){//회원가입된게아니라면 addmember로 회원가입시키자 true리턴
			mav.addObject("errCode", 3);
			mav.setViewName("/board/login"); // success to add new member; move to login page
			return mav;
		} else {
			mav.addObject("errCode", 2); // failed to add new member
			mav.setViewName("/board/join");//회원가입 실패하면 다시입력하게
			return mav;
		}
	}
}
