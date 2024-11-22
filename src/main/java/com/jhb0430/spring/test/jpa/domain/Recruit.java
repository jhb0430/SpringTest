package com.jhb0430.spring.test.jpa.domain;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder(toBuilder=true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name="`recruit`")
@Entity
public class Recruit {

//		id int AI PK 
//		companyId int 
//		position varchar(64) 
//		responsibilities varchar(128) 
//		qualification text 
//		type varchar(8) 
//		region varchar(16) 
//		salary int 
//		deadline timestamp 
//		createdAt timestamp 
//		createdAt
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="companyId")
	private int companyId;
	private String position;
	private String responsibilities;
	private String qualification;
	private String type;
	private String region;
	private int salary;
	private LocalDateTime deadline;
	@Column(name="createdAt")
	@CreationTimestamp
	private LocalDateTime createdAt;
	@Column(name="updatedAt")
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
}
