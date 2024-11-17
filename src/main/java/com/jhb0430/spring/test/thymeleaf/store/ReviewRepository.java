package com.jhb0430.spring.test.thymeleaf.store;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReviewRepository {

	
	public List<Review> selectReview();
}
