package com.jhb0430.spring.test.thymeleaf.weather;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WeatherRepository {
 
	public List<Weatherhistory> selectWeather();
	
	
	public int insertWeather(
			/*`date`
 			,`weather`
 			,`temperatures`
 			,`precipitation`
 			,`microDust`
 			,`windSpeed`*/
			@Param("date") LocalDate date
			,@Param("weather") String weather
			,@Param("temperatures") double temperatures
			,@Param("precipitation") double precipitation
			,@Param("microDust") String microDust
			,@Param("windSpeed") double windSpeed
			);
	
	
	public int insertWeatherByObject(Weatherhistory weatherhistory);
	
}




