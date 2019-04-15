package madvirus.spring.chap07.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class LoginCommandValidator implements Validator {

@Override
public void validate(Object target, Errors errors) {//유효성검증
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "required");//데이터입력을 안했을때 id를 required와 연결
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password","required");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "loginType","required");
	//LoginCommand a =(LoginCommand)target;
	//System.out.println(a.getLoginType());//일반회원자동선택되서 찍힘
	
/*	public void validate(Object target, Errors errors) {
		MemberInfo memberInfo = (MemberInfo) target;
		if (memberInfo.getId() == null || memberInfo.getId().trim().isEmpty()) {
			errors.rejectValue("id", "required");*/
}
@Override
public boolean supports(Class<?> clazz) {
	return LoginCommand.class.isAssignableFrom(clazz);
}

}	