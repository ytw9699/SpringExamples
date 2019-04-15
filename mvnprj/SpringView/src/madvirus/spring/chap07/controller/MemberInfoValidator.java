package madvirus.spring.chap07.controller;

	import org.springframework.validation.Errors;
	import org.springframework.validation.ValidationUtils;
	import org.springframework.validation.Validator;

	public class MemberInfoValidator implements Validator {

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.address1","required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.address2","required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "jobCode", "required");
		MemberInfo memberInfo = (MemberInfo) target;
		if (memberInfo.getFavorites() == null || memberInfo.getFavorites().length == 0) {
			errors.rejectValue("favorites", "must_select");//배열이라 따로하는거
		}
	}
	@Override
	public boolean supports(Class<?> clazz) {
		return MemberInfo.class.isAssignableFrom(clazz);
	}

}