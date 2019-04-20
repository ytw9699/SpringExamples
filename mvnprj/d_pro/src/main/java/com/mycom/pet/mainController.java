package com.mycom.pet;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mycom.goods.GoodsModel;
import com.mycom.goods.GoodsService;

@Controller
public class mainController {
	
	@Resource(name="goodsService")
	private GoodsService goodsService;
	
	ModelAndView mav = new ModelAndView();
	
	
	@RequestMapping(value="/main.dog")
	public ModelAndView mainForm(){
		
		//goods 상품구분 기본=0, 추천=1, 베스트=2, 신상=3에 따라 구분 메인페이지 노출
		List<GoodsModel> goodsSelectList1 = goodsService.goodsSelectList1("1");
		List<GoodsModel> goodsSelectList2 = goodsService.goodsSelectList1("2");
		List<GoodsModel> goodsSelectList3 = goodsService.goodsSelectList1("3");
		
		
		mav.addObject("goodsList1", goodsSelectList1);
		mav.addObject("goodsList2", goodsSelectList2);	
		mav.addObject("goodsList3", goodsSelectList3);	
		mav.setViewName("mainForm");
		return mav;
	}
	
	@RequestMapping(value="/logchek.dog")
	public ModelAndView logchek(){
		
		mav.setViewName("basket/basketAddError");
		
		return mav;
	}
	
	
}
