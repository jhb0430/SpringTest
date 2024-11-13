package com.jhb0430.spring.test.thymeleaf.weather;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

	@Autowired
	private WeatherRepository weatherRepository;
	
	
	
	public List<Weatherhistory> getWeather() {
		
		List<Weatherhistory> weatherhistory = weatherRepository.selectWeather();
		return weatherhistory;
	}
	
	
	public int addWeather(
			LocalDate date
			,String weather
			,double temperatures
			,double precipitation
			,String microDust
			,double windSpeed
			
			) {
		
		int count = weatherRepository.insertWeather(date, weather, temperatures, precipitation, microDust, windSpeed);
	
		return count;
	}
}
