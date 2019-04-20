package com.mycom.notice;

import java.util.Date;

public class NoticeModel {
	
	private int no;
	private String name;	
	private String subject;
	private String content;	
	private Date regdate;
	private int readcount;
	
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
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	/*public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}*/
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public void setReadhit(int readcount) {
		this.readcount = readcount;
	}
}