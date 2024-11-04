package com.jhb0430.spring.test.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhb0430.spring.test.mybatis.domain.RealEstate;
import com.jhb0430.spring.test.mybatis.service.RealEstateService;

// 컨트롤러의 기능은 Request, Response!!!
@Controller	// 이름 맘에 안드는데... 
public class RealEstateController {

//	목적 : id를 parameter 로 입력 받고 해당하는 id의 매물 정보를 
//	json으로 출력하세요. -> responsebody 하세요
	
	@Autowired
	private RealEstateService realEstateService;
	
	// ↓ ㄱㄱ 
	
	
	@ResponseBody
	@RequestMapping("/mybatis/real-estate/select/1")
	public RealEstate selectEstate(@RequestParam("id") int id) {
		
		// 테이블 데릴러 가자 서비스로 
		// →서비스에서 만든거 써줘야됨
		
		RealEstate realEstate = realEstateService.getRealEstate(id);
		
		return realEstate;
		
	}
		
		// 여기까지가 기본.... 
		// @RequestParam("변수") 변수 변수이름 적어주기
		
//		2. 월세 조건 select
//		월세(rentPrice) 를 parameter 로 받고 해당하는 월세보다 낮은 매물을 아래와 같이 json 으로 출력하세요.
		
		@ResponseBody
		@RequestMapping("/mybatis/real-estate/select/2")
		public RealEstate selectRentPrice(@RequestParam("rentPrice") int rentPrice) {
			// 일단 서비스로 가볼까 ??
			
			RealEstate estaterentPrice = realEstateService.getRentPrice(rentPrice);
			
			return estaterentPrice;
			
		
	}
	
//		3. 복합조건 select
//		아래 두 parameter를 받고 매매 매물 중 조건에 모두 부합하는 매물 정보를 아래와 같이 json으로 출력하세요.
//		넓이(area) - 매물의 넓이가 전달 받은 넓이 이상인 것
//		가격(price) - 매물의 매매금이 전달받은 매매금 보다 이하인 것
//		등록일을 기준으로 내림 차순으로 정렬하세요.
//		요청 URL 예시
//
//		http://localhost:8080/mybatis/real-estate/select/3?area=90&price=130000
		@ResponseBody
		@RequestMapping("/mybatis/real-estate/select/3")
		public RealEstate selectPriceArea(@RequestParam("area")int area, @RequestParam("price")int price) {
			
			RealEstate esatatePriceArea = realEstateService.getEstatePriceArea(area, price);
			
			return esatatePriceArea;
		}
	
	
}
