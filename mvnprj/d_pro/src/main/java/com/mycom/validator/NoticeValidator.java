package com.mycom.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mycom.notice.NoticeModel;

public class NoticeValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		
		return NoticeModel.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "subject", "subject");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "content", "content");
	}
}