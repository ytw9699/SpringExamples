package org.zerock.sample;
	import org.springframework.stereotype.Component;
	import lombok.AllArgsConstructor;
	import lombok.Getter;
	import lombok.ToString;
	
@Component 
@ToString
@Getter
@AllArgsConstructor//@AllArgsConstructor는 인스턴스 변수로 선언된 모든 것을 파라미터로 받는 생성자를 작성하게 된다.
public class SampleHotel3 {//생성자 주입 방식
	
	private Cookable chef;
	
	/*public SampleHotel3(Chef chef) {
		this.chef = chef;
	}*/
} 


