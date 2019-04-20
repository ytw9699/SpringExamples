package com.mycom.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mycom.member.MemberModel;

public class ModifyValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		// 유효성검사하려는 model이 Validation가능한지 여부를 확인하고 가능하면 검사시작
		return MemberModel.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		// memberModel을 유효성검사하는 타겟으로 잡음
		MemberModel member = (MemberModel) target;
		
		// ValidationUtils 클래스를 사용하지 않고 유효성 검사하는 다른방법
		
		/*if(member.getId() == null || member.getId().trim().isEmpty()) {
			errors.rejectValue("id", "id");
		}
		
		if(member.getPasswd() == null || member.getPasswd().trim().isEmpty()) {
			errors.rejectValue("passwd", "passwd");
		}
		
		if(member.getPasswd().equals(member.getPasswd2()) == false) {
			errors.rejectValue("passwd2", "passwd2");
		}
		
		if(member.getBirth() == null || member.getBirth().trim().isEmpty()) {
			errors.rejectValue("birth", "birth");
		}
		
		if(member.getEmail() == null || member.getEmail().trim().isEmpty()) {
			errors.rejectValue("email", "email");
		}*/
		
		// rejectIfEmptyOrWhitespace(errors, "1", "2");
		// "1" = 검사할 객체 , "2" = 에러가나면 뜰 문구 (properties에 등록한 변수)
		// "1"이 없거나 공백을 뺀부분이 비어있으면 "2"로 에러메시지를 내보낸다.
		// <form:input type="text" path="1">
		// <form:errors path="2">
	
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password");
		
		if(member.getPassword().equals(member.getPassword2()) == false) {
			errors.rejectValue("password2", "password2");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name");
  	    ValidationUtils.rejectIfEmpty(errors, "email", "email");
	}

}
