package com.jhb0430.spring.test.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhb0430.spring.test.database.domain.Store;
import com.jhb0430.spring.test.database.repository.StoreRepository;

@Service
public class StoreService {

	//싱글턴
//				싱글턴 패턴(Singleton pattern)을 따르는 클래스는, 
//				생성자가 여러 차례 호출되더라도 실제로 생성되는 객체는 하나이고 
//				최초 생성 이후에 호출된 생성자는 최초의 생성자가 생성한 객체를 리턴한다. 
//				이와 같은 디자인 유형을 싱글턴 패턴이라고 한다. 
//				주로 공통된 객체를 여러개 생성해서 사용하는 DBCP(DataBase Connection Pool)와 같은 상황에서 많이 사용된다.
//				자바는 생성자를 private으로 선언하여 상속이 불가능함을 지정하기도 한다.
	@Autowired	
	private StoreRepository StoreRepository;
		// 하 이건 또 repository 만들고 다시 와야하네... 
	
		// 가게 정보 다 얻어오기
		public List<Store> getStoreList(){
			
			List<Store>storeList = StoreRepository.selectStoreList();
			
			return storeList;
		}
	
}
