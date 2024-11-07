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
//	@ResponseBody			 리스폰스 받을 게 아니니까 지워준다 
	public String createSeller(
			@RequestParam("nickname") String nickname
			,@RequestParam("temperature") double temperature
			,@RequestParam("profileImage") String profileImage
				) {
		
		int count = sellerService.addSeller(nickname, temperature, profileImage);
//		return "입력 성공 : " + count;
		// addSeller도 잇어야되넹... 
		
		return "redirect:/mvc/seller/info";
	}
	
	
	
	// 1. 의 입력 성공 -> 리다이렉트 해서 2로 이동되도록 하기.
	
	// 입력화면 
	// html 불러오기
	@GetMapping("/input")
	public String sellerInput() {
		return "mvc/sellerInput";
	}
	

	
	
	
	/*
	
	//↓ 얘네 합치기
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
	
	/* 
	파라미터가 없는 경우는 머지...?
	@GetMapping("/infoId")
	public String sellerIdInfo(Model model, @RequestParam("id") int id) {
		
		Seller sellerId = sellerService.getIdSeller(id);
		
		model.addAttribute("title","판매자 정보");
		model.addAttribute("result",sellerId);
		
		return "mvc/sellerInfo";
	}
	 */
	
	
@GetMapping("/info")																//정수로 받는데 비어도 null을 받을 수 있는 애!!! 
	public String sellerInfo(Model model,@RequestParam(value="id" ,required = false) Integer id) {
		
		Seller seller = sellerService.getSeller(id);
		
		model.addAttribute("title","판매자 정보");
		model.addAttribute("result",seller);
		
		// seller 제일 마지막에 저장된 id값 가져오기 
		
		
		return "mvc/sellerInfo";
	}
	
/*
 * 	=========		풀이		============
 * 
 *  	if(id == null){
 *  	Seller seller = sellerService.getSeller();
 *  
 *  	model.addAttribute("seller",seller);
 *  	}else {
 *  	Seller seller = sellerService.getSeller(id);
 *  	model.addAttribute("seller",seller);
 *  }
 * 
 * 
 * 
 * */
	
	
	
	
	
	
	
}
