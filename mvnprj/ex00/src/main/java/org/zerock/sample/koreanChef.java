package org.zerock.sample;
	import org.springframework.stereotype.Service;
	import lombok.Data;

@Data
//@Service
public class koreanChef implements Cookable {
	
	@Override
	public String cook(){
		return "korean food";
	}
}
