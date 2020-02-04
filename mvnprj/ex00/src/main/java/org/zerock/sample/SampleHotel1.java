package org.zerock.sample;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Component;
	import lombok.Data;
	import lombok.Setter;
	
@Component 
@Data
public class SampleHotel1 {
	
	@Setter(onMethod_ = @Autowired)//의존성 주입 방식 Setter 주입
	private Cook chef;
	
} 


