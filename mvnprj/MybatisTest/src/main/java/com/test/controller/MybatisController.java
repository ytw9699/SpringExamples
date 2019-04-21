package com.test.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.test.mybatis.Member;
import com.test.mybatis.MemberDAOService;

@Controller
public class MybatisController {
	@Autowired
	private MemberDAOService memberDAOService;
	
	private static final Logger logger = LoggerFactory.getLogger(MybatisController.class);
	//���� ����ȭ��.
	@RequestMapping("/main")
	public ModelAndView main(Locale locale, Model model) {
		logger.info("Welcome main.", locale);//�α����
		// view ȭ���� main.jsp�� DB�κ��� �о�� �����͸� �����ش�.
		ModelAndView result = new ModelAndView();
		//addObject view�� �Ѿ�� ������
		List<Member> memberList = memberDAOService.getMembers();
		result.addObject("result", memberList);
		result.setViewName("main");
		return result;
	}
	//insert ��ư Ŭ���� ���� �����ͼ� result.jsp�� ȭ����ȯ ���ش�.
	@RequestMapping(value ="/insert", method = RequestMethod.POST)
	public ModelAndView insert(HttpServletRequest request){
		
		// HttpServletRequest�� �̿��Ͽ� main.jsp�κ��� 
		Member member = new Member();
		member.setName((String) request.getParameter("name"));//�̷��� �� �޴� ���� ����..�ڹٺ� �Ⱦ�..
		member.setEmail((String) request.getParameter("email"));
		member.setPhone((String) request.getParameter("phone"));
		
		memberDAOService.insertMember(member);//�Է�ó��
		//System.out.println("insert complet");
		//�Ʒ��κ��� select���� result.jsp���Ͽ� �����ֱ� ���� �ǻ��.
		ModelAndView result = new ModelAndView();
		List<Member> memberList = memberDAOService.getMembers();
		result.addObject("result", memberList);
		result.setViewName("result");
		return result;
	}
	@RequestMapping(value ="/delete")
	public ModelAndView delete(HttpServletRequest request){
		String name = ((String) request.getParameter("name"));
		memberDAOService.deleteMember(name);
		ModelAndView result = new ModelAndView();
		List<Member> memberList = memberDAOService.getMembers();
		result.addObject("result", memberList);
		result.setViewName("main");
		return result;
	}
	@RequestMapping(value ="/updateForm")
	public ModelAndView updateForm(HttpServletRequest request){
		String name = ((String) request.getParameter("name"));
		Member member = memberDAOService.selectOne(name);
		ModelAndView result = new ModelAndView();
		result.addObject("member", member);
		result.setViewName("updateForm");
		return result;
}
	@RequestMapping(value ="/update")
	public String update(Member member){
		memberDAOService.updateMember(member);
		return "redirect:main";
	}
}