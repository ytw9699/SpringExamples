package com.mycom.basket;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mycom.goods.GoodsModel;
import com.mycom.goods.GoodsService;

@Controller
public class BasketController {

	@Resource(name="basketService")
	private BasketService basketService;
	
	@Resource(name="goodsService")
	private GoodsService goodsService;
	
	ModelAndView mav = new ModelAndView();
	
	private List<BasketModel> basketList = new ArrayList<BasketModel>();

	
	
	
	/*장바구니에 추가*/
	@RequestMapping(value="goods/basketAdd.dog")
	public ModelAndView basketAdd(HttpServletRequest request, GoodsModel goodsModel){
		
		BasketModel basketModel = new BasketModel();
		GoodsModel goodsModel2 = new GoodsModel();
		
		String id = request.getParameter("basket_member_id");
		
		if(id != "" ){
			
		goodsModel2 = goodsService.goodsView(goodsModel.getGoods_num());
		
		basketModel.setBasket_member_id(id);
		basketModel.setBasket_goods_num(goodsModel2.getGoods_num());
		basketModel.setBasket_goods_name(goodsModel2.getGoods_name());
		basketModel.setBasket_goods_price(goodsModel2.getGoods_price());
		basketModel.setBasket_goods_amount(goodsModel.getGoods_amount());
		basketModel.setBasket_goods_image(goodsModel2.getGoods_image());
			
		basketService.insertBasket(basketModel);
		mav.setViewName("redirect:/basket/basketList.dog");
		
		}else{
		
			mav.setViewName("basket/basketAddError");
		}
		
		return mav;
	}

	
	/*장바구니 리스트*/
	@RequestMapping(value="basket/basketList.dog")
	public ModelAndView basketList(HttpServletRequest request, HttpSession session){
		
		session = request.getSession();
	
		BasketModel basketModel = new BasketModel();
		
		String basket_member_id = (String)session.getAttribute("session_member_id");
		
		basketModel.setBasket_member_id(basket_member_id);
		
		if(basketModel.getBasket_member_id() != null ){
		
		basketList= basketService.BasketList(basketModel);
		
		mav.addObject("basketList", basketList);
		mav.setViewName("basketList");
		}else{
			mav.setViewName("redirect:/logchek.dog");
		}
		
		return mav;
	}
	
	
	/*장바구니 삭제*/
	@RequestMapping(value="basket/basketdelete.dog")
	public ModelAndView deleteBasket(HttpServletRequest request, BasketModel basketModel){
		
		basketService.deleteBasket(basketModel);
		
		mav.setViewName("redirect:/basket/basketList.dog");
		
		return mav;
	}
	


}
