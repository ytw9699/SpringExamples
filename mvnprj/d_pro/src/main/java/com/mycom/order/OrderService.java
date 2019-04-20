package com.mycom.order;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements OrderDao {

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	@Override
	public Object OrderInsert(OrderModel orderModel) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert("order.orderInsert", orderModel);
	}

	@Override
	public List<OrderModel> OrderList(OrderModel orderModel) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("order.orderList", orderModel);
	}

	@Override
	public Object deleteOrder(OrderModel orderModel) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.delete("order.deleteOrder", orderModel);
	}

	@Override
	public OrderModel OrdergetOne(int order_num) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("order.ordergetOne", order_num);
	}

	@Override
	public Object OrderModify(OrderModel orderModel) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update("order.orderModify", orderModel);
	}

	@Override
	public Object OrderTradeNum() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("order.orderTradeNum");
	}

}
