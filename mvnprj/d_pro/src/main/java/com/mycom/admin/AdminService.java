package com.mycom.admin;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.mycom.goods.GoodsModel;
import com.mycom.member.MemberModel;
import com.mycom.order.OrderModel;
@Service
public class AdminService implements AdminDao{
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<GoodsModel> goodsList(){
		return sqlSessionTemplate.selectList("goods.goodsList");
	}
	
	@Override
	public Object insertGoods(GoodsModel GoodsModel) {
		return sqlSessionTemplate.insert("goods.insertGoods", GoodsModel);
		
	}
	//상품이름으로 검색
	@Override
	public List<GoodsModel> goodsSearch0(String search) {
		return sqlSessionTemplate.selectList("goods.goodsSearch0", "%"+search+"%"); 
	}
	//상품번호로 검색
	@Override
	public List<GoodsModel> goodsSearch1(String search) {
		return sqlSessionTemplate.selectList("goods.goodsSearch1", "%"+search+"%"); 
	}
	//카테고리로검색
	@Override
	public List<GoodsModel> goodsSearch2(String search) {
		return sqlSessionTemplate.selectList("goods.goodsSearch2", "%"+search+"%"); 
	}
	@Override
	public List<GoodsModel> goodsSearch3(String search) {
		return sqlSessionTemplate.selectList("goods.goodsSearch3", "%"+search+"%"); 
	}


	//글삭제
	@Override
	public int goodsDelete(int goods_num) {
		return sqlSessionTemplate.delete("goods.goodsDelete",goods_num); 
	}
	
	//글수정
	@Override
	public int goodsModify(GoodsModel GoodsModel) {
		return sqlSessionTemplate.update("goods.goodsModify",GoodsModel); 
	}
	//글 하나 불러오기
	@Override
	public GoodsModel goodsAdminView(int goods_num){
		return sqlSessionTemplate.selectOne("goods.selectOne-goods",goods_num);
	}
	
	//회원목록 출력
	@Override
	public List<MemberModel> memberList() {
		return sqlSessionTemplate.selectList("member.memberList");
	}
	
	//회원이름으로 검색
	@Override
	public List<MemberModel> memberSearch0(String search) {
		return sqlSessionTemplate.selectList("member.memberSearch0", "%"+search+"%"); 
	}
	
	//회원삭제
	@Override
	public int memberDelete(String id) {
		return sqlSessionTemplate.delete("member.deleteMember",id);
	}
	
	//회원수정하기
	@Override
	public Object adminmemberModify(MemberModel member) {
		return sqlSessionTemplate.update("member.adminupdateMember", member);
	}
	//주문모든리스트
	@Override
	public List<OrderModel> orderAllList() {
		return sqlSessionTemplate.selectList("order.orderAllList");
	}
	
	//주문수정하기
	@Override
	public Object orderModify(OrderModel OrderModel) {
		return sqlSessionTemplate.update("order.orderModify", OrderModel);
	}
	
	//전체 검색
	@Override
	public List<OrderModel> orderSearch0(String search) {
		return sqlSessionTemplate.selectList("order.orderSearch0", "%"+search+"%"); 
	}
	
	//결재방식
	@Override
	public List<OrderModel> orderSearch1(String search) {
		return sqlSessionTemplate.selectList("order.orderSearch1", "%"+search+"%"); 
	}
	
	
	//주문상태
	@Override
	public List<OrderModel> orderSearch2(String search) {
		return sqlSessionTemplate.selectList("order.orderSearch2", "%"+search+"%"); 
	}
	
}
