package madvirus.spring.chap06.validator;
	import madvirus.spring.chap06.model.Address;
	import madvirus.spring.chap06.model.MemberInfo;
	import org.springframework.validation.BindingResult;
	import org.springframework.validation.Errors;
	import org.springframework.validation.Validator;
	//�����ܿ� ����Ÿ ���������� ��ȿ�������� �ڹٽ�ũ��Ʈ�� �ߴµ�
	//���⼱ �����κ��� �����Ͱ� �Ѿ�°Ű� �װŸ� �ڹٺ� �����ߴµ� ,�� �ڹٺ� ���ְ� ��ȿ�� �����ϴ°� 
	//memberinfo //String id; String name ,Address address;//���۵������� ���������� ������ �����ؼ�
public class MemberInfoValidator implements Validator {//Validator�������̽� ����
	@Override
	public boolean supports(Class<?> clazz) {
		//�������̵�//MemberInfo�ڹٺ��ְ� ��ȿ�������� �Ҽ��ִ��� ���θ� üũ�ϴ� �޼ҵ�
		//supports() �޼���� ������ ��ü�� Ÿ��(Class) ������ �Ķ���ͷ� ���޹޴µ�,
		return MemberInfo.class.isAssignableFrom(clazz);//MemberInfo.class�� �ڹٺ��̸��� �ٲ㼭 ��ȿ������
	} //���� Code�� �˻� ��� ��ü�� MemberInfo Class �Ǵ� �� ���� Class������ ���θ� �˻��Ѵ�.
	@Override
	public void validate(Object target, Errors errors) {//�ڹٺ��� ���� �̿��ؼ� ���� ��ȿ�� ����//�������̵�
	//��ȿ�������ϴٰ� ������ �߻��Ǹ� errors��ü�� ����
	MemberInfo memberInfo = (MemberInfo) target;//������Ʈ�� ����ȯ
	//BindingResult error = (BindingResult)errors;//�̰Ŵ� ����ȯ ���ϰ� �ᵵ��..
	if (memberInfo.getId() == null || memberInfo.getId().trim().isEmpty()) {//trim�յڰ�����ְ� isEmpty�����Ͱ����ų�
		errors.rejectValue("id", "required");//id�� �ڹٺ� �ִ°�//������Ƽ���� required�̰Ÿ� �����ϵ���
		//jsp�� �����ؼ� �����޽����� ��µǵ���//errors��ü���ٰ� �������õ� �޽����� �����Ѵ�
	}
	if (memberInfo.getName() == null || memberInfo.getName().trim().isEmpty()) {
		errors.rejectValue("name", "required");
		//errors.rejectValue() �޼���� "name" ������Ƽ�� ���� �ùٸ��� �ʰ� ���� Code�� "required"��� ���� ����Ѵ�.
	}
	Address address = memberInfo.getAddress();
	if (address == null) {//�ּҰ� ���̸�
		errors.rejectValue("address", "required");//����� �̷�������
		//rejectValue�޼ҵ�� �ڹٺ�ȿ��� ���� �ϳ��ϳ��� ���� ���� ����
	}
	if (address != null) {//���̾ƴϸ� //�����ȣ�� �ּҵ� ����
		errors.pushNestedPath("address");//�̰ǹ���?����=//if (address.getZipcode()�� ���ٰ����ϴٴ°�
		try {
			if (address.getZipcode() == null || address.getZipcode().trim().isEmpty()) {
				errors.rejectValue("zipcode", "required");
			}
			if (address.getAddress1() == null || address.getAddress1().trim().isEmpty()) {
				errors.rejectValue("address1", "required");
			}
		} finally {
			errors.popNestedPath();//=(memberInfo.address.getZipcode()ó�� ������� ���ƿͼ� ���ٰ����ϴٴ°�
			}
		}
		}
	}