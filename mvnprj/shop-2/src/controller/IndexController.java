package controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.Item;
import logic.Shop;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class IndexController implements Controller {

	private Shop shopService;

	public void setShopService(Shop shopService) {
		this.shopService = shopService;
	}

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 상품 목록 정보를 취득
		List<Item> itemList = this.shopService.getItemList();

		// 모델 생성
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemList", itemList);

		// 반환값인 ModelAndView 인스턴스 생성
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		modelAndView.addAllObjects(model);

		return modelAndView;
	}
}












