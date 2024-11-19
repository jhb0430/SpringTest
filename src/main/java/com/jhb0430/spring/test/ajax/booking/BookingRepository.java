package com.jhb0430.spring.test.ajax.booking;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BookingRepository {

	
	public List<Booking> selectBooking();
	
	public int deleteBooking(@Param("id") int id);

	public int insertBooking(@Param("name") String name
			, @Param("date") LocalDateTime date
			, @Param("day") int day
			, @Param("headcount") int headcount
			, @Param("phoneNumber") String phoneNumber);


}
