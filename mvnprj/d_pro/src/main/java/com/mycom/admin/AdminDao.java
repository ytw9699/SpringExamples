package com.mycom.admin;

import java.util.List;

import com.mycom.goods.GoodsModel;
import com.mycom.member.MemberModel;
import com.mycom.order.OrderModel;

public interface AdminDao {
	//상품목록
	public List<GoodsModel> goodsList();
	
	//상품등록
	public Object insertGoods(GoodsModel GoodsModel);
	
	//검색 (0=상품이름, 1=상품번호 2=카테고리)
	List<GoodsModel> goodsSearch0(String search);
	List<GoodsModel> goodsSearch1(String search);
	List<GoodsModel> goodsSearch2(String search);
	List<GoodsModel> goodsSearch3(String search);
	
	//글삭제
	public int goodsDelete(int goods_num);
	
	//글수정
	public int goodsModify(GoodsModel GoodsModel);
	
	//글 하나 불러오기 -수정
	public GoodsModel goodsAdminView(int goods_num);
	
	//회원목록
	public List<MemberModel> memberList();
	
	//회원검색
	List<MemberModel> memberSearch0(String search);
	
	//회원삭제
	public int memberDelete(String id);

	public Object adminmemberModify(MemberModel member);
	
	//주문리스트 출력
	public List<OrderModel> orderAllList();
	
	//주문검색
	public List<OrderModel> orderSearch0(String search);
	
	//결재방식
	public List<OrderModel> orderSearch1(String search);
	
	//주문상태
	public List<OrderModel> orderSearch2(String search);
	
	//주문수정
	public Object orderModify(OrderModel OrderModel);
	
}


