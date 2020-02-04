package org.zerock.sample;
	import org.springframework.stereotype.Component;
	import lombok.Data;
	
@Component 
@Data
public class SampleHotel4 {//직접 생성방식의 단점
	
	//private Chef chef = new ChineseChef();
	private Cook chef = new koreanChef();
	
} 


