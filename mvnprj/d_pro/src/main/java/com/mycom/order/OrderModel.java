package com.mycom.order;

import java.util.Date;

public class OrderModel {

			private int order_num;
			private String order_trans_num; // 송장 번호 기본값-준비중
			private int order_goods_num; //상품번호
			private String order_goods_name; //상품 이름
			private int order_goods_price; 
			private int order_goods_amount;
			private String order_member_id;
			private String order_receive_name;
			private String order_receive_addr;
			private String order_receive_mobile;
			private String order_receive_zipcode;
			private String order_memo;
			private int order_sum_money; //포문로직처리
			private String order_trade_type; //결제방법 라디오버튼
			private Date order_trade_date;  //주문날짜
			private String order_trade_payer; //입금계좌
			private Date order_date; //결제날짜
			private String order_status; //주문상태 기본값 입금확인
			private String order_goods_image;
			private int order_trade_num;
			
			public String getOrder_goods_image() {
				return order_goods_image;
			}
			public void setOrder_goods_image(String order_goods_image) {
				this.order_goods_image = order_goods_image;
			}
			public int getOrder_num() {
				return order_num;
			}
			public void setOrder_num(int order_num) {
				this.order_num = order_num;
			}
			public String getOrder_trans_num() {
				return order_trans_num;
			}
			public void setOrder_trans_num(String order_trans_num) {
				this.order_trans_num = order_trans_num;
			}
			public int getOrder_goods_num() {
				return order_goods_num;
			}
			public void setOrder_goods_num(int order_goods_num) {
				this.order_goods_num = order_goods_num;
			}
			public String getOrder_goods_name() {
				return order_goods_name;
			}
			public void setOrder_goods_name(String order_goods_name) {
				this.order_goods_name = order_goods_name;
			}
			public int getOrder_goods_price() {
				return order_goods_price;
			}
			public void setOrder_goods_price(int order_goods_price) {
				this.order_goods_price = order_goods_price;
			}
			public int getOrder_goods_amount() {
				return order_goods_amount;
			}
			public void setOrder_goods_amount(int order_goods_amount) {
				this.order_goods_amount = order_goods_amount;
			}
			public String getOrder_member_id() {
				return order_member_id;
			}
			public void setOrder_member_id(String order_member_id) {
				this.order_member_id = order_member_id;
			}
			public String getOrder_receive_name() {
				return order_receive_name;
			}
			public void setOrder_receive_name(String order_receive_name) {
				this.order_receive_name = order_receive_name;
			}
			public String getOrder_receive_addr() {
				return order_receive_addr;
			}
			public void setOrder_receive_addr(String order_receive_addr) {
				this.order_receive_addr = order_receive_addr;
			}
			public String getOrder_receive_mobile() {
				return order_receive_mobile;
			}
			public void setOrder_receive_mobile(String order_receive_mobile) {
				this.order_receive_mobile = order_receive_mobile;
			}
			public String getOrder_receive_zipcode() {
				return order_receive_zipcode;
			}
			public void setOrder_receive_zipcode(String order_receive_zipcode) {
				this.order_receive_zipcode = order_receive_zipcode;
			}
			public String getOrder_memo() {
				return order_memo;
			}
			public void setOrder_memo(String order_memo) {
				this.order_memo = order_memo;
			}
			public int getOrder_sum_money() {
				return order_sum_money;
			}
			public void setOrder_sum_money(int order_sum_money) {
				this.order_sum_money = order_sum_money;
			}
			public String getOrder_trade_type() {
				return order_trade_type;
			}
			public void setOrder_trade_type(String order_trade_type) {
				this.order_trade_type = order_trade_type;
			}
			public Date getOrder_trade_date() {
				return order_trade_date;
			}
			public void setOrder_trade_date(Date order_trade_date) {
				this.order_trade_date = order_trade_date;
			}
			public String getOrder_trade_payer() {
				return order_trade_payer;
			}
			public void setOrder_trade_payer(String order_trade_payer) {
				this.order_trade_payer = order_trade_payer;
			}
			public Date getOrder_date() {
				return order_date;
			}
			public void setOrder_date(Date order_date) {
				this.order_date = order_date;
			}
			public String getOrder_status() {
				return order_status;
			}
			public void setOrder_status(String order_status) {
				this.order_status = order_status;
			}
			public int getOrder_trade_num() {
				return order_trade_num;
			}
			public void setOrder_trade_num(int order_trade_num) {
				this.order_trade_num = order_trade_num;
			}
			
		
			
			
	
			
			
			
			
			
	
}
