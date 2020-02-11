package org.zerock.domain;
	import java.util.Date;
	import org.springframework.format.annotation.DateTimeFormat;
	import lombok.Data;
	
@Data
public class TodoDTO {

  private String title;
  
  //문자열로 'yyyy/MM/dd’의 형식으로 요청이 들어온게맞다면 자동으로 날짜 타입으로 변환이 됨
  @DateTimeFormat(pattern = "yyyy/MM/dd")
  private Date dueDate;
}
//@DateTimeFormat을쓰거나 or 컨트롤러에서 아래를 설정하거나 둟중하나하면됨

//@InitBinder
	// public void initBinder(WebDataBinder binder) {

	// 		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	// 		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,
	// 		false));
	// }
