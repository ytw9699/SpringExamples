package com.mycom.goods;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


@Service
public class GoodsService implements GoodsDao{
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<GoodsModel> goodsList(){
		return sqlSessionTemplate.selectList("goods.goodsList");
	}
	
	@Override
	public GoodsModel goodsView(int goods_num){
		return sqlSessionTemplate.selectOne("goods.selectOne-goods",goods_num);
	}

	@Override
	public List<GoodsModel> goodsCategoryList(String goods_category) {
		return sqlSessionTemplate.selectList("goods.select-goods-category",goods_category);
	}

	@Override
	public List<GoodsModel> goodsSelectList1(String goods_best) {
		return sqlSessionTemplate.selectList("goods.select-goods-select",goods_best);
	}

	@Override
	public Object amountDown(GoodsModel goodsModel) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update("goods.amountDown", goodsModel);
	}

	@Override
	public List<GoodsModel> goodsSearchList(String search) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("goods.goodsSearchList", "%"+search+"%");
	}

	@Override
	public Object writecomment(GoodsCommentModel goodsCommentModel) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert("goods.writecomment",goodsCommentModel); 
	}

	@Override
	public List<GoodsCommentModel> commentList(int goods_no) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("goods.commentList",goods_no);
	}

	@Override
	public Object deletecomment(GoodsCommentModel goodsCommentModel) {
		
		return sqlSessionTemplate.delete("goods.deletecomment", goodsCommentModel);
	}

	
	
}
