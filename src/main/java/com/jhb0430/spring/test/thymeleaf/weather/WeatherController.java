package com.jhb0430.spring.test.thymeleaf.weather;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/thymeleaf")

@Controller
public class WeatherController {

	@Autowired
	private WeatherService weatherService;
	
	
	@GetMapping("/test04")
	public String test04(Model model) {
		
		List<Weatherhistory> weatherhistory = weatherService.getWeather();
		// 모든 행 가져오기 
		model.addAttribute("weatherhistory",weatherhistory);
		
		return "thymeleaf/test04";
	}
	
	
	@GetMapping("/test04-input")
	public String inputTest04(){
		
		// 입력받고 -> 파라미터로 받아야함 
		return "thymeleaf/test04-input";
	}
	
	
	
}
