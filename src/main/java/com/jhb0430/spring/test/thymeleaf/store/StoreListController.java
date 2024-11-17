package com.jhb0430.spring.test.thymeleaf.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jhb0430.spring.test.database.domain.Store;
import com.jhb0430.spring.test.database.service.StoreService;

@RequestMapping("/store")
@Controller
public class StoreListController {

	// 데이터베이스 단원에서 사용한 서비스 사용
	@Autowired
	private StoreService storeService;
	
	@Autowired
	private ReviewService reviewService;
	
	
	@GetMapping("/list")
	public String storeList(Model model) {
		
		List<Store> store = storeService.getStoreList();
		
		model.addAttribute("store", store);
		
		
		return"thymeleaf/store/storeList";
		
	}
	
	@GetMapping("/review")
	public String reviewList(Model model) {
		
		List<Review> review = reviewService.getReview();
		
		model.addAttribute("review", review);
		
		return "thymeleaf/store/storeReview";
		
	}
	
	
	
}
