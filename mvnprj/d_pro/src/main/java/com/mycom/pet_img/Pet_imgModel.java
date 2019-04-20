package com.mycom.pet_img;

import java.util.Date;

public class Pet_imgModel {

	
	private int no;
	private String name;
	private String id;
	private String content;
	private String subject;
	private Date regdate;
	private int readcount;
	private int recommendation;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public int getRecommendation() {
		return recommendation;
	}
	public void setRecommendation(int recommendation) {
		this.recommendation = recommendation;
	}
	
	
	
	
	
}
