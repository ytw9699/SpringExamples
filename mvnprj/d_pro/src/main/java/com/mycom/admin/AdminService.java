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
	//��ǰ�̸����� �˻�
	@Override
	public List<GoodsModel> goodsSearch0(String search) {
		return sqlSessionTemplate.selectList("goods.goodsSearch0", "%"+search+"%"); 
	}
	//��ǰ��ȣ�� �˻�
	@Override
	public List<GoodsModel> goodsSearch1(String search) {
		return sqlSessionTemplate.selectList("goods.goodsSearch1", "%"+search+"%"); 
	}
	//ī�װ��ΰ˻�
	@Override
	public List<GoodsModel> goodsSearch2(String search) {
		return sqlSessionTemplate.selectList("goods.goodsSearch2", "%"+search+"%"); 
	}
	@Override
	public List<GoodsModel> goodsSearch3(String search) {
		return sqlSessionTemplate.selectList("goods.goodsSearch3", "%"+search+"%"); 
	}


	//�ۻ���
	@Override
	public int goodsDelete(int goods_num) {
		return sqlSessionTemplate.delete("goods.goodsDelete",goods_num); 
	}
	
	//�ۼ���
	@Override
	public int goodsModify(GoodsModel GoodsModel) {
		return sqlSessionTemplate.update("goods.goodsModify",GoodsModel); 
	}
	//�� �ϳ� �ҷ�����
	@Override
	public GoodsModel goodsAdminView(int goods_num){
		return sqlSessionTemplate.selectOne("goods.selectOne-goods",goods_num);
	}
	
	//ȸ����� ���
	@Override
	public List<MemberModel> memberList() {
		return sqlSessionTemplate.selectList("member.memberList");
	}
	
	//ȸ���̸����� �˻�
	@Override
	public List<MemberModel> memberSearch0(String search) {
		return sqlSessionTemplate.selectList("member.memberSearch0", "%"+search+"%"); 
	}
	
	//ȸ������
	@Override
	public int memberDelete(String id) {
		return sqlSessionTemplate.delete("member.deleteMember",id);
	}
	
	//ȸ�������ϱ�
	@Override
	public Object adminmemberModify(MemberModel member) {
		return sqlSessionTemplate.update("member.adminupdateMember", member);
	}
	//�ֹ���縮��Ʈ
	@Override
	public List<OrderModel> orderAllList() {
		return sqlSessionTemplate.selectList("order.orderAllList");
	}
	
	//�ֹ������ϱ�
	@Override
	public Object orderModify(OrderModel OrderModel) {
		return sqlSessionTemplate.update("order.orderModify", OrderModel);
	}
	
	//��ü �˻�
	@Override
	public List<OrderModel> orderSearch0(String search) {
		return sqlSessionTemplate.selectList("order.orderSearch0", "%"+search+"%"); 
	}
	
	//������
	@Override
	public List<OrderModel> orderSearch1(String search) {
		return sqlSessionTemplate.selectList("order.orderSearch1", "%"+search+"%"); 
	}
	
	
	//�ֹ�����
	@Override
	public List<OrderModel> orderSearch2(String search) {
		return sqlSessionTemplate.selectList("order.orderSearch2", "%"+search+"%"); 
	}
	
}
