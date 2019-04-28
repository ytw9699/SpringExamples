package org.zerock.domain;
	import java.util.Date;
	import org.springframework.format.annotation.DateTimeFormat;
	import lombok.Data;
	
@Data
public class TodoDTO {

  private String title;
  
  @DateTimeFormat(pattern = "yyyy/MM/dd")
  private Date dueDate;
}
//@DateTimeFormat 을쓰거나 컨트롤러에서 아래를 설정하거나 둟중하나하면됨
//@InitBinder
	// public void initBinder(WebDataBinder binder) {
	// SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	// binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,
	// false));
	// }
