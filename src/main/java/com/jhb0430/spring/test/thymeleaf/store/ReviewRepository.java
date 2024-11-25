package com.jhb0430.spring.test.thymeleaf.store;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ReviewRepository {

	
	public List<Review> selectReview(@Param("storeId") int storeId);
//	public List<Review> selectReview();
	
	
	
//	public Review selectStoreId(@Param("storeId") int storeId);
	
}

