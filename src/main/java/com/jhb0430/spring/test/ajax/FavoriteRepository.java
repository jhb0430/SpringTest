package com.jhb0430.spring.test.ajax;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FavoriteRepository {

	
	public List<Favorite> selectFavorite();
	
	public int insertFavorite(
			@Param("name") String name
			,@Param("url") String url);
	
	
	public int countByUrl(@Param("url") String url);
	// 중복이다 -> 카운트 1 ++
	// 카운트는 정수타입으로 받으니까 리턴타입 int.
	// 다 됐으면 서비스로  꼬
	
	
	
	
	// 특정 즐겨찾기 행 삭제
	//input : 삭제 대상 id
	// 기능 ㅣ delete 쿼리 수행으로 특정 행 삭제
	// output : 실행된 행의 개수
	public int deleteFavorite(
			@Param("id") int id);
	
}


