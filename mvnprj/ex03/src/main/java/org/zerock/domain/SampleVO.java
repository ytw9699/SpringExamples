package org.zerock.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor//모든 변수의값을 가진 생성자
@NoArgsConstructor//그냥 기본생성자
public class SampleVO {

  private Integer mno;
  private String firstName;
  private String lastName;

}
