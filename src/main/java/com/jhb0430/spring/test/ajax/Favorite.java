package com.jhb0430.spring.test.ajax;

import java.time.LocalDateTime;

public class Favorite {

	// id name url createdAt updatedAt
	private int id;
	private String name;
	private String url;
	private LocalDateTime createdAt;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	
	
	
	
}
