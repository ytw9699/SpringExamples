package madvirus.spring.chap06.validator;
	import madvirus.spring.chap06.model.Address;
	import madvirus.spring.chap06.model.MemberInfo;
	import org.springframework.validation.BindingResult;
	import org.springframework.validation.Errors;
	import org.springframework.validation.Validator;
	//서버단에 데이타 보내기전에 유효성검증은 자바스크립트가 했는데
	//여기선 폼으로부터 데이터가 넘어온거고 그거를 자바빈에 설정했는데 ,그 자바빈 가주고 유효성 검증하는것 
	//memberinfo //String id; String name ,Address address;//전송되지않은 값이있으면 오류를 내야해서
public class MemberInfoValidator implements Validator {//Validator인터페이스 구현
	@Override
	public boolean supports(Class<?> clazz) {
		//오버라이드//MemberInfo자바빈가주고 유효성검증을 할수있는지 여부를 체크하는 메소드
		//supports() 메서드는 검증할 객체의 타입(Class) 정보를 파라미터로 전달받는데,
		return MemberInfo.class.isAssignableFrom(clazz);//MemberInfo.class만 자바빈이름을 바꿔서 유효성검증
	} //위의 Code는 검사 대상 객체의 MemberInfo Class 또는 그 하위 Class인지의 여부를 검사한다.
	@Override
	public void validate(Object target, Errors errors) {//자바빈의 값을 이용해서 실제 유효성 검증//오버라이드
	//유효성검증하다가 오류가 발생되면 errors객체에 설정
	MemberInfo memberInfo = (MemberInfo) target;//오브젝트라 형변환
	//BindingResult error = (BindingResult)errors;//이거는 형변환 안하고 써도됨..
	if (memberInfo.getId() == null || memberInfo.getId().trim().isEmpty()) {//trim앞뒤공백없애고 isEmpty데이터가없거나
		errors.rejectValue("id", "required");//id는 자바빈에 있는거//프로퍼티스에 required이거를 연결하도록
		//jsp와 연동해서 오류메시지가 출력되도록//errors객체에다가 에러관련된 메시지를 설정한다
	}
	if (memberInfo.getName() == null || memberInfo.getName().trim().isEmpty()) {
		errors.rejectValue("name", "required");
		//errors.rejectValue() 메서드는 "name" 프로퍼티의 값이 올바르지 않고 에러 Code는 "required"라는 것을 기록한다.
	}
	Address address = memberInfo.getAddress();
	if (address == null) {//주소가 널이면
		errors.rejectValue("address", "required");//에러즈에 이런설정함
		//rejectValue메소드는 자바빈안에들어간 변수 하나하나에 대한 에러 설정
	}
	if (address != null) {//널이아니면 //우편번호와 주소도 검증
		errors.pushNestedPath("address");//이건뭐지?질문=//if (address.getZipcode()로 접근가능하다는것
		try {
			if (address.getZipcode() == null || address.getZipcode().trim().isEmpty()) {
				errors.rejectValue("zipcode", "required");
			}
			if (address.getAddress1() == null || address.getAddress1().trim().isEmpty()) {
				errors.rejectValue("address1", "required");
			}
		} finally {
			errors.popNestedPath();//=(memberInfo.address.getZipcode()처럼 원래대로 돌아와서 접근가능하다는것
			}
		}
		}
	}