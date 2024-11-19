package com.jhb0430.spring.test.ajax.booking;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ajax/booking")
public class BookingController {
	
	
	@Autowired
	private BookingService bookingService;
	
	
	
	// 예약 목록 쿼리 전체 조회
	@GetMapping("/list")
	public  String BookingList(Model model) {
		List<Booking> booking = bookingService.getBookingList();
		
		model.addAttribute("booking", booking);
		
		return"ajax/booking/bookinglist";
		
	}
	
	
	// 예약 입력 페이지
	
	@GetMapping("/input")
	
	public String inputBooking(){
		
		return "ajax/booking/booking-input";
	}
	
	
	// create
	@ResponseBody
	@PostMapping("/create")
	public Map<String,String> createBooking(
						@RequestParam("name") String name
						,@DateTimeFormat(pattern="yyyy년 M월 d일") // 묶어주깅 
						@RequestParam("date") LocalDate date
						, @RequestParam("day") int day
						, @RequestParam("headcount") int headcount
						, @RequestParam("phoneNumber") String phoneNumber
			) {
		
		int count = bookingService.addBooking(name, date, day, headcount, phoneNumber);
		
		
		Map<String,String> resultMap = new HashMap<>();
		
		if(count == 1) {
			resultMap.put("result","success");
		}
		else {
			resultMap.put("result","fail");
			
		}
		
		return resultMap;
	
	
	}
	
	
	
	
	@ResponseBody
	@GetMapping("/delete")
	public Map<String, String> deleteBooking(@RequestParam("id") int id) {
		
		int count = bookingService.deleteBooking(id);
		
		Map<String, String> resultMap = new HashMap<>();
		
		// 결과 {"result":success}
		// 결과 {"result":fail}
		
		if(count == 1) {
			resultMap.put("result", "success");
			
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	@GetMapping("/home")
	public String bookingHome() {
		
		return "ajax/booking/booking-home";
	}
	
	// 이름 전화번호 조회해서 일치하는 거 -> 이거 ajax 중복 문제다 
	/*
	@ResponseBody
	@GetMapping("/same-booking")
	public Map<String, boolean> sameBooking (@RequestParam("name")String name
											, @RequestParam("phoneNumber") String phoneNumber){
		
		boolean isSame = bookingService.sameBooking(name, phoneNumber);
		
		Map<String, boolean> resultMap = new HashMap<>();
		
		
		// 일치하면 {"result": true}
		resultMap.put("isSame",isSame); //로 간단하게 처리도 가능
		
		return resultMap;
		 * 
		
		Map<String, boolean> resultMap = new HashMap<>();
		
		resultMap.put("issame",isSame);
		
		return resultMap;
	}
	 * */

}
