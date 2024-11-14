package com.jhb0430.spring.test.thymeleaf.weather;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	
	
	// 크리에이트

	@PostMapping("/create")
	public String createWeather(
			@RequestParam("date") LocalDate date
			,@RequestParam("weather") String weather
			,@RequestParam("temperatures") double temperatures
			,@RequestParam("precipitation") double precipitation
			,@RequestParam("microDust") String microDust
			,@RequestParam("windSpeed") double windSpeed
			,Model model){
		
		Weatherhistory weatherhistory = new Weatherhistory(); 
		
				weatherhistory.setDate(date);
				weatherhistory.setWeather(weather);
				weatherhistory.setTemperatures(temperatures);
				weatherhistory.setPrecipitation(precipitation);
				weatherhistory.setMicroDust(microDust);
				weatherhistory.setWindSpeed(windSpeed);
	
		
				int count = weatherService.addWeatherbyObject(weatherhistory);
				
				
				model.addAttribute("weatherhistory", weatherhistory);
				
//		return "입력 성공 : " + count;
				
				return "redirect:/thymeleat/test04";
	}
	
	
	
	
	@GetMapping("/test04-input")
	public String input() {
		
		return "thymeleaf/test04-input";
	}
			
	
	
	/*
	@PostMapping("/create")
	public String inputTest04(
			@RequestParam("date") LocalDate date
			,@RequestParam("weather") String weather
			,@RequestParam("temperatures") double temperatures
			,@RequestParam("precipitation") double precipitation
			,@RequestParam("microDust") String microDust
			,@RequestParam("windSpeed") double windSpeed
			,Model model){

		
		Weatherhistory weatherhistory = new Weatherhistory(); 
		
		int count = weatherService.addWeather(date, weather, temperatures, precipitation, microDust, windSpeed);
		
		model.addAttribute("weatherhistory",weatherhistory);
		
		
		// 입력받고 -> 파라미터로 받아야함 
		return "redirect:/thymeleaf/test04";
	}
	 * */
	
	
	
}
