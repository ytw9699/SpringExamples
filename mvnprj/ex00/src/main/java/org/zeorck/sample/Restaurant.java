package org.zeorck.sample;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Component;
	import lombok.Data;
	import lombok.Setter;
	
@Component 
@Data 
public class Restaurant {
	 @Setter(onMethod_ = @Autowired)
	 private Chef chef;
} 
/*@Component는 스프링에게 해당 클래스가 스프링에서 관리해야 하는 대상임을 표시하는 어노테이션
@Data는 setter를 생성하는 기능과 생성자，toString() 등을 자동으로 생성
@Setter에서 사용된 onMethod 속성은 생성되는 setChef()에 @Autowired 어노테이션을 추가하도록함
@setter는 자동으로 setChef( )를 컴파일 시 생성함*/