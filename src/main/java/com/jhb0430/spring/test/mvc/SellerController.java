package com.jhb0430.spring.test.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhb0430.spring.test.mvc.domain.Seller;
import com.jhb0430.spring.test.mvc.service.SellerService;

@Controller

@RequestMapping("/mvc/seller")
public class SellerController {

	@Autowired
	private SellerService sellerService;
	
	// 테이블 정보 가져오기
	@PostMapping("/create")
	@ResponseBody
	public String createSeller(
			@RequestParam("nickname") String nickname
			,@RequestParam("temperature") double temperature
			,@RequestParam("profileImage") String profileImage
				) {
		
		int count = sellerService.addSeller(nickname, temperature, profileImage);
		
		return "입력 성공 : " + count;
	}
	@GetMapping("/input")
	public String sellerInput() {
		return "mvc/sellerInput";
	}
	
	//2. seller 출력 
	// 샘플데이터를 가지고 화면구성하기
	@GetMapping("/info")
	public String sellerInfo(Model model) {
		
		Seller seller = sellerService.getSeller();
		
		model.addAttribute("title","판매자 정보");
		model.addAttribute("result",seller);
		
		return "mvc/sellerInfo";
	}
	
	//3. seller 검색 출력
//	2번 문제에서 만든 결과를 재사용해서 id 를 parameter로 받아서 해당하는 seller를 출력하세요.
//	id parameter가 없는 경우와 있는 경우 모두 처리 가능하도록 구현하세요.
	
//	@RequestParam("id") int id;
	
	@GetMapping("/info")
	public String sellerIdInfo(Model model, @RequestParam("id") int id) {
		
		Seller sellerId = sellerService.getIdSeller(id);
		
		model.addAttribute("title","판매자 정보");
		model.addAttribute("result",sellerId);
		
		return "mvc/sellerInfo";
	}
	
/* 
	 	SELECT 
 			`nickname`
 			,`temperature`
 			,`profileImage`
 		FROM
 			`seller`
	
 		WHERE `id`= 3;
 */
}
