package com.jhb0430.spring.test.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ajax/favorite")
public class FavoriteController {

// id name url createdAt updatedAt
	
	@Autowired
	private FavoriteService favoriteService;
	
	
	// json으로 출력되는 create 만들기...
	
	@ResponseBody
	@PostMapping("/create")
	public Map<String,String> createFavorite(
			@RequestParam("name") String name
			,@RequestParam("url") String url
			) {
		
		int count = favoriteService.addFavorite(name, url);
		
		
		Map<String,String> resultMap = new HashMap<>();
		
		if(count == 1) {
			resultMap.put("result","success");
		}
		else {
			resultMap.put("result","fail");
			
		}
		
		return resultMap;
		
	}
	
	/*

API : request(시작) → response(끝)
저장기능을 하는 api는 저장에 필요한 정보를 request로 전달받고 이 정보를 저장해요.
그리고 response가 남았죠? 저장 기능을 수행하고 나서 요청한 곳에 무슨 정보를 돌려줄까?
저장 기능에 대한 결과로 딱히 별다른게 없으니 적당히 성공 실패 여부를 데이터로 만들어서 json으로 담는거예요.

끗!

api는 이렇게 끝이예요.












ajax 수행과정은 이제 api를 사용하는 거예요.

만들어져 있는 api를 필요에 따라서 선택해서 사용하는 거고요.
사용자가 입력한 내용을 통해 즐겨찾기를 추가하려고 해요.
저장 api를 이용해야하는 필요가 생겼고 이를 활용하는 거예요.

api의 사용법은 정해진 메소드에 정해진 url path로 정해진 파라미터를 전달해요.
그러면 정해진 response가 전달되는 거예요.

ajax는 그저 사용법에 따라서 필요한 기능을 수행하는 것 뿐이예요.

input.html에서 성공 실패 옵션 준다라고 하는 것은 혹시 success와 error일까요?
여기서 error 은 api 요청과정 혹은 수행과정에서 에러가 발생되어서 정상적으로 rseponse가 전달이 안된 상황이에요
말그대로 에러인거죠.

success의 function에서 조건으로 구분하는 성공 실패여부는 api에서 전달해준 json을 분석해서 성공 실패를 구분하는 과정이고요.

api에서 수행된 기능인데, api에서 정확한 성공 실패여부를 알 수 있겠쬬?
그래서 api에서 전달해주는 response의 데이터에 의존하게 되고요.


error는 완전 다른 문제가 생긴 것이고요.

api와 ajax의 흐름을 명확하게 둘러 나누어서 독립적으로 생각하는게 매우 중요해요.

쉽지는 않겠지만 그렇게 정리가 되었을때 가장 명확히 정리가 됩니다.!!


*/
	
	
	@GetMapping("/input")
	public String favoriteInput() {
		
		return "ajax/favoriteInput";	
	}
	
	
	
	
	@GetMapping("/list")
	public String favoriteList(Model model) {
		
		List<Favorite> favorite = favoriteService.getFavorite();
		
		model.addAttribute("favorite",favorite);
		
		
		return "ajax/favoriteList";	
		}
	
	// 중복 확인하는 기능 만들깅 
	@ResponseBody
	@GetMapping("/duplicate-url")
	public Map<String,Boolean> isDuplicateUrl(@RequestParam("url") String url){
		// 서비스 다녀옵시둥
		boolean isDuplicate = favoriteService.isDuplicate(url);
		
		// 이제 이다 아니다를 알게됐으니까 이걸 전달해줘야하는데 (API)로
		
		// 중복이다 {"isDuplicate" : true}
		// 중복 아니다 {"isDuplicate" : false}
		
		// 얘로 담아두면 아 나눠놨네? ㅇㅋㅇㅋ 알아서 가져가겠삼 할 수 있도록 ... key, value 로 저장해주자
		
		Map<String,Boolean> resultMap = new HashMap<>();
		
		// if/ else 필요 없이 
		// resultMap.put("isDuplicate",isDuplicate)
		// 로 간단히 처리할 수 도 있다. 왜냐 => isDuplicate 자체가 true/false 가지고 있으니까
		if(isDuplicate) { // true면
			resultMap.put("isDuplicate", true);
		} else {
			resultMap.put("isDuplicate", false);
		}
		// 완성 /a^~^
		return resultMap;
	}
	
	
	// 삭제
	
	@ResponseBody
	@GetMapping("/delete-url")
	public Map<String, String> deleteFavorite(@RequestParam("id") int id 
//			, Model model
			) {
		
//		List<Favorite> favorite = favoriteService.getFavorite();
//		
//		model.addAttribute("favorite",favorite);
		
		int count = favoriteService.deleteFavorite(id);
		
		// 삭제 됐다 {"result":success}
		// 안됐다 {"result": fail}
		
//		엥..? 그냥 쓸 수 있었나??
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
			
		}
		return resultMap;
		
	}
	
	
	
	
	
}


