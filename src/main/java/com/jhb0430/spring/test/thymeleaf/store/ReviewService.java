package com.jhb0430.spring.test.thymeleaf.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;
	
	public List<Review> getReview(){
		
		List<Review> review = reviewRepository.selectReview();
		
		return review;
	}
}
