package org.zerock.sample;
	import org.springframework.stereotype.Component;
	import lombok.Data;
	
@Component 
@Data
public class SampleHotel4 {
	
	private Chef chef = new maleChef();//직접 생성방식
	//private Chef chef = new femaleChef();//직접 생성방식의 단점
	
} 


