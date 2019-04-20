package com.mycom.goods;

import java.util.List;
import com.mycom.goods.GoodsModel;


public interface GoodsDao {
	public List<GoodsModel> goodsList();
	
	public GoodsModel goodsView(int goods_num);
	
	public List<GoodsModel> goodsCategoryList(String goods_category);
	//1=��õ, 2=����Ʈ, 3=�Ż�
	public List<GoodsModel> goodsSelectList1(String goods_best);
	
	public Object amountDown(GoodsModel goodsModel);
	
	
	public List<GoodsModel> goodsSearchList(String search);
	
	public Object writecomment(GoodsCommentModel goodsCommentModel);
	
	public List<GoodsCommentModel> commentList(int goods_no);
	
	public Object deletecomment(GoodsCommentModel goodsCommentModel);
	
	
}
