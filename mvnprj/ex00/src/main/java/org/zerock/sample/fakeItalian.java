package org.zerock.sample;
	import org.springframework.stereotype.Service;
	import lombok.Data;

@Data
//@Service
public class fakeItalian implements Cook {//가짜 구현 객체
	
	@Override
	public String cook(){
		return "fakeItalian cook";
	}
}
