package com.jhb0430.spring.test.thymeleaf.weather;

import java.util.List;

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
	
}
