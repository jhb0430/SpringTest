package com.jhb0430.spring.test.mybatis.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jhb0430.spring.test.mybatis.domain.RealEstate;

@Mapper
public interface RealEstateRepository {

	public RealEstate selectRealEstate(@Param("id")int id);
		// 조회해야되니까 xml 가자 
	
	// 다시 서비스
	
	
//	public RealEstate selectRentPrice(@Param("rentPrice")int rentPrice);
	public List<RealEstate> selectRentPrice(@Param("rentPrice")int rentPrice);
	
	
	public List<RealEstate> selectPriceArea(@Param("area")int area,@Param("price")int price);
	
	
	// 전달받은 정보를 기반으로 insert
	public int insertRealEstate(
			@Param("realtorId") int realtorId
			,@Param("address") String address
			,@Param("area") int area
			,@Param("type") String type
			,@Param("price") int price
			);
	
	
	public int insertRealEstateByObject(RealEstate realEstate);
	
}
