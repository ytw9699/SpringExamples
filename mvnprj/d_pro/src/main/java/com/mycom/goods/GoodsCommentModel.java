package com.mycom.goods;

import java.util.Date;

public class GoodsCommentModel {

	
	private int comment_num;
	private int goods_no;
	private String cmter;
	private String commentt;
	private int goods_point;
	private Date cmt_date;
	
	
	public int getComment_num() {
		return comment_num;
	}
	public void setComment_num(int comment_num) {
		this.comment_num = comment_num;
	}
	public int getGoods_no() {
		return goods_no;
	}
	public void setGoods_no(int goods_no) {
		this.goods_no = goods_no;
	}
	public String getCmter() {
		return cmter;
	}
	public void setCmter(String cmter) {
		this.cmter = cmter;
	}
	public String getCommentt() {
		return commentt;
	}
	public void setCommentt(String commentt) {
		this.commentt = commentt;
	}

	public int getGoods_point() {
		return goods_point;
	}
	public void setGoods_point(int goods_point) {
		this.goods_point = goods_point;
	}
	public Date getCmt_date() {
		return cmt_date;
	}
	public void setCmt_date(Date cmt_date) {
		this.cmt_date = cmt_date;
	}
	
	
	
	
}
