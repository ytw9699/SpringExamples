package org.zerock.sample;
	import org.springframework.stereotype.Service;
	import lombok.Data;

@Data
@Service//chef종류중에서 이 서비스 어노테이션이 들어가 있는게 주입이 됨, 객체간의 관계를 구성하는것임
public class ChineseChef implements Cookable {
	
	@Override
	public String cook(){
		return "Chinese food";
	}
}
