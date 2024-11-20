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
	

	// 육하원칙에 맞게 작성 하는게 몾다
	// 언제 : 사용자가 예약 정보를 입력하고 젖아을 수행하고자 할때
	// 어디서 : 서버
	// input(request) : 예약이 필요한 예약자 정보
	// 기능 : 
	// 무엇을 : 예약 정보를 저장한다
	// 어떻게 : 예약 정보를 booking 테이블에 insert 한다
	// 왜 : 테이블에 저장해야 나중에 예약 목록을 얻어올 수 있으니까
	// output(response) : 성공 실패 여부를 json 문자열로 만든다
	
	
	// create
	@ResponseBody
	@GetMapping("/create") // 보안적으로 문제되거나 긴 데이터일때는 post 나머지는 다 겟...
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
	
	
	
	
	
	
	
	//  풀이
	
	//언제 : 사용자가 이름과 전화번호를 입력하고 조회를 요청했을때
	// 어디서 : 서버에서
	// input: 예약자 이름, 전화 번호
	// 기능 : 
	// 무엇을 : 이름과 전화번호가 일치하는 사용자 정보 조회
	// 어떻게 :booking 테이블에 이름과 전화번호를 조건으로 일치하는 행 조회
	// 왜 : 예약자의 모든 정보가 필요하니까 
	// output : 예약자 정보
	/*
	 * @GetMapping("/info)
	 *  public  Booking bookingInfo(
	 * 				 @RequestParam("name")String name
					, @RequestParam("phoneNumber") String phoneNumber
	 *  		){
	 *  
	 *  Booking booking = bookingService.sameBooking(name,phoneNumber);
	 *  // bookingService.sameBooking 와 일치하는 예약 정보를 얻어온다 .
	 *  
	 *  // response에 데이터를 담아야한다.
	 *  
	 *  
	 *  //{"name":어쩌구,"date":yyyy-mm-dd,......} 
	 *  
	 *  
	 *  }
	 * 
	 * 
	 * */
	
	
	//이름과 전화번호가 같으면 그 쿼리를 조회해서 출력해준다.
	// 이름을 넣고 전화번호를 넣으면
	// 나머지 값이 출력되어야 한다.
	
		//언제 : 사용자가 이름과 전화번호를 입력하고 조회를 요청했을때
		// 어디서 : 서버에서
		// input: 예약자 이름, 전화 번호
		// 기능 : 
		// 무엇을 : 이름과 전화번호가 일치하는 사용자 정보 조회
		// 어떻게 :booking 테이블에 이름과 전화번호를 조건으로 일치하는 행 조회
		// 왜 : 예약자의 모든 정보가 필요하니까 
		// output : 예약자 정보
	@ResponseBody
	@GetMapping("/same-booking")
	public Map<String, Object>  sameBooking (
//			public Booking sameBooking (
											@RequestParam("name")String name
											, @RequestParam("phoneNumber") String phoneNumber
			){
		
		 //{"name":어쩌구,"date":yyyy-mm-dd,......} 
		Booking sameBooking = bookingService.sameBooking(name, phoneNumber);
		// bookingService.sameBooking 와 일치하는 예약 정보를 얻어온다 .
		//{"id":0,"name":"장나라","headcount":2,"day":1,"date":"2025-09-12","phoneNumber":"010-2222-0000","state":"확정","createdAt":null,"updatedAt":null}
		// response에 데이터를 담아야한다.
		
		// 조회가 됐는지 안됐는지 표현해주면 좋을 것 같다
		// 조회 성공 {"result":"success", "item" : {}} 으로 설정 가능
		// success 인 경우에만 ! item이라는 키로 값을 가져오면 되지 않나? 
		// 
		// 조회 실패 {"result":"fail"}
		
//		return sameBooking;
		
		Map<String, Object> resultMap = new HashMap<>();
		// 성공 실패 여부에 따라 구분
		if(sameBooking != null) {
			resultMap.put("result","success");
			resultMap.put("item",sameBooking);
			
		}else {
			resultMap.put("result","fail");
			
		}
		return resultMap;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/*		 실패의 흔적...
	 * 
	 * //											@RequestParam("name") String name
//											,@DateTimeFormat(pattern="yyyy년 M월 d일") 
//											@RequestParam("date") LocalDate date
//										, @RequestParam("day") int day
//										, @RequestParam("headcount") int headcount
//										, @RequestParam("phoneNumber") String phoneNumber
//
	 */
//		Booking booking = new Booking();
//		booking.setName(name);
//		booking.setDate(date);
//		booking.setDay(day);
//		booking.setHeadcount(headcount);
//		booking.setPhoneNumber(phoneNumber);
		
		
//		model.addAttribute("booking", booking);
		
//		Map<String,Object> bookingMap = new HashMap<>();
//		
//		if(sameBooking != null) {
//		
//		{"name":어쩌구,"date":yyyy-mm-dd,......} 
//		bookingMap.put("name", name);
//		bookingMap.put("date", date);
//		bookingMap.put("day", day);
//		bookingMap.put("headcount", headcount);
//		bookingMap.put("phoneNumber", phoneNumber);
		
//		bookingMap.put("result","success");
//		}else {
//			bookingMap.put("result","fail");
//			
//		}
//		return bookingMap;
//	}
//		
		
		/*
		// 조회되면 {"result": success}
		Map<String,String> resultMap = new HashMap<>();
		
		if(booking != null) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
			
		}
		return resultMap;
		
	
	
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
