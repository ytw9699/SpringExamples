package com.mycom.goods;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mycom.pet_img.Pet_imgCommentModel;



@Controller
@RequestMapping("/goods")
public class GoodsController {
	
	@Resource(name="goodsService")
	private GoodsService goodsService;
	
	ModelAndView mav = new ModelAndView();
	
	String session_member_id;
	
	//goods 리스트
	@RequestMapping("goodsList.dog")
	public ModelAndView goodsList(HttpServletRequest request) throws Exception{		
			
		List<GoodsModel> goodslist=goodsService.goodsList();		
		
		mav.addObject("goodsList", goodslist);
		mav.setViewName("goodsList");
		
		return mav;
		
	}
	
	
	///goods 카테고리별로 리스트 뽑아내기
	@RequestMapping("goodsCategoryList.dog")
	public ModelAndView goodsCategoryList(HttpServletRequest request) throws Exception{
		
		String goods_categoryy = request.getParameter("goods_category");
		
		List<GoodsModel> goodsCategoryList = goodsService.goodsCategoryList(goods_categoryy);
		
		mav.addObject("cate",goods_categoryy);
		mav.addObject("goodsList", goodsCategoryList);
		mav.setViewName("goodsList");
		return mav;
	}
	
	//goods View 상세보기
	@RequestMapping("goodsView.dog")
	public ModelAndView goodsView(HttpServletRequest request) throws Exception{
		
		int goods_num = Integer.parseInt(request.getParameter("goods_num"));
		
		GoodsModel goodsModel = goodsService.goodsView(goods_num);
		
		mav.addObject("goodsModel",goodsModel);
		
		mav.addObject("commentlist",goodsService.commentList(goodsModel.getGoods_num()));
		
		mav.setViewName("goodsView");
		return mav;
	}
	
	
	
	
	
	@RequestMapping("goodsSearchList.dog")
	public ModelAndView goodsSearchList(HttpServletRequest request){
		
		ModelAndView mav = new ModelAndView();
		
		String search = request.getParameter("search");
		
		List<GoodsModel> goodslist = goodsService.goodsSearchList(search);
		
		mav.addObject("goodsList", goodslist);
		mav.setViewName("goodsList");
		
		return mav;
	}
	
	
	@RequestMapping("/commentWrite.dog")
	public ModelAndView commentWrite(HttpServletRequest request, HttpSession session, GoodsCommentModel goodsCommentModel) {
		
		ModelAndView mav=new ModelAndView();
		
		try{
			session_member_id=session.getAttribute("session_member_id").toString();
		
			
			if(session_member_id == null){
				mav.setViewName("pet_img/loginConfirm");
				return mav;
			}
			
			if(request.getParameter("commentt").equals("") || request.getParameter("commentt").trim().isEmpty()) {
			
				mav.setViewName("pet_img/commentConfirm");
				return mav;
			}
			
		}	
		catch(NullPointerException np) {
			mav.setViewName("pet_img/commentConfirm");
			
			return mav;
		}
		
		
		int goods_no = Integer.parseInt(request.getParameter("item_no"));
		
		goodsCommentModel.setCommentt(request.getParameter("commentt").replaceAll("\r\n", "<br />"));
		goodsCommentModel.setGoods_no(goods_no);
		goodsCommentModel.setCmter(session_member_id);
		
		goodsService.writecomment(goodsCommentModel);
		
		mav.setViewName("redirect:goodsView.dog?goods_num="+goods_no);
		
		return mav;
		
		
	}

		@RequestMapping("/commentDelete.dog")
		public ModelAndView commentDelete(HttpServletRequest request, GoodsCommentModel goodsCommentModel ){
		
			ModelAndView mav=new ModelAndView();
		
			goodsService.deletecomment(goodsCommentModel);
		
			mav.setViewName("redirect:goodsView.dog?goods_num="+goodsCommentModel.getGoods_no());
		
			return mav;
		
	}
	
	
	
}


