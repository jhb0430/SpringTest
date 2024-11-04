package com.jhb0430.spring.test.database.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jhb0430.spring.test.database.domain.Store;

//데이터베이스 관련 처리 
//데이터 베이스에 관련된 처리는 무조건 Repository가 한다
//(데이터베이스만을 ! 담당)

//Mybatis Framework
//		Repository를 통해서 데이터 베이스를 연동해야하는데 ,
//		마이바티스(Mybatis)라고 하는 프레임워크(Framework)를 연동할것이다! 
//			->쿼리를 수행하고 접속하고 처리하는 등의 과정이 번거로움
//			그래서 이 처리 과정을 명확하고 간결하게 할 수 있게 하는 여러 라이브러리와 프레임워크들이 존재한다!
//			그 중 우리는 마이바티스라는 프레임워크를 통해서 데이터베이스를 다룰것임

@Mapper
//1. Repository  인터페이스 위에 @Mapper 어노테이션을 적어준다.
//-> 이 메소드에 대한 구현은 클래스가 아닌 xml이라는 파일을 통해 구현된다
//(xml-> mark up language. 데이터를 표현하기 위해 사용하는 형태의 파일.)
//(application.properties에 mybatis.mapper-locations-=에 설정해줬다)
//src/main/resources/
//에 mappers 라는 패키지를 만들어주고, 그 안에 xml파일을 만들어준다 
//(이름뒤에는 무조건 Mapper.xml로 끝나도록 구성해줘야한다.)
public interface StoreRepository {
//	Repository ☆★☆★인터페이스☆★☆★ 를 만들어준다!!! 

	
	
	// STORE 테이블 모든 행 조회 (Repository 클래스를 만든 이유)
//								-> Repository에서 수행한 기능을 호출해서 다른 클래스에서 사용할 수 있도록 해줘야한다
//								-> 즉, 그걸 수행하기 위한 메소드를 구성해줘야한다
	public List<Store> selectStoreList();
//						(조회할거니까 select어쩌구로 하는게 만만해서 적는거임)
//	리턴형태를 리스트로 잡아주면 되는데? 그때의 Generic은 
//	→ 마이바티스의 사용법을 적용하면, 
//	여러 행을 저장하는 형태 => 리스트를 이용 
//	한 행의 정보를 , 하나의 "클래스" 객체로 표현해서 처리할 수 있다
//	하나의 객체 안에는 ``,``,``,로 된 항목(컬럼)이 다 저장가능한 클래스 객체여야한다
//	즉, 이 컬럼값을 저장할 멤버변수를 가진 클래스를 만들어서 그 클래스 객체로 하나의 행을 저장한다.
//	객체가 여러개 저장된 리스트면, 결국 이 모든 행을 표현한 리스트 객체가 된다.
//	↓
//	하나의 행을 표현할 클래스를 만들어준다. => Entity, Domain 클래스 만들러 갑시당

	
//	→ 리턴타입 리스트로 잡을건데, 그때 한 행의 정보를 저장하기 위한 타입은 방금 만든 Entity 클래스! 
//	근데 Repository는 인터페이스기때문에 이 메소드를 수행했을때, 수행할 수 있는 코드가 없다.
//	인터페이스는 나열만 하는거고, 나열된 내용을 클래스를 통해 implements, "구현"해줘야한다.

//	mybatis framework 사용법을 적용하면 클래스 없이 간단하게 쿼리를 작성해서 결과를 리턴해 줄 수 있다
//	(메소드에 대한 구현이 클래스가 아닌 다른 방식이 되는것.)
	
//	↑@Mapper 설명으로 이동
	
//	Mapper.xml 만들고 왔으면 ↓
//	이제 select테이블List(); 메소드를 호출하면?
//			-> 얘와 연결된 xml을 통해서 연결된 셀렉트 태그가 수행이 되고
//			-> 이 셀렉트 태그가 수행된 결과의 내용이 
//			-> resultType(리턴타입)에 지정된 클래스의 객체를 통해 
//			-> 한 행을 직접 마이바티스가 객체를 생성하고
//			-> 조회된 행을 다 세팅해주게 된다
//			-> 그렇게 조회된 모든 행을  resultType의 객체로 알아서 생성하고
//			-> 생성된 객체를 다 List에 저장한다
//			-> 그렇게 만들어진 리스트 객체를 알아서 리턴까지 해준다.
//
//			(우리가 맵 만들어서 리스트에 넣고 했던 그런 과정들을 마이바티스가 알아서 척척 해버리는것임)
//
//			↓
//			그럼 Repository 왜만들었어? 
//			Service 에서 쓰려고 → Service 클래스로 가자!!

}
