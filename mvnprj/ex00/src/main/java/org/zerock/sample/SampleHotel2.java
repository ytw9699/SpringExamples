package org.zerock.sample;
	import org.springframework.stereotype.Component;
	import lombok.Getter;
	import lombok.ToString;
	
@Component 
@ToString
@Getter
public class SampleHotel2 {
	
	private Cookable chef;
	
	public SampleHotel2(Cookable chef) {//생성자 주입 방식
		this.chef = chef;
//@Autowired와 같은 어노테이션을 추가해야만 생성자 주입이 이루어 졌지만 스프링 4.3 이후에는 묵시적으로 생성자 주입이 가능
//코드를 보면 기존과 달리 생성자를 선언하고 Chef를 주입하도록 작성 
//기존과 다른 점은 @Autowired 어노테이션이 없이 처리되고 있다는 점.
	}
} 


