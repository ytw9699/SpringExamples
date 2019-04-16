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
//���������� 2.5 �̷���..��Ʈ�ѷ�,������Ʈ ������̼��� �ϳ��� �Ⱥ���
public class IndexController implements Controller {//�߾��� ��Ʈ�ѷ� 2.5����
	//������̼� ���� Controller�������̽� ���� ��������� Ŭ������ ��Ʈ�ѷ��� 

private Shop shopService;

public void setShopService(Shop shopService) {
	this.shopService = shopService;
}
/*<bean id="indexController" name="/index.html" class="controller.IndexController"
p:shopService-ref="shopService">
</bean>*/
//@RequestMapping("/game/users/")�� ���� ������Ʈ ������ �������, �� �ּ� index.html�� �����̴�
public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

	//��ǰ ��� ���� ���
	List<Item> itemList = this.shopService.getItemList();

	//�� ����
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("itemList", itemList);

	//��ȯ���� ModelAndView �ν��Ͻ� ����
	ModelAndView modelAndView = new ModelAndView();
	modelAndView.setViewName("/WEB-INF/jsp/index.jsp");//��θ� �پ�//viewresover�Ⱦ���
	modelAndView.addAllObjects(model);//map�� �𵨴ܿ� �����ϰ� jsp��������

	return modelAndView;
}
}











