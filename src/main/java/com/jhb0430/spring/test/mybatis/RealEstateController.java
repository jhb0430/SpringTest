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
		
		
		// 여기까지가 기본.... 
		
		
		
	}
	
	
	
}
