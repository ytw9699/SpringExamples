package com.mycom.order;

import java.util.List;


public interface OrderDao {

	public Object OrderInsert(OrderModel orderModel);
	
	public List<OrderModel> OrderList(OrderModel orderModel);
	
	public Object deleteOrder(OrderModel orderModel);
	
	public OrderModel OrdergetOne(int order_num);
	
	public Object OrderModify(OrderModel orderModel);
	
	public Object OrderTradeNum();
}
