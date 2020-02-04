package org.zerock.sample;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Component;
	import lombok.Data;
	import lombok.Setter;
	
@Component //@Component는 스프링에게 해당 클래스가 스프링에서 관리해야 하는 대상임을 표시하는 어노테이션 그러면 스프링은 이클래스 인스턴스를 생성해줌
@Data //@Data는 setter를 생성하는 기능과 생성자，toString() 등을 자동으로 생성
	  // @ToString, @EqualsAndHashCode, @Getter/©Setter, 
	  //@RequiredArgsCtonstructor를 모두결합한 형태로 자주 사용되는 모든 메서드들을 한 번에 생성할 수 있다는 장점
public class Restaurant {//Restaurant 객체는 Chef 타입의 객체를 필요로 하는 상황
	 @Setter(onMethod_ = @Autowired)//@Autowired는 스프링 내부에서 자신이 특정한 객체에 의존적이므로 자신에게 해당 타입의 빈을 주입해주라는 표시
	 private cook chef;
	 /*
		 @setter는 자동으로 setChef()메서드를 컴파일 시 생성함
		 @Setter에서 사용된 onMethod 속성은 생성되는 setChef()에 @Autowired 어노테이션을 추가하도록함
		 스프링은 @Autowired 어노테이션붙어서 chef객체를 주입해줌
	 */
} 

