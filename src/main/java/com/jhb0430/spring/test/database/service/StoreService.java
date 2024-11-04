package com.jhb0430.spring.test.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhb0430.spring.test.database.domain.Store;
import com.jhb0430.spring.test.database.repository.StoreRepository;

@Service
public class StoreService {

	//싱글턴					이 머더라???
//							싱글턴 패턴(Singleton pattern)을 따르는 클래스는, 
//							생성자가 여러 차례 호출되더라도 실제로 생성되는 객체는 하나이고 
//							최초 생성 이후에 호출된 생성자는 최초의 생성자가 생성한 객체를 리턴한다. 
//							이와 같은 디자인 유형을 싱글턴 패턴이라고 한다. 
//							주로 공통된 객체를 여러개 생성해서 사용하는 DBCP(DataBase Connection Pool)와 같은 상황에서 많이 사용된다.
//							자바는 생성자를 private으로 선언하여 상속이 불가능함을 지정하기도 한다.
	
	
	
//				@Autowired라는 어노테이션을 붙여주면 그 멤버변수는 아무런 값을 지정해주지 않았어도 스프링이 알아서 내부적으로 객체를 생성해서 이 변수에 값을 넣어준다
//				-> 저 멤버변수의 값이, 객체가 생성되어 있다고 가정하고 마음껏 가져다 쓰면 된다 
	@Autowired
//	-> 멤버 변수 형태로 사용할 변수를 만들어준다
	private StoreRepository StoreRepository;
		// 하 이건 또 repository 만들고 다시 와야하네... 
	
		// 가게 정보 다 얻어오기
		public List<Store> getStoreList(){
			
			// 테이블 조회 결과를 얻어오는 과정을 메소드 안에서 수행해줘야한다!
			// 근데 테이블 조회는 또 서비스의 역할이 아님;; 다른 클래스를 통해서 수행시켜줘야한다
			// 그게 뭐다??? Repository -> Repository 패키지 안에 Repository 클래스 생성하러 가자
			List<Store>storeList = StoreRepository.selectStoreList();
//	 @위에서 Autowired 만들었으면 여기 봐					작성한 selectStoreList를 호출하기 위해서,
//													-> 얘를 호출하면 이 메소드와 연결된 태그에 있는 쿼리가 수행이 되고 , 
//													그 쿼리 수행결과로 마이바티스가 직접 구성한 리스트 객체가 리턴이 된다
//													해당하는 리스트 객체의 형태는 Entity 클래스의 형태로 만들어진다.
//			-> repository를 통해서 게시글 정보를 얻어오고, 이게 리스트로 리턴되게 된다 
//			↓	그럼 위에 getStoreList() 의 리턴형태도 List<Store> 로 정해진다
//
//						↓
//			이제 서비스에서 기능이 완성 됐으니까 컨트롤러에서 쓸 수 있게 됐다
//						→ 컨트롤러로 돌아가자 !!! 
//			
			
			
			
			
			
//			여기서 쓰려고 Repository 만들어 옴... 근데(Repository) 쓰려면 객체가 있어야한다 .
//
//			but 인터페이스는 객체로 못씀! 
//			ㅎㅎ 다행스럽게도 스프링에서 다 해줍니다 ㅎ
//			
//			싱글턴 패턴 활용~!
//			↑ 상위 private StoreRepository StoreRepository; 로 이동

			
			
			return storeList;
		}
	
}
