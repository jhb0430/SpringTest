package com.jhb0430.spring.test.thymeleaf.store;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Review {

//	id int AI PK 
//	storeId int 
//	menu varchar(32) 
//	userName varchar(32) 
//	point decimal(2,1) 
//	review varchar(256) 
//	createdAt timestamp 
//	updatedAt timestamp
//	
	
	private int id;
	private int StoreId;
	private String menu;
	private String userName;
	private double point;
	private String review;
	private LocalDateTime createdAt;
	private LocalDateTime updateAt;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStoreId() {
		return StoreId;
	}
	public void setStoreId(int storeId) {
		StoreId = storeId;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public double getPoint() {
		return point;
	}
	public void setPoint(double point) {
		this.point = point;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(LocalDateTime updateAt) {
		this.updateAt = updateAt;
	}
	
	
	
}
