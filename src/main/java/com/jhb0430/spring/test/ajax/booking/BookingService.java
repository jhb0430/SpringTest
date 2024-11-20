package com.jhb0430.spring.test.ajax.booking;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;
	
	// booking 쿼리 가져오는 역할
	public List<Booking> getBookingList() {
		
		List<Booking> booking = bookingRepository.selectBooking();
		
		return booking;
	}
	
	
	public int deleteBooking(int id) {
		// 행 1 지우는 긴으
		int count = bookingRepository.deleteBooking(id);
		
		return count;
	}
	
	
	public int addBooking(String name
					, LocalDate date
					,int day
					, int headcount
					,String phoneNumber
			) {
		
		int count = bookingRepository.insertBooking(name, date, day, headcount, phoneNumber);
		
		return count;
		
	}
	
	// 이름 전화번호 일치
/*	
	public boolean sameBooking(String name ,String phoneNumber) {
		
		int count = bookingRepository.sameBooking(name, phoneNumber);
		
		if(count > 0 ) {
			return true;
		} else {
			return false;
		}
	}
*/	
	
	public Booking sameBooking(String name ,String phoneNumber) {
		
		Booking booking = bookingRepository.sameBooking(name, phoneNumber);
		
		return booking;
		
	}
	
	
	
}
