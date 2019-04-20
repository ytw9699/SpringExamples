package com.mycom.pet;

import java.util.Date;

public class PetCommentModel {

	private int comment_num;
	private int pet_no;
	private String cmter;
	private String commentt;
	private Date cmt_date;
	
	
	public int getComment_num() {
		return comment_num;
	}
	public void setComment_num(int comment_num) {
		this.comment_num = comment_num;
	}

	public int getPet_no() {
		return pet_no;
	}
	public void setPet_no(int pet_no) {
		this.pet_no = pet_no;
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
	public Date getCmt_date() {
		return cmt_date;
	}
	public void setCmt_date(Date cmt_date) {
		this.cmt_date = cmt_date;
	}
	
	
	
	
}
