package com.jhb0430.spring.test.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhb0430.spring.test.mvc.domain.Realtor;
import com.jhb0430.spring.test.mvc.repository.RealtorRepository;

@Service
public class RealtorService {

	@Autowired
	private RealtorRepository realtorRepository;
	
	// 객체 받아오는 기능
	public int addRealtor(Realtor realtor) {
		
		int count = realtorRepository.insertRealtor(realtor);
	
		return count;
	}
	
	/*private String office;
	private String phoneNumber;
	private String address;
	private String grade;*/
	
	
	public Realtor getRealtor() {
		
		Realtor realtor = realtorRepository.selectRealtor();
		
		return realtor;
	}

	
}
