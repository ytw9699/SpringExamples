package org.zerock.sample;
	import org.springframework.stereotype.Component;
	import lombok.Data;
	
@Component 
@Data
public class SampleHotel5 {//직접 생성방식의 단점
	
	//private Chef chef = new ItalianChef();
	private cook chef = new fakeItalian();//가짜 구현 객체를 만든것을 넣어주기위해 코드 수정이필요
										//수십개 클래스에 코드  수정필요
	
} 


