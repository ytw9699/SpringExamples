package org.zerock.sample;
	import org.springframework.stereotype.Service;
	import lombok.Data;

@Data
//@Service
public class fakeItalian implements Cookable {//의존성 주입을 해준다면 가짜 구현 객체를 이용해 테스트를 하기 편리하다 
	
	@Override
	public String cook(){
		return "fakeItalian food";
	}
}
