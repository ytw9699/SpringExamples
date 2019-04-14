package madvirus.spring.chap06.controller;

	import java.util.List;
	import madvirus.spring.chap06.model.Address;
	import madvirus.spring.chap06.model.OrderItem;

	public class OrderCommand {

		private List<OrderItem> orderItems;//자바빈 안에 또다른 객체
		private Address address;//또 다른 자바빈

		public void setOrderItems(List<OrderItem> orderItems) {
			this.orderItems = orderItems;
		}
		public List<OrderItem> getOrderItems() {
			return orderItems;
		}
		public Address getAddress() {
			return address;
		}
		public void setAddress(Address address) {
			this.address = address;
		}

	}