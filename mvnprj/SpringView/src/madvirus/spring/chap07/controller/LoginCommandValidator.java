package madvirus.spring.chap07.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class LoginCommandValidator implements Validator {

@Override
public void validate(Object target, Errors errors) {//��ȿ������
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "required");//�������Է��� �������� id�� required�� ����
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password","required");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "loginType","required");
	//LoginCommand a =(LoginCommand)target;
	//System.out.println(a.getLoginType());//�Ϲ�ȸ���ڵ����õǼ� ����
	
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