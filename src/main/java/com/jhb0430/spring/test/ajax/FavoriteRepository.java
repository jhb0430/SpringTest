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
	
	public int deleteFavorite(
			@Param("id") int id);
}
