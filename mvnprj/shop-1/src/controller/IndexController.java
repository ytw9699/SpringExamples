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
//옛날버전은 2.5 이랬다..컨트롤러,리퀘스트 어노테이션이 하나도 안붙음
public class IndexController implements Controller {//추억의 컨트롤러 2.5버전
	//어노테이션 없이 Controller인터페이스 구현 내가만드는 클래스는 컨트롤러다 

private Shop shopService;

public void setShopService(Shop shopService) {
	this.shopService = shopService;
}
/*<bean id="indexController" name="/index.html" class="controller.IndexController"
p:shopService-ref="shopService">
</bean>*/
//@RequestMapping("/game/users/")과 같은 리퀘스트 맵핑이 여기없음, 위 주석 index.html이 맵핑이다
public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

	//상품 목록 정보 취득
	List<Item> itemList = this.shopService.getItemList();

	//모델 생성
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("itemList", itemList);

	//반환값인 ModelAndView 인스턴스 생성
	ModelAndView modelAndView = new ModelAndView();
	modelAndView.setViewName("/WEB-INF/jsp/index.jsp");//경로를 다씀//viewresover안쓰고
	modelAndView.addAllObjects(model);//map을 모델단에 저장하고 jsp에서쓰자

	return modelAndView;
}
}











