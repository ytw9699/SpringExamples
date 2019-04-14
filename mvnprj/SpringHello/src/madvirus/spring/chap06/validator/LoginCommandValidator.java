package madvirus.spring.chap06.validator;

import madvirus.spring.chap06.service.LoginCommand;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class LoginCommandValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return LoginCommand.class.isAssignableFrom(clazz);//LoginCommand를 유효성검증
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", "required");
		//유효성검증 결과와 프로퍼티스 메시지결과를 연결해서쓰도록
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required");
	}
}
//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", "required");
//위 한줄 코드와 아래 코드는 같은거
/*public void validate(Object target, Errors errors) {
	MemberInfo memberInfo = (MemberInfo) target;
	if (memberInfo.getId() == null || memberInfo.getId().trim().isEmpty()) {
		errors.rejectValue("id", "required");
	}
}
ValidatorUtils.rejectIfEmpty() 메서드는 값이 null이거나 길이가 0인 경우 에러Code를 추가하며, 
rejectIfEmptyOrWhitespace() 메서드는
값이 null이거나 길이가 0이거나 또는 값이 공백 문자(스페이스한번누른거)
로 구성되어 있는 경우 에러 Code를 추가한다.
//Whitespace는 스페이스를 한번 누른거도잡아내는거
 * 
 ValidatorUtils.rejectIfEmpty() 메서드는 값이 null이거나 길이가 0인 경우 에러Code를 추가하며, 
rejectIfEmptyOrWhitespace() 메서드는
값이 null이거나 길이가 0이거나 또는 값이 공백 문자(스페이스한번누른거)
로 구성되어 있는 경우 에러 Code를 추가한다. 이 두 이름의 메서드 목록은 아래와 같다.
- rejectIfEmpty(Errors errors, String field, String errorCode)
- rejectIfEmpty(Errors errors, String field, String errorCode, String defaultMessage)
- rejectIfEmpty(Errors errors, String field, String errorCode, Object[] errorArgs)
- rejectIfEmpty(Errors errors, String field, String errorCode, Object[] errorArgs, String defaultMessage)
- rejectIfEmptyOrWhitespace(Errors errors, String field, String errorCode)//Whitespace는 스페이스를 한번 누른거도잡아내는거
- rejectIfEmptyOrWhitespace(Errors errors, String field, String errorCode, String defaultMessage)
- rejectIfEmptyOrWhitespace(Errors errors, String field, String errorCode, Object[] errorArgs)
- rejectIfEmptyOrWhitespace(Errors errors, String field, String errorCode, Object[] errorArgs, String defaultMessage)
	
메서드 파라미터에서 errorArgs는 에러 Message에 삽입될 인자 목록이고, defaultMessage는 에러 Code에 해당하는 에러 Message가 존재하지
않을 때 사용할 기본 Message다. 
 * 
 */