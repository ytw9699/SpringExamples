package net.example14;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class SameValueController {
	@RequestMapping("/example14/Checkbox.do")
	public String Checkboxform() {
		return "example14/Checkboxform";
	}
	@RequestMapping("/example14/Checkbox.do2")
	public String Checkboxform2(@ModelAttribute("CheckboxModel") CheckboxModel CheckboxModel) {
		return "example14/CheckView";
	}
}


