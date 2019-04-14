package madvirus.spring.chap06.controller;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;

	@Controller
	@RequestMapping("/order/order.do")
	public class OrderController {

		@RequestMapping(method = RequestMethod.GET)
		public String form() {
			return "order/orderForm";
		}
		
		@RequestMapping(method = RequestMethod.POST)
		public String submit(OrderCommand orderCommand) {
			return "order/orderCompletion";
		}
	}
	