package org.zerock.sample;
	import org.springframework.stereotype.Service;
	import lombok.Data;

@Data
//@Service
public class femaleChef implements Chef {
	
	@Override
	public String cook(){
		return "female cook";
	}
}
