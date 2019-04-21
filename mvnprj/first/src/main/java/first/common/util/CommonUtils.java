package first.common.util;

import java.util.UUID;

public class CommonUtils {
	
	public static String getRandomString(){
		return UUID.randomUUID().toString().replaceAll("-", "");//랜덤한 문자열만듬
							//5d5d7ff396ef49edbf95002b7de462fb
	}
}
