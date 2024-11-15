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
	
	
	
	
}


