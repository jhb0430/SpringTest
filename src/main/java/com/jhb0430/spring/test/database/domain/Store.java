package com.jhb0430.spring.test.database.domain;

import java.time.LocalDateTime;

//Domain 
// Entity Class
//대상 테이블의 컬럼 이름과 정확히 일치하는 멤버 변수를 가진 클래스
//한 행의 정보를 모두 저장하는 객체를 만들기 위한 목적 
public class Store {

	/*
id int AI PK 
name varchar(32) 
phoneNumber varchar(16) 
address varchar(64) 
businessNumber varchar(32) 
introduce text 
createdAt timestamp 
updatedAt timestamp
	 */
	private int id;
	private String name;
	private String phoneNumber;
	private String address;
	private String businessNumber;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBusinessNumber() {
		return businessNumber;
	}
	public void setBusinessNumber(String businessNumber) {
		this.businessNumber = businessNumber;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	private String introduce;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	
	
}
