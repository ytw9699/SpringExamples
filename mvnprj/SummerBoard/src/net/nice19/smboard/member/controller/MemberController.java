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
	@RequestMapping("/join.do")//http://localhost:8080/SummerBoard/member/join.do�� ��û�ؾ���
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
		//db���پ���ϴϱ� ���������� ��������
		context = new ClassPathXmlApplicationContext("/config/applicationContext.xml");
		MemberService memberService = (MemberService) context.getBean("memberService");
		MemberModel checkMemberModel = memberService.findByUserId(memberModel.getUserId());//id���ش��ϴ� ����
		
		if(checkMemberModel != null){//�̹�ȸ�����Ե�
			mav.addObject("errCode", 1); // userId already exist 
			mav.setViewName("/board/join");
			return mav;
		}		
		if(memberService.addMember(memberModel)){//ȸ�����ԵȰԾƴ϶�� addmember�� ȸ�����Խ�Ű�� true����
			mav.addObject("errCode", 3);
			mav.setViewName("/board/login"); // success to add new member; move to login page
			return mav;
		} else {
			mav.addObject("errCode", 2); // failed to add new member
			mav.setViewName("/board/join");//ȸ������ �����ϸ� �ٽ��Է��ϰ�
			return mav;
		}
	}
}
