package org.zerock.sample;
	import org.springframework.stereotype.Service;
	import lombok.Data;

@Data
@Service
public class maleChef implements Chef {
	
	@Override
	public String cook(){
		return "male cook";
	}
}
