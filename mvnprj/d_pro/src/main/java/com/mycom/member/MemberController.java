package com.mycom.member;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mycom.member.MemberService;
import com.mycom.member.MemberModel;

import com.mycom.validator.MemberValidator;


@Controller
@RequestMapping("/member")
public class MemberController {
   
   @Resource(name="memberService")
   private MemberService memberService;
   
   ModelAndView mav = new ModelAndView();
   
   
   private List<ZipcodeModel> zipcodeList = new ArrayList<ZipcodeModel>();
   
   
   //로그인 폼
   @RequestMapping(value="/login.dog", method=RequestMethod.GET)
   public String loginForm() {
      return "loginForm";
   }

   //로그인동작 및 세션 생성
   @RequestMapping(value="/login.dog", method=RequestMethod.POST)
   public ModelAndView memberLogin(HttpServletRequest request, MemberModel mem) {

      MemberModel result = memberService.memberLogin(mem);
      //ModelAndView mav = new ModelAndView();
      
      if(result!=null) {
         
         HttpSession session = request.getSession();         
         
         session.setAttribute("mem", result);
         session.setAttribute("session_member_id", result.getId());
         session.setAttribute("session_member_name", result.getName());
         session.setAttribute("session_member_no", result.getNum());
      
         session.setAttribute("TOKEN_SAVE_CHECK", "TRUE");
                 
         mav.setViewName("member/loginSuccess");
         return mav;
      }
      
      //System.out.println("로그인 실패");         
      mav.setViewName("member/loginError");
      return mav;
         
   }
   
   
   
   @RequestMapping("/logout.dog")
   public ModelAndView memberLogout(HttpServletRequest request, MemberModel mem){
      
      HttpSession session = request.getSession(false);
      
      if(session!=null){
         session.invalidate();
      }
      mav.addObject("member", new MemberModel());
      //ModelAndView mav = new ModelAndView();
      mav.setViewName("member/logout");
      return mav;
   }
   
   
   //유효성검사했을때 에러있을시 넘어가게끔 해줘야함
      @ModelAttribute("member")
      public MemberModel formBack() {
         return new MemberModel();
      }
      
      @RequestMapping("/member.dog")
      public ModelAndView memberStep1(){
         
    	 ModelAndView mav = new ModelAndView();
    	  
         mav.setViewName("member");
         return mav;
      }
      
      
      
      @RequestMapping("/memberEnd.dog")
      public ModelAndView memberStep3(@ModelAttribute("member") MemberModel member,
                              BindingResult result) {
         
         //<form:form commandName="member"> 검사할 model을 영역에 올려준 이름과 동일하게한다.
         
         // Validation Binding
         new MemberValidator().validate(member, result);
         
         // 에러가있으면 회원가입폼으로 넘어감
         if(result.hasErrors()) {
        	 
        	ModelAndView mav = new ModelAndView();
        	 
            mav.setViewName("member");
            return mav;
         }
         try {
            // 유효성검사에 통과하면 회원가입
        	member.setAddr(member.getAddr()+" " + member.getAddr2());
            
            memberService.insertMember(member);
            mav.addObject("member",member);
            mav.setViewName("memberEnd");
            return mav;
         } catch (DuplicateKeyException e) {
            // db에서 id의 제약조건을 unique로 바꿨기 때문에 중복된 아이디로 가입하려하면 DuplicateKeyException이 뜨게되고
            // 예외처리로 properties파일에 등록된 "invalid"의 내용이 나오게 만들고 회원가입폼으로 돌아가게했음.
            // 아이디 중복검사
            result.reject("invalid", null);
            mav.setViewName("member");
            return mav;
         }

      }
      

  	@RequestMapping(value = "/memberIdFind.dog", method = RequestMethod.GET)
  	public ModelAndView memberFindForm() {
  		mav.setViewName("member/idFind");
  		return mav;
  	}

  	@RequestMapping(value = "/memberIdFind.dog", method = RequestMethod.POST)
  	public ModelAndView memberIdFind(@ModelAttribute("member") MemberModel member, HttpServletRequest request) {

  		int memberFindChk;

  		member = memberService.idFindByName(member);
  		if (member == null) {
  			memberFindChk = 0; // 가입되어 있는 사람 X;
  			mav.addObject("memberFindChk", memberFindChk);
  			mav.setViewName("member/idFindError");
  			return mav;

  		} else {
  			if (member.getName().equals(member.getName()) && member.getEmail().equals(member.getEmail())) {
  				memberFindChk = 1; // 회원가입되어 있음, 이메일 일치
  				mav.addObject("member", member);
  				mav.addObject("memberFindChk", memberFindChk);
  				mav.setViewName("member/idFindOk");
  				return mav;
  			} else {
  				memberFindChk = -1; // 이름 , 이메일 틀림
  				mav.addObject("memberFindChk", memberFindChk);
  				mav.setViewName("member/idFindError");
  				return mav;
  			}
  		}
  	}

  	// 비밀번호찾기
  	@RequestMapping(value = "/memberPwFind.dog", method = RequestMethod.GET)
  	public ModelAndView memberPwFindForm() {
  		mav.setViewName("member/pwFind");
  		return mav;
  	}

