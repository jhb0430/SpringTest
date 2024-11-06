package com.jhb0430.spring.test.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhb0430.spring.test.mvc.domain.Seller;
import com.jhb0430.spring.test.mvc.repository.SellerRepository;

@Service
public class SellerService {

	@Autowired
	private SellerRepository sellerRepository;
	
	
	public int addSeller(
			String nickname
			, double temperature
			, String profileImage
			) {
		
		int count = sellerRepository.insertSeller(nickname, temperature, profileImage);
		
		return count;
	}
	
	// 가장 최근에 추가된 seller 정보 출력하기 
	public Seller getSeller() {
		
		Seller seller = sellerRepository.selectSeller();
		
		return seller;
	}
	public Seller getIdSeller(int id) {
		
		Seller sellerId = sellerRepository.selectSeller();
		
		return sellerId;
	}
	
}
