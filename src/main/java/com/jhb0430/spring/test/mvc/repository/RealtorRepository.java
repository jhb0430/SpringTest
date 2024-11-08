package com.jhb0430.spring.test.mvc.repository;

import org.apache.ibatis.annotations.Mapper;

import com.jhb0430.spring.test.mvc.domain.Realtor;

@Mapper
public interface RealtorRepository {

	
	public int insertRealtor(Realtor realtor);
	
	
	public Realtor selectRealtor();
}