  	@RequestMapping(value = "/memberPwFind.dog", method = RequestMethod.POST)
  	public ModelAndView memberPwFind(@ModelAttribute("member") MemberModel member, HttpServletRequest request) {

  		int memberFindChk;


  		member = memberService.pwFindById(member);
  		
  		if (member == null) {
  			memberFindChk = 0; // 가입되어 있는 사람 X;
  			mav.addObject("memberFindChk", memberFindChk);
  			mav.setViewName("member/idFindError");
  			return mav;

  		} else {
  			
  			if (member.getId().equals(member.getId()) && member.getEmail().equals(member.getEmail())) {
  				memberFindChk = 1; // 회원가입되어 있음, 이메일 일치
  				mav.addObject("member", member);
  				mav.addObject("memberFindChk", memberFindChk);
  				mav.setViewName("member/pwFindOk");
  				return mav;
  			} else {
  				memberFindChk = -1; // 이름 , 이메일 틀림
  				mav.addObject("memberFindChk", memberFindChk);
  				mav.setViewName("member/idFindError");
  				return mav;
  			}
  		}
  	}

  	// 회원정보수정
  	@RequestMapping("/memberModify.dog")
  	public ModelAndView memberModify(@ModelAttribute("member") MemberModel member, BindingResult result,
  			HttpSession session) {
  		session.getAttribute("session_member_id");

  		if (session.getAttribute("session_member_id") != null) {
  			String id = (String) session.getAttribute("session_member_id");
  			member = memberService.getMember(id);

  			mav.addObject("member", member);
  			mav.setViewName("memberModify");
  			return mav;
  		} else {

  			mav.setViewName("loginConfirm");
  			return mav;
  		}
  	}

  	@RequestMapping("/memberModifyEnd.dog")
  	public ModelAndView memberModifyEnd(@ModelAttribute("member") MemberModel member, BindingResult result) {
  		// Validation Binding
  		/*new MemberValidator().validate(member, result);*/
  	
  		try {
  			// 유효성검사에 통과하면
  			memberService.memberModify(member);
  			mav.setViewName("memberModifyEnd");
  			return mav;
  		} catch (DuplicateKeyException e) {
  			// db에서 id의 제약조건을 unique로 바꿨기 때문에 중복된 아이디로 가입하려하면
  			// DuplicateKeyException이 뜨게되고
  			// 예외처리로 properties파일에 등록된 "invalid"의 내용이 나오게 만들고 회원가입폼으로 돌아가게했음.
  			// 아이디 중복검사
  			result.reject("invalid", null);
  			System.out.println("캐치에러");
  			mav.setViewName("memberModify");
  			return mav;
  		}

  	}
   
      @RequestMapping(value="/zipcodeCheckForm.dog")
      public ModelAndView zipcodeCheckForm( HttpServletRequest req) throws Exception{
         ModelAndView mv = new ModelAndView();

             mv.setViewName("check/zipcodeCheck");
          return mv;
   }
      /*회원가입시 우편번호 검색 로직*/ 
      @RequestMapping(value="/zipcodeCheck.dog")
      public ModelAndView zipcodeCheck( @ModelAttribute ZipcodeModel zipcodeModel ,HttpServletRequest req) throws Exception{
         
    	 ModelAndView mv = new ModelAndView();
         
         int chk=100;

         zipcodeList = memberService.zipcodeCheck(zipcodeModel);
             
         mv.addObject("zipcode", zipcodeList);
                
         if(zipcodeList.size() == 0){
        	 chk =0;
         }else{
        	 chk=1;
         }
             mv.addObject("chk",chk);
             mv.setViewName("check/zipcodeCheck");
             return mv;
          }   
   
   
        @RequestMapping("/memberWith.dog")
     	public ModelAndView memberWith() {
     		mav.setViewName("signOut");
     		return mav;
     	}
     	
     	@RequestMapping("/memberDelete.dog")
     	public ModelAndView memberDelete(@ModelAttribute("member") MemberModel member, BindingResult result, HttpSession session, HttpServletRequest request) {
     		
     		MemberModel memberModel; // 쿼리 결과 값을 저장할 객체
     		
     		String id;
     		String password;
     		password = request.getParameter("password");
     		int deleteCheck;
     		
     		//해당 아이디의 정보를 가져온다
     		id = session.getAttribute("session_member_id").toString();
     		memberModel = (MemberModel) memberService.getMember(id);
     		
     		
     		
     		if(memberModel.getPassword().equals(password)) {
     			//패스워드가 맞으면
     			deleteCheck = 1;
     			//삭제 쿼리 수행
     			memberService.memberDelete(id);
     			session.removeAttribute("session_member_id");
     			session.removeAttribute("session_member_name");
     		/*	session.removeAttribute("session_member_no");*/
     		}
     		else {
     			deleteCheck = -1; //패스워드가 안맞을때
     		}
     		
     		mav.addObject("deleteCheck", deleteCheck);
     		mav.setViewName("deleteResult");
     		return mav;
     	}
   
   
}
