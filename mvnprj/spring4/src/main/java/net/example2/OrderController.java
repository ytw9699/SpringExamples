package net.example2;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
@Controller
@RequestMapping("/example2/order.do")
public class OrderController {

	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return "example2/orderForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submit(OrderCommand orderCommand) {
		return "example2/orderCompletion";
	}
}
	