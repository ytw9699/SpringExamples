package org.zerock.domain;
	import lombok.Data;

/*	SampleDTO 클래스는 Lombok의 ©Data 어노테이션을 이용해서 처리합니다. ©Data
	를 이용하게 되면 getter/setter, equals(), toString() 등의 메서드를 자동 생성하기
	때문에 편리합니다.*/
	
@Data
public class SampleDTO {

  private String name;
  private int age;
}
