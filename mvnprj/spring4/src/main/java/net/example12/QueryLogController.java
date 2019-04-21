package net.example12;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

//@InitBinder Annotation과 커스텀 데이터 타입 변환 처리
@Controller
public class QueryLogController {
	/*@ModelAttribute("command")
	public QueryLogCommand formBacking() {
		return new QueryLogCommand();
	}*/
	@RequestMapping("/example12/logquery.do")
	public String query(@ModelAttribute("command") QueryLogCommand command,
			BindingResult result) {
		if (result.hasErrors()) {
			return "example12/logList";//유효성검증결과 에러가있으면 다시 포워딩
		}
		return "example12/logList";
	}
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));//true or false
		//binder.setValidator(new LoginCommandValidator());//이부분이 생력되서 알아서 동작하는듯
	}
}
