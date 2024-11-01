package com.jhb0430.spring.test.lifecycle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lifecycle/test02")
public class Test02Controller {

	
	
	//1. json 출력 (List, Map)
	
	@RequestMapping("/1")
	public List<Map<String,Object>> filmList(){
		
		
List <Map<String,Object>>filmList = new ArrayList();
		
	Map<String,Object> filmMap = new HashMap<>();
	filmMap.put("rate", 15);
	filmMap.put("director", "봉준호");
	filmMap.put("time", 131);
	filmMap.put("title", "기생충");
	
	filmList.add(filmMap);
	
	filmMap = new HashMap<>();
	filmMap.put("rate", 0);
	filmMap.put("director", "로베르토 베니니");
	filmMap.put("time", 116);
	filmMap.put("title", "인생은 아름다워");
	
	filmList.add(filmMap);
	
	filmMap = new HashMap<>();
	filmMap.put("rate", 12);
	filmMap.put("director", "크리스토퍼 놀란");
	filmMap.put("time", 147);
	filmMap.put("title", "인셉션");
	
	filmList.add(filmMap);
	
	filmMap = new HashMap<>();
	filmMap.put("rate", 19);
	filmMap.put("director", "윤종빈");
	filmMap.put("time", 133);
	filmMap.put("title", "범죄와의 전쟁 : 나쁜놈들 전성시대");
	
	filmList.add(filmMap);
	
	filmMap = new HashMap<>();
	filmMap.put("rate", 15);
	filmMap.put("director", "프란시스 로렌스");
	filmMap.put("time", 137);
	filmMap.put("title", "헝거게임");
	
	filmList.add(filmMap);
	
	
	
	return filmList;
	}
	
	
	//2. json 출력 (List, Class)
	
	@RequestMapping("/2")
	public List <Introduce> intoduceList() {
		List <Introduce> intoduceList = new ArrayList();
		Introduce userIntro = new Introduce("안녕하세요 가입인사 드립니다","hagulu","안녕하세요. 가입했어요. 앞으로 잘 부탁 드립니다. 활동 열심히 하겠습니다");
		intoduceList.add(userIntro);
//		intoduceList.add(new Introduce("안녕하세요 가입인사 드립니다","hagulu","안녕하세요. 가입했어요. 앞으로 잘 부탁 드립니다. 활동 열심히 하겠습니다"));

		
		
		userIntro = new Introduce("헐 대박", "bada", "오늘 목요일이 었어 ... 금요일인줄");
		intoduceList.add(userIntro);
		
		userIntro = new Introduce("오늘 데이트 한 이야기 해드릴게요.", "dulumary", "...");
		intoduceList.add(userIntro);
		
		
		return intoduceList;
		
	}
	
	@RequestMapping("/3")
	public ResponseEntity<Introduce> entityResponse(){
		Introduce introduce = new Introduce("안녕하세요 가입인사 드립니다","hagulu","안녕하세요. 가입했어요. 앞으로 잘 부탁 드립니다. 활동 열심히 하겠습니다");
		ResponseEntity<Introduce> entity = new ResponseEntity<>(introduce,HttpStatus.INTERNAL_SERVER_ERROR);
		
		return entity;
	}
	
	
}
