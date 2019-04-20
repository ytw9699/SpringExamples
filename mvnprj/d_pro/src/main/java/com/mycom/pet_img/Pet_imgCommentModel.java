package com.mycom.pet_img;

import java.util.Date;

public class Pet_imgCommentModel {
	
	private int comment_num;
	private int pet_img_no;
	private String cmter;
	private String commentt;
	private String cmt_delete;
	private Date cmt_date;
	
	public void setCmt_delete(String cmt_delete) {
		this.cmt_delete = cmt_delete;
	}
	public String getCmt_delete() {
		return cmt_delete;
	}

	public int getComment_num() {
		return comment_num;
	}
	public void setComment_num(int comment_num) {
		this.comment_num = comment_num;
	}
	public int getPet_img_no() {
		return pet_img_no;
	}
	public void setPet_img_no(int pet_img_no) {
		this.pet_img_no = pet_img_no;
	}
	public String getCommentt() {
		return commentt;
	}
	public void setCommentt(String commentt) {
		this.commentt = commentt;
	}
	public int getMv_no() {
		return pet_img_no;
	}
	public void setMv_no(int mv_no) {
		this.pet_img_no = mv_no;
	}
	public String getCmter() {
		return cmter;
	}
	public void setCmter(String cmter) {
		this.cmter = cmter;
	}

	public Date getCmt_date() {
		return cmt_date;
	}
	public void setCmt_date(Date cmt_date) {
		this.cmt_date = cmt_date;
	}
	
	

}
