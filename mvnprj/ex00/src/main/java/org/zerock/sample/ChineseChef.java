package org.zerock.sample;
	import org.springframework.stereotype.Service;
	import lombok.Data;

@Data
@Service
public class ChineseChef implements Cook {
	
	@Override
	public String cook(){
		return "Chinese cook";
	}
}
