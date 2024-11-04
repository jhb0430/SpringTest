package com.jhb0430.spring.test.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhb0430.spring.test.mybatis.domain.RealEstate;
import com.jhb0430.spring.test.mybatis.repository.RealEstateRepository;

@Service
public class RealEstateService {

	// id가 ?? 인 행의 매물 정보 얻어오기 
	
	@Autowired
	private RealEstateRepository realEstateRepository;
	
	public RealEstate getRealEstate(int id) {
		//real_estate의 행 조회
		// 근데 행 조회는 ?? 서비스가 못한댔어 -> Repository 가야됨

		
		// repository 만든거 써야하니까 ↑ 위에 멤버 변수 만들어줘야함
		RealEstate realEstate = realEstateRepository.selectRealEstate(id);
		
		return realEstate;
		
		// 이제 컨트롤러로 돌아가자 
	
	}


	public RealEstate getRentPrice(int rentPrice) {
		
		RealEstate estaterentPrice = realEstateRepository.selectRentPrice(rentPrice);
		
		return estaterentPrice;
	}
	
	public RealEstate getEstatePriceArea(int area, int price) {
		
	RealEstate estatePriceArea = realEstateRepository.selectPriceArea(area, price);
	
		return estatePriceArea;
	}
	

}
