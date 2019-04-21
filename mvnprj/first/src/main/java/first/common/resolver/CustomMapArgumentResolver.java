package first.common.resolver;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;

import org.springframework.web.method.support.ModelAndViewContainer;

import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import first.common.common.CommandMap;
//http://addio3305.tistory.com/75?category=772645
//HandlerMethodArgumentResolver 는 사용자 요청이 Controller에 도달하기 전에 그 요청의 파라미터들을 수정할 수 있도록 해준다.(값을 자바빈에 꼽는거같은거)
//문제는 HandlerMethodArgumentResolver는 컨트롤러의 파라미터가 Map 형식이면 동작하지 않는다. 
//Map 형식이면 우리가 설정한 클래스가 아닌, 스프링에서 기본적으로 설정된 ArgumentResolver를 거치게 된다. 
//항상 그렇게 동작하는것은 아니고, 스프링의 <mvc:annotation-driven/>을 선언하게 되면 위에서 이야기한것처럼 동작하게 된다. 
//그래서 HandlerMethodArgumentResolver인터페이스를 구현한 클래스를 만들어주고
//맵 을 상속받지 않고!맵과 같은 클래스를 직접만들어서 해줘야한다는것

public class CustomMapArgumentResolver implements HandlerMethodArgumentResolver{
	//전송된걸 맵으로 다이렉트로 받기 위한 클래스 
@Override
public boolean supportsParameter(MethodParameter parameter) {
	return CommandMap.class.isAssignableFrom(parameter.getParameterType());
	//내가만든 CommandMap클래스가 활용가능한지 적용 가능한지 검사하는 역할을 하고,
}
@Override//파라미터와 기타 정보를 받아서 실제 자바빈처럼 쓰여질 객체를 반환한다.
public Object resolveArgument(MethodParameter parameter,
		ModelAndViewContainer mavContainer,
		NativeWebRequest webRequest,
		WebDataBinderFactory binderFactory) throws Exception {
	CommandMap commandMap = new CommandMap();//맵객체 생성
	
	HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
	//HttpServletRequest리퀘스트 객체받아서
	Enumeration<?> enumeration = request.getParameterNames();//리퀘스트로 부터 파라미터 이름들 받아서
	
	String key = null;
	String[] values = null;
	while(enumeration.hasMoreElements()){
		key = (String) enumeration.nextElement();
		values = request.getParameterValues(key);
		if(values != null){
			commandMap.put(key, (values.length > 1) ? values:values[0] );//맵에다 키와값을 넣는다
		}
	}
	return commandMap;
}
}
