package com.jhb0430.spring.test.mvc.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jhb0430.spring.test.mvc.domain.Seller;

@Mapper
public interface SellerRepository {

	public int insertSeller(
			@Param("nickname") String nickname
			, @Param("temperature") double temperature
			, @Param("profileImage") String profileImage
			);
	
	// xml 안만든거 ㄹㅇ 바보아녀??? 


// 최근 들어간 애 뽑자~~

	public Seller selectSeller();
	
	public Seller selectIdSeller(@Param("id") int id);
	


}