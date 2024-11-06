package com.jhb0430.spring.test.mybatis.service;

import java.util.List;

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

	
	/* 여러 행 조회해야하니까 이제는 리턴타입을 리스트로 받아야한다!!!! */

//	public RealEstate getRentPrice(int rentPrice) {
		public List<RealEstate> getRentPrice(int rentPrice) {
		
//		RealEstate estaterentPrice = realEstateRepository.selectRentPrice(rentPrice);
		List<RealEstate> estaterentPrice = realEstateRepository.selectRentPrice(rentPrice);
		
		return estaterentPrice;
	}
	
	public List<RealEstate> getEstatePriceArea(int area, int price) {
		
		List<RealEstate> estatePriceArea = realEstateRepository.selectPriceArea(area, price);
	
		return estatePriceArea;
	}
	
// =======================================
	
	// 전달 받은 정보 기반으로 매물 저장 
	public int addRealEstate(
			int realtorId,
			String address
			, int area
			, String type
			, int price
			, int rentPrice
			){
		//repository에서 값 가져오기
		
		int count =realEstateRepository.insertRealEstate(realtorId,address, area, type, price, rentPrice);
	
		return count;
	}
	
	
	
	public int addRealEstateByObject(RealEstate realEstate) {
		
		int count = realEstateRepository.insertRealEstateByObject(realEstate);
	
		return count;
	}
	
	
	public int editRealEstate(
				int id
				, String type
				, int price
				 
			) {
		
		int count = realEstateRepository.updateRealEstate(id, type, price);
	
		return count;
	}
	
	public int deleteRealEstate(int id) {
		int count = realEstateRepository.deleteRealEstateById(id);
		
		return count;
		
//		 카운트는 성공한 행의 수!! 를 출력하는게 
//		지금 식의 의도이기 때문에 카운트로 리턴 받는 것 뿐임
//		int count 는 공식이 아님을 유의하기 
	}
	
}
