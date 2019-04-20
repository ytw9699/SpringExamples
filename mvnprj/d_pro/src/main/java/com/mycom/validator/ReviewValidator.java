package com.mycom.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mycom.member.MemberModel;
import com.mycom.review.ReviewModel;

public class ReviewValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return ReviewModel.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// memberModel�� ��ȿ���˻��ϴ� Ÿ������ ����
		ReviewModel review = (ReviewModel) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "subject", "subject");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "content", "content");
	}
}