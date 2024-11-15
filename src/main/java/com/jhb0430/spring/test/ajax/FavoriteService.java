package com.jhb0430.spring.test.ajax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FavoriteService {

	@Autowired
	private FavoriteRepository favoriteRepository;
	
	
	public List<Favorite> getFavorite() {
		
		List<Favorite> favorite = favoriteRepository.selectFavorite();
		return favorite;
	}
	
	
	// 추가하는 기능 
	
	public int addFavorite(
			String name
			,String url
			) {
		
		int count = favoriteRepository.insertFavorite(name, url);
		
		return count;
		
	}
	
}
