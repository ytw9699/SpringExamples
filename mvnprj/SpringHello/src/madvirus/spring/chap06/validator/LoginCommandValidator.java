package madvirus.spring.chap06.validator;

import madvirus.spring.chap06.service.LoginCommand;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class LoginCommandValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return LoginCommand.class.isAssignableFrom(clazz);//LoginCommand�� ��ȿ������
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", "required");
		//��ȿ������ ����� ������Ƽ�� �޽�������� �����ؼ�������
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required");
	}
}
//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", "required");
//�� ���� �ڵ�� �Ʒ� �ڵ�� ������
/*public void validate(Object target, Errors errors) {
	MemberInfo memberInfo = (MemberInfo) target;
	if (memberInfo.getId() == null || memberInfo.getId().trim().isEmpty()) {
		errors.rejectValue("id", "required");
	}
}
ValidatorUtils.rejectIfEmpty() �޼���� ���� null�̰ų� ���̰� 0�� ��� ����Code�� �߰��ϸ�, 
rejectIfEmptyOrWhitespace() �޼����
���� null�̰ų� ���̰� 0�̰ų� �Ǵ� ���� ���� ����(�����̽��ѹ�������)
�� �����Ǿ� �ִ� ��� ���� Code�� �߰��Ѵ�.
//Whitespace�� �����̽��� �ѹ� �����ŵ���Ƴ��°�
 * 
 ValidatorUtils.rejectIfEmpty() �޼���� ���� null�̰ų� ���̰� 0�� ��� ����Code�� �߰��ϸ�, 
rejectIfEmptyOrWhitespace() �޼����
���� null�̰ų� ���̰� 0�̰ų� �Ǵ� ���� ���� ����(�����̽��ѹ�������)
�� �����Ǿ� �ִ� ��� ���� Code�� �߰��Ѵ�. �� �� �̸��� �޼��� ����� �Ʒ��� ����.
- rejectIfEmpty(Errors errors, String field, String errorCode)
- rejectIfEmpty(Errors errors, String field, String errorCode, String defaultMessage)
- rejectIfEmpty(Errors errors, String field, String errorCode, Object[] errorArgs)
- rejectIfEmpty(Errors errors, String field, String errorCode, Object[] errorArgs, String defaultMessage)
- rejectIfEmptyOrWhitespace(Errors errors, String field, String errorCode)//Whitespace�� �����̽��� �ѹ� �����ŵ���Ƴ��°�
- rejectIfEmptyOrWhitespace(Errors errors, String field, String errorCode, String defaultMessage)
- rejectIfEmptyOrWhitespace(Errors errors, String field, String errorCode, Object[] errorArgs)
- rejectIfEmptyOrWhitespace(Errors errors, String field, String errorCode, Object[] errorArgs, String defaultMessage)
	
�޼��� �Ķ���Ϳ��� errorArgs�� ���� Message�� ���Ե� ���� ����̰�, defaultMessage�� ���� Code�� �ش��ϴ� ���� Message�� ��������
���� �� ����� �⺻ Message��. 
 * 
 */