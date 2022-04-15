package org.zerock.mapper;
	import org.apache.ibatis.annotations.Select;

public interface TestMapper {
	
	//어노테이션을 이용해작성하면 동적으로 불가 고정된 SQL만 가능 그래서 XML파일 같이 하는게 좋음
	@Select("SELECT sysdate FROM dual")
	public String getTime();
	
	public String getTime2();
	
}
