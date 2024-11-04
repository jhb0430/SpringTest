package com.jhb0430.spring.test.mybatis.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jhb0430.spring.test.mybatis.domain.RealEstate;

@Mapper
public interface RealEstateRepository {

	public RealEstate selectRealEstate(@Param("id")int id);
		// 조회해야되니까 xml 가자 
	
	// 다시 서비스 
}
