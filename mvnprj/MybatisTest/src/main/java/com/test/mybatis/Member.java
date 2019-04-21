package com.test.mybatis;
public class Member {
	private String name;//_바들어가니까 다 소문자로 만들어짐
	private String email;
	private String phone;

	public Member(){
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}