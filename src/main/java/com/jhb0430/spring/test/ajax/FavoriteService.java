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

	public boolean isDuplicate(String url) {
		// url 중복입니까 아닙니까?? 
		// 이다 아니다? -> boolean
		// 레파지토리야 답을 알려줘! 
		
		// 요청하신 이다 아니다 입니다 
		int count =favoriteRepository.countByUrl(url);
		// 얘는 카운트 갯수만 받아오니까 또 int 
		 // 근데 바로 리턴 못함...
		
		if(count > 0 ) {
			return true;
		} else {
			return false;
		}
		
		
	}
	
	
	public int deleteFavorite(int id) {
		// 행 1 지우는 기능 
		int count = favoriteRepository.deleteFavorite(id);
		
		return count;
	}
	
	
}
