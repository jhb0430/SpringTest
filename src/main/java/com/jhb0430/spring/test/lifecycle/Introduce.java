package com.jhb0430.spring.test.lifecycle;

public class Introduce {

	private String title;
	private String user;
	private String content;
	
	public Introduce(String title, String user, String content) {
		this.title = title;
		this.user = user;
		this.content = content;
	}
	
	
	
	public String getTitle() {
		return title;
	}
	
	public String getUser() {
		return user;
	}
	public String getContent() {
		return content;
	}
}

