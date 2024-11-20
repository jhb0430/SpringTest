package com.jhb0430.spring.test.ajax.booking;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BookingRepository {

	
	public List<Booking> selectBooking();
	
	public int deleteBooking(@Param("id") int id);

	public int insertBooking(@Param("name") String name
			, @Param("date") LocalDate date
			, @Param("day") int day
			, @Param("headcount") int headcount
			, @Param("phoneNumber") String phoneNumber);


//	public int sameBooking(@Param("name") String name
//			, @Param("phoneNumber") String phoneNumber);
	
	
	public List<Booking> sameBooking(@Param("name") String name
			, @Param("phoneNumber") String phoneNumber);
}
