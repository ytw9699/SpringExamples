package org.zerock.sample;
	import org.springframework.stereotype.Service;
	import lombok.Data;

@Data
//@Service
public class ItalianChef implements Cookable {//아직 미완성된 ItalianChef객체
	
	@Override
	public String cook(){
		throw new UnsupportedOperationException();
		//return "Italian food";
	}
}
